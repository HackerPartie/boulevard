package hacker.partie.services;


/**
 * Die Klasse "SvcSentenceDao" stellte eine Verbindung bietet die Methoden zum
 * Anzeigen und Speichern von Datensätzen aus der Tabelle "sentences_svc".
 * Weiters bietet sie die Möglichkeit zur Erstellung eines zufällig
 * zusammengestellten Sentence.
 * 
 * @author Bergsocke
 * 
 */
public class SvcSentenceDao extends SentenceDao {
    
    // sentences_svc

    public SvcSentenceDao() {
        super("sentences_svc");
    }
}
