
package AusgabeDatenVerwaltung.DatenObjekte;
import EingabeDatenVerwaltung.DatenObjekte.*;
import EingabeDatenVerwaltung.DatenVerwaltung.*;

/**
 * Datentraegerklasse Anwesenheit mit den Eigenschaften Student und Kursliste
 * und den passenden Getter/Setter-Methoden.
 * Enthaelt selbst nicht Tag und Uni und auch keine Liste, 
 * da dies erst in der Verwaltungsklassen für die Listen zusammengestellt wird 
 * 
 * @author  Silvia Wölfle
 * @version 2.1 on 08.01.2010
 */

public class Anwesenheit 
{
    // Attribute für Klasse Anwesenheit, Liste wird aus der Kursliste verwendet
    // Tag und Uni werden erst in Verwaltungsklassen für Listen genutzt
    private Student student;
    private Kursliste studentKursliste;

    /**
     * Konstruktor Anwesenheit, verlangt Student
     * @param student  anwesender Student mit Überprüfung
     */
    public Anwesenheit (Student student)
    {
         if(student == null){
            System.out.println("Student ist null!");
            return;
        }         
        this.student = student; 
    }
   /**
     * Set-Methode studentKursliste (ueberschreibt Attribut studentKursliste)
     * @param studentKursliste Kurse, die ein Student an einem Pruefungstag schreibt (Kursliste)
     */ 
    public void setKursliste(Kursliste studentKursliste)
        {
           if(studentKursliste==null){
              System.out.println("Studentenliste für Kurs ist null!");
              return;
              }else if(studentKursliste.getSize()==0){
              System.out.println("Studentenliste für Kurs ist leer!");
              return;
              }         
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

