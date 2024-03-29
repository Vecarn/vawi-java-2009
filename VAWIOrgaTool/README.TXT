------------------------------------------------------------------------
This is the project README file. Here, you should describe your project.
Tell the reader (someone who does not know anything about this project)
all he/she needs to know. The comments should usually include at least:
------------------------------------------------------------------------

PROJECT TITLE: VAWI JAVA WS0910 - Teilleistung 3
PURPOSE OF PROJECT: Lauff�higes Tool zum planen eines Pr�fungsterminplans.  
VERSION or DATE: 25.01.2010
HOW TO START THIS PROJECT:
Beim starten des Programms k�nnen Parameter eingegeben werden mit den Dateinamen der Eingabedateien.
Der Aufruf per Parameter lautet z.B. -studenten=studenten.txt -kurse=kurse.txt -buchungen=buchungen.txt
Wichtig: Die Dateien m�ssen sich im Wurzelverzeichnis des VAWIOrgaTools befinden!
Wenn keine Angaben gemacht werden, werden Standardnamen der Dateien angenommen.
AUTHORS: Silvia W�lfle, Martin Munkelt, J�rn Hauser, Markus Bode. Die genaue Zuordnung ist anhand der Namen pro Klasse zu sehen!

|---------------------------------------------|
| Allgemeine Beschreibung des Klassensystems |
|---------------------------------------------|

Das Programm unterst�tzt die Planung und Organisation von Pr�fungen. Es verwaltet Studierende, 
Kurse und verteilt gebuchte Kurse konfigurierbar auf Pr�fungstage. Pro Tag und Student sind 
maximal drei Kurse zul�ssig. Der m�glichst kurze Pr�fungsterminplan umfasst mehrere Pr�fungstage. 
Das Programm erzeugt auch fiktive Kursbelegungen. 
Es werden Anwesenheitslisten (pro Tag und Ort), Notenlisten (pro Kurs, inkl. Darstellung bereits erreichter Punkte) 
sowie Platzkarten (pro Student, Tag und Ort) erstellt. Die Erf�llung der Pr�ferenz der Studenten, 
ob alle Kurse an einem Tag oder m�glichst nur ein Kurs am Tag gepr�ft werden will, pr�ft das System im Nachhinein. 

Grundgedanke des Klassenmodells ist eine gute objektorientierte Architektur, die Klassen gruppiert 
und eindeutig einzelnen Komponenten zuordnen l�sst. Daher die Packages Dateneinlesen, Pr�fungsplanung, Datenausgabe. 
Es wurde zudem darauf geachtet, dass Ber�hrungspunkte f�r eine leichte Austauschbarkeit teils abstrahiert wurden
Das Klassenmodell wurde so gestaltet, dass der eigentliche Pr�fungs-Algorithmus leicht austauschbar ist. 
Alle Algorithmen verwenden die gleichen Randbedingungen. 



|---------------------------------------------|
| Zusammenh�nge der Klassen                   |
|---------------------------------------------|

VAWIOrgaTool (J�rn Hauser)
--------------------------
Einsprungspunkt in das Programm. Enth�lt die "Main"-Methode. Ebenso stellt es Methoden f�r eine rudiment�re Benutzerschnittstelle zur Verf�gung.

Ablaufsteuerung (J�rn Hauser)
-----------------------------
Stellt Methoden zur Steuerung des Programmablaufs bereit. Pr�ft zus�tzlich auf Plausibilit�t des Programmablaufs.

Simulator (Markus Bode)
------------------------
Die Klasse Simulator nutzt die Verwaltungsklassen aus dem Paket EingabeDatenVerwaltung.DatenVerwaltung.
Anhand einer �bergebenen Kursliste und wahlweise Parametern werden Daten generiert.

ZufriedenheitsMesser (Markus Bode)
----------------------------------
Der ZufriedenheitsMesser bestimmt die Zufriedenheit der Studenten mit dem erstellten Pruefungsterminplan.
Dazu wird die Klasse Studentenliste genutzt um die Zufriedenheit eines Studenten zu speichern.



PruefungsPlanung.Planungsbedingunen (Silvia W�lfle)
---------------------------------------------------
Die Planungsbedingungen ist eine Datenklasse mit Attributen, getter/setter-Methoden (inkl. Pr�fungen), z.B. maximale Anzahl an Kurse pro Student und Tag. 
Die Planungsbedingungen werden ueber den Programmablauf gesetzt. (Also keine Konstanten)
                
PruefungsPlanung.PruefungsplanerAlgo1 (J�rn Hauser)
---------------------------------------------------
Der PruefungsplanerAlgo1 ist die konkrete Umsetzung des Planungsalgorithmus. 
Er implementiert den Pruefungsplaner und spezialisiert den PruefungsplanerAbstrakt

PruefungsPlanung.PruefungsplanerAbstrakt (J�rn Hauser)
------------------------------------------------------
Der PruefungsplanerAbstrakt implementiert allgemeineg�ltige Methoden f�r Pr�fungsplaner.

PruefungsPlanung.PruefungsPlaner (J�rn Hauser)
----------------------------------------------
Interface, das eine Klasse zur Pruefungsplanung beschreibt.



EingabeDatenverwaltung.DatenObjekte: Student, Kurs und Buchung (Silvia W�lfle)
------------------------------------------------------------------------------
Enthalten Datenobjekte Student, Kurs und Buchung und getter/setter-Methoden (inkl. Pr�fungen)

EingabeDatenverwaltung.DatenVerwaltung: Buchungsliste + BuchungsComparator (Markus Bode)
----------------------------------------------------------------------------------------
Die Buchungsliste steht mit allen Klassen in Beziehung, die Zugriff auf den Buchungs-Bestand ben�tigen. 
Der PruefungsPlaner nutzt so die Liste. Au�erdem wird Sie von der Klasse FlatFileLeser genutzt um 
die Objekte aus den Daten zu erstellen. Im Simulationsprozess wird die Klasse von der Klasse Simulator 
genutzt, welche die Liste mit generierten Daten beliefert. Die Buchungsliste nutzt den BuchungsComparator 
um die Objekte der Klasse Buchung sortiert zu speichern.

EingabeDatenverwaltung.DatenVerwaltung: Kursliste + KursComparator (Markus Bode)
--------------------------------------------------------------------------------
Auch die Kursliste steht mit dem PruefungsPlaner und dem FlatFileLeserin in Beziehung. Die Klasse nutzt den 
KursComparator um Objekte der Klasse Kurs sortiert zu speichern. Weiterhin wird die Klasse Kursliste von allen Klassen genutzt, 
die mehrere Kurse speichern m�ssen oder Zugriff auf diese ben�tigen. (z.B.: Klasse Anwesenheit, Klasse Simulator) 

EingabeDatenverwaltung.DatenVerwaltung: Studentenliste + StudentenComparator (Markus Bode)
------------------------------------------------------------------------------------------
Die Studentenliste steht ebenfalls mit dem PruefungsPlaner in Beziehung. Die Klasse nutzt den StudentenComparator
um die erstellten Objekte der Klasse Student sortiert vorzuhalten. Auch die Studentenliste wird durch den FlatFileLeser
mit Daten beliefert. Die Studentenliste steht au�erdem mit allen Klassen in Beziehung, welche die Verwaltungslogik (Speicherung und Zugriff) 
der Studentenliste ben�tigen. (z.B.: Klasse Simulator, Klasse Pruefungstag, Klasse ZufriedenheitsMesser)

Eingabe: FlatFileLeser (Markus Bode)
------------------------------------
Wird von der Klasse Ablaufsteuerung genutzt und liest Daten mit Hilfe der Klasse Datei ein. 
Die Daten werden an die entsprechenden Verwaltungs-Klassen �bergeben. 



AusgabeDatenverwaltung.DatenObjekte: Pruefungstag (Silvia W�lfle)
-----------------------------------------------------------------
Enth�lt den Pr�fungstag und eine Kursliste sowie ein Studentenliste und getter/setter-Methoden (inkl. Pr�fungen)
Die Tage wertden aus dem PruefungsPlanerAlgo1 gesetzt.

AusgabeDatenverwaltung.DatenObjekte: Anwesenheit (Silvia W�lfle)
----------------------------------------------------------------
Enth�lt Student und Kursliste und getter/setter-Methoden (inkl. Pr�fungen) 
Enth�lt selbst nicht Tag und Uni, da erst in der Verwaltungsklassen f�r die Listen zusammengestellt 

AusgabeDatenverwaltung.DatenVerwaltung: Pruefungsterminplan (Martin Munkelt)
----------------------------------------------------------------------------
Der Pr�fungsterminplan enth�lt alle Pr�fungstage. Der Pruefungsterminplan steht mit der AusgabeVerwaltung
und der Logik f�r die Erzeugung des Planes in Beziehung

AusgabeDatenverwaltung.DatenVerwaltung: Notenliste (Martin Munkelt)
-------------------------------------------------------------------
Die Notenliste enth�lt Buchungen. Dadurch, dass in der Buchung alle f�r die Notenliste
relevanten Informationen zur Verf�gung stehen wird keine weitere Notenklasse ben�tigt.

AusgabeDatenverwaltung.DatenVerwaltung: Anwesenheitsliste (Martin Munkelt)
--------------------------------------------------------------------------
Die Anwesenheitsliste wird von der AusgabeVerwaltung generiert. Sie enth�lt die einzelnen
Anwesenheiten. Daf�r wird ebenfalls auf die Daten der Buchungsliste zur�ckgegriffen.

AusgabeDatenverwaltung.DatenVerwaltung: Platzkartenlisten (Martin Munkelt)
--------------------------------------------------------------------------
Die Platzkartenliste wird von der AusgabeVerwaltung erzeugt und enth�lt Buchungsobjekte. Auch
hier sind in den Buchungen die gesamten Informationen der Platzkarte enthalten.


AusgabeDatenverwaltung.DatenVerwaltung: PruefungstagComparator
--------------------------------------------------------------
Der PruefungstagComparator wird vom Pruefungstag benutzt, um die Objekte der 
Klasse Pruefungstag sortiert zu speichern.


Ausgabe: FlatFileSchreiber (Martin Munkelt)
-------------------------------------------
Der FlatFileSchreiber wird von der AusgabeVerwaltung instantziiert und f�r die Ausgabe
der Listen in Files verwendet. Die Klasse ruft die Hilfsklasse Datei auf und sendet
die aufbereiteten Datenstr�me an die Ausgabe.



Hilfsklasse Datei
-----------------�
Die vorgegebene Klasse Datei stellt die Logik zum Zugriff auf eine Datei zur Verf�gung. 
Sie wird genutzt vom FlatFileLeser und vom FlatFileSchreiber.

Hilfsklasse: Interface Uni (Silvia W�lfle)
------------------------------------------
Mit diesem Interface ist sichergestellt, dass programmweit immer "D" f�r Duisburg und "B" f�r Bamberg steht.




