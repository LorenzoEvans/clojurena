(ns clojurena.API.Blocks.block-delete-requests
    (:require [clj-http.client :as client]
              [clojure.string :as str]
              [clojurena.API.utils :refer [async]]
              [clojurena.API.Channels.channel-get-requests :refer [base-url]])) 

(def default-url "https://api.are.na/v2/channel/")

(defn delete-block [slug block-id & auth-token]
    "Deletes/removes connection between a block and channel, requires authentication"
    (async
        (client/delete (str default-url slug "/" "blocks" "/" block-id)
                       {:async? true
                        :headers {"Authorization" auth-token}}
         (fn [response] (println "Response is: " response) response)
         (fn [exception] (println "Exception is: " exception) exception))))
    
(def del-test 
  (delete-block "Clojurena-test" "5967619"))

(println del-test)