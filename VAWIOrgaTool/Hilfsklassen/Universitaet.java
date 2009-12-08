@solle das nicht ein interface sein? Gruss Silvia

/**
 * 
 */
package Hilfsklassen;

/**
 * Klasse für die Universitäten
 * 
 * @author Martin
 * @version 0.1
 *
 */
public class Universitaet {
	
	private int id;
	private String name;
	private String ort;

	/**
	 * Konstruktor für die Universitätsklasse
	 * @param name Der Name der Uni
	 * @param ort Der Ort der Uni
	 */
	public void Universtitaet(String name, String ort){
		this.name = name;
		this.ort = ort;
	}

	
	/**
	 * @return the ort
	 */
	public String getOrt() {
		return ort;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	
	
}
