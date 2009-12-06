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

Ein paar allgemeine Sätze.	



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

PruefungsPlaner
----------------
				
....
....
....

Buchungsliste + BuchungsComparator
----------------------------------
Die Buchungsliste steht mit den Klassen in Beziehung, die Zugriff auf den Buchungs-Bestand benötigen. 
Der PruefungsPlaner nutzt so die Liste. Außerdem wird Sie von der Klasse FlatFileLeser genutzt um 
die Objekte aus den Daten zu erstellen. Im Simulationsprozess wird die Klasse von der Klasse Simulator 
genutzt welche die Liste mit generierten Daten beliefert. Die Buchungsliste nutzt den BuchungsComparator 
um die Objekte der Klasse Buchung sortiert zu speichern.

Kursliste + KursComparator
--------------------------
Auch die Kursliste steht mit dem PruefungsPlaner in Beziehung und mit dem FlatFileLeser. Die Klasse nutzt den 
KursComparator um Objekte der Klasse Kurs sortiert zu speichern.

Studentenliste + Studentencomparator
------------------------------------
Die Studentenliste steht ebenfalls mit dem PruefungsPlaner in Beziehung. Die Klasse nutzt den StudentenComparator
um die erstellten Objekte der Klasse Student sortiert vorzuhalten. Auch die Studentenliste wird durch den FlatFileLeser
mit Daten beliefert. Im Simulationsprozess wird die Liste von der Klasse Simulator genutzt welcher die Liste mit generierten Daten beliefert.
Die Studentenliste wird auch vom ZufriedenheitsMesser genutzt welcher die Studenten abfragt. 

FlatFileLeser
-------------
Wird von der Haupt-Klasse VAWIOrgaTool genutzt und liest Daten mit Hilfe der Klasse Datei ein. 
Die Daten werden an die entsprechenden Verwaltungs-Klassen übergeben. 
