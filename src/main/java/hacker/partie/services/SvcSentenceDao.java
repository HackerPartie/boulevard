package hacker.partie.services;

import hacker.partie.model.SvcSentence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Die Klasse "SentenceDB" stellte eine Verbindung bietet die Methoden zum
 * Anzeigen und Speichern von Datensätzen aus der Tabelle "sentences_svc".
 * Weiters bietet sie die Möglichkeit zur Erstellung eines zufällig
 * zusammengestellten Sentence.
 * 
 * @author Bergsocke
 * 
 */
public class SvcSentenceDao {

	private static Connection connect = null;
	private static PreparedStatement myPreparedStatement = null;
	private static ResultSet myResultSet = null;
	// Variablen, die anzeigen sollen, ob das Speichern, Updaten oder Löschen
	// eines Datensatzes erfolgreich war
	public static int execute = 0;
	public static boolean successful = false;

	/**
	 * Es werden alle Datensätze, die in der Tabelle "sentences_svc" vorhanden
	 * sind, angezeigt
	 * 
	 * @return sentenceList
	 */
	public static List<SvcSentence> findAll() {

		connect = DatabaseConnection.connectDB();

		List<SvcSentence> sentenceList = new ArrayList<SvcSentence>();

		try {
			// PreparedStatement für den SQL-Befehl
			myPreparedStatement = connect
					.prepareStatement("SELECT * FROM sentences_svc;");

			// SQL-Befehl wird ausgeführt
			myResultSet = myPreparedStatement.executeQuery();

			while (myResultSet.next()) {
				sentenceList.add(new SvcSentence(myResultSet.getInt(1),
						myResultSet.getString(2), myResultSet.getString(3),
						myResultSet.getString(4)));
			}

		} catch (SQLException ex) {
			System.out.println(ex.toString());

		} finally {
			SvcSentenceDao.closeConnections();
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
	public static boolean save(SvcSentence toSave) {

		try {
			connect = DatabaseConnection.connectDB();

			// PreparedStatement für SQL-Befehl
			myPreparedStatement = connect
					.prepareStatement("INSERT INTO sentences_svc VALUES(default,?, ?, ?)");

			myPreparedStatement.setString(1, toSave.getSubject());
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
			closeConnections();
		}
	}

    /**
     * Methode zum Erstellen eines zufällig zusammengesetzten Sentence aus den
     * Tabellenfeldern der Tabelle "sentences_svc"
     * original von jens
     *
     * @return randomSentence
     */
	
    public static SvcSentence createRandom() {

        String subject = get_subject();
        String verb = get_verb();
        String complement = get_complement();
        SvcSentence sent = new SvcSentence(subject, verb, complement);

        return sent;
    }

    private static String get_subject(){
        String randomObject = null;
        connect = DatabaseConnection.connectDB();

        try {
            myPreparedStatement = connect.prepareStatement("select sentences_svc.object from sentences_svc order by random() limit 1");
            myResultSet = myPreparedStatement.executeQuery();
            while (myResultSet.next()) {
                randomObject = myResultSet.getString("object");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnections();
        }
        return randomObject;
    }

    private static String get_verb(){
        String randomVerb = null;
        connect = DatabaseConnection.connectDB();

        try {
            myPreparedStatement = connect.prepareStatement("select sentences_svc.verb from sentences_svc order by random() limit 1");
            myResultSet = myPreparedStatement.executeQuery();
            while (myResultSet.next()) {
                randomVerb = myResultSet.getString("verb");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnections();
        }

        return randomVerb;
    }

    private static String get_complement(){
        String randomComplement = null;
        connect = DatabaseConnection.connectDB();

        try {
            myPreparedStatement = connect.prepareStatement("select sentences_svc.complement from sentences_svc order by random() limit 1");
            myResultSet = myPreparedStatement.executeQuery();

            while (myResultSet.next()) {
                randomComplement = myResultSet.getString("complement");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnections();
        }

        return randomComplement;
    }

	/**
	 * Ermittelt einen Datensatz aus der Tabelle "sentences_svc" anhand einer
	 * Zufallszahl
	 * 
	 * @param randomNumber
	 * @return myResultSet
	 */
	public static ResultSet findByID(int randomNumber) {
		try {
			myPreparedStatement = connect
					.prepareStatement("SELECT * FROM sentences_svc WHERE id = "
							+ randomNumber + ";");

			myResultSet = myPreparedStatement.executeQuery();

		} catch (Exception e) {
			System.out.println(e.toString());
		}

		return myResultSet;
	}

	/**
	 * Methode zum Löschen eines Datensatzes aus der Tabelle "sentences_svc"
	 * 
	 * @param id
	 * @return successful
	 */
	public static boolean delete(int id) {

		try {

			myPreparedStatement = connect
					.prepareStatement("DELETE FROM sentences_svc WHERE id = "
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
	private static void closeConnections() {
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
