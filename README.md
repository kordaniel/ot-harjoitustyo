# Tetris
Tähän repositorioon pyrin totetuttamaan klassisen tetris-pelin kloonin. Peli on minun harjoitustyö HY:n 2019 kevään kurssille _ohjelmistotekniikka_.

### Tämänviikkoinen "iteraatio"
Peliä voi nyt pelata JavaFX:n kautta. Tietenkin bugeja on vielä reilusti enemmän kuin ominaisuuksia. mm. peli lähtee heti pyörimään kun pelin käynnistää. Ruudun kokoa ei ole asetettu mitenkään, joten jos haluaa testata peliä, niin sitä pitää itse suurentaa vetämällä. En ole vielä lisännyt tarkistuksia palikoiden pyörittämiseen, joten jos testaatte, niin kannattaa varautua siihen että reunoilla tehdyt pyöräytykset menevät taulukon ulkopuolelle. Eteenpäin sanoi mummo lumihangessa!  

Myöskin checkstyle-raportissa on yhteensä 12 erroria, mutta 10 niistä johtuu vakioiden nimeämisestä CAPS:eilla sekä yhdestä Mainissa olevasta käyttöliittymän JavaFX start()-metodista..  

### Dokumentaatio
[Vaatimusmäärittely](https://github.com/kordaniel/ot-harjoitustyo/blob/master/dokumentaatio/vaatimusmaarittely.md)  
[Arkkitehtuurikuvaus](https://github.com/kordaniel/ot-harjoitustyo/blob/master/dokumentaatio/arkkitehtuuri.md)  
[Työaikakirjanpito](https://github.com/kordaniel/ot-harjoitustyo/blob/master/dokumentaatio/tuntikirjanpito.md)  

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
