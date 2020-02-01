(ns clojurena.block-get-tests
  (:require [clojure.test :refer :all]
            [clj-http.client :as client]
            [clojurena.API.Blocks.block-get-requests :refer :all]))

(deftest get-block-by-id-test
  (testing "Ability to retrieve individual blocks"
    (is (= (:status (get-block-by-id)) 200))))
