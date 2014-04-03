package hacker.partie.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Die Klasse "SentenceDB" stellte eine Verbindung bietet die Methoden zum
 * Anzeigen und Speichern von Datensätzen aus der Tabelle "sentences". Weiters
 * bietet sie die Möglichkeit zur Erstellung eines zufällig zusammengestellten
 * Sentence.
 * 
 * @author Bergsocke
 * 
 */
public class SentenceDB {

	private static Connection connect = null;
	private static PreparedStatement myPreparedStatement = null;
	private static ResultSet myResultSet = null;
	// Variablen, die anzeigen sollen, ob das Speichern, Updaten oder Löschen
	// eines Datensatzes erfolgreich war
	public static int execute = 0;
	public static boolean successful = false;

	/**
	 * Es werden alle Datensätze, die in der Tabelle "sentences" vorhanden sind,
	 * angezeigt
	 * 
	 * @return sentenceList
	 */
	public static List<Sentence> findAll() {

		connect = DatabaseConnection.connectDB();

		List<Sentence> sentenceList = new ArrayList<Sentence>();

		try {
			// PreparedStatement für den SQL-Befehl
			myPreparedStatement = connect
					.prepareStatement("SELECT * FROM sentences;");

			// SQL-Befehl wird ausgeführt
			myResultSet = myPreparedStatement.executeQuery();

			while (myResultSet.next()) {
				sentenceList.add(new Sentence(myResultSet.getInt(1),
						myResultSet.getString(2), myResultSet.getString(3),
						myResultSet.getString(4)));
			}

		} catch (Exception e) {
			System.out.println(e.toString());

		} finally {
			// offene Verbindungen werden geschlossen
			SentenceDB.closeConnections();
		}

		return sentenceList;
	}

	/**
	 * Methode zum Speichern eines neuen Datensatzes in die Tabelle "sentences"
	 * 
	 * @param toSave
	 * @return successful
	 */
	public static boolean save(Sentence toSave) {

		try {
			connect = DatabaseConnection.connectDB();

			// PreparedStatement für SQL-Befehl
			myPreparedStatement = connect
					.prepareStatement("INSERT INTO sentences VALUES(default,?, ?, ?)");

			myPreparedStatement.setString(1, toSave.getObject());
			myPreparedStatement.setString(2, toSave.getVerb());
			myPreparedStatement.setString(3, toSave.getComplement());

			// SQL-Befehl wird ausgeführt
			execute = myPreparedStatement.executeUpdate();

			successful = (execute != 0);
			return successful;

		} catch (Exception e) {
			System.out.println(e.toString());

			return successful = false;

		} finally {
			// closeConnections();
		}
	}

	/**
	 * Methode zum Erstellen eines zufällig zusammengesetzten Sentence aus den
	 * Tabellenfeldern der Tabelle "sentences"
	 * 
	 * @return randomSentence
	 */
	public static Sentence createRandom() {

		connect = DatabaseConnection.connectDB();
		int numRows = 0;
		String randomObjekt = null;
		String randomVerb = null;
		String randomComplement = null;
		Sentence random = new Sentence();

		try {
			// Anzahl der vorhandenen Datensätze ermitteln
			myPreparedStatement = connect
					.prepareStatement("SELECT COUNT(*) AS count FROM sentences");
			myResultSet = myPreparedStatement.executeQuery();
			while (myResultSet.next()) {
				numRows = myResultSet.getInt("count");
			}

			// Random-Zahl von 1 bis Anzahl der Datensätze
			int randomObjektID = 1 + (int) (Math.random() * numRows);
			int randomVerbID = 1 + (int) (Math.random() * numRows);
			int randomComplementID = 1 + (int) (Math.random() * numRows);

			// Ein Random-Objekt aus der Tabelle holen
			myResultSet = findByID(randomObjektID);
			if (myResultSet.next()) {
				randomObjekt = myResultSet.getString(2);
				// Wird ein Datensatz aus der Tabelle gelöscht, entsteht in der
				// ID-Numerierung eine Lücke und liefert "null" zurück
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
			random = new Sentence(randomObjekt, randomVerb,
					randomComplement);

		} catch (Exception e) {
			System.out.println(e.toString());

		} finally {
			// offene Verbindungen werden geschlossen
			// SentenceDB.closeConnections();
		}

		return random;
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
					.prepareStatement("SELECT * FROM sentences WHERE id = "
							+ randomNumber + ";");

			myResultSet = myPreparedStatement.executeQuery();

		} catch (Exception e) {
			System.out.println(e.toString());
		}

		return myResultSet;
	}

	/**
	 * Methode zum Löschen eines Datensatzes aus der Tabelle "sentences"
	 * 
	 * @param id
	 * @return successful
	 */
	public static boolean delete(int id) {

		try {

			myPreparedStatement = connect
					.prepareStatement("DELETE FROM sentences WHERE id = "
							+ id + ";");

			execute = myPreparedStatement.executeUpdate();

			successful = (execute != 0);
			return successful;

		} catch (Exception e) {
			System.out.println(e.toString());

			return successful = false;

		} finally {
			closeConnections();
		}
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
		}
	}
}
