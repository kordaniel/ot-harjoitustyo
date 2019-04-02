# Tetris
Tähän repositorioon pyrin totetuttamaan klassisen tetris-pelin kloonin. Peli on minun harjoitustyö HY:n 2019 kevään kurssille _ohjelmistotekniikka_.

## Sovelluksen tämänhetkinen tila
Aloitin sovelluksen kehittämisen hieman väärin, sillä aloitin projektin tutustumalla JavaFX:ään sekä kokeilemalla miten tekisin käyttöliittymän sen avulla. Tähän päädyin sen takia, koska en ole koskenut JavaFX:ään ohja:n jälkeen, minkä suoritin viime keväällä ja halusin hieman harjoitella sen käyttöä. Sovelluksella on tällä hetkellä kaksi JavaFX luokkaa, joissa siis on vain ja ainoastaan hahmotelmia, näitä en kuitenkaan halua poistaa tässä vaiheessa, sillä uskon niistä olevan hyötä myöhemmässä vaiheessa, kunhan saan pelilogiikan hieman valmiimmaksi. Tällä hetkellä siis sovellus avautuu yksinkertaiseen tekstikäyttöliittymään, mitä olen käyttänyt pelilogiikan testaamiseen. Tarkoituksenani olisi, että ensi viikolla peli jo pyörisi "oikein", eli JavaFX:n avulla.

Toimintasuunnitelmana on eriyttää logiikka ja käyttöliitymää kokonaan toisistaan. Pelilogiikka jakautuu Game/Board/Piece luokkiin, joista Piece on abstrakti luokka josta voi luoda erilaisia tetris-palikoita. Kaikilla tetris-palikoilla on x/y-koordinaatit, niitä voi siirrellä/käännellä. Näistä aina yksi on olemassa oliona, aina niin pitkään kunnes se on laskeutunut. Boardiin tallennetaan pelin tila. Game sitoo nämä kaikki yhteen.

### Tämänviikkoinen "iteraatio"
Ketterässä ohjelmistokehityksessä pitäisi aina olla suoritettava sovellus, mutta tällä hetkellä en ole ehtinyt niin pitkälle että peliä voisi pelata. Ohjelman voi kyllä suorittaa ja pala tippuu, mutta pelata ei oikein voi. Piece sekä sen toteuttava luokka PieceI on ainut testattu luokka johon olen tällä hetkellä tyytyväinen. PieceT on myös vastaavasti "valmis", vaikka testejä en ole vielä ehtinyt sille luoda.

### Dokumentaatio
[Vaatimusmäärittely](https://github.com/kordaniel/ot-harjoitustyo/blob/master/dokumentaatio/vaatimusmaarittely.md)  
[Työaikakirjanpito](https://github.com/kordaniel/ot-harjoitustyo/blob/master/dokumentaatio/tuntikirjanpito.md)  

## Komentorivitoiminnot
Kaikki komennot on suoritettava hakemistossa _Tetris_, ei repositorion juuressa.

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
