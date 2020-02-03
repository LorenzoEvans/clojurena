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

(deftest get-follows-test 
  (testing "Ability to retrieve channels/users an account is following"
    (is (= (:status (get-follows "17"))))))


(deftest get-followers-test
  (testing "Ability to retrieve channels/users an account is following"
    (is (= (:status (get-followers "17"))))))

(deftest user-get-tests
  (get-user-test)
  (get-user-channel-test)
  (get-user-channels-test)
  (get-follows-test)
  (get-followers-test))
