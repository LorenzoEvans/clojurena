(ns clojurena.core
  (:require 
            [clojure.data.json :as json]
            [clj-http.client :as client]
            [clojurena.API.Authentication.auth]
            [environ.core :refer [env]]
            [clojurena.API.Blocks.block-delete-requests :refer :all]
            [clojure.java.browse :refer [browse-url]])
  (:gen-class))

(defn -main
  "I don't do a whole lot."
  []
  (println "Hello, World!"))

; (def deltest
;   (delete-block "Clojurena-test" "5967619" (env :access-token)))
; (println channel)
; (println  block)
; (println auth-data)
; (def test "https://dev.are.na/oauth/authorize?client_id=aa7365a1f8df2aec7b31405a7fa50944df77b2bd63c5bac07f97829168867da5&redirect_uri=urn:ietf:wg:oauth:2.0:oob&response_type=code")

; (def test-response
;   (client/get test))
; (println test-response)
