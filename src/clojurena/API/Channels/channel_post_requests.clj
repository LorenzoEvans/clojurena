(ns clojurena.API.Channels.channel-post-requests
 (:require [clj-http.client :as client]
           [clojure.string :as str]
           [clojurena.API.Channels.channel-get-requests :refer [base-url]]
           [clojurena.API.Blocks.block-post-requests :refer [post-block]]
           [clojurena.API.utils :refer [async]]))
        

(defn post-channel [channel-name & status]
 "Creates a channel."
  (async
    (client/post base-url (cond 
                           (= status nil) {:title channel-name}
                            :else {:title channel-name
                                   :status status})
      (fn [response] (println "Response is: " response) response)
      (fn [exception] (println "Exception is: " exception) exception))))

(defn check-collaborators [ids channel-name]
 "Returns collaborators of a given channel."
  (async
    (client/post (str base-url channel-name "/" "collaborators") {:body ids}
      (fn [response] (println "Response is: " response) response)
      (fn [exception] (println "Exception is: " exception) exception)))) 
  
(defn post-block-to-channel [channel-name source auth & content user pass]
 "Posts a specific block to channel, identical to post-block."
  (post-block channel-name source auth & content user pass))
  
