# Arkkitehtuurikuvaus
## Luokkakaavio
![Luokkakaavio](https://raw.githubusercontent.com/kordaniel/ot-harjoitustyo/master/dokumentaatio/kuvat/190505_luokkakaavio.jpg)  

## Pelilogiikka
### Tetris-palan siirtäminen alaspäin
Game-luokalla on metodi advanceGame() jota kutsutaan tietyin aikavälein javaFX:n AnimationTimer -luokasta. Metodi tarkistaa ensin, voiko tippuva/vuorossa oleva tetrispala (Piece) siirtyä alaspäin pelilaudalla. Jos voi, niin metodi kutsuu palan metodia moveDown(), joka kasvattaa palan y-koordinaatin arvoa.  

Jos pala ei voi siirtyä alaspäin, niin kutsutaan pelilaudan (Board) addPieceToBoard() metodia ja annetaan pala-olio sille parametrina. addPieceToBoard() tarkistaa vielä, että palan voi lisätä laudalle, jonka jälkeen se asettaa oikeat koordinaatit pelilaudalle. Tämän jälkeen kutsutaan Boardin metodia dropRows(), joka poistaa täydet rivit pelilaudalta sekä valuttaa tarvittavat koordinaatit alaspäin pelilaudalla.  

 (LISÄYS: dropRows() palauttaa poistettujen rivien määrän, joka annetaan parametrina Scorecounter-oliolle, joka päivittää pisteidenlaskua). ~~Viimeiseksi kutsutaan Game-luokan metodia setNewPiece() joka asettaa uuden palan aktiiviseksi~~. Seuraavaksi kutsutaan pelilaudaun (Board) metodia pieceCanBeSpawned() ja annetaan seuraavaksi vuorossa oleva pala sille parametriksi. Tämä palauttaa joko true, jos pala mahtuu pelilaudalle tai muutoin false:n. Tämän arvon perusteella joko vaihdetaan seuraava pala nykyiseksi palaksi tai asetetaan peli päättyneeksi. Sekvenssikaaviossa on siis pieniä virheitä tämän muutoksen myötä.  

Viimeisenä ja riippumatta siitä pystyikö palaa siirtämään alaspäin, niin kutsutaan Game-luokan metodia AddPieceToBoardInPlay(), joka päivittää Game-luokassa olevaa pelilautaa jota käytetään pelitilanteen piirtämiseen.

Sekvenssikaaviossa on siis pieniä virheitä, kun sovelluksen logiikka on muuttunut

#### Sekvenssikaavio, kun palaa voidaan siirtää alaspäin
![Luokkakaavio](https://raw.githubusercontent.com/kordaniel/ot-harjoitustyo/master/dokumentaatio/kuvat/advanceGame.png)
#### Sekvenssikaavio, kun palaa ei voida siirtää alaspäin
![Luokkakaavio](https://raw.githubusercontent.com/kordaniel/ot-harjoitustyo/master/dokumentaatio/kuvat/advanceGame2.png)
