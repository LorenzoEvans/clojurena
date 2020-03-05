(ns clojurena.API.Users.user-get-requests
  (:require [clj-http.client :as client]
            [clojure.string :as str]
            [clojurena.API.utils :as utils]))


(defn get-user [id]
 "Returns a representation of a user object."
  (try
    (utils/async
     (client/get (str utils/user-base-url id) {:async? true}))
    (catch Exception e
      (println "Exception Message: " (.getMessage e)))))

(defn get-user-channel [id]
 "Returns a specified user channel."
  (try
    (utils/async
     (client/get (str utils/user-base-url id "/" "channel") {:async? true}))
    (catch Exception e
      (println "Exception Message: " (.getMessage e)))))

(defn get-user-channels [id]
  "Returns a list of a users channels."
  (try
    (utils/async
     (client/get (str utils/user-base-url id "/" "channels") {:async? true}))
    (catch Exception e
      (println "Exception Message: " (.getMessage e)))))
      
(defn get-follows [id]
 "Returns a list of channels and users a specified user is following."
  (try
    (utils/async
     (client/get (str utils/user-base-url id "/" "following") {:async? true}))
    (catch Exception e
      (println "Exception Message: " (.getMessage e)))))
      
(defn get-followers [id]
  "Returns a list of users following a specified user."
  (try
    (utils/async
      (client/get (str utils/user-base-url id "/" "followers") {:async? true}))
    (catch Exception e
      (println "Exception Message: " (.getMessage e)))))
  
