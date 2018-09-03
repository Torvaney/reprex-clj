(ns reprex.clipboard-test
  (:require [clojure.test :refer :all]
            [reprex.clipboard :refer :all]))

(deftest test-empty-clipboard
  (testing "Slurping empty clipboard returns nil"
    (is (nil? (slurp-clipboard)))))

(deftest test-empty-clipboard
  (testing "Can slurp from clipboard (sort of...)"
    (do
      (spit-clipboard "test-spit")
      (is (= "test-spit" (slurp-clipboard))))))

