(ns clojurena.API.Blocks.block-post-requests
    (:require [clj-http.client :as client]
              [clojure.string :as str]
              [clojurena.API.utils :as utils])) 

(defn post-text-block [channel-name content auth]
  "Posts a block to the specified channel, requires authentication, use source *or* content, not both."
  (try
      (client/post (str utils/channel-base-url channel-name "/blocks") {:oauth-token auth
                                                                        :content content})
      (catch Exception e
        (println "Exception message: " (.getMessage e)))))

(defn post-media-block [channel-name source auth]
  (try 
      (client/post (str utils/channel-base-url channel-name "/blocks") {:oauth-token auth
                                                                        :source source})
      (catch Exception e
        (println "Exception message: " (.getMessage e)))))