(ns clojurena.API.Blocks.block-get-requests
    (:require [clj-http.client :as client]
              [clojure.string :as str]
              [clojurena.API.utils :as utils])) 

(defn get-block-by-id [block-id]
    "Returns the full representation of a block, id is an numeric string, does not require authentication."
    (try
        (client/get (str utils/block-base-url block-id))
      (catch Exception e
        (println "Exception Message: " (.getMessage e)))))


(defn get-blocks-channels [block-id]
    "Returns a paginated list of channels a specified block exists in, does not require authentication, does have pagination."
    (try
        (client/get (str utils/channel-base-url block-id))
      (catch Exception e
        (println "Exception Message: " (.getMessage e)))))
         
