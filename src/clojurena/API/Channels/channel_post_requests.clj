(ns clojurena.API.Channels.channel-post-requests
 (:require [clj-http.client :as client]
           [clojure.string :as str]
           [clojurena.API.Blocks.block-post-requests :refer [post-text-block post-media-block]]
           [clojurena.API.utils :as utils]))
        

(defn post-channel [channel-name status]
  "Creates a new channel, requires authentication."
  (try
    (utils/async
      (client/post utils/channel-base-url {:title channel-name
                                           :async? true
                                           :status status}))
    (catch Exception e
      (println "Exception Message: " (.getMessage e)))))

(defn check-collaborators [ids channel-name]
 "Returns collaborators of a given channel, requires authentication."
  (try
    (utils/async
      (client/post (str utils/channel-base-url channel-name "/" "collaborators") {:body ids
                                                                                  :async? true}))
    (catch Exception e
      (println "Exception Message: " (.getMessage e))))) 
  
(defn post-media-block-to-channel [channel-name source auth]
 "Posts a media block to a specific channel, identical to post-media-block."
 (post-media-block channel-name source auth)) ; assumedly if this needs to throw an error post-media-block will return it
 
(defn post-text-block-to-channel [channel-name content auth]
 "Posts a text block to a specific channel, identical to post-text-block."
 (post-text-block channel-name content auth))
