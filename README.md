# Ohjelmistotekniikka, harjoitustyö

## Dokumentaatio
[Vaatimusmäärittely](https://github.com/lautsar/ot-ht-2020/blob/master/dokumentointi/vaatimusmaarittely.md)

[Tuntikirjanpito](https://github.com/lautsar/ot-ht-2020/blob/master/dokumentointi/tuntikirjanpito.md)

[Arkkitehtuurikuvaus](https://github.com/lautsar/ot-ht-2020/blob/master/dokumentointi/arkkitehtuuri.md)

## Komentorivitoiminnot
Koodin voi suorittaa komennolla

mvn compile exec:java -Dexec.mainClass=journal.ui.Main

Testit voi ajaa komennolla

mvn test

Testikattavuusraportti luodaan komennolla

mvn test jacoco:report

Checkstyle-raportin saa luotua komennolla

mvn jxr:jxr checkstyle:checkstyle
