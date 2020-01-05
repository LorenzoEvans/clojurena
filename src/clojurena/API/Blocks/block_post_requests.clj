(ns clojurena.API.Blocks.block-post-requests
    (:require [clj-http.client :as client]
              [clojure.string :as str]
              [clojurena.API.utils :refer [async]]
              [clojurena.API.Channels.channel-get-requests :refer [base-url]])) 

(defn post-block [slug source auth & content]
    "Posts a block to the specified channel, requires authentication, use source *or* content, not both."
    (async
        (client/post (str base-url slug "/blocks") 
            (if (not= source nil) {:oauth-token auth :source source}
                                  {:oauth-token auth :content content})
         (fn [response] "Response is: " response)
         (fn [exception] "Exception is: " exception)))) 
