------------------------------------------------------------------------
This is the project README file. Here, you should describe your project.
Tell the reader (someone who does not know anything about this project)
all he/she needs to know. The comments should usually include at least:
------------------------------------------------------------------------

PROJECT TITLE: VAWI JAVA WS0910 - Teilleistung 3
PURPOSE OF PROJECT: Lauffähiges Tool zum planen eines Prüfungsterminplans.  
VERSION or DATE: 25.01.2010
HOW TO START THIS PROJECT:
Beim starten des Programms können Parameter eingegeben werden mit den Dateinamen der Eingabedateien.
Der Aufruf per Parameter lautet z.B. -studenten=studenten.txt -kurse=kurse.txt -buchungen=buchungen.txt
Wichtig: Die Dateien müssen sich im Wurzelverzeichnis des VAWIOrgaTools befinden!
Wenn keine Angaben gemacht werden, werden Standardnamen der Dateien angenommen.
AUTHORS: Silvia Wölfle, Martin Munkelt, Jörn Hauser, Markus Bode. Die genaue Zuordnung ist anhand der Namen pro Klasse zu sehen!

|---------------------------------------------|
| Allgemeine Beschreibung des Klassensystems |
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
| Zusammenhänge der Klassen                   |
|---------------------------------------------|

VAWIOrgaTool (Jörn Hauser)
--------------------------
Einsprungspunkt in das Programm. Enthält die "Main"-Methode. Ebenso stellt es Methoden für eine rudimentäre Benutzerschnittstelle zur Verfügung.

Ablaufsteuerung (Jörn Hauser)
-----------------------------
Stellt Methoden zur Steuerung des Programmablaufs bereit. Prüft zusätzlich auf Plausibilität des Programmablaufs.

Simulator (Markus Bode)
------------------------
Die Klasse Simulator nutzt die Verwaltungsklassen aus dem Paket EingabeDatenVerwaltung.DatenVerwaltung.
Anhand einer übergebenen Kursliste und wahlweise Parametern werden Daten generiert.

ZufriedenheitsMesser (Markus Bode)
----------------------------------
Der ZufriedenheitsMesser bestimmt die Zufriedenheit der Studenten mit dem erstellten Pruefungsterminplan.
Dazu wird die Klasse Studentenliste genutzt um die Zufriedenheit eines Studenten zu speichern.



PruefungsPlanung.Planungsbedingunen (Silvia Wölfle)
---------------------------------------------------
Die Planungsbedingungen ist eine Datenklasse mit Attributen, getter/setter-Methoden (inkl. Prüfungen), z.B. maximale Anzahl an Kurse pro Student und Tag. 
Die Planungsbedingungen werden ueber den Programmablauf gesetzt. (Also keine Konstanten)
                
PruefungsPlanung.PruefungsplanerAlgo1 (Jörn Hauser)
---------------------------------------------------
Der PruefungsplanerAlgo1 ist die konkrete Umsetzung des Planungsalgorithmus. 
Er implementiert den Pruefungsplaner und spezialisiert den PruefungsplanerAbstrakt

PruefungsPlanung.PruefungsplanerAbstrakt (Jörn Hauser)
------------------------------------------------------
Der PruefungsplanerAbstrakt implementiert allgemeinegültige Methoden für Prüfungsplaner.

PruefungsPlanung.PruefungsPlaner (Jörn Hauser)
----------------------------------------------
Interface, das eine Klasse zur Pruefungsplanung beschreibt.



EingabeDatenverwaltung.DatenObjekte: Student, Kurs und Buchung (Silvia Wölfle)
------------------------------------------------------------------------------
Enthalten Datenobjekte Student, Kurs und Buchung und getter/setter-Methoden (inkl. Prüfungen)

EingabeDatenverwaltung.DatenVerwaltung: Buchungsliste + BuchungsComparator (Markus Bode)
----------------------------------------------------------------------------------------
Die Buchungsliste steht mit allen Klassen in Beziehung, die Zugriff auf den Buchungs-Bestand benötigen. 
Der PruefungsPlaner nutzt so die Liste. Außerdem wird Sie von der Klasse FlatFileLeser genutzt um 
die Objekte aus den Daten zu erstellen. Im Simulationsprozess wird die Klasse von der Klasse Simulator 
genutzt, welche die Liste mit generierten Daten beliefert. Die Buchungsliste nutzt den BuchungsComparator 
um die Objekte der Klasse Buchung sortiert zu speichern.

EingabeDatenverwaltung.DatenVerwaltung: Kursliste + KursComparator (Markus Bode)
--------------------------------------------------------------------------------
Auch die Kursliste steht mit dem PruefungsPlaner und dem FlatFileLeserin in Beziehung. Die Klasse nutzt den 
KursComparator um Objekte der Klasse Kurs sortiert zu speichern. Weiterhin wird die Klasse Kursliste von allen Klassen genutzt, 
die mehrere Kurse speichern müssen oder Zugriff auf diese benötigen. (z.B.: Klasse Anwesenheit, Klasse Simulator) 

EingabeDatenverwaltung.DatenVerwaltung: Studentenliste + StudentenComparator (Markus Bode)
------------------------------------------------------------------------------------------
Die Studentenliste steht ebenfalls mit dem PruefungsPlaner in Beziehung. Die Klasse nutzt den StudentenComparator
um die erstellten Objekte der Klasse Student sortiert vorzuhalten. Auch die Studentenliste wird durch den FlatFileLeser
mit Daten beliefert. Die Studentenliste steht außerdem mit allen Klassen in Beziehung, welche die Verwaltungslogik (Speicherung und Zugriff) 
der Studentenliste benötigen. (z.B.: Klasse Simulator, Klasse Pruefungstag, Klasse ZufriedenheitsMesser)

Eingabe: FlatFileLeser (Markus Bode)
------------------------------------
Wird von der Klasse Ablaufsteuerung genutzt und liest Daten mit Hilfe der Klasse Datei ein. 
Die Daten werden an die entsprechenden Verwaltungs-Klassen übergeben. 



AusgabeDatenverwaltung.DatenObjekte: Pruefungstag (Silvia Wölfle)
-----------------------------------------------------------------
Enthält den Prüfungstag und eine Kursliste sowie ein Studentenliste und getter/setter-Methoden (inkl. Prüfungen)
Die Tage wertden aus dem PruefungsPlanerAlgo1 gesetzt.

AusgabeDatenverwaltung.DatenObjekte: Anwesenheit (Silvia Wölfle)
----------------------------------------------------------------
Enthält Student und Kursliste und getter/setter-Methoden (inkl. Prüfungen) 
Enthält selbst nicht Tag und Uni, da erst in der Verwaltungsklassen für die Listen zusammengestellt 

AusgabeDatenverwaltung.DatenVerwaltung: Pruefungsterminplan (Martin Munkelt)
----------------------------------------------------------------------------
Der Prüfungsterminplan enthält alle Prüfungstage. Der Pruefungsterminplan steht mit der AusgabeVerwaltung
und der Logik für die Erzeugung des Planes in Beziehung

AusgabeDatenverwaltung.DatenVerwaltung: Notenliste (Martin Munkelt)
-------------------------------------------------------------------
Die Notenliste enthält Buchungen. Dadurch, dass in der Buchung alle für die Notenliste
relevanten Informationen zur Verfügung stehen wird keine weitere Notenklasse benötigt.

AusgabeDatenverwaltung.DatenVerwaltung: Anwesenheitsliste (Martin Munkelt)
--------------------------------------------------------------------------
Die Anwesenheitsliste wird von der AusgabeVerwaltung generiert. Sie enthält die einzelnen
Anwesenheiten. Dafür wird ebenfalls auf die Daten der Buchungsliste zurückgegriffen.

AusgabeDatenverwaltung.DatenVerwaltung: Platzkartenlisten (Martin Munkelt)
--------------------------------------------------------------------------
Die Platzkartenliste wird von der AusgabeVerwaltung erzeugt und enthält Buchungsobjekte. Auch
hier sind in den Buchungen die gesamten Informationen der Platzkarte enthalten.


AusgabeDatenverwaltung.DatenVerwaltung: PruefungstagComparator
--------------------------------------------------------------
Der PruefungstagComparator wird vom Pruefungstag benutzt, um die Objekte der 
Klasse Pruefungstag sortiert zu speichern.


Ausgabe: FlatFileSchreiber (Martin Munkelt)
-------------------------------------------
Der FlatFileSchreiber wird von der AusgabeVerwaltung instantziiert und für die Ausgabe
der Listen in Files verwendet. Die Klasse ruft die Hilfsklasse Datei auf und sendet
die aufbereiteten Datenströme an die Ausgabe.



Hilfsklasse Datei
-----------------´
Die vorgegebene Klasse Datei stellt die Logik zum Zugriff auf eine Datei zur Verfügung. 
Sie wird genutzt vom FlatFileLeser und vom FlatFileSchreiber.

Hilfsklasse: Interface Uni (Silvia Wölfle)
------------------------------------------
Mit diesem Interface ist sichergestellt, dass programmweit immer "D" für Duisburg und "B" für Bamberg steht.




