(ns clojurena.API.Blocks.block-post-requests
    (:require [clj-http.client :as client]
              [clojure.string :as str]
              [clojurena.API.utils :refer [async]]
              [clojurena.API.Channels.channel-get-requests :refer [base-url]])) 

(defn post-block [slug source & content]
    "Posts a block to the specified channel.")
