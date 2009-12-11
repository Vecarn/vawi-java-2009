------------------------------------------------------------------------
This is the project README file. Here, you should describe your project.
Tell the reader (someone who does not know anything about this project)
all he/she needs to know. The comments should usually include at least:
------------------------------------------------------------------------

Aufgabe:
"Eine Readme-Datei, die das Klassensystem kurz und praegnant beschreibt und die
Zusammenhaenge der Klassen des Klassensystems dokumentiert (Als Pi-mal-Daumen Regel:
pro Zusammenhang ein bis zwei Saetze)." --> bitte noch vervollständigen.

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
Die Buchungsliste steht mit den Klassen in Beziehung, die Zugriff auf den Buchungs-Bestand benötigen. 
Der PruefungsPlaner nutzt so die Liste. Außerdem wird Sie von der Klasse FlatFileLeser genutzt um 
die Objekte aus den Daten zu erstellen. Im Simulationsprozess wird die Klasse von der Klasse Simulator 
genutzt welche die Liste mit generierten Daten beliefert. Die Buchungsliste nutzt den BuchungsComparator 
um die Objekte der Klasse Buchung sortiert zu speichern.

EingabeDatenverwaltung.DatenVerwaltung: Kursliste + KursComparator
------------------------------------------------------------------
Auch die Kursliste steht mit dem PruefungsPlaner in Beziehung und mit dem FlatFileLeser. Die Klasse nutzt den 
KursComparator um Objekte der Klasse Kurs sortiert zu speichern.

EingabeDatenverwaltung.DatenVerwaltung: Studentenliste + StudentenComparator
----------------------------------------------------------------------------
Die Studentenliste steht ebenfalls mit dem PruefungsPlaner in Beziehung. Die Klasse nutzt den StudentenComparator
um die erstellten Objekte der Klasse Student sortiert vorzuhalten. Auch die Studentenliste wird durch den FlatFileLeser
mit Daten beliefert. Im Simulationsprozess wird die Liste von der Klasse Simulator genutzt welcher die Liste mit generierten Daten beliefert.
Die Studentenliste wird auch vom ZufriedenheitsMesser genutzt welcher die Studenten abfragt. 

Eingabe: FlatFileLeser
----------------------
Wird von der Haupt-Klasse VAWIOrgaTool genutzt und liest Daten mit Hilfe der Klasse Datei ein. 
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


AusgabeDatenverwaltung.DatenVerwaltung: Notenliste
-----------------------------------------------------------

AusgabeDatenverwaltung.DatenVerwaltung: Anwesenheitsliste
-----------------------------------------------------------

AusgabeDatenverwaltung.DatenVerwaltung: Platzkartenlisten
-----------------------------------------------------------

Ausgabe: FlatFileSchreiber
--------------------------


Hilfsklasse Datei
-----------------

Hilfsklasse: Interface Uni
--------------------------
Mit diesem Interface ist sichergestellt, dass programmweit immer "D" für Duisburg und "B" für Bamberg steht.




