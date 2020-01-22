(ns clojurena.API.Channels.channel-put-requests
 (:require [clj-http.client :as client]
           [clojure.string :as str]
           [clojurena.API.utils :refer [async]]
           [clojurena.API.Blocks.block-put-requests :refer [toggle-block-status]]))

(defn update-channel []
  "Updates the contents of a channel")

(defn update-order []
  "Updates the order(?) of a channel according to id's.")

(defn toggle-block [status]
  "Toggles the status of a specific block.")
