e2Reservation
=============

Ensimmäinen rest-api on nyt tehty:

GET /reservations (hakee kaikki lisätyt varaukset)
GET /reservations/{id} (hakee varauksen id:llä)
PUT /reservations  (lisää uuden varauksen jsonina)
POST /reservations (päivittää id:n perusteella uuden varauksen tiedot, varaus jsonina)
DELETE /reservations/{id} (poistaa id:llä varauksen tai siis merkkaa poistetuksi, dataa kun ei saa oikeasti poistaa!)

Ensi viikolla jo käyttöliittymän tynkää. Tällä viikolla ei ollut niin kauheasti aikaa työkiireiden takia.

Sovellus käynnistää komentoriviltä mvn spring-boot:run, jonka 
jälkeen selaimessa tulisi mennä osoitteeseen http://localhost:8080. 

Tällä hetkellä kuitenkaan käyttäliittymää ja ainuttakaan kontrolleria ei ole toteutettu, joten 
ohjelman suoritus ei tuota mitään. Ensi vaiheessa toteutin domain-oliot ja niiden repositorit 
sekä ReservationManager-palvelun toiminnallisuutta, jonka ympärille sovelluksen ydintoiminnot 
rakentuvat sekä siihen liittyvät testit.


- [Aiheen kuvaus](https://github.com/triton93/e2Reservation/blob/master/dokumentit/aihe.md)
- [Vaatimusmäärittely](https://github.com/triton93/e2Reservation/blob/master/dokumentit/backlog.md)
- [Työaikakirjanpito](https://github.com/triton93/e2Reservation/blob/master/dokumentit/tunnit.md)


 



