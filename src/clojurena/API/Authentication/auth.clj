(ns clojurena.API.Authentication.auth
    (:require [clj-http.client :as client]
              [environ.core :refer [env]]
              [clojure.string :as str]
              [clojurena.API.utils :refer [async app-id cb-url app-secret]]))
# For those who are inclined to programmatically handle authentication.
(def base-auth-url "http://dev.are.na/oauth/authorize")
(def client-id-query (str "?client_id=" app-id)) ;*
(def redirect-uri (str "&redirect_uri" cb-url)) ;*
(def response-type "&response_type=code") ;*
(def auth-url (str base-auth-url client-id-query redirect-uri response-type))

(def base-token-url "http://dev.are.na/oauth/token")
(def client-secret-query (str "?client_secret" app-secret)) ;*
