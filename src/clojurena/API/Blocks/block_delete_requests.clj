(ns clojurena.API.Blocks.block-delete-requests
    (:require [clj-http.client :as client]
              [clojure.string :as str]
              [clojurena.API.utils :as utils]
              [clojurena.API.Channels.channel-get-requests :as channel-get])) 
         
(defn delete-block [slug channel-id block-id auth]
  "Deletes/removes connection between a block and channel, requires authentication"
  (let [channel-id (:id (channel-get/get-single-channel slug))]
   (try
    (utils/async 
      (client/delete (str utils/channel-base-url slug "/" channel-id "/" "blocks" "/" block-id) {:async? true
                                                                                                 :oauth auth})))))
    

; currently having trouble pulling channel ID
; (def del-test 
;   (delete-block "Clojurena-test" "5967619"))

; (println del-test)
