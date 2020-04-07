(ns clojurena.core
  (:require 
            [clojure.data.json :as json]
            [clj-http.client :as client]
            [clojurena.API.Authentication.auth :refer [auth-url]]
            [environ.core :refer [env]]
            [clojurena.API.utils :as utils]
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
  [])
; (auth-data)
(def auth-test
  (try
    (client/get auth-url)
    (catch Exception e
      (println "Exception is: " (.getMessage e)))))
(println auth-test)
  ; (println user-follows-test)
; (println  (json/read-str (:body channel-get-test) :key-fn keyword)) ; this is IT BRO!!!
