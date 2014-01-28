package hacker.partie.testPackage;

import hacker.partie.databasePackage.DatabaseConnection;
import hacker.partie.databasePackage.Sentence;
import hacker.partie.databasePackage.SentenceDB;

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
		Sentence sentenceTest1 = new Sentence("Piraten", "erobern",
				"Luxus-Schiff");
		Sentence sentenceTest2 = new Sentence("Fans", "stürmen", "Station");

		// Sentences speichern
		SentenceDB.saveSentence(sentenceTest1);
		SentenceDB.saveSentence(sentenceTest2);

		displayAllTest();

		// Sentence löschen
		SentenceDB.deleteSentence(2);

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
					.prepareStatement("SELECT * FROM sentence_database.sentences;");
			myResultSet = myPreparedStatement.executeQuery();

			while (myResultSet.next()) {
				int id = myResultSet.getInt(1);
				String objekt = myResultSet.getString(2);
				String verb = myResultSet.getString(3);
				String complement = myResultSet.getString(4);
				System.out.println(id + ": " + objekt + " " + verb + " "
						+ complement);
			}

			// Random Sentence erstellen
			Sentence mySentence = SentenceDB.createRandomSentence();
			System.out.println("\nZufallssatz:");
			System.out.println(mySentence.getSentenceObject() + " "
					+ mySentence.getSentenceVerb() + " "
					+ mySentence.getSentenceComplement());

		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

}
