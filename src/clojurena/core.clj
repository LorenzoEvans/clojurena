(ns clojurena.core
  (:require 
            [clojure.data.json :as json]
            [clj-http.client :as client]))

(defn -main
  "I don't do a whole lot."
  []
  (println "Hello, World!"))

(def block 
  (client/get "https://api.are.na/v2/blocks/8693"))
(def channel
  (client/get "https://api.are.na/v2/channels/pop-codeture"))

(println  block)
