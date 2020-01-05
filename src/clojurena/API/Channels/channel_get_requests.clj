(ns clojurena.API.Channels.channel-get-requests
 (:require [clj-http.client :as client]
		   [clojure.string :as str]
		   [clojurena.API.utils :refer [async app-id cb-url app-secret]]))          

(def base-url "https://api.are.na/v2/channels/")
(def all-public-channels 
	(client/get base-url))

(defn get-single-channel [channel-name]
	"Returns contents of specified channel, can be paginated."
	(async
		(client/get (str base-url channel-name) {:async? true}
		 (fn [response] (println "Response is: " response) response)
		 (fn [exception] (println "Exception is: " exception) exception))))

(defn get-channel-thumb [channel-name]
 "Returns a 9 block representation of a specified channel."
 (async
	(client/get (str base-url channel-name "/" "thumb") {:async? true}
	 (fn [response] (println "Response is: " response) response)
	 (fn [exception] (println "Exception is: " exception) exception))))

(defn get-channel-connections [channel-name]
 "Returns a collection all of the connections a specified channel has, sans contents, can be paginated."
	(async 
		(client/get (str base-url channel-name "/" "connections") {:async? true}
		 (fn [response] (println "Response is: " response) response)
		 (fn [exception] (println "Exception is: " exception) exception))))

(defn get-connected-blocks [channel-name]
	"Returns a list of all channels connection to a specified channel, sans contents, can be paginated."
	(async
	  (client/get (str base-url channel-name "/" "channels")
	   (fn [response] (println "Response is: " response) response)
	   (fn [exception] (println "Exception is: " exception) exception))))

; (defn get-channel
;  "Multi-arity function for getting channels based on channel name, page, and pagination limit" 
  
;     ([base-url slug page limit]
;      (async
;         (client/get (str base-url channel "?" "page=" page "&" "per=" limit)))))    
  
