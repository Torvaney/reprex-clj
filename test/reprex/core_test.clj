(ns reprex.core-test
  (:require [clojure.test :refer :all]
            [reprex.core :refer :all]))

(deftest test-capture-expr
  (testing "Single expressions are captured correctly"
    ;; Maths
    (is (= "(+ 1 1)\n; => 2"  (capture-expr (+ 1 1))))
    (is (= "(* 5 5)\n; => 25" (capture-expr (* 5 5))))
    (is (= "(- 5 2)\n; => 3"  (capture-expr (- 5 2))))
    ;; Common fns
    ; (is (= "(require 'clojure.string)\n; => " (capture-expr (require 'clojure.string))))
    ))


(deftest test-capture-exprs
  (testing "Any number of expressions are captured correctly"
    ;; Maths
    (is (= '("(+ 1 1)\n; => 2")  (capture-exprs ((+ 1 1)))))
    (is (= '("(* 5 5)\n; => 25") (capture-exprs ((* 5 5)))))
    (is (= '("(- 5 2)\n; => 3")  (capture-exprs ((- 5 2)))))
    (is (= '("(+ 1 1)\n; => 2" "(* 5 5)\n; => 25")
           (capture-exprs ((+ 1 1) (* 5 5)))))
    (is (= '("(+ 1 1)\n; => 2" "(* 5 5)\n; => 25" "(- 5 2)\n; => 3")
           (capture-exprs ((+ 1 1) (* 5 5) (- 5 2)))))))
