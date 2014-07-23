package hacker.partie.services;



/**
 * Die Klasse "NnpSentenceDao" stellt eine Verbindung bietet die Methoden zum Anzeigen und Speichern von Datensätzen aus der
 * Tabelle "sentences_nnp". Weiters bietet sie die Möglichkeit zur Erstellung eines zufällig zusammengestellten Sentence.
 * 
 * @author EmmanuelKasper
 * 
 */
public class NnpSentenceDao extends SentenceDao {

    public NnpSentenceDao() {
        super("sentences_nnp");
    }
}
