package EingabeDatenVerwaltung.DatenVerwaltung;

import java.util.Collection;
import java.util.Iterator;
import java.util.TreeSet;
import EingabeDatenVerwaltung.DatenObjekte.*;

/**
 * Verwaltungsklasse f&uuml;r Studenten
 * @author Markus Bode
 */
public class Studentenliste {

    private Collection<Student> studenten = new TreeSet<Student>(new StudentenComparator());
    
    /**
     * Fügt ein Studenten-Objekt zur Collection hinzu.
     * 
     * @param id (long)
     * @param nachname (String)
     * @param vorname (String)
     * @param uni (Char)
     * @param region (String)
     * @param zeitminimierer (boolean)
     * @return	true: wenn Collection geändert wurde <br>
     *			false: wenn Collection nicht geändert wurde (z.B. wenn Objekt bereits in Collection)
     */
    public boolean addStudent(long id, String nachname, String vorname, char uni, String region, boolean zeitminimierer){
    	    	
    	return studenten.add(new Student(id));
        	
    }
    
    /**
     * Liefert ein Studenten-Objekt anhand einer zu übergebenden id. 
     * 
     * @param id (long)	: Identifizierendes Merkmal eines Studenten
     * @return Student	: Konkretes Studenten-Objekt<br>
     * 			null	: Wenn kein Student mit entsprechender id vorhanden.
     * 			
     */

    public Student getStudent(long id){
    	
    	Iterator<Student> studenteniterator = studenten.iterator();
    	
    	while(studenteniterator.hasNext()){
    		
    		Student student = studenteniterator.next();
  
    		if(student.getId()==id){
    			return student;
    		}
    	}
    		
    	return null;
    }
    /**
     * Liefert einen Iterator auf die vorhandene Studenten-Collection.
     * 
     * @return Iterator<Student> : Iterator auf Collection mit Studenten-Objekten.
     */
    
    public Iterator<Student> getStudentIterator(){
		return studenten.iterator();	
    }

}
