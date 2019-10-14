# picerija

Clojure aplikacija za porucivanje pizza, radjena kao projekat iz predmeta Web programiranje.

Korisnik moze da pregleda pizze koje su u ponudi. Moze izvrsiti porucivanje pizza, kao i izmenu i brisanje svoje narudzbine. Takodje, postoji opcija za pregled svih porudzbina. 
Koriscen je hiccup dependency za kombinaciju HTML-a sa Clojure-om. Projekat se povezuje na MYSQL bazu.  

Pocetnik sam u Clojure programiranju, ali sam se trudila da projekat bude uradjen bez puno ponavljanja istog koda, tako da je kod rasporedjen u smislene celine radi lakseg razumevanja, i sto manje ponavljanja.
Ukljucivanjem jednog namespace-a u drugi omoguceno je da se kod ne ponavlja, vec samo pozove iz ukljucenog namespace-a.

U toku izrade projekta bile su zabune oko ukljucivanja .css fajlova, ali su resene.

Imala sam nameru da cuvanje i prikaz datuma bude drugaciji, da koristim neki dependency za to, ali nisam uspela da realizujem ideju na prvo zamisljeni nacin, pa sam preko java.time paketa resila problem.   

## Usage
Podaci za aplikaciju su u MYSQL bazi
Da bi se aplikacija pokrenula treba instalirati Leiningen. Pokretanje: lein ring server

## License

Copyright © 2019 Maja

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
