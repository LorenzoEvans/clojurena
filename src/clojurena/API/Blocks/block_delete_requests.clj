(ns clojurena.API.Blocks.block-delete-requests
    (:require [clj-http.client :as client]
              [clojure.string :as str]
              [clojurena.API.utils :refer [async]]
              [clojurena.API.Channels.channel-get-requests :refer [base-url get-single-channel]])) 

(def default-url "https://api.are.na/v2/channel/")

(defn delete-block [slug channel-id block-id & args] ;handle args w/ hashmap
    "Deletes/removes connection between a block and channel, requires authentication"
  ; so we have to get the channel, pull the channel-id off of it, then pipe that bit of info
  ; into the delete request....bet!
  ; alright so... we have to use & args, but now auth-token, user and pass can't be resolved.
  ; Righting an variable arity function seems messy..
  ; args is expecting a sequence of kv pairs that should contain auth-token OR user name and path?
    (let [channel-id (:id (get-single-channel slug))]
      (async
        (client/delete (str default-url slug "/" channel-id "/" "blocks" "/" block-id)
                       {:async? true
                        :headers {"Authorization" (if (not= nil (:auth-token args)) (:auth-token args) nil)}
                        :basic-auth (if (not= nil (and (:user args) (:pass args))) [(:user args) (:pass args)])}
         (fn [response] (println "Response is: " response) response)
         (fn [exception] (println "Exception is: " exception) exception)))))


    

; currently having trouble pulling channel ID
; (def del-test 
;   (delete-block "Clojurena-test" "5967619"))

; (println del-test)
