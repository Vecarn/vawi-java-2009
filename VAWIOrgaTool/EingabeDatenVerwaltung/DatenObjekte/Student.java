
package EingabeDatenVerwaltung.DatenObjekte;
import  EingabeDatenVerwaltung.DatenObjekte.*;

/**
 * Datenträgerklasse Student
 * enthält Student-Objekte 
 * mit den Eigenschaften eines Studenten und den passenden Getter/Setter-Methoden
 * 
 * @author  Silvia Wölfle
 * @version 1.0 on 04.12.2009
 */
public class Student
{
    // Attribute der Klasse Student
    private int matrikelnr;
    private String name;
    private String vorname;
    // Kategorien einordnen lassen:
    // 'Ba' - Universität Bamberg
    // 'Dui' - Universität Duisburg-Essen
    private char uni;
    private String bundesland;
    // Studenten können angeben, ob sie möglichst viele Prüfungen an einem Tag machen möchten
    // true bedeutet, dass der Student Zeitminimierer ist
    // false bedeutet, dass der nicht Student Zeitminimierer ist, also Prüfungen besser verteilen will
    private boolean zeitminimierer;

    /**
     * Konstruktor für Objekte der Klasse Student mit Parameter 
     * (der name, vorname und matrikelnr bei der erstellung des Objekts verlangt und gleich setzt)
     * 
     * @param name             Nachname des Studenten (String)
     * @param vorname          Vorname des Studenten (String)
     * @param matrikelnr       ID des Studenten (int)
     */
    public Student(String name, String vorname, int kursid)
    {
        this.name=name;
        this.vorname=vorname;
        this.matrikelnr=matrikelnr;
     }
   /**
     * Getter/Setter-Methoden
     */    
    // Setter
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
    // Getter
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

}