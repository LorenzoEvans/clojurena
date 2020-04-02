(ns clojurena.API.Channels.channel-delete-requests
 (:require [clj-http.client :as client]
           [clojurena.API.utils :as utils]))

(defn delete-channel [channel-name]
 "Deletes a specified channel, requires authentication."
  (try
      (client/delete (str utils/channel-base-url channel-name))
    (catch Exception e
      (println "Exception Message: " (.getMessage e)))))  
  
(defn delete-collaborators [channel-name ids]
  "Accepts a serialized list of id's, representing collaborators to *keep* in the channel, requires authentication."
  (try
      (client/delete (str utils/channel-base-url channel-name))
    (catch Exception e
      (println "Exception Message: " (.getMessage e)))))  
  
