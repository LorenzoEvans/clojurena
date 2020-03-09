(ns clojurena.API.Search.search-get-requests
  (:require [clj-http.client :as client]
            [clojure.string :as str]
            [clojurena.API.utils :as utils]))
            

(defn search [term]
  "Searches the entire are.na system for blocks, users and channels matching the query."
  (try
    (utils/async
     (client/get utils/base-search-url {:query-params {:q [term]}})))
    (catch Exception e
      (println "Exception Message :" (.getMessage e)))))
  
(defn search-users [term]
  "Searches the are.na system for users that match the query."
  (try
    (utils/async
      (client/get utils/user-search-url {:query-params {:q [term]}
                                         :throw-entire-message? true})))
    (catch Exception e
      (println "Exception Message: " (.getMessage e)))))
      
(defn search-channels [term]
  "Searches the are.na system for channels that match the query."
  (try
    (utils/async
     (client/get utils/channel-search-url {:query-params {:q [term]}
                                           :throw-entire-message? true})))
    (catch Exception e
      (println "Exception Message: " (.getMessage e)))))

(defn search-blocks [term]
 "Searches the are.na system for channels that match the query."
 (try 
  (utils/async
   (client/get utils/block-search-url {:async? true
                                       :throw-entire-message? true
                                       :query-params {:q [term]}}))
  (catch Exception e
    (println "Exception Message: " (.getMessage e)))))
