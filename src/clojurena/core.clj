(ns clojurena.core
  (:require [compojure.core :refer :all]
            [compojure.response :as res]
            [clojure.data.json :as json]))

(defn -main
  "I don't do a whole lot."
  []
  (println "Hello, World!"))

(def block 
  (GET "https://api.are.na/v2/blocks/:1" []))

(println (compojure.response/render block :get))
