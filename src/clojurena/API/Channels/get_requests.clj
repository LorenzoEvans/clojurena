(ns clojurena.API.Channels.get-requests
 (:require [compojure.core :refer [GET defroutes]]
           [clojure.string :as str]))

(def base-endpoint "https://api.are.na/v2/channels")
(def channel-endpoint "https://api.are.na/")
(def all-channels 
    (GET base-endpoint []))

(def get-channel
; Maybe make multi arity fn instead
    (fn [& channel page limit]
     (GET (str channel-endpoint channel) [])))
; (defroutes get-channels
;     (GET (str)))
