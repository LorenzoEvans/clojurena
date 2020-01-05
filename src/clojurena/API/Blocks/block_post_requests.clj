(ns clojurena.API.Blocks.block-post-requests
    (:require [clj-http.client :as client]
              [clojure.string :as str]
              [clojurena.API.utils :refer [async]]
              [clojurena.API.Channels.channel-get-requests :refer [base-url]])) 

(defn post-block [slug source auth & content user pass]
    "Posts a block to the specified channel, requires authentication, use source *or* content, not both."
  (let [arg-map {:slug slug 
                   :source source 
                   :auth auth 
                   :content (if (not= content nil) content) 
                   :user-pw-vec (if (and user pass) [user pass])}]
    (async
      (client/post (str base-url slug "/blocks") 
        (cond 
          (not= (:source arg-map) nil) {:oauth-token (:auth arg-map) 
                                              :source (:source arg-map)
                                              :coerce :always}
          (= source nil) {:oauth-token (:auth arg-map) 
                                :content (:content arg-map)
                                :coerce :always}
          (not= (:user-pw-vec arg-map) nil) {:basic-auth [(first (:user-pw-vec arg-map)) 
                                                          (fnext (:user-pw-vec arg-map))]
                                             :content content
                                             :coerce :always}
         (fn [response] (println "Response is: " response) response)
         (fn [exception] (println "Exception is: " exception) exception)))))) 
