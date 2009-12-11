
package AusgabeDatenVerwaltung.DatenObjekte;
import EingabeDatenVerwaltung.DatenObjekte.*;
import Hilfsklassen.Universitaet.*;
import PruefungsPlanung.PruefungsPlanerAlgo1.*;
import PruefungsPlanung.Pruefungstag.*;

/**
 * Datentraegerklasse Anwesenheit mit den Eigenschaften Studentenliste und Tag und Uni
 * und den passenden Getter/Setter-Methoden.
 * 
 * @author  Silvia Wölfle
 * @version 1.0 on 11.12.2009
 */

public class Anwesenheit 
{
    // Attribute für Klasse Anwesenheit, Liste wird aus der Studentenliste verwendet
    // Tag und Uni werden erst in Verwaltungsklassen für Listen genutzt, daher hier nicht
    // kein Array/keine Liste, weil das erst in Verwaltungsklasse zusammengestellt
    private Student student;
    private Kursliste studentKursliste;
    // Array für Kurse pro Student?
    private Kurs kursStudent[];

    /**
     * Konstruktor Anwesenheit, verlangt Tag und Uni
     * für die Erstellung eines Anwesenheits-Objektes
     */
    public Anwesenheit (Student student)
    {
        this.student = student; 
    }
   /**
     * Methoden
     */ 
    
    // Setter
    public void setKursliste(Kursliste studentKursliste)
        {
            this.studentKurslistee = studentKursliste;
        }
     // Getter  
     public Student getStudent ()
      {
       return student;
      }
     public Kursliste getStudentKursliste()
      {
      return studentKursliste;
      }
 }
