(ns reprex.core
  (:require
    [clojure.java.shell :refer [sh]]
    [reprex.clipboard :as clip]))


;; Options (TODO: make arguments to reprex)
(def prompt  "; => ")
(def spacing "\n\n")

;; Rendering + metadata

(defn java-version
  "Get the current java version"
  []
  (->> (sh "java" "-version")
       :err
       (#(clojure.string/split % #"\n"))
       (map #(str "\t" %))
       (clojure.string/join "\n")))


(defn session-info
  "Get the current clojure session's information."
  []
  (str "\n```\n"
       "Clojure version:\n\t" (clojure-version) "\n"
       "Java version:\n" (java-version) "\n"
       "```\n"))


(defn markdown-details
  "Hide some text in a foldable section."
  [summary content]
  (str "<details><summary>" summary "</summary>\n" content "\n</details>"))


(defn embed-markdown
  "Embed a string containing code into a markdown chunk."
  [code]
  (str "``` clojure\n"
       code "\n"
       "```\n\n"
       (markdown-details "Session info" (session-info)) "\n\n"
       "Created by [reprex](https://github.com/Torvaney/reprex-clj)"))


(defn render-captured
  "Render captured expressions as markdown."
  [spacing xs]
  (-> (clojure.string/join spacing xs) embed-markdown))

;; Managing namespaces
;; (from https://stackoverflow.com/questions/27343707/i-would-like-to-run-load-file-in-a-sandboxed-namespace-in-clojure)

(defmacro with-ns
  "Evaluates body in another namespace.  ns is either a namespace
  object or a symbol.  This makes it possible to define functions in
  namespaces other than the current one."
  [ns & body]
  `(binding [*ns* (the-ns ~ns)]
     ~@(map (fn [form] `(eval '~form)) body)))


(defmacro with-temp-ns
  "Evaluates body in an anonymous namespace, which is then immediately
  removed.  The temporary namespace will 'refer' clojure.core."
  [& body]
  `(try
     (create-ns 'sym#)
     (let [result# (with-ns 'sym#
                     (clojure.core/refer-clojure)
                     ~@body)]
       result#)
     (finally (remove-ns 'sym#))))

;; Capturing & evaluating expressions

(defmacro capture-expr
  "Capture an expression and its output."
  [expr]
  (let [expr-str (str expr)
        eval-str (str (eval expr))]
    (str expr-str "\n"
         prompt   eval-str)))


(defmacro capture-exprs
  "Capture any number of expressions with their output."
  [exprs]
  (loop [evald   (list)
         unevald exprs]
    (if-let [expr (first unevald)]
      (recur `(conj ~evald (capture-expr ~expr)) (rest unevald))
      `(reverse ~evald))))

;; Reprex

;; TODO use temp-ns in new macro; keep eval and render separate
(defmacro reprex
  "Create a reproducible example. With no arguments, reprex will attempt to read
   code from the clipboard, otherwise it will evaluate any expressions provided
   as arguments."
  ([]
     (let [code (read-string (clip/slurp-clipboard))]
       `(reprex ~code)))
  ([& body]
     (let [form `(with-temp-ns (->> (capture-exprs ~body) (render-captured spacing)))]
       `(do (clip/spit-clipboard (eval ~form)) ~form))))
