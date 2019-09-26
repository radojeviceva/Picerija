(ns picerija.pojedinacniPrikazi
  (:use hiccup.page hiccup.element)
  (:require  
    [hiccup.core :refer [h]]
    [picerija.izgledStranice :as izgledSvega]))

(defn index []
  (izgledSvega/izgled 
    [:div {:class "container"}
          [:a [:img {:class "img-fluid" :alt "Responsive image" :src "/img/1.jpg"}]]
      ]
    ))