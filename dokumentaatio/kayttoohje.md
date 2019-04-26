# Käyttöohje
Lataa uusin release [releaset](https://github.com/kordaniel/ot-harjoitustyo/releases)

## Konfigurointi
Sovellus olettaa, että hakemistot
```src/main/resources/db```  
```src/main/resources/sounds```  
ovat olemassa ja releasen mukana tulevat wav-tiedostot ovat sijoitettu hakemistoon ../sounds

## Käynnistäminen
Kun konfigurointi on tehty, niin sovellus voidaan ajaa suorittamalla komento:
```java -jar ot-tetris.jar```  
Sovellus luo automaattisesti sqlite3-tiedoston ```scores.db``` hakemistoon ../db

## Pelin käyttö
Peli on yksinkertainen tetrispeli, menusta klikkailemalla pääsee eteenpäin jne :).
Pelitilassa on kolme nappia oikeassa alakulmassa, joita klikkailemalla voi aloittaa uuden pelin, laittaa peli pauselle tai poistua päävalikkoon, jolloin peli menee automaagisesti pauselle. Putoavaa tetris-palikkaa voidaan ohjata nuoli- sekä välilyöntinäppäimillä.

Jos haluat, että keräämäsi pisteet tallennetaan High Score-listaan, niin sinun on muutettava nimesi pelin asetus-valikosta. Jos nimi on "Noname" (oletus), niin tulosta ei tallenneta.
