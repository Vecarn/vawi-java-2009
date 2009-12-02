package EingabeDatenVerwaltung.DatenVerwaltung;

import java.util.Collection;
import java.util.Iterator;
import java.util.TreeSet;

import EingabeDatenVerwaltung.DatenObjekte.*;
/**
 * Verwaltungsklasse f&uuml;r Studenten
 * @author Markus Bode
 * @poseidon-object-id [I2d0758e8m124d537380cmm7ba0]
 */
public class Studentenliste {
/**
 * 
 * 
 * @poseidon-object-id [I2d0758e8m124d537380cmm7ac0]
 * @poseidon-type EingabeDatenVerwaltung.DatenObjekte.Student
 */
    private Collection<Student> studenten = new TreeSet<Student>();
 
    /**
     * 
     * @param id
     * @param nachname
     * @param vorname
     * @param uni
     * @param region
     * @param zeitminimierer
     * @return	true: wenn Collection geändert wurde <br>
     *			false: wenn Collection nicht geändert wurde (z.B. wenn Objekt bereits in Collection)
     */
    
    public boolean addStudent(long id, String nachname, String vorname, char uni, String region, boolean zeitminimierer){
    	//new Student(variablen)
    	if(studenten.add(new Student())){
    		return true;
    	}
    	
    	return false;
    }
    
    /**
     * 
     * @param id: Identifizierendes Merkmal eines Studenten
     * @return Student
     */

    public Student getStudent(int id){
    	
    	Iterator<Student> studenteniterator = studenten.iterator();
    	
    	while(studenteniterator.hasNext()){
    		Student student = studenteniterator.next();
    		//student.getId() == id
    		if(true){
    			return student;
    		}
    	}
    		
    	return null;
    }

}
