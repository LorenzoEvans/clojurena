(ns clojurena.API.Channels.get-requests
 (:require [clj-http.client :as client]
           [clojure.string :as str]
           [clojurena.API.utils :refer [async app-id cb-url app-secret]])
 (:import '(java.util.concurrent TimeoutException TimeUnit)))          

(def base-endpoint "https://api.are.na/v2/channels")
(def channel-endpoint "https://api.are.na/")
(def all-public-channels 
    (client/get base-endpoint))

(defn get-channel
 "Multi-arity function for getting channels based on channel name, page, and pagination limit" 
    ([url] 
     (async
      (client/get url {:async? true}
       (fn [response] (println "response is: " response)))))
    ([base-url channel]
     (async
      (client/get (str base-url channel) {:async? true}
        (fn [response] (println "response is: " response)))))
    ([base-url channel page]
     (async 
        (client/get (str base-url channel "?" "page=" page) {:async? true}
            (fn [response] (println "response is: " response)))))
    ([base-url channel page limit]
     (async
        (client/get (str base-url channel "?" "page=" page "&" "per=" limit)))))      
