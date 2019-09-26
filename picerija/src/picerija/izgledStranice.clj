(ns picerija.izgledStranice
  (:use [hiccup.element :only (link-to)])
  (:require [hiccup.page :as h]
            [hiccup.page :refer [html5 include-css]]))

(defn izgled [body]
  (h/html5
    [:head
     [:title "Pizzerija"]
     (include-css "/css/bootstrap.css" "js/bootstrap.js" "js/main.js" "js/jquery.js" "/css/bootstrap.min.css" "/css/responsive.css" "css/style.css" "https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css")
     ]
    [:body {:class "homepage"}
     [:header {:id "header"}
      [:nav {:class "navbar navbar-fixed-top" :role "banner"}
            [:div {:class "container"}
                [:div {:class "navbar-header"}
                    [:button {:type "button" :class "navbar-toggle" :data-toggle "collapse" :data-target ".navbar-collapse"}
                        [:span {:class "sr-only"} "Toggle navigation"]
                        [:span {:class "icon-bar"}]
                        [:span {:class "icon-bar"}]
                        [:span {:class "icon-bar"}]
                     ]
                    [:a {:class "navbar-brand" :href "/"} "Pizzerija"]
                ]

                [:div {:class "collapse navbar-collapse navbar-right"}
                    [:ul {:class "nav navbar-nav"}
                     [:li [:a {:href="/porudzbine"} "Porudzbine"]]
                     [:li [:a {:href="/novaporudzbina"} "Dodaj porudzbinu"]]
                     [:li [:a {:href="/pretraga"} "Pretrazi pizze"]]
					
                    ]
                ]
             ]
            ]
      ]
     body

      	[:footer {:id "footer" :class "midnight-blue"}
        [:div {:class "container"}
            [:div {:class "row"}
              [:div {:class "col-sm-6"}
                    "Požarevačka 13, Beograd, Vračar"[:br]
                    "060 343 2116, (011) 243 2116"[:br]
                    "Radno vreme: 11.00 – 23.00, nedeljom 13.00 - 23.00"[:br]
                    "pizzerija@gmail.com"[:br][:br]
                    [:a {:href "https://www.facebook.com/picafabrika/" :class "fa fa-facebook"}]
                    [:a {:href "https://twitter.com/hashtag/pizzerija" :class "fa fa-twitter"}][:br][:br]
                    "Pizzerija. All Rights Reserved. Majce Zmajce."
               ]
           ]
   ]]]
  ))

