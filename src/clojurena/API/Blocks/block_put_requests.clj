(ns clojurena.API.Blocks.block-put-requests
    (:require [clj-http.client :as client]
              [clojure.string :as str]
              [clojurena.API.utils :refer [async]]
              [clojurena.API.Blocks.block-get-requests :refer [base-url]])) 

(defn put-block [content id & title description]
    "Updates the contents/attributes of a block. Assumes content and id."
    (let [arg-map {:content content
                   :id id
                   :title (if (not= title nil) title)
                   :description (if (not= description nil) description)}]
      (async
        (client/put (str base-url "blocks/" id) 
          (cond 
            (and (= (:title arg-map) 
                    (:description arg-map) nil)) {:content (:content arg-map) 
                                                  :coerce :always}
            (not= nil (:title arg-map)) {:content (:content arg-map)
                                         :title (:title arg-map)
                                         :coerce :always}
            (not= nil (:description arg-map)) {:content (:content arg-map)
                                               :description (:description arg-map)
                                               :coerce :always}
            :else {:content (:content arg-map)
                   :title (:title arg-map)
                   :description (:description arg-map)
                   :coerce :always})
          (fn [response] (println "Response is: " response) response)
          (fn [exception] (println "Response is: " exception) exception)))))
              
                
(defn toggle-block-status [slug id status auth & user pass]
 "Changes the status of a block, specifically it's connection to a channel."
  (async
    (client/put (str base-url slug "/" "blocks/" id "/" selection) {:oauth-token (if (not= nil auth) auth) 
                                                                    :status status
                                                                    :basic-auth (if (not= nil user pass) [user pass])}
     (fn [response] (println "Response is: " response) response)
     (fn [exception] (println "Exception is: " exception) exception))))                       
