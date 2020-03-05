(ns clojurena.API.Channels.channel-post-requests
 (:require [clj-http.client :as client]
           [clojure.string :as str]
           [clojurena.API.Channels.channel-get-requests :refer [base-url]]
           [clojurena.API.Blocks.block-post-requests :refer [post-text-block post-media-block]]
           [clojurena.API.utils :refer [async]]))
        

(defn post-channel [channel-name & status]
 "Creates a channel."
  (async
    (client/post base-url (cond 
                           (= status nil) {:title channel-name
                                           :async? true}
                            :else {:title channel-name
                                   :status status
                                   :async? true})
      (fn [response] (println "Response is: " response) response)
      (fn [exception] (println "Exception is: " exception) exception))))

(defn check-collaborators [ids channel-name]
 "Returns collaborators of a given channel."
  (async
    (client/post (str base-url channel-name "/" "collaborators") {:body ids
                                                                  :async? true}
      (fn [response] (println "Response is: " response) response)
      (fn [exception] (println "Exception is: " exception) exception)))) 
  
(defn post-block-to-channel [channel-name source auth & content]
 "Posts a specific block to channel, identical to post-block."
  ([channel-name source auth] (post-media-block channel-name source auth))
  ([channel-name source auth]))
  
(defn post-media-block-to-channel [channel-name source auth]
 "Posts a media block to a specific channel, identical to post-media-block.")
 
(defn post-text-block-to-channel [channel-name content auth]
 "Posts a text block to a specific channel, identical to post-text-block.")
