(ns reprex.core)


(defmacro eval-and-capture
  "Evaluate an expression and capture the output"
  [expr]
  (let [expr-str (str expr)
        eval-str (str (eval expr))]
    (str expr-str "\n"
         "; => " eval-str)))


(defmacro reprex
  "Create a reproducable example."
  [& exprs]
  (loop [evald   (list)
         unevald exprs]
    (if-let [expr (first unevald)]
      (recur `(conj ~evald (eval-and-capture ~expr)) (rest unevald))
      `(clojure.string/join "\n\n" (reverse ~evald)))))
