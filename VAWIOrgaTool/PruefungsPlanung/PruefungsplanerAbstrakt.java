
package PruefungsPlanung;

/**
 * Der PruefungsplanerAbstrakt ist eine Abstrakte Klasse, die das Interface Pruefungsplaner implementiert. Alle Methoden die den Algorithmus direkt betreffen bleiben abstrakt. Lediglich die Methoden, die die Planungsbedingungen als Randbedingungen f&uuml;r den Algorithmus setzen, sind implementiert.
 * 
 * @poseidon-object-id [Im3057c7d4m124e9a3360amm7463]
 */
public abstract class PruefungsplanerAbstrakt implements PruefungsPlanung.PruefungsPlaner {
/**
 * 
 * 
 * @poseidon-object-id [Im3057c7d4m124e9a3360amm7414]
 */
    public PruefungsPlanung.Planungsbedingungen planungsbedingungen;
 }
