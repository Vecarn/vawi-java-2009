------------------------------------------------------------------------
This is the project README file. Here, you should describe your project.
Tell the reader (someone who does not know anything about this project)
all he/she needs to know. The comments should usually include at least:
------------------------------------------------------------------------

PROJECT TITLE: VAWI JAVA WS0910 - Teilleistung 2
PURPOSE OF PROJECT: API - Dokumentation	
VERSION or DATE: 14.12.2009
HOW TO START THIS PROJECT: - noch zu definieren in TL3 -
AUTHORS: Silvia Wölfle, Martin Munkelt, Jörn Hauser, Markus Bode
USER INSTRUCTIONS: -

|---------------------------------------------|
| Allgemeine Beschreibgung des Klassensystems |
|---------------------------------------------|

Das Programm unterstützt die Planung und Organisation von Prüfungen. Es verwaltet Studierende, 
Kurse und verteilt gebuchte Kurse konfigurierbar auf Prüfungstage. Pro Tag und Student sind 
maximal drei Kurse zulässig. Der möglichst kurze Prüfungsterminplan umfasst mehrere Prüfungstage. 
Das Programm erzeugt auch fiktive Kursbelegungen. 
Es werden Anwesenheitslisten (pro Tag und Ort), Notenlisten (pro Kurs, inkl. Darstellung bereits erreichter Punkte) 
sowie Platzkarten (pro Student, Tag und Ort) erstellt. Die Erfüllung der Präferenz der Studenten, 
ob alle Kurse an einem Tag oder möglichst nur ein Kurs am Tag geprüft werden will, prüft das System im Nachhinein. 

Grundgedanke des Klassenmodells ist eine gute objektorientierte Architektur, die Klassen gruppiert 
und eindeutig einzelnen Komponenten zuordnen lässt. Daher die Packages Dateneinlesen, Prüfungsplanung, Datenausgabe. 
Es wurde zudem darauf geachtet, dass Berührungspunkte für eine leichte Austauschbarkeit teils abstrahiert wurden
Das Klassenmodell wurde so gestaltet, dass der eigentliche Prüfungs-Algorithmus leicht austauschbar ist. 
Alle Algorithmen verwenden die gleichen Randbedingungen. 



|---------------------------------------------|
| Zusammenhänge der Klassen					  |
|---------------------------------------------|

VAWIOrgaTool
------------

Simulator
------------
Die Klasse Simulator nutzt die Verwaltungsklassen aus dem Paket EingabeDatenVerwaltung.DatenVerwaltung.
Anhand einer übergebenen Kursliste und wahlweise Parametern werden Daten generiert.

ZufriedenheitsMesser
--------------------
Der ZufriedenheitsMesser bestimmt die Zufriedenheit der Studenten mit dem erstellten Pruefungsterminplan.
Dazu wird die Klasse Studentenliste genutzt um die Zufriedenheit eines Studenten zu speichern.

PruefungsPlanung.Planungsbedingunen
-----------------------------------
Die Planungsbedingungen ist eine Datenklasse mit Attributen, getter/setter-Methoden (inkl. Prüfungen), z.B. maximale Anzahl an Kurse pro Student und Tag. 
Die Planungsbedingungen werden ueber den Programmablauf gesetzt. (Also keine Konstanten)
				
PruefungsPlanung.PruefungsplanerAlgo1
-------------------------------------

PruefungsPlanung.PruefungsplanerAbstrakt
----------------------------------------

PruefungsPlanung.PruefungsPlaner
--------------------------------



EingabeDatenverwaltung.DatenObjekte: Student, Kurs und Buchung
--------------------------------------------------------------
Enthalten Datenobjekte Student, Kurs und Buchung und getter/setter-Methoden (inkl. Prüfungen)


EingabeDatenverwaltung.DatenVerwaltung: Buchungsliste + BuchungsComparator
--------------------------------------------------------------------------
Die Buchungsliste steht mit allen Klassen in Beziehung, die Zugriff auf den Buchungs-Bestand benötigen. 
Der PruefungsPlaner nutzt so die Liste. Außerdem wird Sie von der Klasse FlatFileLeser genutzt um 
die Objekte aus den Daten zu erstellen. Im Simulationsprozess wird die Klasse von der Klasse Simulator 
genutzt, welche die Liste mit generierten Daten beliefert. Die Buchungsliste nutzt den BuchungsComparator 
um die Objekte der Klasse Buchung sortiert zu speichern.

EingabeDatenverwaltung.DatenVerwaltung: Kursliste + KursComparator
------------------------------------------------------------------
Auch die Kursliste steht mit dem PruefungsPlaner und dem FlatFileLeserin in Beziehung. Die Klasse nutzt den 
KursComparator um Objekte der Klasse Kurs sortiert zu speichern. Weiterhin wird die Klasse Kursliste von allen Klassen genutzt, 
die mehrere Kurse speichern müssen oder Zugriff auf diese benötigen. (z.B.: Klasse Anwesenheit, Klasse Simulator) 

EingabeDatenverwaltung.DatenVerwaltung: Studentenliste + StudentenComparator
----------------------------------------------------------------------------
Die Studentenliste steht ebenfalls mit dem PruefungsPlaner in Beziehung. Die Klasse nutzt den StudentenComparator
um die erstellten Objekte der Klasse Student sortiert vorzuhalten. Auch die Studentenliste wird durch den FlatFileLeser
mit Daten beliefert. Die Studentenliste steht außerdem mit allen Klassen in Beziehung, welche die Verwaltungslogik (Speicherung und Zugriff) 
der Studentenliste benötigen. (z.B.: Klasse Simulator, Klasse Pruefungstag, Klasse ZufriedenheitsMesser)

Eingabe: FlatFileLeser
----------------------
Wird von der Klasse Ablaufsteuerung genutzt und liest Daten mit Hilfe der Klasse Datei ein. 
Die Daten werden an die entsprechenden Verwaltungs-Klassen übergeben. 





AusgabeDatenverwaltung.DatenObjekte: Pruefungstag
-------------------------------------------------
Enthält den Prüfungstag und eine Kursliste sowie ein Studentenliste und getter/setter-Methoden (inkl. Prüfungen)
Die Tage wertden aus dem PruefungsPlanerAlgo1 gesetzt.



AusgabeDatenverwaltung.DatenObjekte: Anwesenheit
------------------------------------------------
Enthält Student und Kursliste und getter/setter-Methoden (inkl. Prüfungen) 
Enthält selbst nicht Tag und Uni, da erst in der Verwaltungsklassen für die Listen zusammengestellt 



AusgabeDatenverwaltung.DatenVerwaltung: Pruefungsterminplan
-----------------------------------------------------------
Der Prüfungsterminplan enthält alle Prüfungstage. Der Pruefungsterminplan steht mit der AusgabeVerwaltung
und der Logik für die Erzeugung des Planes in Beziehung


AusgabeDatenverwaltung.DatenVerwaltung: Notenliste
-----------------------------------------------------------
Die Notenliste enthält Buchungen. Dadurch, dass in der Buchung alle für die Notenliste
relevanten Informationen zur Verfügung stehen wird keine weitere Notenklasse benötigt.

AusgabeDatenverwaltung.DatenVerwaltung: Anwesenheitsliste
-----------------------------------------------------------
Die Anwesenheitsliste wird von der AusgabeVerwaltung generiert. Sie enthält die einzelnen
Anwesenheiten. Dafür wird ebenfalls auf die Daten der Buchungsliste zurückgegriffen.

AusgabeDatenverwaltung.DatenVerwaltung: Platzkartenlisten
-----------------------------------------------------------
Die Platzkartenliste wird von der AusgabeVerwaltung erzeugt und enthält Buchungsobjekte. Auch
hier sind in den Buchungen die gesamten Informationen der Platzkarte enthalten.

Ausgabe: FlatFileSchreiber
--------------------------
Der FlatFileSchreiber wird von der AusgabeVerwaltung instantziiert und für die Ausgabe
der Listen in Files verwendet. Die Klasse ruft die Hilfsklasse Datei auf und sendet
die aufbereiteten Datenströme an die Ausgabe.

Hilfsklasse Datei
-----------------´
Die vorgegebene Klasse Datei stellt die Logik zum Zugriff auf eine Datei zur Verfügung. 
Sie wird genutzt vom FlatFileLeser und vom FlatFileSchreiber.


Hilfsklasse: Interface Uni
--------------------------
Mit diesem Interface ist sichergestellt, dass programmweit immer "D" für Duisburg und "B" für Bamberg steht.




