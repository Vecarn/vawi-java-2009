
package EingabeDatenVerwaltung.DatenObjekte;

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
    // ==========================================================================
    // === Attribute der Klasse Student
    // ========================================================================== 
    private int matrikelnr;
    private String name;
    private String vorname;
    // Kategorien einordnen lassen:
    // 'Ba' - Universit�t Bamberg
    // 'Dui' - Universit�t Duisburg-Essen
    private char uni;
    private String bundesland;
    // Studenten k�nnen angeben, ob sie m�glichst viele Pr�fungen an einem Tag machen m�chten
    // true bedeutet, dass der Student Zeitminimierer ist
    // false bedeutet, dass der nicht Student Zeitminimierer ist, also Pr�fungen besser verteilen will
    private boolean zeitminimierer;

    /**
     * Konstruktor f�r Objekte der Kurs ohne Parameter
     */
    public Student()
    {

    }
}