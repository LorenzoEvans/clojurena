(ns clojurena.channel-post-tests
  (:require [clojure.test :refer :all]
            [clj-http.client :as client]
            [clojurena.API.Channels.channel-post-requests :refer :all]))

; Take advantage of fixtures for destructive tests.