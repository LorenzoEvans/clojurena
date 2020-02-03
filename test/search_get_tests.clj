(ns clojurena.search-get-tests
  (:require [clojure.test :refer :all]
            [clj-http.client :as client]
            [clojurena.API.Search.search-get-request :refer :all]))

(deftest search-test
  (testing "Ability to search are.na for terms."
    (is (= (:status (search "history")) 200))))

(deftest search-users-test
  (testing "Ability to search are.na for users."
    (is (= (:status (search-users "history")) 200))))


(deftest search-channels-test
  (testing "Ability to search are.na for users."
    (is (= (:status (search-channels "history")) 200))))


(deftest search-blocks-test
  (testing "Ability to search are.na for users."
    (is (= (:status (search-blocks "history")) 200))))


(deftest search-tests
  (search-test)
  (search-users-test)
  (search-channels-test)
  (search-blocks-test))
