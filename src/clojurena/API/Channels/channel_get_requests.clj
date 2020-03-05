(ns clojurena.API.Channels.channel-get-requests
 (:require [clj-http.client :as client]
		   [clojure.string :as str]
		   [clojurena.API.utils :as utils])) ; require entire utils ns as utils         

(def all-public-channels
  "Returns all public channels. May be a large amount of data, so be careful/patient." 
	(client/get utils/channel-base-url))

(defn get-single-channel [channel-name]
	"Returns contents of specified channel, can be paginated."
  (try
    (utils/async
      (client/get (str utils/channel-base-url channel-name) {:async? true}))
    (catch Exception e
      (println "Exception Message: " (.getMessage e)))))

(defn get-channel-thumb [channel-name]
 "Returns a 9 block representation of a specified channel."
 (try
  (utils/async
    (client/get (str utils/channel-base-url channel-name "/" "thumb") {:async? true}))
  (catch Exception e
    (println "Exception Message: " (.getMessage e)))))

(defn get-channel-connections [channel-name]
 "Returns a collection all of the connections a specified channel has, sans contents, can be paginated."
  (try 
    (utils/async 
      (client/get (str utils/channel-base-url channel-name "/" "connections") {:async? true}))
    (catch Exception e
      (println "Exception Message: " (.getMessage e)))))

(defn get-connected-channels [channel-name]
	"Returns a list of all channels connection to a specified channel, sans contents, can be paginated."
  (try
    (utils/async
      (client/get (str utils/channel-base-url channel-name "/" "channels")))
    (catch Exception e
      (println "Exception Message: " (.getMessage e)))))

(defn get-channel-contents [channel-name]
  "Returns a list of channel contents, sans collaborators."
  (try
    (utils/async
      (client/get (str utils/channel-base-url channel-name "/" "contents")))
    (catch Exception e
      (println "Exception Message: " (.getMessage e)))))


