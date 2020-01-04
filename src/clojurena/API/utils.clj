(ns clojurena.API.utils
 (:require [environ.core :refer [env]]
           [clojure.string :as str])
 (:import (java.util.concurrent TimeoutException TimeUnit)))

(defn async [request]
    (try
     (.get request 5 TimeUnit/SECONDS)
     (catch TimeoutException e
        (.cancel request true))))

(def app-id (env :app-id))
(def app-secret (env :app-sec-key))
(def cb-url (env :cb-url))
