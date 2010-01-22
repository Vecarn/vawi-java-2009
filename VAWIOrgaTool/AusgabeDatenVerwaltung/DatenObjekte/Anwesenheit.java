
package AusgabeDatenVerwaltung.DatenObjekte;
import EingabeDatenVerwaltung.DatenObjekte.*;
import EingabeDatenVerwaltung.DatenVerwaltung.*;

/**
 * Datentraegerklasse Anwesenheit mit den Eigenschaften Student und Kursliste
 * und den passenden Getter/Setter-Methoden.
 * Enthaelt selbst nicht Tag und Uni und auch keine Liste, 
 * da dies erst in der Verwaltungsklassen f�r die Listen zusammengestellt wird 
 * 
 * @author  Silvia W�lfle
 * @version 2.1 on 08.01.2010
 */

public class Anwesenheit 
{
    // Attribute f�r Klasse Anwesenheit, Liste wird aus der Kursliste verwendet
    // Tag und Uni werden erst in Verwaltungsklassen f�r Listen genutzt
    private Student student;
    private Kursliste studentKursliste;

    /**
     * Konstruktor Anwesenheit, verlangt Student
     * @param student  anwesender Student mit �berpr�fung
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
              System.out.println("Studentenliste f�r Kurs ist null!");
              return;
              }else if(studentKursliste.getSize()==0){
              System.out.println("Studentenliste f�r Kurs ist leer!");
              return;
              }         
            this.studentKursliste = studentKursliste;
        }
     /**
     * Get-Methode: Gibt Student an einem Pruefungstag als Student zur�ck
     * @return   student Student an einem Pruefungstag
     */
     public Student getStudent ()
      {
       return student;
      }
     /**
     * Get-Methode: Gibt Kurse, die ein Student an einem Pruefungstag schreibt als Kursliste zur�ck
     * @return   studentKursliste Kurse des Studenten am Pruefungstag
     */
     public Kursliste getStudentKursliste()
      {
      return studentKursliste;
      }
 }

