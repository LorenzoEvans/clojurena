(ns clojurena.block-get-tests
  (:require [clojure.test :refer :all]
            [clj-http.client :as client]
            [clojurena.API.Blocks.block-get-requests :refer :all]))

(deftest get-block-by-id-test
  (testing "Ability to retrieve individual blocks"
    (is (= (:status (get-block-by-id base-url "5967619")) 200))))

(deftest get-blocks-channels-test
  (testing "Ability to retrieve list of channels a block exists in."
    (is (= (:sttus (get-block-by-id-test base-url "5967619"))))))

(deftest block-get-tests
  (get-block-by-id-test)
  (get-blocks-channels-test))
