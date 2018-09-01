(ns reprex.core-test
  (:require [clojure.test :refer :all]
            [reprex.core :refer :all]))

(deftest test-eval-and-capture
  (testing "Single expressions are captured correctly"
    ;; Maths
    (is (= "(+ 1 1)\n; => 2"  (eval-and-capture (+ 1 1))))
    (is (= "(* 5 5)\n; => 25" (eval-and-capture (* 5 5))))
    (is (= "(- 5 2)\n; => 3"  (eval-and-capture (- 5 2))))
    ;; Common fns
    ; (is (= "(require 'clojure.string)\n; => " (eval-and-capture (require 'clojure.string))))
    ))


(deftest test-reprex
  (testing "Any number of expressions are captured correctly"
    ;; Maths
    (is (= "(+ 1 1)\n; => 2"  (reprex (+ 1 1))))
    (is (= "(* 5 5)\n; => 25" (reprex (* 5 5))))
    (is (= "(- 5 2)\n; => 3"  (reprex (- 5 2))))
    (is (= "(+ 1 1)\n; => 2\n\n(* 5 5)\n; => 25"
           (reprex (+ 1 1) (* 5 5))))
    (is (= "(+ 1 1)\n; => 2\n\n(* 5 5)\n; => 25\n\n(- 5 2)\n; => 3"
           (reprex (+ 1 1) (* 5 5) (- 5 2))))
    ))
