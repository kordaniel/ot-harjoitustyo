# Vaatimusmäärittely

## Sovelluksen tarkoitus
Sovellus on yksinkertainen, klassinen Tetris-peli. Sovelluksella ei ole erilaisia käyttäjärooleja mutta käyttäjä voi halutessaan asettaa itselleen nimimerkin. Peli on tietyn kokoinen ruudukko ja seuraava palikka arvotaan satunnaisesti. Pelin tavoitteena on pitää ruudukko mahdollisimman tyhjänä. Pelin tahti nopeutuu mitä kauemmin pelaaja on pelannut.

## Käyttöliittymäluonnos
![Käyttöliittymäluonnos](https://raw.githubusercontent.com/kordaniel/ot-harjoitustyo/master/dokumentaatio/kuvat/gui_mockup.png)  
Peli aukeaa menunäkymään, josta valinnan mukaan voi asettaa itselleen nimimerkin, käynnistää pelin, tarkastella ennätystuloksia tai poistua sovelluksesta.

## Perusversion tarjoama toiminnallisuus
* Pelaaja voi pelata tetristä
  * Ilman asetettua nimimerkkiä, jolloin peli ei tallenna mitään
  * Nimimerkin kanssa, jolloin mahdollinen huipputulos tallennetetaan huipputulosten listaan, jos pistemäärä riittävän korkea
  * Pelin keskeyttäminen, "pause".
* Pelinäkymässä näytetään
  * Itse pelitilanne
  * Seuraavaksi tuleva palikka
  * Tämänhetkinen tulos
  * Tämänhetkinen taso/hävitetyt kerrokset
  * Korkein tunnettu tulos/pistemäärä
* Pelissä olevat palikat
  * O eli "Neliö"
  * I
  * T
  * L
  * J
  * S
  * Z
  * Kaikkia palikoita voi
    * Käännellä
    * Tiputtaa

## Jatkokehitysideoita
* Sovellus voisi tallentaa eri nimimerkkien tilastoja, esim pelattujen pelien määrää, tuloksia, paljonko aikaa käyttäjä on käyttänyt pelin ääressä.  
* Jos nimimerkki on jo "varattu", eli joku on joskus käyttänyt samaa nimimerkkiä, peli voisi kysyä varmistuksen siitä, haluaako käyttäjä käyttää syöttämäänsä nimimerkkiä vai kenties vaihtaa toiseen?  
* Rekisteröitymismahdollisuus, henkilökohtaiset tiedot.
* Keskeneräisen pelitilanteen tallennus ja mahdollisuus jatkaa myöhemmin.
* Erilaisten palikoiden valitseminen/poisjättäminen pelistä.
* Kaksinpeli
* Erilaiset teemat/värit, niiden valitsemismahdollisuus. Lokalisaatio, eli kielen valitsemismahdollisuus
  * Tallennetaan asetuksiin jolloin valittu teeema/kieli pysyy vaikka sovellus suljettaisiin
  * Valinnat voitaisiin tallentaa käyttäjäkohtaisesti, jos käyttäjäprofiilit toteutetaan
