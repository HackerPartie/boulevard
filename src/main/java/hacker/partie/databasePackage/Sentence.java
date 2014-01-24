package hacker.partie.databasePackage;

/**
 * Die Klasse "Sentence" ist f�r die Erfassung und R�ckgabe des Inhalts der
 * einzelnen Datens�tze zust�ndig
 * 
 * @author Bergsocke
 * 
 */

public class Sentence {
	private int sentenceID;
	private String sentenceObject;
	private String sentenceVerb;
	private String sentenceComplement;

	/**
	 * Konstruktor f�r einen random Sentence
	 * 
	 */
	public Sentence() {

	}

	/**
	 * Konstruktor f�r den Zugriff auf alle Tabellenfelder
	 * 
	 * @param sentenceID
	 * @param sentenceObject
	 * @param sentenceVerb
	 * @param sentenceComplement
	 */
	public Sentence(int sentenceID, String sentenceObject, String sentenceVerb,
			String sentenceComplement) {

		this.sentenceID = sentenceID;
		this.sentenceObject = sentenceObject;
		this.sentenceVerb = sentenceVerb;
		this.sentenceComplement = sentenceComplement;
	}

	/**
	 * Konstruktor bei Neuanlage eines Datensatzes
	 * 
	 * @param sentenceObject
	 * @param sentenceVerb
	 * @param sentenceComplement
	 */
	public Sentence(String sentenceObject, String sentenceVerb,
			String sentenceComplement) {

		this.sentenceObject = sentenceObject;
		this.sentenceVerb = sentenceVerb;
		this.sentenceComplement = sentenceComplement;
	}

	/**
	 * Definition der Getter und Setter
	 */
	public int getSentenceID() {
		return sentenceID;
	}

	public void setSentenceID(int sentenceID) {
		this.sentenceID = sentenceID;
	}

	public String getSentenceObject() {
		return sentenceObject;
	}

	public void setSentenceObject(String sentenceObject) {
		this.sentenceObject = sentenceObject;
	}

	public String getSentenceVerb() {
		return sentenceVerb;
	}

	public void setSentenceVerb(String sentenceVerb) {
		this.sentenceVerb = sentenceVerb;
	}

	public String getSentenceComplement() {
		return sentenceComplement;
	}

	public void setSentenceComplement(String sentenceComplement) {
		this.sentenceComplement = sentenceComplement;
	}

}
