(ns clojurena.channel-get-tests
  (:require [clojure.test :refer :all]
            [clj-http.client :as client]
            [clojurena.API.Channels.channel-get-requests :refer :all]))

(deftest get-all-channels-test
  (testing "Ability to retrieve all public are.na channels."
    (is (= (:status (all-public-channels)) 200))))

(deftest get-single-channel-test
  (testing "Ability to retrieve single channel."
    (is (= (:status (get-single-channel "geosymgif")) 200))))

(deftest get-channel-thumb-test
  (testing "Ability to retrieve single channel."
    (is (= (:status (get-channel-thumb "geosymgif")) 200))))

(deftest get-channel-connections-test
  (testing "Ability to retrieve single channel."
    (is (= (:status (get-channel-connections "geosymgif")) 200))))

(deftest get-connected-channels-test
  (testing "Ability to retrieve single channel."
    (is (= (:status (get-connected-channels "geosymgif")) 200))))

(deftest get-channel-contents-test
  (testing "Ability to retrieve single channel."
    (is (= (:status (get-channel-contents "geosymgif")) 200))))

(deftest channel-get-tests
  (get-all-channels-test)
  (get-single-channel-test)
  (get-channel-thumb-test)
  (get-channel-connections-test)
  (get-connected-channels-test)
  (get-channel-contents-test))
