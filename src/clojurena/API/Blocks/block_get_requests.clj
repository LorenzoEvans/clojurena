(ns clojurena.API.Blocks.block-get-requests
    (:require [clj-http.client :as client]
              [clojure.string :as str]
              [clojurena.API.utils :refer [async]])) 

(def base-url "https://api.are.na/v2/blocks/")

(defn get-block-by-id [block-id]
    "Returns the full representation of a block, id is an numeric string."
    (async
        (client/get (str base-url block-id) {:async? true}
         (fn [response] (println "Response is: " response))
         (fn [exception] (println "Exception is: " exception)))))

(defn get-blocks-channels [block-id]
    "Returns a paginated list of channels a specified block exists in."
    (async
        (client/get (str base-url block-id) {:async? true}
           (fn [response] (println "Response is: " response))
           (fn [exception] (println "Exception is: " exception)))))
         
