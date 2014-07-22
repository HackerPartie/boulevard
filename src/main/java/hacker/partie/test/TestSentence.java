package hacker.partie.test;

import hacker.partie.model.ThreePartSentence;
import hacker.partie.services.DatabaseConnection;
import hacker.partie.services.SvcSentenceDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Klasse mit Main-Methode zum Testen (Consolenausgabe)
 * 
 */

public class TestSentence {

	private static Connection connect = null;
	private static PreparedStatement myPreparedStatement = null;
	private static ResultSet myResultSet = null;

	/**
	 * Main-Methode
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// Alle Datensätze und einen Random Sentence anzeigen
		displayAllTest();

		// Test-Sentences
		ThreePartSentence sentenceTest1 = new ThreePartSentence("Piraten", "erobern",
				"Luxus-Schiff");
		ThreePartSentence sentenceTest2 = new ThreePartSentence("Fans", "stürmen", "Station");

		// Sentences speichern
		SvcSentenceDao.save(sentenceTest1);
		SvcSentenceDao.save(sentenceTest2);

		displayAllTest();

		// Sentence löschen
		SvcSentenceDao.save(sentenceTest1);
		SvcSentenceDao.delete(2);

		displayAllTest();

	}

	/**
	 * Es werden alle vorhandenen Datensätze der Tabelle "sentences" angezeigt
	 * und ein Random-Sentence gebildet (Consolenausgabe)
	 */
	public static void displayAllTest() {
		try {
			connect = DatabaseConnection.connectDB();

			// Alle Datensätze anzeigen
			myPreparedStatement = connect
					.prepareStatement("SELECT * FROM sentences_svc;");
			myResultSet = myPreparedStatement.executeQuery();

			while (myResultSet.next()) {
				int id = myResultSet.getInt(1);
				String subject = myResultSet.getString(2);
				String verb = myResultSet.getString(3);
				String complement = myResultSet.getString(4);
				System.out.println(id + ": " + subject + " " + verb + " "
						+ complement);
			}

			// Random Sentence erstellen
			ThreePartSentence mySentence = SvcSentenceDao.createRandom();
			System.out.println("\nZufallssatz:");
			System.out.println(mySentence.getSubject() + " "
					+ mySentence.getVerb() + " "
					+ mySentence.getComplement());

		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

}
