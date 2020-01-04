(ns clojurena.API.Channels.get-requests
 (:require [clj-http.client :as client]
           [clojure.string :as str])
 (:import '(java.util.concurrent TimeoutException TimeUnit)))          

(def base-endpoint "https://api.are.na/v2/channels")
(def channel-endpoint "https://api.are.na/")
(def all-channels 
    (client/get base-endpoint))

(def get-channel
; Maybe make multi arity fn instead
    (fn [& channel page limit]
     (GET (str channel-endpoint channel) [])))

(defn async [request]
    (try
     (.get request 5 TimeUnit/SECONDS)
     (catch TimeoutException e
        (.cancel request true))))

(defn get-channel
    ([url] 
     (async
      (client/get url {:async? true}
       (fn [response] (println "response is: " response)))))
    ([base-url channel]
     (async
      (client/get (str base-url channel) {:async? true}
        (fn [response] (println "response is: " response)))))
    ([base-url channel page])
    ([base-url channel page limit]))      
