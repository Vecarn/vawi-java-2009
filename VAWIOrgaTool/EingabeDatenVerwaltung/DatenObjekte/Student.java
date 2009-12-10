
package EingabeDatenVerwaltung.DatenObjekte;
import  EingabeDatenVerwaltung.DatenObjekte.*;

/**
 * Datentr�gerklasse Student
 * enth�lt Student-Objekte 
 * mit den Eigenschaften eines Studenten und den passenden Getter/Setter-Methoden
 * 
 * @author  Silvia W�lfle
 * @version 1.0 on 04.12.2009
 */
public class Student
{
    // Attribute der Klasse Student
    private int matrikelnr;
    private String name;
    private String vorname;
    // Kategorien einordnen lassen:
    // 'B' - Universit�t Bamberg
    // 'D' - Universit�t Duisburg-Essen
    private char uni;
    private String bundesland;
    // Studenten k�nnen angeben, ob sie m�glichst viele Pr�fungen an einem Tag machen m�chten
    // true bedeutet, dass der Student Zeitminimierer ist
    // false bedeutet, dass der nicht Student Zeitminimierer ist, also Pr�fungen besser verteilen will
    private boolean zeitminimierer;
    // Hier wird gesetzt, ob Student zufrieden, also ob zeitminimierung erfuellt
    // true bedeutet, dass Praeferenz Zeitminimierer erfuellt
    // false bedeutet, dass Praeferenz Zeitminimierer nicht erfuellt
    private boolean zufrieden;

    /**
     * Konstruktor f�r Objekte der Klasse Student mit Parameter 
     * (der name, vorname und matrikelnr bei der erstellung des Objekts verlangt und gleich setzt)
     * 
     * @param name             Nachname des Studenten (String)
     * @param vorname          Vorname des Studenten (String)
     * @param matrikelnr       ID des Studenten (int)
     */
    public Student(String name, String vorname, int matrikelnr)
    {
        this.name=name;
        this.vorname=vorname;
        this.matrikelnr=matrikelnr;
     }
   /**
     * Getter/Setter-Methoden
     */    
    // Setter (Name: gleich Vor- und Nachname??)
    public void setVorname(String vorname)
     {
         this.vorname = vorname;
     }
    public void setName(String name)
     {
         this.name = name;
     }
    public void setUni(char uni)
     {
         this.uni = uni;
     }
    public void setBundesland(String bundesland)
     {
         this.bundesland = bundesland;
     }   
    public void setZeitminimierer(boolean zeitminimierer)
     {
         this.zeitminimierer = zeitminimierer;
     }        
    public void setZufrieden(boolean zufrieden)
     {
         this.zufrieden = zufrieden;
     }  
    // Getter
      public int getMatrikelnr()
      {
      return matrikelnr;
      }
    public String getVorname()
      {
      return vorname;
      }
     public String getName()
      {
      return name;
      }
    public char getUni()
      {
      return uni;
      }
    public String getBundesland()
      {
      return bundesland;
      }   
    public boolean getZeitminimierer()
    {
     return zeitminimierer;
     } 
    public boolean getZufrieden()
    {
     return zufrieden;
     } 
}