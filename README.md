# Ohjelmistotekniikka, harjoitustyö
tämä on HY:n *kevään* 2019 **ohjelmistotekniikka**-kurssin repositorio

## Tetris
Tähän repositorioon pyrin totetuttamaan klassisen tetris-pelin kloonin.

### Dokumentaatio
[Vaatimusmäärittely](https://github.com/kordaniel/ot-harjoitustyo/blob/master/dokumentaatio/vaatimusmaarittely.md)  
[Työaikakirjanpito](https://github.com/kordaniel/ot-harjoitustyo/blob/master/dokumentaatio/tuntikirjanpito.md)  

## Komentorivitoiminnot
Kaikki komennot on suoritettava hakemistossa Tetris, ei repositorion juuressa.

### Sovelluksen suorittaminen konsolissa, mavenin avulla
Komennon  

```
mvn exec:java -Dexec.mainClass=tetris.Main
```
suorittaminen käynnistää sovelluksen  

### Testaus
Testit suoritetaan komennolla  

```
mvn test
```

Testikattavuusraportti luodaan komennolla  

```
mvn jacoco:report
```
Raportti tallentuu index.html -tiedostona hakemistoon target/site/jacoco/  

## Suoritettavan jarin generointi
Komento  

```
mvn package
```
generoi hakemistoon target suoritettavan jar-tiedoston Tetris-1.0-SNAPSHOT.jar  


## Checkstyle
Tiedoston [checkstyle.xml] (https://github.com/kordaniel/ot-harjoitustyo/blob/master/Tetris/checkstyle.xml) määrittelemät tarkistukset suoritetaan komennolla
```
mvn jxr:jxr checkstyle:checkstyle
```
Raportti tallentuu checkstyle.html -tiedostona hakemistoon target/site/

### Tehtävät
Linkki | Sisältö
-------|--------
[Viikko1](http://github.com/kordaniel/ot-harjoitustyo/tree/master/laskarit/viikko1)|Viikko 1
[Viikko2](http://github.com/kordaniel/ot-harjoitustyo/tree/master/laskarit/viikko2)|Viikko 2

### Viikko 1
[gitlog.txt](https://github.com/kordaniel/ot-harjoitustyo/blob/master/laskarit/viikko1/gitlog.txt)  
[komentorivi.txt](https://github.com/kordaniel/ot-harjoitustyo/blob/master/laskarit/viikko1/komentorivi.txt)

### Viikko 2
[Maksukortti](https://github.com/kordaniel/ot-harjoitustyo/blob/master/laskarit/viikko2/Maksukortti)  
[Unicafe](https://github.com/kordaniel/ot-harjoitustyo/blob/master/laskarit/viikko2/Unicafe)  
[testikattavuus.jpg](https://github.com/kordaniel/ot-harjoitustyo/blob/master/laskarit/viikko2/testikattavuus.jpg)
