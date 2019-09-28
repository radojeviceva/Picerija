(ns picerija.pojedinacniPrikazi
  (:use hiccup.page hiccup.element
        )
  (:require  
    [hiccup.core :refer [h]]
    [picerija.izgledStranice :as izgledSvega]
     [hiccup.form :as form]
     [ring.util.anti-forgery :as anti-forgery]
))

(defn index []
  (izgledSvega/izgled 
    [:div {:class "container"}
          [:a [:img {:class "img-fluid" :alt "Responsive image" :src "/img/1.jpg"}]]
      ]
    ))

(defn porudzbine [podaci] 
  (izgledSvega/izgled 
   [:section {:id "porudzbine"}
        [:div {:class "container"}
           [:div
                [:h2 "Porudzbine"]
                [:p {:class "lead"} "Lista porudzbina"]
            ]

            [:div {:class "row"}
                [:div {:class "porudzbine"}
                     [:table {:class "table table-hover"}
                       [:thead
                         [:tr
                           [:th "Pizza"]
                           [:th "Kolicina"]
                           [:th "Datum preuzimanja"]
                           [:th "Izmena"]
                           [:th "Brisanje"]
                         ]
                       ]
                       [:tbody
                          [:tr 
                           (map 
                             (fn [podatak]
                               [:tr
                                [:td (:nazivvrste podatak)]
                                [:td (:kolicina podatak)]
                                [:td (.toString (:datumpreuzimanja podatak))] 
                                [:td [:a {:class "btn btn-info" :href (str "/izmeni/" (h (:porudzbinaid podatak)))} "Izmeni" ]]
                                [:td [:a {:class "btn btn-danger" :href (str "/obrisi/" (h (:porudzbinaid podatak)))} "Obrisi" ]]
                           ] ) podaci)]
  ]]]]]]  
 ))

(defn izmenaforma [porudzbina pizze]
   (map 
      (fn [porudzbina]
                     (form/form-to [:post "/update"]
                       (anti-forgery/anti-forgery-field)
                      [:div {:class "col-md-6"}
                        [:label {:for "pizza"} "Pizza"]
                        [:select {:name "pizzaid" :class "form-control" :id "pizza" :value (:pizzaid porudzbina)}
                         (map (fn [pizza]
                                [:option {:value (:pizzaid pizza)} (:nazivvrste pizza)]) pizze)
                         ]
                       ]

                      [:div {:class "col-md-12"}
                        [:label {:for "kolicina"} "Kolicina"]
                        [:input {:type "number" :name "kolicina" :class "form-control" :id "kolicina" :value (:kolicina porudzbina)}]
                     ]
                      [:div {:class "col-md-12"}
                        [:label {:for "id" }]
                        [:input {:type "hidden" :name "id" :class "form-control" :id "kolicina" :value (:porudzbinaid porudzbina)}]
                      ]
                      [:div {:class "col-md-12"}
                        [:label {:for "dugme"}]
                        [:input {:type "submit" :class "form-control btn-info" :id "dugme" :value "Izmeni"}]
                      ]
                      )) porudzbina)
  
  )

(defn izmena [porudzbina pizze]
  (izgledSvega/izgled 

    [:section {:id "porudzbina"}
         [:div {:class "container"}
          [:div {:class "center wow fadeInDown"}
                [:h2 "Izmeni porudzbinu"]
                 [:p {:class "lead"} "Izmena porudzbine"]
             ]

             [:div {:class "row"}
                 [:div  {:class "porudzbine"}
                (izmenaforma porudzbina pizze)
                    ]
                 ]
            ]
        ]
    )
  )