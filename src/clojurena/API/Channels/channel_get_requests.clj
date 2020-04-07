(ns clojurena.API.Channels.channel-get-requests
 (:require [clj-http.client :as client]
       [clojure.string :as str]
       [clojure.data.json :as json]
		   [clojurena.API.utils :as utils])) ; require entire utils ns as utils         

(defn all-public-channels []
  "Returns all public channels. May be a large amount of data, so be careful/patient." 
	(client/get utils/channel-base-url))

(defn get-single-channel [channel-name]
	"Returns contents of specified channel, can be paginated."
  (try
    (client/get (str utils/channel-base-url channel-name) {:as :json})
   (catch Exception e
      (println "Exception Message: " (.getMessage e)))))

(defn get-channel-thumb [channel-name]
 "Returns a 9 block representation of a specified channel."
 (try
    (client/get (str utils/channel-base-url channel-name "/" "thumb"))
  (catch Exception e
    (println "Exception Message: " (.getMessage e)))))

(defn get-channel-connections [channel-name]
 "Returns a collection all of the connections a specified channel has, sans contents, can be paginated."
  (try 
      (client/get (str utils/channel-base-url channel-name "/" "connections") {:as :clojure})
    (catch Exception e
      (println "Exception Message: " (.getMessage e)))))

(defn get-connected-channels [channel-name]
	"Returns a list of all channels connection to a specified channel, sans contents, can be paginated."
  (let [channel-id (:id (json/read-str (:body (get-single-channel channel-name)) :key-fn keyword))]
    (try
      (client/get (str utils/channel-base-url channel-id "/" "channels"))
    (catch Exception e
      (println "Exception Message: " (.getMessage e))))))

      (defn get-channel-contents [channel-name]
  "Returns a list of channel contents, sans collaborators."
  (try
    (client/get (str utils/channel-base-url channel-name "/" "contents"))
    (catch Exception e
      (println "Exception Message: " (.getMessage e)))))


