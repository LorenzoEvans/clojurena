(ns clojurena.API.Blocks.block-delete-requests
    (:require [clj-http.client :as client]
              [clojure.string :as str]
              [clojurena.API.utils :refer [async]]
              [clojurea.API.Channels.channel-get-requests :refer [base-url]])) 

(defn delete-block [slug block-id]
    "Deletes/removes connection between a block and channel."
    (async
        (client/delete (str base-url slug "/" "blocks" "/" block-id)
                       {:async? true}
         (fn [response] (println "Response is: " response) response)
         (fn [exception] (println "Exception is: " exception) exception))))
    
