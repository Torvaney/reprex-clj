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
