(ns picerija.baza
   (:require [clojure.java.jdbc :as sql]))

(def connection 
  {:classname "com.mysql.jdbc.Driver"
   :subprotocol "mysql"
   :subname "//localhost/showroom"
   :user "root"
   :password ""})

(defn podaci []
   (into [] (sql/query connection ["SELECT * FROM porudzbina, pizza WHERE porudzbina.pizzaID = pizza.pizzaID"])))

(defn obrisi [id]
  (sql/delete! connection :porudzbina ["porudzbinaid = ?" id])
  )

(defn podaciPizza []
   (into [] (sql/query connection ["SELECT * FROM pizza"])))


(defn podatakPorudzbina [id]
  (into [] (sql/query connection ["SELECT * FROM porudzbina, pizza WHERE porudzbina.pizzaID = pizza.pizzaID && porudzbina.porudzbinaID=?" id])))

(defn updatePorudzbina [id pizzaid kolicina]
  (sql/update! connection :porudzbina {:porudzbinaid id :pizzaid pizzaid :kolicina kolicina} ["porudzbinaid = ?" id]))

(defn dodaj [pizzaid kolicina]
  (sql/insert! connection :porudzbina [:pizzaid :kolicina :datumpreuzimanja] [pizzaid (read-string kolicina) (java.time.LocalDateTime/now)]))

(defn podaciSearch [filter]
  (into [] (sql/query connection ["SELECT *, SUM(porudzbina.kolicina) as broj FROM porudzbina, pizza WHERE porudzbina.pizzaID = pizza.pizzaID && pizza.nazivVrste LIKE ? group by pizza.pizzaID" (str "%" filter "%")]))
  )