(ns reprex.core)


;; Options (TODO: make arguments to reprex)
(def prompt  "; => ")
(def spacing "\n\n")


(defn embed-markdown
  "Embed a string containing code into a markdown chunk."
  [code]
  (str "``` clojure\n"
       code "\n"
       "```\n\n"
       "Created by [reprex](https://github.com/Torvaney/reprex-clj)"))


(defn render-captured
  "Render captured expressions as markdown."
  [spacing xs]
  (-> (clojure.string/join spacing xs) embed-markdown))


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


(defmacro reprex
  "Create a reproducible example."
  [& exprs]
  `(->> (capture-exprs ~exprs) (render-captured spacing)))
