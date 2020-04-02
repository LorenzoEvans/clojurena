(ns clojurena.API.Blocks.block-put-requests
    (:require [clj-http.client :as client]
              [clojure.string :as str]
              [clojurena.API.utils :as utils])) 
              
(defn put-block
  "Updates the contents/attributes of a block. Assumes content and id." 
  ([content id auth] (try  
                        (client/put (str utils/block-base-url "blocks" id) {:id id
                                                                           :oauth-token auth
                                                                           :content content})
                        (catch Exception e 
                          (println "Exception Message: " (.getMessage e)))))
  ([content id title auth] (try 
                              (client/put (str utils/block-base-url "blocks" id) {:id id
                                                                                  :oauth-token auth
                                                                                  :content content
                                                                                  :title title})
                            (catch Exception e
                              (println "Exception Message: " (.getMessage e)))))
  ([content id title description auth] (try 
                                         (client/put (str utils/block-base-url "blocks" id) {:id id
                                                                                             :content content
                                                                                             :title title
                                                                                             :oauth-token auth})
                                       (catch Exception e
                                         (println "Exception Message: " (.getMessage e))))))

(defn toggle-block-status [channel-name id status auth]
 "Changes the status of a block, specifically it's connection to a channel."
  (try 
         (client/put (str utils/channel-base-url channel-name "/" "blocks/" id "/selection") {:oauth-token auth :status status})
       (catch Exception e
          (println "Exception Message: " (.getMessage e)))))