# Käyttöohje
Lataa uusin [release](https://github.com/kordaniel/ot-harjoitustyo/releases), vaihtoehtoisesti voit git:in avulla kloonata repositorion itsellesi.

## Konfigurointi
Sovellusta ei tarvitse konfiguroida mitenkään. Kun sovellus ajetaan ensimmäisen kerran, niin se luo automaattisesti tiedoston ```scores.db``` nimisen tiedoston juurihakemistoon.  

## Käynnistäminen
### Ladatun releasen ajaminen
Sovellus voidaan ajaa suorittamalla komento: ```java -jar tetris.jar```.  

## Pelin käyttö
Peli on yksinkertainen tetrispeli, menusta klikkailemalla pääsee eteenpäin jne :). Ainut huomionarvoinen asia on se, että jos haluat että saavuttamasi tulos tallentuisi HighScores-listalle, niin sinun pitää asettaa itsellesi nimimerkki Settings-valikon kautta. Tältä osin käyttöliittymä on hieman hankalahko, ja sinun pitää vielä erikseen painaa entteriä nimimerkin syöttämisen jälkeen. Jos nimenä on Noname, niin tulosta ei ikinä talleneta mihinkään.  

Pelitilassa on kolme nappia oikeassa alakulmassa, joita klikkailemalla voi aloittaa uuden pelin, laittaa peli pauselle tai poistua päävalikkoon, jolloin peli menee automaagisesti pauselle. Putoavaa tetris-palikkaa voidaan ohjata nuoli- sekä välilyöntinäppäimillä.

Jos tavoittelet korkeita pisteitä, niin kannattaa pyrkiä tyhjentämään mahdollisimman monta riviä kerrallaan, tästä annetaan lisäpisteitä.
