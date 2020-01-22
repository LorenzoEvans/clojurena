(ns clojurena.API.Search.search-get-requests
  (:require [clj-http.client :as client]
            [clojure.string :as str]
            [clojurena.API.utils :refer [async]]))
            

(def base-search-url "https://api.are.na/v2/search?q=")
(def user-search-url "https://api.are.na/v2/search/users?q=")
(def channel-search-url "https://api.are.na/v2/search/channels?q=")
(def block-search-url "https://api.are.na/v2/search/blocks?q=")

(defn search [term]
  "Searches the entire are.na system for blocks, users and channels matching the query."
  (async
    (client/get (str base-search-url term) {:async? true}
     (fn [response] (println "Response is: " response) response)
     (fn [exception] (println "Exception is: " exception) exception))))
  
(defn search-users [term]
  "Searches the are.na system for users that match the query."
  (async
    (client/get (str user-search-url term) {:async? true}
     (fn [response] (println "Response is: " response) response)
     (fn [exception] (println "Exception is: " exception) exception))))
      
(defn search-channels [term]
  "Searches the are.na system for channels that match the query."
  (async
    (client/get (str channel-search-url term) {:async? true}
     (fn [response] (println "Response is: " response) response)
     (fn [exception] (println "Exception is: " exception) exception))))


(defn search-blocks [term]
 "Searches the are.na system for channels that match the query."
 (async
  (client/get (str block-search-url term) {:async? true}
    (fn [response] (println "Response is: " response) response)
    (fn [exception] (println "Exception is: " exception) exception))))
