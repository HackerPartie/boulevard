package hacker.partie.services;

import hacker.partie.model.ThreePartSentence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Die Klasse "SvcSentenceDao" stellte eine Verbindung bietet die Methoden zum
 * Anzeigen und Speichern von Datensätzen aus der Tabelle "sentences_svc".
 * Weiters bietet sie die Möglichkeit zur Erstellung eines zufällig
 * zusammengestellten Sentence.
 * 
 * @author Bergsocke
 * 
 */
public class SvcSentenceDao {

	// Variablen, die anzeigen sollen, ob das Speichern, Updaten oder Löschen
	// eines Datensatzes erfolgreich war

	/**
	 * Es werden alle Datensätze, die in der Tabelle "sentences_svc" vorhanden
	 * sind, angezeigt
	 * 
	 * @return sentenceList
	 */
	public static List<ThreePartSentence> findAll() {

		Connection connect = null;
		PreparedStatement myPreparedStatement = null;
		ResultSet myResultSet = null;

		List<ThreePartSentence> sentenceList = new ArrayList<ThreePartSentence>();

		try {
			// PreparedStatement für den SQL-Befehl
			connect = DatabaseConnection.connectDB();
			myPreparedStatement = connect
					.prepareStatement("SELECT * FROM sentences_svc;");

			// SQL-Befehl wird ausgeführt
			myResultSet = myPreparedStatement.executeQuery();

			while (myResultSet.next()) {
				sentenceList.add(new ThreePartSentence(myResultSet.getInt(1),
						myResultSet.getString(2), myResultSet.getString(3),
						myResultSet.getString(4)));
			}

		} catch (SQLException ex) {
			System.out.println(ex.toString());

		} finally {
			closeConnections(myResultSet, myPreparedStatement, connect);
		}

		return sentenceList;
	}

	/**
	 * Methode zum Speichern eines neuen Datensatzes in die Tabelle
	 * "sentences_svc"
	 * 
	 * @param toSave
	 * @return successful
	 */
	public static boolean save(ThreePartSentence toSave) {
		Connection connect = null;
		PreparedStatement myPreparedStatement = null;
		ResultSet myResultSet = null;

		try {
			connect = DatabaseConnection.connectDB();

			// PreparedStatement für SQL-Befehl
			myPreparedStatement = connect
					.prepareStatement("INSERT INTO sentences_svc VALUES(default,?, ?, ?)");

			myPreparedStatement.setString(1, toSave.getSubject());
			myPreparedStatement.setString(2, toSave.getVerb());
			myPreparedStatement.setString(3, toSave.getComplement());

			// SQL-Befehl wird ausgeführt
			int execute = myPreparedStatement.executeUpdate();
			return (execute != 0);

		} catch (SQLException ex) {
			System.out.println(ex.toString());
			return  false;

		} finally {
			closeConnections(myResultSet, myPreparedStatement, connect);
		}
	}

	/**
	 * Methode zum Erstellen eines zufällig zusammengesetzten Sentence aus den
	 * Tabellenfeldern der Tabelle "sentences_svc" original von jens
	 * 
	 * @return randomSentence
	 */

	public static ThreePartSentence createRandom() {

		String subject = get_subject();
		String verb = get_verb();
		String complement = get_complement();
		ThreePartSentence sent = new ThreePartSentence(subject, verb, complement);
		return sent;
	}

	private static String get_subject() {
		String randomSubject = null;
		Connection connect = null;
		PreparedStatement myPreparedStatement = null;
		ResultSet myResultSet = null;

		try {
			connect = DatabaseConnection.connectDB();
			myPreparedStatement = connect
					.prepareStatement("select sentences_svc.object from sentences_svc order by random() limit 1");
			myResultSet = myPreparedStatement.executeQuery();
			while (myResultSet.next()) {
				randomSubject = myResultSet.getString("object");
			}
		} catch (SQLException e) {
			randomSubject = "Titelblatt generator";
			e.printStackTrace();
			System.err.println("boulevard_db error");
		} finally {
			closeConnections(myResultSet, myPreparedStatement, connect);
		}
		return randomSubject;
	}

	private static String get_verb() {
		String randomVerb = null;
		
		Connection connect = null;
		PreparedStatement myPreparedStatement = null;
		ResultSet myResultSet = null;

		try {
			connect = DatabaseConnection.connectDB();
			myPreparedStatement = connect
					.prepareStatement("select sentences_svc.verb from sentences_svc order by random() limit 1");
			myResultSet = myPreparedStatement.executeQuery();
			while (myResultSet.next()) {
				randomVerb = myResultSet.getString("verb");
			}
		} catch (SQLException e) {
			randomVerb = "hat gerade";
			e.printStackTrace();
			System.err.println("boulevard_db error");
		} finally {
			closeConnections(myResultSet, myPreparedStatement, connect);
		}

		return randomVerb;
	}

	private static String get_complement() {
		String randomComplement = null;
		Connection connect  = null;
		PreparedStatement myPreparedStatement = null;
		ResultSet myResultSet = null;

		try {
			connect = DatabaseConnection.connectDB();
			myPreparedStatement = connect
					.prepareStatement("select sentences_svc.complement from sentences_svc order by random() limit 1");
			myResultSet = myPreparedStatement.executeQuery();

			while (myResultSet.next()) {
				randomComplement = myResultSet.getString("complement");
			}
		} catch (SQLException e) {
			randomComplement = "Problemen mit seiner Datenbank";
			System.err.println("boulevard_db error");
			e.printStackTrace();
		} finally {
			closeConnections(myResultSet, myPreparedStatement, connect);
		}

		return randomComplement;
	}


	/**
	 * Methode zum Löschen eines Datensatzes aus der Tabelle "sentences_svc"
	 * 
	 * @param id
	 * @return successful
	 */
	public static boolean delete(int id) {
		
		Connection connect = null;
		PreparedStatement myPreparedStatement = null;
		ResultSet myResultSet = null;

		try {
			connect = DatabaseConnection.connectDB();
			myPreparedStatement = connect
					.prepareStatement("DELETE FROM sentences_svc WHERE id = "
							+ id + ";");

			int execute = myPreparedStatement.executeUpdate();
			return (execute != 0);

		} catch (Exception e) {
			System.out.println(e.toString());

			return  false;

		} finally {
			closeConnections(myResultSet, myPreparedStatement, connect);
		}
	}
	
    public static int count() {
        Connection connect = null;
        PreparedStatement myPreparedStatement = null;
        ResultSet myResultSet = null;
        

        try {
            connect = DatabaseConnection.connectDB();
            myPreparedStatement = connect
                .prepareStatement("SELECT COUNT(*) FROM sentences_svc;");
            myResultSet = myPreparedStatement.executeQuery();
            myResultSet.next();
            return myResultSet.getInt("count");

        } catch (Exception e) {
            System.out.println(e.toString());

            return -1;

        } finally {
            closeConnections(myResultSet, myPreparedStatement, connect);
        }

    }

	/**
	 * Methode zum Schließen aller offenen Verbindungen
	 */
	private static void closeConnections(ResultSet myResultSet, PreparedStatement myPreparedStatement, Connection connect) {
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
