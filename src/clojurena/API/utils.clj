(ns clojurena.API.utils
 (:require [environ.core :refer [env]]
           [clojure.string :as str])
 (:import (java.util.concurrent TimeoutException TimeUnit)))

;add baseurl's here maybe? 
; Re-using them the way we are currently works, but it may link dependencies throughout parts of
; the library in a way that will be problematic over time, i.e changing the channel base-url affecting block level http requests.

(defn async [request]
    (try
     (.get request 10 TimeUnit/SECONDS)
     (catch TimeoutException e
        (.cancel request true))))

(def app-id (env :app-id))
(def app-secret (env :app-sec-key))
(def cb-url (env :cb-url))
