(defproject picerija "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [compojure "1.4.0"]
                 [ring/ring "1.7.1"]
                 [ring/ring-defaults "0.3.2"]
                 [ring/ring-json "0.5.0"]
                 [ring/ring-jetty-adapter "1.7.0"]
                 [ring/ring-core "1.7.0"]
                 [ring-json-response "0.2.0"]]
   :plugins [[lein-ring "0.12.5"]]
   :ring { :handler picerija.handler/app}
  )
