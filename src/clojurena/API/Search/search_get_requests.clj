(ns clojurena.API.Search.search-get-requests
  (:require [clj-http.client :as client]
            [clojure.string :as str]
            [clojurena.API.utils :refer [async]]))
            

(def base-url "https://api.are.na/v2/search?q=")

(defn search [term]
  "Searches the entire are.na system for blocks, users and channels matching the query")
  
