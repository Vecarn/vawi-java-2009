
package EingabeDatenVerwaltung.DatenObjekte;

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
    // ==========================================================================
    // === Attribute der Klasse Student
    // ========================================================================== 
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
     * Konstruktor für Objekte der Kurs ohne Parameter
     */
    public Student()
    {

    }
}