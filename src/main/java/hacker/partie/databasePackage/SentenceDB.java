package hacker.partie.databasePackage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

/**
 * Die Klasse "SentenceDB" stellte eine Verbindung bietet die Methoden zum
 * Anzeigen und Speichern von Datens�tzen aus der Tabelle "sentences". Weiters
 * bietet sie die M�glichkeit zur Erstellung eines zuf�llig zusammengestelten
 * Sentence.
 * 
 * @author Bergsocke
 * 
 */
public class SentenceDB {

	private static Connection connect = null;
	private static PreparedStatement myPreparedStatement = null;
	private static ResultSet myResultSet = null;
	// Variable, die anzeigen soll, ob das Speichern, Updaten oder L�schen eines
	// Datensatzes erfolgreich war
	public static int successful = 0;

	/**
	 * Es werden alle Datens�tze, die in der Tabelle "sentences" vorhanden sind,
	 * angezeigt
	 * 
	 * @return sentenceList
	 */
	public static List<Sentence> findAllSenctences() {

		connect = DatabaseConnection.connectDB();

		List<Sentence> sentenceList = new ArrayList<Sentence>();

		try {
			// PreparedStatement f�r den SQL-Befehl
			myPreparedStatement = connect
					.prepareStatement("SELECT * FROM sentence_database.sentences;");

			// SQL-Befehl wird ausgef�hrt
			myResultSet = myPreparedStatement.executeQuery();

			while (myResultSet.next()) {
				sentenceList.add(new Sentence(myResultSet.getInt(1),
						myResultSet.getString(2), myResultSet.getString(3),
						myResultSet.getString(4)));
			}

		} catch (Exception e) {
			System.out.println(e.toString());
			JOptionPane.showMessageDialog(null,
					"Datenbankabfrage konnte nicht durchgef�hrt werden.",
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
	public static int saveSentence(Sentence sentenceToSave) {

		try {
			connect = DatabaseConnection.connectDB();

			// PreparedStatement f�r SQL-Befehl
			myPreparedStatement = connect
					.prepareStatement("INSERT INTO sentence_database.sentences VALUES(default,?, ?, ?)");

			myPreparedStatement
					.setString(1, sentenceToSave.getSentenceObject());
			myPreparedStatement.setString(2, sentenceToSave.getSentenceVerb());
			myPreparedStatement.setString(3,
					sentenceToSave.getSentenceComplement());

			// SQL-Befehl wird ausgef�hrt
			successful = myPreparedStatement.executeUpdate();

			return successful;

		} catch (Exception e) {
			System.out.println(e.toString());
			JOptionPane.showMessageDialog(null,
					"Datenbank-Fehler beim Abspeichern eines Datensatzes",
					"Fehler", JOptionPane.ERROR_MESSAGE);
			successful = 0;

			return successful;

		} finally {
//			closeConnections();
		}
	}

	/**
	 * Methode zum Erstellen eines zuf�llig zusammengesetzten Sentence aus den
	 * Tabellenfeldern der Tabelle "sentences"
	 * 
	 * @return randomSentence
	 */
	public static Sentence createRandomSentence() {

		connect = DatabaseConnection.connectDB();
		int numRows = 0;
		String randomObjekt = null;
		String randomVerb = null;
		String randomComplement = null;
		Sentence randomSentence = new Sentence();

		try {
			// Anzahl der vorhandenen Datens�tze ermitteln
			myPreparedStatement = connect
					.prepareStatement("SELECT COUNT(*) AS count FROM sentence_database.sentences");
			myResultSet = myPreparedStatement.executeQuery();
			while (myResultSet.next()) {
				numRows = myResultSet.getInt("count");
			}

			// Random-Zahl von 1 bis Anzahl der Datens�tze
			int randomObjektID = 1 + (int) (Math.random() * numRows);
			int randomVerbID = 1 + (int) (Math.random() * numRows);
			int randomComplementID = 1 + (int) (Math.random() * numRows);

			// Ein Random-Objekt aus der Tabelle holen
			myResultSet = findByID(randomObjektID);
			if (myResultSet.next()) {
				randomObjekt = myResultSet.getString(2);
				// Wird ein Datensatz aus der Tabelle gel�scht, entsteht in der
				// ID-Numerierung eine L�cke und liefert "null" zur�ck 
				if (randomObjekt == null) {
					randomObjekt = "Maus";		
				}
			}

			// Ein Random-Verb aus der Tabelle holen
			myResultSet = findByID(randomVerbID);
			if (myResultSet.next()) {
				randomVerb = myResultSet.getString(3);
				if (randomVerb == null) {
					randomVerb = "verletzt";		
				}
			}

			// Ein Random-Complement aus der Tabelle holen
			myResultSet = findByID(randomComplementID);
			if (myResultSet.next()) {
				randomComplement = myResultSet.getString(4);
				if (randomComplement == null) {
					randomComplement = "Katze";		
				}
			}

			// Random Sentence zusammenstellen
			randomSentence = new Sentence(randomObjekt, randomVerb,
					randomComplement);

		} catch (Exception e) {
			System.out.println(e.toString());
			JOptionPane.showMessageDialog(null,
					"Datenbankabfrage konnte nicht durchgef�hrt werden.",
					"Fehler", JOptionPane.ERROR_MESSAGE);

		} finally {
			// offene Verbindungen werden geschlossen
//			SentenceDB.closeConnections();
		}

		return randomSentence;
	}

	/**
	 * Ermittelt einen Datensatz aus der Tabelle "sentences" anhand einer
	 * Zufallszahl
	 * 
	 * @param randomNumber
	 * @return myResultSet
	 */
	public static ResultSet findByID(int randomNumber) {
		try {
			myPreparedStatement = connect
					.prepareStatement("SELECT * FROM sentence_database.sentences WHERE id = "
							+ randomNumber + ";");

			myResultSet = myPreparedStatement.executeQuery();

		} catch (Exception e) {
			System.out.println(e.toString());
			JOptionPane.showMessageDialog(null,
					"Datenbankabfrage konnte nicht durchgef�hrt werden.",
					"Fehler", JOptionPane.ERROR_MESSAGE);
		}

		return myResultSet;
	}

	/**
	 * Methode zum L�schen eines Datensatzes aus der Tabelle "sentences"
	 * 
	 * @param sentenceID
	 * @return successful
	 */
	public static int deleteSentence(int sentenceID) {

		try {

			myPreparedStatement = connect
					.prepareStatement("DELETE FROM sentence_database.sentences WHERE id = "
							+ sentenceID + ";");

			successful = myPreparedStatement.executeUpdate();

			return successful;

		} catch (Exception e) {
			System.out.println(e.toString());
			JOptionPane.showMessageDialog(null,
					"Datenbank-Fehler beim L�schen eines Datensatzes",
					"Fehler", JOptionPane.ERROR_MESSAGE);
			successful = 0;
			return successful;

		} finally {
			closeConnections();
		}
	}

	/**
	 * Methode zum Schlie�en aller offenen Verbindungen
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
