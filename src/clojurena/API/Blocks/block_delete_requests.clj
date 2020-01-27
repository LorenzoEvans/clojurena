(ns clojurena.API.Blocks.block-delete-requests
    (:require [clj-http.client :as client]
              [clojure.string :as str]
              [clojurena.API.utils :refer [async]]
              [clojurena.API.Channels.channel-get-requests :refer [base-url]])) 

(defn delete-block [channel-name block-id]
    "Deletes/removes connection between a block and channel, requires authentication"
    (async
        (client/delete (str base-url channel-name "/" "blocks" "/" block-id)
                       {:async? true}
         (fn [response] (println "Response is: " response) response)
         (fn [exception] (println "Exception is: " exception) exception))))
    
(def del-test 
  (delete-block "Clojurena-test" "5967619"))

(println del-test)