(ns clojurena.API.Channels.channel-put-requests
 (:require [clj-http.client :as client]
           [clojure.string :as str]
           [clojurena.API.utils :as utils]
           [clojurena.API.Blocks.block-put-requests :as block-puts]))


(defn update-channel-attributes [slug status title]
  "Updates the contents of a channel"
  ([slug status] (utils/async
                  (client/put (str utils/channel-base-url slug) {:status status})))
  ([slug status title] (utils/async
                        (client/put (str utils/channel-base-url slug) {:status status
                                                                       :title title}))))


(defn update-order [slug ids]
  "Updates the order of a channel according to the order of the id's, expected as a vector"
  (try
    (utils/async
      (client/put (str utils/channel-base-url slug "/" "sort") {:ids ids}))
    (catch Exception e
      (println "Exception Message: " (.getMessage e)))))


(defn toggle-block [slug status block-id]
  "Toggles the status of a specific block."
  (try
    (utils/async
      (client/put (str utils/channel-base-url slug "/" "blocks/" block-id "/selection") {:status status}))
    (catch Exception e
      (println "Exception Message: " (.getMessage e)))))
