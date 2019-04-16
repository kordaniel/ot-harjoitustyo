# Tetris
Tähän repositorioon pyrin totetuttamaan klassisen tetris-pelin kloonin. Peli on minun harjoitustyö HY:n 2019 kevään kurssille _ohjelmistotekniikka_.

### Tämänviikkoinen "iteraatio"
Pelilogiikka alkaa olemaan kunnossa, palan saa tiputettua painamalla x-näppäintä. Settings näkymästä ei sitten pääse pois sulkematta sovellusta, koko käyttöliittymä pitää refaktoroida jossain vaiheessa. Tämän viikon aikana olen myös lisännyt joitain luokkia, peli ei vielä vain ole siinä vaiheessa, että niille olisi käyttöä. Seuraavien viikkojen aikana olisi tarkoitus toteuttaa ne sekä ottaa käyttöön. 

Checkstyle-raportissa on jonkin verran virheitä, mutta ne johtuvat vakioiden nimeämisestä ALL_CAPS-tyylillä sekä yhdestä Mainissa olevasta käyttöliittymän JavaFX start()-metodista.. Pyrkimyksenä olisi refaktoroida se ui-pakkauksen alle.  

### Dokumentaatio
[Vaatimusmäärittely](https://github.com/kordaniel/ot-harjoitustyo/blob/master/dokumentaatio/vaatimusmaarittely.md)  
[Arkkitehtuurikuvaus](https://github.com/kordaniel/ot-harjoitustyo/blob/master/dokumentaatio/arkkitehtuuri.md)  
[Työaikakirjanpito](https://github.com/kordaniel/ot-harjoitustyo/blob/master/dokumentaatio/tuntikirjanpito.md)  

## Releaset
[Viikko 5](https://github.com/kordaniel/ot-harjoitustyo/releases/tag/viikko5)

## Komentorivitoiminnot
Kaikki komennot on suoritettava hakemistossa _Tetris_, ei repositorion juuressa.

### Sovelluksen suorittaminen konsolissa, mavenin avulla
Komennon  

```
mvn compile exec:java -Dexec.mainClass=tetris.Main
```
suorittaminen käynnistää sovelluksen  

### Testaus
Testit suoritetaan komennolla  

```
mvn test
```

Testikattavuusraportti luodaan komennolla  

```
mvn test jacoco:report
```
Raportti tallentuu index.html -tiedostona hakemistoon _target/site/jacoco/_

## Suoritettavan jarin generointi
Komento  

```
mvn package
```
generoi hakemistoon _target_ suoritettavan jar-tiedoston Tetris-1.0-SNAPSHOT.jar  


## Checkstyle
Tiedoston [checkstyle.xml](https://github.com/kordaniel/ot-harjoitustyo/blob/master/Tetris/checkstyle.xml) määrittelemät tarkistukset suoritetaan komennolla
```
mvn jxr:jxr checkstyle:checkstyle
```
Raportti tallentuu checkstyle.html -tiedostona hakemistoon _target/site/_
