package hacker.partie.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

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
		}
		return connect;
	}
}
