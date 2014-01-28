package hacker.partie.databasePackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import javax.swing.JOptionPane;

/**
 * Die Klasse "DatabaseConnection" stellte eine Verbindung zur MySQL-Datenbank
 * "sentence_database" her
 * 
 * @author Bergsocke
 * 
 */

public class DatabaseConnection {

	private static Connection connect = null;

	/**
	 * Diese Methode baut die Datenbankverbindung zur Datenbank
	 * "sentence_database" auf
	 * 
	 * @return connect
	 */
	public static Connection connectDB() {

		try {
			Properties myProperties = new Properties();

			try {
				// load a properties file from class path, inside static method
				myProperties.load(DatabaseConnection.class.getClassLoader()
						.getResourceAsStream("database.properties"));

			} catch (Exception e) {
				System.out.println(e.toString());
				JOptionPane.showMessageDialog(null,
						"database.properties wurde nicht gefunden.", "Fehler",
						JOptionPane.ERROR_MESSAGE);
			}

			String drivers = myProperties.getProperty("jdbc.driver");
			String connectionURL = myProperties.getProperty("jdbc.url");
			String username = myProperties.getProperty("jdbc.username");
			String password = myProperties.getProperty("jdbc.password");

			Class.forName(drivers);

			connect = DriverManager.getConnection(connectionURL, username,
					password);

		} catch (Exception e) {
			System.out.println(e.toString());
			JOptionPane.showMessageDialog(null,
					"Datenbankverbindung konnte nicht hergestellt werden. "
							+ "Bitte prüfen Sie, ob der MySQL-Server läuft.",
					"Fehler", JOptionPane.ERROR_MESSAGE);
		}
		return connect;
	}
}
