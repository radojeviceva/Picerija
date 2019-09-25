(ns picerija.core
  (:use ring.util.json-response 
        ring.adapter.jetty
        compojure.core)
  (:require [ring.middleware.resource :refer [wrap-resource]]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [ring.util.response :as ring] 
            [compojure.route :as route]
            [compojure.core :refer [defroutes GET POST]])
)
(defroutes my_routes
  (route/resources "/"))
