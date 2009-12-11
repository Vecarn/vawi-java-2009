
package AusgabeDatenVerwaltung.DatenObjekte;
import EingabeDatenVerwaltung.DatenObjekte.*;
import EingabeDatenVerwaltung.DatenVerwaltung.*;
import AusgabeDatenVerwaltung.DatenObjekte.*;

/**
 * Datentraegerklasse Anwesenheit mit den Eigenschaften Student und Kursliste
 * und den passenden Getter/Setter-Methoden.
 * Enthaelt selbst nicht Tag und Uni und auch keine Liste, 
 * da dies erst in der Verwaltungsklassen für die Listen zusammengestellt wird 
 * 
 * @author  Silvia Wölfle
 * @version 2.0 on 11.12.2009
 */

public class Anwesenheit 
{
    // Attribute für Klasse Anwesenheit, Liste wird aus der Kursliste verwendet
    // Tag und Uni werden erst in Verwaltungsklassen für Listen genutzt
    private Student student;
    private Kursliste studentKursliste;

    /**
     * Konstruktor Anwesenheit, verlangt Student
     * @param student  anwesender Student
     */
    public Anwesenheit (Student student)
    {
        this.student = student; 
    }
   /**
     * Set-Methode studentKursliste (ueberschreibt Attribut studentKursliste)
     * @param studentKursliste Kurse, die ein Student an einem Pruefungstag schreibt (Kursliste)
     */ 
    public void setKursliste(Kursliste studentKursliste)
        {
            this.studentKursliste = studentKursliste;
        }
     /**
     * Get-Methode: Gibt Student an einem Pruefungstag als Student zurück
     * @return   student Student an einem Pruefungstag
     */
     public Student getStudent ()
      {
       return student;
      }
     /**
     * Get-Methode: Gibt Kurse, die ein Student an einem Pruefungstag schreibt als Kursliste zurück
     * @return   studentKursliste Kurse des Studenten am Pruefungstag
     */
     public Kursliste getStudentKursliste()
      {
      return studentKursliste;
      }
 }
