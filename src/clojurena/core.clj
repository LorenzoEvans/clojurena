(ns clojurena.core
  (:require 
            [clojure.data.json :as json]
            [clj-http.client :as client]
            [clojurena.API.Authentication.auth]
            [environ.core :refer [env]]
            [clojurena.API.Channels.channel-get-requests :as channel-get]
            [clojurena.API.Channels.channel-post-requests]
            [clojurena.API.Channels.channel-put-requests]
            [clojurena.API.Channels.channel-delete-requests]
            [clojurena.API.Blocks.block-get-requests]
            [clojurena.API.Blocks.block-post-requests]
            [clojurena.API.Blocks.block-put-requests]
            [clojurena.API.Blocks.block-delete-requests :refer :all]
            [clojurena.API.Search.search-get-requests]
            [clojurena.API.Users.user-get-requests :as user-get]
            [clojure.java.browse :refer [browse-url]]))

(defn -main
  "I don't do a whole lot."
  []
  )

; (def deltest
;   (delete-block "Clojurena-test" "5967619" (env :access-token)))

(def channel-get-test
  (channel-get/get-single-channel "b-w-ia_z787i4aw"))
(println channel-get-test)
; (def user-get-test
;   (user-get/get-user "17"))
; (println "user get is: " user-get-test)
; (println channel)
; (println  block)
; (println auth-data)
; (def test "https://dev.are.na/oauth/authorize?client_id=aa7365a1f8df2aec7b31405a7fa50944df77b2bd63c5bac07f97829168867da5&redirect_uri=urn:ietf:wg:oauth:2.0:oob&response_type=code")

; (def test-response
;   (client/get test))
; (println test-response)
