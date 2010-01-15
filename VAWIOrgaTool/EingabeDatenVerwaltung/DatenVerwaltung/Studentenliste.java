package EingabeDatenVerwaltung.DatenVerwaltung;

import java.util.Collection;
import java.util.Iterator;
import java.util.TreeSet;
import EingabeDatenVerwaltung.DatenObjekte.*;

/**
 * Verwaltungsklasse f&uuml;r Studenten.<br>
 * Die Studenten werden aufsteigend nach Ihrer MatrikelNr in einem TreeSet gespeichert.<br>
 * Die Klasse bietet entsprechende Methoden um ein Studenten-Objekt hinzuzufügen und <br>
 * Informationen über den Datenbestand zu liefern.
 * 
 * @author Markus Bode
 * @version 1.1 vom 12.01.2010
 */
public class Studentenliste {

    private Collection<Student> studenten = new TreeSet<Student>(new StudentenComparator());
    
    /**
     * Fügt ein neues Studenten-Objekt zur Collection hinzu.<br>
     * Dabei werden doppelte Studenten-Objekte automatisch ausgeschlossen.
     * 
     * @param matrikelNummer (int) - Die MatrikelNr. des Studenten. 
     * @param name (String) - Der Nachname des Studenten.
     * @param vorname (String) - Der Vorname des Studenten.
     * @param uni (Char) - Die Universität an der der Student eingeschrieben ist.
     * @param bundesland (String) - Das Herkunfts-Bundesland des Studenten.
     * @param zeitminimierer (boolean) - Wahrheitswert gibt an ob Student zeitminimierer ist oder nicht.
     * @return	true: wenn Collection geändert wurde <br>
     *			false: wenn Collection nicht geändert wurde (z.B. wenn Objekt bereits in Collection)
     */
    public boolean addNeuerStudent(int matrikelNummer, String name, String vorname, char uni, String bundesland, boolean zeitminimierer){
    	
    	Student student = new Student(vorname,name,matrikelNummer);
    	
    	if(studenten.add(student)){
    		student.setUni(uni);
    		student.setBundesland(bundesland);
    		student.setZeitminimierer(zeitminimierer);
    		return true;
    	}
    	
    	return false;
        	
    }
    
    /**
     * Methode kann genutzt werden um ein bereits bestehendes Studenten-Objekt der Studentenliste hinzuzufügen. <br>
     * Dies ist sinnvoll, wenn eine weitere Studentenliste benötigt wird, um zum Beispiel eine Untermenge der vorhandenen Studenten separat zwischenzuspeichern.<br>
     * (z.B.: Menge an Studenten die an einem Prüfungstag eine Prüfung ablegen) 
     * 
     * @param student (Student) - Ein konkretes Studenten-Objekt
     * @return	true: wenn Collection geändert wurde <br>
     *			false: wenn Collection nicht geändert wurde (z.B. wenn Objekt bereits in Collection)
     */
    public boolean addStudent(Student student){
    	if(studenten.add(student)){
    		return true;
    	}
    	
    	return false;
    }
    
    /**
     * Studenten sind über Ihre MatrikelNr. eindeutig zu identifizieren.<br>
     * Die Methode liefert ein Studenten-Objekt anhand der MatrikelNr. 
     * 
     * @param matrikelnr (int) - MatrikelNr. des gesuchten Studenten.
     * @return Student	: Konkretes Studenten-Objekt<br>
     * 			null	: Wenn kein Student mit entsprechender MatrikelNr. vorhanden ist.
     * 			
     */
    public Student getStudent(int matrikelnr){
    	
    	Iterator<Student> studenteniterator = studenten.iterator();
    	
    	while(studenteniterator.hasNext()){
    		
    		Student student = studenteniterator.next();
  
    		if(student.getMatrikelnr()==matrikelnr){
    			return student;
    		}
    	}
    		
    	return null;
    }
    
    /**
     * Liefert einen Iterator auf die vorhandene Studenten-Collection.<br>
     * Anhand des Iterators kann durch alle Studenten-Objekte, aufsteigend nach MatrikelNr. gesucht werden.
     * 
     * @return Iterator: Iterator auf Collection mit Studenten-Objekten.
     */
    public Iterator<Student> getStudentIterator(){
		return studenten.iterator();	
    }
    
    /**
     * Liefert die Anzahl der Studenten-Objekte.
     * 
     * @return int: Anzahl der vorhandenen Studenten-Objekte.
     */
    public int getSize(){
    	return studenten.size();
    }
    
    /**
     * Methode prüft ob ein Student in der Studentenliste enthalten ist.
     * 
     * @param student (Student) - Ein Studentenobjekt.
     * @return	true:	Student ist in Collection enthalten.
     * 			false: 	Student ist nicht in der Collection enthalten.
     */
    public boolean containsStudent(Student student){
    	return(studenten.contains(student));
    }
    
    /**
     * Methode entfernt das Studentenobjekt aus der Collection.
     * 
     * @param student (Student) - Das zu entfernende Studentenobjekt.
     */
	public void removeStudent(Student student) {
    	studenten.remove(student);
	}

}
