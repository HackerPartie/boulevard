package databasePackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class SentenceDB {
	
	private static Connection connect = null;
	private static PreparedStatement myPreparedStatement = null;
	private static ResultSet myResultSet = null;
	// Variable, die anzeigen soll, ob das Speichern, Updaten oder L�schen eines
	// Datensatzes erfolgreich war
	public static int successful = 0;

	/**
	 * Diese Methode baut die Datenbankverbindung zur Datenbank
	 * "sentence_database" auf
	 */
	public static void connectDB() {

		try {
			// Treiber wird geladen und die Regestrierung beim DriverManager
			// erfolgt
			Class.forName("com.mysql.jdbc.Driver");

			// DriverManager wird verwenden und die Verbindung zur DB wird
			// aufgebaut
			connect = DriverManager.getConnection(
					"jdbc:mysql://localhost/sentence_database",
					"sentence_user", "sentence_password");

		} catch (Exception e) {
			System.out.println(e.toString());
			JOptionPane.showMessageDialog(null,
					"Datenbankverbindung konnte nicht hergestellt werden. "
							+ "Bitte pr�fen Sie, ob der MySQL-Server l�uft.",
					"Fehler", JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Es werden alle Datens�tze, die in der Tabelle "sentences" vorhanden sind,
	 * angezeigt
	 * 
	 * @return bookList
	 */
	public static List<Sentence> findAllSenctences() {

		List<Sentence> sentenceList = new ArrayList<Sentence>();

		try {
			// Datenbankverbindung herstellen
			connectDB();

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
			closeConnections();
		}

		return sentenceList;
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
