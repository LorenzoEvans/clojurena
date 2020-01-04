(ns clojurena.core
  (:require [compojure.core :refer :all]
            [compojure.response :as res]
            [clojure.data.json :as json]
            [clj-http.client :as client]))

(defn -main
  "I don't do a whole lot."
  []
  (println "Hello, World!"))

(def block 
  (client/get "https://api.are.na/v2/blocks/8693"))

(println  block)
