# Testausdokumentti
Peliä on testattu JUNITin avulla suurella määrällä yksikkötestejä. Peliä on myös testattu aktiivisesti kehitystyön ohessa manuaalisesti.  

### DAO
Dao-testit jäivät hieman vajavaisiksi, koska monen tunnin yrittämisestä huolimatta niin en saanut testejä toimimaan haluamallani tavalla. Ongelmaksi muodostui in-memory tietokannan luominen ScoreDao:n testaamista varten. Testejä luodessani, niin tein ensin toisen nimen, jonka annoin parametrina Database-luokalle. Tällöin siis testit loivat toisennimisen tietokannan tiedostojärjestelmään, jota käytetään ainoastaan testeissä. Tällöin testit toimivat, ja sain testattua että Scoredao toimii kuten haluan sen toimivan. Tämä ei kuitenkaan taida olla hyvä menetelmä, sillä tällöin on huolehdittava tiedostojärjestelmään jäävästä testitietokannasta. Sekä myös, jos testeissä on virheitä, niin ei voida olla varmoja siitä, että tietokanta todella on tyhjä kun testejä aloitetaan.  

Kokemusten perusteella, niin ongelmaksi taisi muodostua se, että Dao avaa aina uuden yhteyden tietokantamoottoriin jokaisessa erillisessä metodissa eikä tämä taida toimia ihan suoriltaan in-memory-kantaa käyttäessä.  

En tiedä voiko in-memory tietokanta-ajuria konfiguroida siten, että minun ScoreDao:ta voisi testata sen avulla, vai joudunko suunnittelemaan sen toiminnan uudelleen. Olen elänyt siinä käsityksessä, että try with resources:in avulla muodostettu yhteys sulkee myös kaikki muut komennot jotka suoritetaan lohkon sisällä. Sain kuitenkin koodikatselmoinnissa mainnin tästä, että näin ei ole ja nyt tätä dokumenttia kirjoittaessani voi olla, että tässä on kaikkien ongelmien alku ja juuri.

### Testauskattavuus
Näistä ongelmista huolimatta käyttöliittymää lukuunottamatta sovelluksen testauksen rivikattavuus on 75% ja haarautumakattavuus 63%. **HUOMAUTUS** Nämä prosentit saavutetaan siis, jos testeissä otetaan käyttöön tuo yksi poiskommentoitu DAOn testi, joka ei toimi in-memory ajurilla. Ilman sitä, niin kattavuudet ovat hieman heikohkot 69% ja 60%.  
![Testiraportti](https://raw.githubusercontent.com/kordaniel/ot-harjoitustyo/master/dokumentaatio/kuvat/testikattavuus.png)
![Testiraportti2](https://raw.githubusercontent.com/kordaniel/ot-harjoitustyo/master/dokumentaatio/kuvat/testikattavuus2.png)

# Sovellukseen jääneet ongelmat  
DAO:ssa mahdollisesti tulevat poikkeukset tulostetaan konsoliin, System.err.println():in avulla. Niitä ei siis näytetä käyttäjälle, eikä sovellusta suljeta. Tällöin voi käydä niin, että käyttäjä ei ikinä näe virheitä, vaikka ne syötetään käyttöjärjestelmän virhe-"streamiin". Parempi olisi käsitellä ne sovelluksen sisällä niin, että käyttäjälle mainittaisiin asiasta.  

Toinen onglema on taustamusiikki. Se ei tällä hetkellä looppaa ikuisesti, ainoastaan lyhyen aikaa. Tämä ongelma ilmeni aivan viime metreillä, enkä ehtinyt sitä enää tutkia. Todennäköisesti tämä liittyy JAR:in paketointiin ja ResourceLoader-luokan käyttöönottoon joka käsittelee tiedostoa Inputstremin kautta vs. aiemmin käytössä ollut File-luokka. Tai siis JavaFX:n MediaPlayerin käyttö näiden luokkien kanssa.
