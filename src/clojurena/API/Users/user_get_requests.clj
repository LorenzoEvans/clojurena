(ns clojurena.API.Users.user-get-requests
  (:require [clj-http.client :as client]
            [clojure.string :as str]
            [clojurena.API.utils :refer [async]]))

(def base-url "https://api.are.na/v2/users/")

(defn get-user [id]
 "Returns a representation of a user object."
  (async
    (client/get (str base-url id) {:async? true}
     (fn [response] (println "Response is: " response) response)
     (fn [exception] (println "Exception is: " exception) exception))))

(defn get-user-channel [id]
 "Returns a specified user channel."
  (async
    (client/get (str base-url id "/" "channel") {:async? true}
     (fn [response] (println "Response is: " response) response)
     (fn [exception] (println "Exception is: " exception) exception))))

(defn get-user-channels [id]
  "Returns a list of a users channels."
  (async
    (client/get (str base-url id "/" "channels") {:async? true}
     (fn [response] (println "Response is: " response) response)
     (fn [exception] (println "Exception is: " exception) exception))))
      
(defn get-follows [id]
 "Returns a list of channels and users a specified user is following."
  (async
    (client/get (str base-url id "/" "following") {:async? true}
     (fn [response] (println "Response is: " response) response)
     (fn [exception] (println "Exception is: " exception) exception))))
      
(defn get-followers [id]
  "Returns a list of users following a specified user."
  (async
    (client/get (str base-url id "/" "followers") {:async? true}
     (fn [response] (println "Response is: " response) response)
     (fn [exception] (println "Exception is: " exception) exception))))
  
