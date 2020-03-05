(ns clojurena.API.Channels.channel-put-requests
 (:require [clj-http.client :as client]
           [clojure.string :as str]
           [clojurena.API.utils :refer [async]]
           [clojurena.API.Blocks.block-put-requests :refer [toggle-block-status]]))

(def base-url "https://api.are.na/v2/channels/")

(defn update-channel-attributes [slug status]
  "Updates the contents of a channel"
  (async
    (client/put (str base-url slug) {:async? true
                                     :status status
                                     :title slug}
      (fn [response] (println "Response is: " response) response)
      (fn [exception] (println "Exception is: " exception) exception))))

(defn update-order [slug ids]
  "Updates the order of a channel according to the order of the id's, expected as a vector"
  (async
    (client/put (str base-url slug "/" "sort") {:async? true
                                                :ids ids}
      (fn [response] (println "Response is: " response) response)
      (fn [exception] (println "Exception is: " exception) exception))))

(defn toggle-block [slug status block-id]
  "Toggles the status of a specific block."
  (async
    (client/put (str base-url slug "/" "blocks/" block-id "/selection") {:async? true
                                                                         :status status}
      (fn [response] (println "Response is: " response) response)
      (fn [exception] (println "Exception is: " exception) exception))))
