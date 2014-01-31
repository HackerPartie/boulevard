package hacker.partie.database;

/**
 * Die Klasse "Sentence" ist für die Erfassung und Rückgabe des Inhalts der
 * einzelnen Datensätze zuständig
 * 
 * @author Bergsocke
 * 
 */

public class Sentence {
	private int id;
	private String object;
	private String verb;
	private String complement;

	/**
	 * Konstruktor für einen Random Sentence
	 * 
	 */
	public Sentence() {

	}

	/**
	 * Konstruktor für den Zugriff auf alle Tabellenfelder
	 * 
	 * @param id
	 * @param object
	 * @param verb
	 * @param complement
	 */
	public Sentence(int id, String object, String verb, String complement) {

		this.id = id;
		this.object = object;
		this.verb = verb;
		this.complement = complement;
	}

	/**
	 * Konstruktor bei Neuanlage eines Datensatzes
	 * 
	 * @param object
	 * @param verb
	 * @param complement
	 */
	public Sentence(String object, String verb, String complement) {

		this.object = object;
		this.verb = verb;
		this.complement = complement;
	}

	/**
	 * Definition der Getter und Setter
	 */
	public int getID() {
		return id;
	}

	public void setID(int id) {
		this.id = id;
	}

	public String getObject() {
		return object;
	}

	public void setObject(String object) {
		this.object = object;
	}

	public String getVerb() {
		return verb;
	}

	public void setVerb(String verb) {
		this.verb = verb;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

}
