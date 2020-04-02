(ns clojurena.API.Users.user-get-requests
  (:require [clj-http.client :as client]
            [clojure.string :as str]
            [clojurena.API.utils :as utils]))


(defn get-user [id]
 "Returns a representation of a user object."
  (try
     (client/get (str utils/user-base-url id))
    (catch Exception e
      (println "Exception Message: " (.getMessage e)))))


(defn get-user-channels [id]
  "Returns a list of a users channels."
  (let [url (str utils/channel-base-url id)]
    (try
        (client/get url)
      (catch Exception e
        (println "Exception Message: " (.getMessage e))))))
      
(defn get-follows [id]
 "Returns a list of channels and users a specified user is following."
  (try
     (client/get (str utils/user-base-url id "/" "following"))
    (catch Exception e
      (println "Exception Message: " (.getMessage e)))))
      
(defn get-followers [id]
  "Returns a list of users following a specified user."
  (try
      (client/get (str utils/user-base-url id "/" "followers"))
    (catch Exception e
      (println "Exception Message: " (.getMessage e)))))
  
