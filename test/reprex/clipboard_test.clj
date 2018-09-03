(ns reprex.clipboard-test
  (:require [clojure.test :refer :all]
            [reprex.clipboard :refer :all]))

(deftest test-empty-clipboard
  (testing "Slurping empty clipboard returns nil"
    (is (nil? (slurp-clipboard)))))

(deftest test-empty-clipboard
  (testing "Can slurp from clipboard (sort of...)"
    (is (= "test-spit" (do (spit-clipboard "test-spit") (slurp-clipboard))))
    (is (= "123456789" (do (spit-clipboard "123456789") (slurp-clipboard))))))

