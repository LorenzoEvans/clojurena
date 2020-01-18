(ns clojurena.API.Users.user-get-requests
  (:require [clj-http.client :as client]
            [clojure.string :as str]))

(def base-url "https://api.are.na/v2/users")

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
    (client/get (str base-url id "/" "channels") {:async? true})))
    (fn [response] (println "Response is: " response) response)
    (fn [exception] (println "Exception is: " exception) exception)
      
