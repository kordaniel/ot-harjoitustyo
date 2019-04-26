# Tetris
Tähän repositorioon pyrin totetuttamaan klassisen tetris-pelin kloonin. Peli on minun harjoitustyö HY:n 2019 kevään kurssille _ohjelmistotekniikka_.

### Tämänviikkoinen "iteraatio"
Peliin ilmestyi bugi jota en ole ehtinyt vielä selvittää: pistelasku toimii satunnaisesti. Viikon kohokohta on se, että sovellus tallentaa sekä lataa pisteet tietokannasta sekä käyttöliittymä on vihdoin refaktoroitu hieman parempaan kuntoon, vaikka se vielä onkin jossain määrin sekava.

Itse pelistä, niin muuten alkaa olemaan kunnossa. Ainut mikä vielä pitää toteuttaa on pelin tasot eli levelit järkevästi sekä pelin nopeutuminen levelien kasvamisen myötä.

Checkstylestä, laitoin päälle javadocin tarkistukset ja virheitä ilmestyi vähintään riittävästi. Miten siihen pitäisi suhtautua loppupalautuksen yhteydessä? Käsittääkseni ihan kaikkia metodeja/luokkia ei tarvitse kuitenkaan dokumentoida?

Testauksesta sen verran, että testikattavuus on tippunut reilusti koska koodin määrä on kasvanut reilusti tämän viikon aikana. Testien määrä on tarkalleen sama kuin viime viikolla, toki tästä varmaan pitää pisteitä vähentää :)

#### Javadocista
Seuraavat neljä luokkaa on dokumentoitu javadocilla:
```Database
Board
User
Piece```
Sekä myös ```Game``` luokka osittain

### Dokumentaatio
[Vaatimusmäärittely](https://github.com/kordaniel/ot-harjoitustyo/blob/master/dokumentaatio/vaatimusmaarittely.md)  
[Arkkitehtuurikuvaus](https://github.com/kordaniel/ot-harjoitustyo/blob/master/dokumentaatio/arkkitehtuuri.md)  
[Työaikakirjanpito](https://github.com/kordaniel/ot-harjoitustyo/blob/master/dokumentaatio/tuntikirjanpito.md)  

## Releaset
[Viikko 6](https://github.com/kordaniel/ot-harjoitustyo/releases/tag/viikko6)
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

## javadocin
HTML-muotoisen Javadocin saa luotua komennolla
```
mvn javadoc:javadoc
```
Raportti tallentuu index.html-tiedostona hakemistoon _target/site/apidocs/_
