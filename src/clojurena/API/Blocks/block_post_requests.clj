(ns clojurena.API.Blocks.block-post-requests
    (:require [clj-http.client :as client]
              [clojure.string :as str]
              [clojurena.API.utils :refer [async]] ; [clojurena.API.utils :as utils] => utils/async 
              [clojurena.API.Channels.channel-get-requests :refer [base-url]])) 

(defn post-text-block [channel-name content auth]
  "Posts a block to the specified channel, requires authentication, use source *or* content, not both."
  (try
    (async 
      (client/post (str base-url channel-name "/blocks") {:async? true 
                                                          :oauth-token auth
                                                          :content content}))
      (catch Exception e
        (println "Exception message: " (.getMessage e)))))

(defn post-media-block [channel-name source auth]
  (try 
    (async
      (client/post (str base-url channel-name "/blocks") {:async? true
                                                          :oauth-token auth
                                                          :source source}))
      (catch Exception e
        (println "Exception message: " (.getMessage e)))))