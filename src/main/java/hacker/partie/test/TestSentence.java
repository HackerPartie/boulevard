package hacker.partie.test;

import hacker.partie.model.SvcSentence;
import hacker.partie.services.DatabaseConnection;
import hacker.partie.services.SvcSentenceDaoImpl;

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
		SvcSentence sentenceTest1 = new SvcSentence("Piraten", "erobern",
				"Luxus-Schiff");
		SvcSentence sentenceTest2 = new SvcSentence("Fans", "stürmen", "Station");

		// Sentences speichern
		SvcSentenceDaoImpl.save(sentenceTest1);
		SvcSentenceDaoImpl.save(sentenceTest2);

		displayAllTest();

		// Sentence löschen
		SvcSentenceDaoImpl.save(sentenceTest1);
		SvcSentenceDaoImpl.delete(2);

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
			SvcSentence mySentence = SvcSentenceDaoImpl.createRandom();
			System.out.println("\nZufallssatz:");
			System.out.println(mySentence.getSubject() + " "
					+ mySentence.getVerb() + " "
					+ mySentence.getComplement());

		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

}
