(ns test.block-delete-tests
  (:require [clojurena.API.Blocks.block-delete-requests :refer :all]
            [clojure.test :refer :all]
            [clj-http.client :as client]
            [environ.core :as env]))

; Take advantage of fixtures for destructive tests.

(deftest delete-block
  (testing "Ability to delete blocks from specified channels"
    (is (= (:status (delete-block "geosymgif" "549706" (env :access-token)))))))
