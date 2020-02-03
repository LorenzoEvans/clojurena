(ns clojurena.block-get-tests
  (:require [clojure.test :refer :all]
            [clj-http.client :as client]
            [clojurena.API.Blocks.block-put-requests :refer :all]))

; Take advantage of fixtures for destructive tests.