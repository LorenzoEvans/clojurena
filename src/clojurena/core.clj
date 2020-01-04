(ns clojurena.core
  (:require 
            [clojure.data.json :as json]
            [clj-http.client :as client]
            [clojurena.API.Authentication.auth :refer [auth-data]]))

(defn -main
  "I don't do a whole lot."
  []
  (println "Hello, World!"))

(def block 
  (client/get "https://api.are.na/v2/blocks/8693"))
(def channel
  (client/get "https://api.are.na/v2/channels/pop-codeture"))

; (println  block)
; (println auth-data)

(def test "https://dev.are.na/oauth/authorize?client_id=aa7365a1f8df2aec7b31405a7fa50944df77b2bd63c5bac07f97829168867da5&redirect_uri=urn:ietf:wg:oauth:2.0:oob&response_type=code")

(def test-response
  (client/get test))
(println test-response)