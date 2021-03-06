package hacker.partie.model;

/**
 * Die Klasse "Sentence" ist für die Erfassung und Rückgabe des Inhalts der
 * einzelnen Datensätze zuständig
 * 
 * Diese klasse enthält Sätze die drei teile enthaltens
 * zbs: Grossbrand / zerstoert / UNESCO-Weltkulturerbe 
 * zbs: Mutter / schmuggelt / Drogen im Kinderwagen 
 * 
 * 
 * @author Bergsocke
 * 
 */

public class ThreePartSentence {
	private int id;
	private String subject;
	private String verb;
	private String complement;

	/**
	 * Konstruktor für einen Random Sentence
	 * 
	 */
	public ThreePartSentence() {

	}

	/**
	 * Konstruktor für den Zugriff auf alle Tabellenfelder
	 * 
	 * @param id
	 * @param subject
	 * @param verb
	 * @param complement
	 */
	public ThreePartSentence(int id, String subject, String verb, String complement) {

		this.id = id;
		this.subject = subject;
		this.verb = verb;
		this.complement = complement;
	}

	/**
	 * Konstruktor bei Neuanlage eines Datensatzes
	 * 
	 * @param subject
	 * @param verb
	 * @param complement
	 */
	public ThreePartSentence(String subject, String verb, String complement) {

		this.subject = subject;
		this.verb = verb;
		this.complement = complement;
	}

	/**
	 * Definition der Getter und Setter
	 */
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String Subject) {
		this.subject = Subject;
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
