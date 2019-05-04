# Työaikakirjanpito

| Päivä | Aika | Mitä tein |
| :----:|:-----| :---------|
| 22.3. | 1h   | Projektin alustus, materiaalin lukemista|
| 26.3  | 2h   | Vaatimusmääritelmän, käyttöliittymäluonnosten laatiminen|
| 29.3  | 1h   | Maven&Checkstylen tutkimista, käyttöönotto projektissa|
| 29.3  | 1h   | JavaFX tutustumista, sovellukselle luotu Main.java|
| 29.3  | 3h   | JavaFX:n opiskelua, alustavat luokat menu sekä pelinäkymälle|
| 30.3  | 4h   | Pelilogiikan sekä luokkien mietiskelyä, alustavat luokat luotu|
| 30.3  | 3h   | Jatkettu pelilogiikan parissa, luotu Game-luokka jossa ylläpidetään pelin tilaa|
| 31.1  | 1h   | Luotu alustava luokka tekstikäyttöliittymää varten, helpottaa sovelluksen kehittämistä|
| 31.1  | 1h   | Pelilogiikan kehittelyä, Game-luokka käyttää Board & Piece luokkia|
| 02.4  | 2h   | Luotu testit luokalle PieceI|
| 06.4  | 3h   | JavaFX otettu käyttöön|
| 06.4  | 1h   | Pelilogiikan kehittelyä sekä yhteensovittamistasta GUI:hin|
| 07.4  | 2h   | Pelilogiikan kehittelyä sekä luotu testit luokalle PieceT| 
| 07.4  | 0.5h | Luotu uusi luokka PieceJ sekä sille testit|
| 09.4  | 4.5h | Luotu luokat Piece[L,O,S,Z] sekä testit näille kaikille, pieniä muutoksia pelilogiikkaan sekä GUIhin|
| 12.4  | 0.5h | Turhaa koodia poistettu, lisätty tarkistukset palan kääntöä varten|
| 12.4  | 1h   | Lisätty seuraavana vuorossa olevan palan esittäminen käyttöliittymään|
| 14.4  | 2h   | Lisätty luokkat vakioita sekä GUIlle asetuksia varten, kumpikaan ei käytössä vielä. Pari testiä Board-luokalle sekä pelilogiikan kehittelyä|
| 16.4  | 3h   | Peliloogiikkaa muutettu, nyt käytössä normaali tetriksen rivien tyhjennys/palojen tippuminen, [wikipedia](https://en.wikipedia.org/wiki/Tetris). Eli palat/koordinaatit voivat jäädä "leijailemaan". Lisätty testejä Board-luokalle|
| 16.4  | 2h   | Kaikki eri tetrispalikat ilmestyvät nyt oikealle y-koordinaatille eli taulukon ylälaitaan. Luotu testit tätä varten. Korjattu bugeja Board-luokasta, liittyen palojen koordinaattien laskentaan suhteessa taulukkoon|
| 18.4  | 0.5h | Lisätty Statistics luokka ja sen avulla tyhjennettyjen rivien laskenta|
| 22.4  | 4h   | JavaFX:n opiskelua, käyttöliittymän refaktorointia, taustamusiikin alustava lisäys, tyhjennettyjen rivien näyttäminen, pelin pausettaminen, tod.näk jotain unohdettuakin|
| 22.4  | 1h   | GUI:n asetusnäkymän refaktorointia|
| 22.4  | 2h   | GUI:n kanssa jatkettu, nyt on hieno popup! Pistelaskujärjestelmää sekä niiden tallentamista sqlite-kantaan aloitettu|
| 24.4  | 1h   | scoredao tehty, sqlite-tietokannasta voi nyt hakea seka tallentaa lista kaikista pisteistä. sovellus olettaa, että src/main/resources/db-hakemisto on olemassa|
| 25.4  | 1h   | tikape-materiaalin kertausta ja sen seurauksena paljon refaktorointia|
| 25.4  | 1h   | Refaktorointi jatkuu, turhien luokkien poisto|
| 26.4  | 0.5h | Highscores-luokka tehty|
| 26.4  | 2.5h | Pistelaskujärjestelmää kehitelty. Nyt sovellus lataa aina käynnistäessä pisteet sqlite-tietokannasta, sekä tallentaa ne suljettaessa. Kaikkien pelien pisteet myös tallennetaan, jos ne ovat riittävän korkeita sekä pelaaja on asettanut itselleen nimen|
| 04.5  | 2h   | Lisätty testejä|
| 04.5  | 2h   | Testejä, refaktorointia, pelissä nyt levelit sekä nopeutuminen, javadoceja kirjoitettu sekää muutettu checkstyleä javadocin suhteen|
| Yht   | 56h  | |
