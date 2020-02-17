(ns clojurena.core-test
  (:require [clojure.test :refer :all]
            [clj-http.client :as client]
            [environ.core :as env]
            [clojurena.API.Blocks.block-delete-requests :as block-del]
            [clojurena.API.Blocks.block-get-requests :as block-get]
            [clojurena.API.Blocks.block-put-requests :as block-put]
            [clojurena.API.Blocks.block-post-requests :as block-post]
            [clojurena.API.Channels.channel-delete-requests :as channel-del]
            [clojurena.API.Channels.channel-get-requests :as channel-get]
            [clojurena.API.Channels.channel-put-requests :as channel-put]
            [clojurena.API.Channels.channel-post-requests :as channel-post]
            [clojurena.API.Search.search-get-requests :as search-get]          
            [clojurena.API.Users.user-get-requests :as user-get]          
            [clojurena.API]
            [clojurena.API]))
            
            
            
            
; Block delete tests
(deftest delete-block
  (testing "Ability to delete blocks from specified channels"
    (is (= (:status (block-del/delete-block "geosymgif" "549706" (env :access-token)))))))


; Block get tests
(deftest get-block-by-id-test
  (testing "Ability to retrieve individual blocks"
    (is (= (:status (block-get/get-block-by-id base-url "5967619")) 200))))

(deftest get-blocks-channels-test
  (testing "Ability to retrieve list of channels a block exists in."
    (is (= (:sttus (block-get/get-block-by-id-test base-url "5967619"))))))

(deftest block-get-tests
  (get-block-by-id-test)
  (get-blocks-channels-test))

; Block put tests TBD

; Take advantage of fixtures for destructive tests.

(deftest update-block-test
  (testing "Ability to update specific block in channel."
    (is (= (block-put/put-block)))))

; Test toggle block
  
; Take advantage of fixtures for destructive tests.
; (deftest post-block-test
;   (testing "Ability to post a block to a specific channel."
;     (is (= (post )))))
