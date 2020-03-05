(ns clojurena.API.Channels.channel-delete-requests
 (:require [clj-http.client :as client]
           [clojurena.API.Channels.channel-get-requests :refer [base-url]]
           [clojurena.API.utils :refer [async]]))

(defn delete-channel [channel-name]
 "Deletes a specified channel"
  (async
    (client/delete (str base-url channel-name)
      (fn [response] (println "Response is: " response) response)
      (fn [exception] (println "Exception is: " exception) exception))))
  
(defn delete-collaborators [channel-name ids]
  "Accepts a serialized list of id's, representing collaborators to *keep* in the channel."
  (async
    (client/delete (str base-url channel-name) {:body ids}
      (fn [response] (println "Response is: " response) response))))
  
