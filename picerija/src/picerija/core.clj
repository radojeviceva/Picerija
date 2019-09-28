(ns picerija.core
  (:use ring.util.json-response 
        ring.adapter.jetty
        compojure.core)
  (:require [ring.middleware.resource :refer [wrap-resource]]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [ring.util.response :as ring] 
            [compojure.route :as route]
            [compojure.core :refer [defroutes GET POST]]
            [picerija.pojedinacniPrikazi :as prikazi]
            [picerija.baza :as b])
)

(defn pocetna []
   (prikazi/index )
  )

(defn porudzbine []
   (prikazi/porudzbine (b/podaci))
  )

(defn obrisi [id]
  (b/obrisi id)
  (ring/redirect "/porudzbine")
  )

(defn izmeniPor [id]
  (prikazi/izmena (b/podatakPorudzbina id) (b/podaciPizza))
  )

(defn izmeniPorudzbinu [id pizzaid kolicina]
  (b/updatePorudzbina id pizzaid kolicina) 
  (ring/redirect "/porudzbine")
  )

(defn novaPor []
  (prikazi/novaPorudzbina (b/podaciPizza))
  )

(defn dodajPorudzbinu [pizzaid kolicina]
  (b/dodaj pizzaid kolicina)
   (ring/redirect "/porudzbine")
  )

(defroutes my_routes
 (GET "/" [] (pocetna))
 (GET "/porudzbine" [] (porudzbine))
 (GET "/izmeni/:id" [id] (izmeniPor id))
 (GET "/obrisi/:id" [id] (obrisi id))
 (POST "/update" [pizzaid kolicina id] (izmeniPorudzbinu id pizzaid kolicina))
 (GET "/novaporudzbina" [] (novaPor))
 (POST "/add" [pizza kolicina] (dodajPorudzbinu pizza kolicina))
 (route/resources "/"))
