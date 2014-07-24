package hacker.partie.services;

import hacker.partie.model.ThreePartSentence;
import hacker.partie.services.DatabaseConnection;

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
public class SentenceDao {
    
    private final String tableName;

    public String getTableName() {
        return tableName;
    }

    public SentenceDao(String tableName) {
        this.tableName = tableName;
    }
    
	/**
	 * Es werden alle Datensätze, die in der Tabelle "sentences_svc" vorhanden
	 * sind, angezeigt
	 * 
	 * @return sentenceList
	 */
	public List<ThreePartSentence> findAll() {

		Connection connect = null;
		PreparedStatement myPreparedStatement = null;
		ResultSet myResultSet = null;



		List<ThreePartSentence> sentenceList = new ArrayList<ThreePartSentence>();

		try {
			// PreparedStatement für den SQL-Befehl
			connect = DatabaseConnection.connectDB();
			myPreparedStatement = connect
					.prepareStatement("SELECT * FROM " + tableName + ";");

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
	public boolean save(ThreePartSentence toSave) {
		Connection connect = null;
		PreparedStatement myPreparedStatement = null;
		ResultSet myResultSet = null;

		try {
			connect = DatabaseConnection.connectDB();

			// PreparedStatement für SQL-Befehl
			myPreparedStatement = connect
					.prepareStatement("INSERT INTO " + tableName + "VALUES(default,?, ?, ?)");

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

	public ThreePartSentence createRandom() {

		String subject = get_subject();
		String verb = get_verb();
		String complement = get_complement();
		ThreePartSentence sent = new ThreePartSentence(subject, verb, complement);
		return sent;
	}

	private String get_subject() {
		String randomSubject = null;
		Connection connect = null;
		PreparedStatement myPreparedStatement = null;
		ResultSet myResultSet = null;

		try {
			connect = DatabaseConnection.connectDB();
			myPreparedStatement = connect
					.prepareStatement("select object from " + tableName + " order by random() limit 1");
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

	private String get_verb() {
		String randomVerb = null;
		
		Connection connect = null;
		PreparedStatement myPreparedStatement = null;
		ResultSet myResultSet = null;

		try {
			connect = DatabaseConnection.connectDB();
			myPreparedStatement = connect
					.prepareStatement("select verb from " + tableName + " order by random() limit 1");
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

	private String get_complement() {
		String randomComplement = null;
		Connection connect  = null;
		PreparedStatement myPreparedStatement = null;
		ResultSet myResultSet = null;

		try {
			connect = DatabaseConnection.connectDB();
			myPreparedStatement = connect
					.prepareStatement("select complement from " + tableName + " order by random() limit 1");
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
	public boolean delete(int id) {
		
		Connection connect = null;
		PreparedStatement myPreparedStatement = null;
		ResultSet myResultSet = null;
		boolean localSuccess = false;

		try {
			connect = DatabaseConnection.connectDB();
			myPreparedStatement = connect
					.prepareStatement("DELETE FROM " + tableName + " WHERE id = "
							+ id + ";");

			if (myPreparedStatement.executeUpdate() == 0) 
			    localSuccess = true;

		} catch (Exception e) {
			System.out.println(e.toString());

		} finally {
			closeConnections(myResultSet, myPreparedStatement, connect);
		}
		
		return localSuccess;
	}
	
    public int count() {
        Connection connect = null;
        PreparedStatement myPreparedStatement = null;
        ResultSet myResultSet = null;

        try {
            connect = DatabaseConnection.connectDB();
            myPreparedStatement = connect
                .prepareStatement("SELECT COUNT(*) FROM " + tableName + ";");
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
	protected void closeConnections(ResultSet myResultSet, PreparedStatement myPreparedStatement, Connection connect) {
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
