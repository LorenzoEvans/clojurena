(ns clojurena.API.Blocks.block-delete-requests
    (:require [clj-http.client :as client]
              [clojure.string :as str]
              [clojurena.API.utils :refer [async]]
              [clojurena.API.Channels.channel-get-requests :refer [base-url get-single-channel]])) 

(def default-url "https://api.are.na/v2/channel/")
         
(defn delete-block [slug channel-id block-id auth]
  "Deletes/removes connection between a block and channel, requires authentication"
  (let [channel-id (:id (get-single-channel slug))]
   (try
    (async 
      (client/delete (str default-url slug "/" channel-id "/" "blocks" "/" block-id) {:async? true
                                                                                      :oauth auth})))))
    

; currently having trouble pulling channel ID
; (def del-test 
;   (delete-block "Clojurena-test" "5967619"))

; (println del-test)
