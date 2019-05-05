# Tetris
Tähän repositorioon pyrin totetuttamaan klassisen tetris-pelin kloonin. Peli on minun harjoitustyö HY:n 2019 kevään kurssille _ohjelmistotekniikka_.

### Dokumentaatio
[Käyttöohje](https://github.com/kordaniel/ot-harjoitustyo/blob/master/dokumentaatio/kayttoohje.md)  
[Vaatimusmäärittely](https://github.com/kordaniel/ot-harjoitustyo/blob/master/dokumentaatio/vaatimusmaarittely.md)  
[Arkkitehtuurikuvaus](https://github.com/kordaniel/ot-harjoitustyo/blob/master/dokumentaatio/arkkitehtuuri.md)  
[Työaikakirjanpito](https://github.com/kordaniel/ot-harjoitustyo/blob/master/dokumentaatio/tuntikirjanpito.md)  

## Releaset
[Loppupalautus](https://github.com/kordaniel/ot-harjoitustyo/releases/tag/loppupalautus)  
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

## Javadoc
HTML-muotoisen Javadocin saa luotua komennolla
```
mvn javadoc:javadoc
```
Raportti tallentuu index.html-tiedostona hakemistoon _target/site/apidocs/_
