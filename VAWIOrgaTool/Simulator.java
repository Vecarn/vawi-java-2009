import EingabeDatenVerwaltung.DatenVerwaltung.*;

/**
 * Der Simulatorist eine Logikklasse, die fiktive Kursbelegungen f&uuml;r jeden Studenten anleget. Sie verwendet deshalb die Stundentenliste und Kursliste als Eingabe, um daraus zufallsgenerierte Buchungen zu erstellen und diese einer Buchungsliste zuzuweisen.
 * 
 * 
 * @author Markus Bode
 * @version 1.0 vom 8.12.2009
 */
public class Simulator {

	private Kursliste kursliste;
	private Buchungsliste generierteBuchungsliste;
	private Studentenliste  generierteStudentenliste;
	
	/**
	 * @param kursliste (Kursliste) - eine Kursliste mit den eingelesenen Kursen
	 */
	public Simulator(Kursliste kursliste){
		
		this.kursliste=kursliste;
		generiereDaten();
		
	}
	
	private void generiereDaten(){
		kursliste.getKursIterator();
		// kleine snippets
		//      String [] vornamen = new String[]{"Elias","Julian","Marcel","Thomas","Luca","Stefan","Michael","Felix",
		//		"Luca","Stefan","Michael","Felix","Jessica","Katharina","Frauke",
		//		"Petra","Manuela","Sophie","Marta","Lisa"};
		//String [] nachnamen = new String[]{"Mueller","Schmidt","Klein","Muster","Mayer","Bode","Hauser","Munkelt","Woelfle",
		//		"Schoenherr","Nett","Gosler","Sell","Rausch","Freitag","Buchmann","Junge",
		//		"Merkel","Schroeder","Schaeuble"};
		//char[] uni = new char[]{'B','D','U'};
		//
		//String name = new String();
		//for(int i = 0; i<100000;i++){
		//int rand = (int)(Math.random()*20000);
		//boolean zeitmini;
		////System.out.println(rand);
		//if((rand/10000)==1){
		//zeitmini=true;
		//}else{
		//zeitmini=false;
		//}
		//
		//sl.addStudent(rand,nachnamen[rand/1000], vornamen[(int)(Math.random()*20)],'B', "TESTLAND",zeitmini);
		//Student s1=sl.getStudent(rand);
		//Kurs k1=kl.getKurs(rand/1000);
		////System.out.println(k1.getKursid());
		//bl.addBuchung(s1, k1,(short) 0);
		//
		//}
	}
	
	/**
	 * @return Buchungsliste
	 */
	public Buchungsliste getBuchungsliste(){
		return generierteBuchungsliste;
	}
	
	/**
	 * @return Studentenliste
	 */
	public Studentenliste getStudentenliste(){
		return generierteStudentenliste;
	}
	

}
