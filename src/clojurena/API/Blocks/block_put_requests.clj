(ns clojurena.API.Blocks.block-put-requests
    (:require [clj-http.client :as client]
              [clojure.string :as str]
              [clojurena.API.utils :refer [async]]
              [clojurena.API.Blocks.block-get-requests :refer [base-url]])) 

(defn put-block [content id & title description]
    "Updates the contents/attributes of a block."
    (async
        (client/put (str base-url "blocks/" id) {:content content
                                                 :coerce :always})))
                                                 
