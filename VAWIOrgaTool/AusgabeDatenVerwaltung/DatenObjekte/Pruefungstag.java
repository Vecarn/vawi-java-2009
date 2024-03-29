package AusgabeDatenVerwaltung.DatenObjekte;
import EingabeDatenVerwaltung.DatenVerwaltung.*;
import PruefungsPlanung.PruefungsPlanerAlgo1.*;


/**
 * Datentraegerklasse Pruefungstag mit den Eigenschaften Kursliste, Studentenliste und Tag
 * Studentenliste hier auch enthalten, damit diese f�r die Ausgabe nicht nochmal muehsam zusammengesetzt werden muss
 * Wird ueber Pruefunsplanung fuer Tage 1,2,... gefuellt
 * 
 * @author  Silvia W�lfle
 * @version 2.1 on 08.01.2010
 */
public class Pruefungstag 
{
    // Attribute f�r den Pruefungstag, ggf. Datum zus�tzlich
    private int tagId;
    private Kursliste tagesKursliste;
    private Studentenliste tagesStudentenliste;  
     
    /**
     * Konstruktor Pruefungstag verlangt Tag f�r die Erstellung eines Anwesenheits-Objektes
     * 
     * @param tagId   ID des Tages (int)
     */
    public Pruefungstag (int tagId)
    {
        this.tagId = tagId;   
    }
   /**
     * Set-Methode tagesKursliste (ueberschreibt Attribut tagesKursliste)
     * @param tagesKursliste Kursliste f�r einen Pruefungstag (Kursliste)
     */  
    public void setTagesKursliste(Kursliste tagesKursliste)
     {
         if(tagesKursliste==null){
            System.out.println("Kursliste f�r Tag ist null!");
            return;
             }else if(tagesKursliste.getSize()==0){
            System.out.println("Kursliste f�r Tag ist leer!");
            return;
            }         
         this.tagesKursliste = tagesKursliste;
     }
   /**
     * Set-Methode tagesStudentenliste (ueberschreibt Attribut tagesStudentenliste)
     * @param tagesStudentenliste Studentenliste f�r einen Pruefungstag (Studentenliste)
     */  
    public void setTagesStudentenliste(Studentenliste tagesStudentenliste)
     {
         if(tagesStudentenliste==null){
            System.out.println("Studentenliste f�r Tag ist null!");
            return;
             }else if(tagesStudentenliste.getSize()==0){
            System.out.println("Studentenliste f�r Tag ist leer!");
            return;
            }       
         this.tagesStudentenliste = tagesStudentenliste;
     }

     /**
     * Get-Methode: Gibt ID eines Tages als int zur�ck
     * @return   tagId des Pruefungstages als int
     */
     public int getTagId()
      {
      return tagId;
      }
     /**
     * Get-Methode: Gibt Kursliste f�r einen Pruefungstag als Kursliste zur�ck
     * @return   tagesKursliste des Pruefungstages als Kursliste
     */
     public Kursliste getTagesKursliste()
      {
      return tagesKursliste;
      }   
     /**
     * Get-Methode: Gibt Studentenliste f�r einen Pruefungstag als Studentenliste zur�ck
     * @return   tagesStudentenliste des Pruefungstages als Studentenliste
     */
     public Studentenliste getTagesStudentenliste()
      {
      return tagesStudentenliste;
      }   
}