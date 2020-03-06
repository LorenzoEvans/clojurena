(defproject clojurena "0.1.0-SNAPSHOT"
  :description "A wrapper for the are.na api in Clojure"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [clj-http "3.10.0"]
                 [org.clojure/data.json "0.2.6"]
                 [environ "1.1.0"]
                 [com.fzakaria/slf4j-timbre "0.3.19"]]
  :main clojurena.core
  :aot clojurena.core
  :paths ["src" "clojurena" "test"]
  :profiles {:dev {:dependencies [[midje "1.6.0" :exclusions [org.clojure/clojure]]]
                   :plugins [[lein-midje "3.2.1"]]}
             :uberjar {:aot ["clojurena.core"]}})
