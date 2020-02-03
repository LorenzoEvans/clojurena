(ns clojurena.user-get-tests
  (:require [clojure.test :refer :all]
            [clj-http.client :as client]
            [clojurena.API.User.user-get-requests :refer :all]))

(deftest get-user-test
  (testing "Ability to retrieve a specific user"
    (is (= (:status (get-user "17")) 200))))

(deftest get-user-channel-test
  (testing "Ability to retrieve a specific user"
    (is (= (:status (get-user-channel "17")) 200))))

(deftest get-user-channels-test
  (testing "Ability to retrieve a specific user"
    (is (= (:status (get-user-channels "17")) 200))))

(deftest get-follows 
  (testing "Ability to retrieve channels/users an account is following"
    (is (= (:status (get-follows "17"))))))


(deftest get-followerss 
  (testing "Ability to retrieve channels/users an account is following"
    (is (= (:status (get-followers "17"))))))