package hacker.partie.databasePackage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

/**
 * Die Klasse "SentenceDB" stellte eine Verbindung bietet die Methoden zum
 * Anzeigen und Speichern von Datensätzen aus der Tabelle "sentences". Weiters
 * bietet sie die Möglichkeit zur Erstellung von zufällig zusammengesetzte
 * Senctences.
 * 
 * @author Bergsocke
 * 
 */
public class SentenceDB {

	private static Connection connect = null;
	private static PreparedStatement myPreparedStatement = null;
	private static ResultSet myResultSet = null;
	// Variable, die anzeigen soll, ob das Speichern, Updaten oder Löschen eines
	// Datensatzes erfolgreich war
	public static int successful = 0;

	/**
	 * Es werden alle Datensätze, die in der Tabelle "sentences" vorhanden sind,
	 * angezeigt
	 * 
	 * @return sentenceList
	 */
	public static List<Sentence> findAllSenctences() {

		connect = DatabaseConnection.connectDB();

		List<Sentence> sentenceList = new ArrayList<Sentence>();

		try {
			// PreparedStatement für den SQL-Befehl
			myPreparedStatement = connect
					.prepareStatement("SELECT * FROM sentence_database.sentences;");

			// SQL-Befehl wird ausgeführt
			myResultSet = myPreparedStatement.executeQuery();

			while (myResultSet.next()) {
				sentenceList.add(new Sentence(myResultSet.getInt(1),
						myResultSet.getString(2), myResultSet.getString(3),
						myResultSet.getString(4)));
			}

		} catch (Exception e) {
			System.out.println(e.toString());
			JOptionPane.showMessageDialog(null,
					"Datenbankabfrage konnte nicht durchgeführt werden.",
					"Fehler", JOptionPane.ERROR_MESSAGE);

		} finally {
			// offene Verbindungen werden geschlossen
			SentenceDB.closeConnections();
		}

		return sentenceList;
	}
	

	/**
	 * Methode zum Speichern eines neuen Datensatzes in die Tabelle "sentences"
	 * 
	 * @param sentenceToSave
	 * @return successful
	 */
	public static int saveBook(Sentence sentenceToSave) {

		try {
			connect = DatabaseConnection.connectDB();

			// PreparedStatement für SQL-Befehl
			myPreparedStatement = connect
					.prepareStatement("INSERT INTO sentence_database.sentences VALUES(default,?, ?, ?)");

			myPreparedStatement.setString(1, sentenceToSave.getSentenceObject());
			myPreparedStatement.setString(2, sentenceToSave.getSentenceVerb());
			myPreparedStatement.setString(3, sentenceToSave.getSentenceComplement());

			// SQL-Befehl wird ausgeführt
			successful = myPreparedStatement.executeUpdate();

			// offene Verbindungen werden geschlossen
			closeConnections();

			return successful;

		} catch (Exception e) {
			System.out.println(e.toString());
			JOptionPane.showMessageDialog(null,
					"Datenbank-Fehler beim Abspeichern eines Datensatzes",
					"Fehler", JOptionPane.ERROR_MESSAGE);
			successful = 0;
			closeConnections();
			return successful;

		} finally {
			closeConnections();
		}
	}
	/**
	 * Methode zum Erstellen eines zufällig zusammengesetzten Sentence aus
	 * der Tabelle "sentences"
	 * 
	 * @return randomSentence
	 */
	public static Sentence createRandomSentence() {

		connect = DatabaseConnection.connectDB();

		int randomObjektID = 0;
		int randomVerbID = 0;
		int randomComplementID = 0;

		Sentence randomSentence = new Sentence();

		try {
			// PreparedStatement für den SQL-Befehl
//			myPreparedStatement = connect
//					.prepareStatement("SELECT * FROM sentence_database.sentences;");

			// SQL-Befehl wird ausgeführt
			myResultSet = myPreparedStatement.executeQuery();

			// es wird jeweils nur ein Datensatz ausgelesen!!
			//........................

		} catch (Exception e) {
			System.out.println(e.toString());
			JOptionPane.showMessageDialog(null,
					"Datenbankabfrage konnte nicht durchgeführt werden.",
					"Fehler", JOptionPane.ERROR_MESSAGE);

		} finally {
			// offene Verbindungen werden geschlossen
			SentenceDB.closeConnections();
		}

		return randomSentence;
	}

	/**
	 * Methode zum Schließen aller offenen Verbindungen
	 */
	public static void closeConnections() {
		try {

			if (myResultSet != null) {
				myResultSet.close();
			}

			if (myPreparedStatement != null) {
				myPreparedStatement.close();
			}

			if (connect != null) {
				connect.close();
			}

		} catch (Exception e) {
			System.out.println(e.toString());
			JOptionPane.showMessageDialog(null,
					"Verbindungen konnten nicht geschlossen werden.", "Fehler",
					JOptionPane.ERROR_MESSAGE);
		}
	}

}
