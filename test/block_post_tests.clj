(ns clojurena.block-post-tests
  (:require [clojure.test :refer :all]
            [clj-http.client :as client]
            [clojurena.API.Blocks.block-post-requests :refer :all]))

; Take advantage of fixtures for destructive tests.
; (deftest post-block-test
;   (testing "Ability to post a block to a specific channel."
;     (is (= (post )))))
