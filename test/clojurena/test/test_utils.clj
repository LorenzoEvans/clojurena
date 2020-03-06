(ns clojurena.test.test_utils
  (:require [environ.core :refer [env]]
            [clojure.string :as str])
  (:import (java.util.concurrent TimeoutException TimeUnit)))


(def channel-base-url "https://api.are.na/v2/channels/")
(def block-base-url "http://api.are.na/v2/blocks/")
(def base-search-url "https://api.are.na/v2/search?q=")
(def user-search-url "https://api.are.na/v2/search/users?q=")
(def channel-search-url "https://api.are.na/v2/search/channels?q=")
(def block-search-url "https://api.are.na/v2/search/blocks?q=")
(def user-base-url "https://api.are.na/v2/users/")

(defn async [request]
    (try
     (.get request 10 TimeUnit/SECONDS)
     (catch TimeoutException e
        (.cancel request true))))

(def app-id (env :app-id))
(def auth-token (env :access-token))
(def app-secret (env :app-sec-key))
(def cb-url (env :cb-url))