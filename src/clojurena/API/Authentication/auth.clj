(ns clojurena.API.Authentication.auth
    (:require [clj-http.client :as client]
              [environ.core :refer [env]]
              [clojure.string :as str]
              [clojurena.API.utils :refer [async app-id cb-url app-secret]]))
              

; Authorization for lib

(def base-auth-url "http://dev.are.na/oauth/authorize")
(def client-id-query (str "?client_id=" app-id)) ;*
(def redirect-uri (str "&redirect_uri" cb-url)) ;*
(def response-type "&response_type=code") ;*
(def auth-url (str base-auth-url client-id-query redirect-uri response-type))
; (def auth-data 
;     (async 
;         (client/get auth-url {:async? true}
;             (fn [response] (println "Response is: " response))
;             (fn [exception] (println "Exception is: " exception)))))
; (println auth-data)
; Access Token (for general are.na access?)
; (def returned-code <= current
;     ;something like (get-in auth-data [:cookies _platform_session :value])
; )
(def base-token-url "http://dev.are.na/oauth/token")
(def client-secret-query (str "?client_secret" app-secret)) ;*
; deprecated (def code "&code=RETURNED") ;* ? pull this off auth-data





; (def token-url
;     (str base-token-url client-id-query client-secret-query ))
; (def access-token)
    

