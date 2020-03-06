(ns clojurena.test.core-test
  (:require [clojure.test :refer :all]
            [clj-http.client :as client]
            [environ.core :refer [env]]
            [clojurena.test.test-utils :as t-utils]
            [clojurena.API.Blocks.block-delete-requests :as block-del]
            [clojurena.API.Blocks.block-get-requests :as block-get]
            [clojurena.API.Blocks.block-put-requests :as block-put]
            [clojurena.API.Blocks.block-post-requests :as block-post]
            [clojurena.API.Channels.channel-delete-requests :as channel-del]
            [clojurena.API.Channels.channel-get-requests :as channel-get]
            [clojurena.API.Channels.channel-put-requests :as channel-put]
            [clojurena.API.Channels.channel-post-requests :as channel-post]
            [clojurena.API.Search.search-get-requests :as search-get]          
            [clojurena.API.Users.user-get-requests :as user-get]))
            
; Block delete tests
; (deftest delete-block
;   (testing "Ability to delete blocks from specified channels"
;     (is (= (:status (block-del/delete-block "Clojurena-test" "5967619" t-utils/auth-token)) 200))))


; Block get tests
(deftest get-block-by-id-test
  (testing "Ability to retrieve individual blocks"
    (is (= (:status (block-get/get-block-by-id 't-utils/block-base-url "5967619")) 200))))

(deftest get-blocks-channels-test
  (testing "Ability to retrieve list of channels a block exists in."
    (is (= (:status (block-get/get-block-by-id-test 't-utils/block-base-url "5967619")) 200))))

(deftest block-get-tests
  (get-block-by-id-test)
  (get-blocks-channels-test))

; Block put tests TBD
; put-block
; toggle-block-status

; Block posts tests TBD
; post-text-block
; post-media-block

; Take advantage of fixtures for destructive tests.
; How are we going to allow users to properly authenticate themselves
; for editing their own accounts?
; We need to figure that out before we can test these operations.

; (deftest update-block-test
;   (testing "Ability to update specific block in channel."
;     (is (= (block-put/put-block)))))

; Test toggle block
  
; Take advantage of fixtures for destructive tests.
; (deftest post-block-test
;   (testing "Ability to post a block to a specific channel."
;     (is (= (post )))))


; Channel delete tests TBD
; delete-channel
; delete-collaborators
; Take advantage of fixtures for destructive tests.

; Channel get tests
(deftest get-all-channels-test
  (testing "Ability to retrieve all public are.na channels."
    (is (= (:status (channel-get/all-public-channels)) 200))))

(deftest get-single-channel-test
  (testing "Ability to retrieve single channel."
    (is (= (:status (channel-get/get-single-channel "geosymgif")) 200))))

(deftest get-channel-thumb-test
  (testing "Ability to retrieve single channel."
    (is (= (:status (channel-get/get-channel-thumb "geosymgif")) 200))))

(deftest get-channel-connections-test
  (testing "Ability to retrieve single channel."
    (is (= (:status (channel-get/get-channel-connections "geosymgif")) 200))))

(deftest get-connected-channels-test
  (testing "Ability to retrieve single channel."
    (is (= (:status (channel-get/get-connected-channels "geosymgif")) 200))))

(deftest get-channel-contents-test
  (testing "Ability to retrieve single channel."
    (is (= (:status (channel-get/get-channel-contents "geosymgif")) 200))))

(deftest channel-get-tests
  (get-all-channels-test)
  (get-single-channel-test)
  (get-channel-thumb-test)
  (get-channel-connections-test)
  (get-connected-channels-test)
  (get-channel-contents-test))


; Channel Post tests TBD

; post-channel
; check-collaborators
; post-block-to-channel

; Channel Put tests

; update-channel-attributes
; update-order
; toggle-block

; Search get tests

(deftest search-test
  (testing "Ability to search are.na for terms."
    (is (= (:status (search-get/search "history")) 200))))

(deftest search-users-test
  (testing "Ability to search are.na for users."
    (is (= (:status (search-get/search-users "history")) 200))))


(deftest search-channels-test
  (testing "Ability to search are.na for users."
    (is (= (:status (search-get/search-channels "history")) 200))))


(deftest search-blocks-test
  (testing "Ability to search are.na for users."
    (is (= (:status (search-get/search-blocks "history")) 200))))


(deftest search-get-tests
  (search-test)
  (search-users-test)
  (search-channels-test)
  (search-blocks-test))


; User get tests
(deftest get-user-test
  (testing "Ability to retrieve a specific user"
    (is (= (:status (user-get/get-user "17")) 200))))

(deftest get-user-channel-test
  (testing "Ability to retrieve a specific user"
    (is (= (:status (user-get/get-user-channel "17")) 200))))

(deftest get-user-channels-test
  (testing "Ability to retrieve a specific user"
    (is (= (:status (user-get/get-user-channels "17")) 200))))

(deftest get-follows-test 
  (testing "Ability to retrieve channels/users an account is following"
    (is (= (:status (user-get/get-follows "17")) 200))))


(deftest get-followers-test
  (testing "Ability to retrieve channels/users an account is following"
    (is (= (:status (user-get/get-followers "17")) 200))))

(deftest user-get-tests
  (get-user-test)
  (get-user-channel-test)
  (get-user-channels-test)
  (get-follows-test)
  (get-followers-test))

(run-tests)