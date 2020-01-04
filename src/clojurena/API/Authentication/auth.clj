(ns clojurena.API.Authentication.auth
    (:require [clj-http :as client]
              [environ.core :refer [env]]))

(def app-id (env :app-id))
(def app-secret (env :app-sec-key))
(def cb-url (env :cb-url))