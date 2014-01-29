package hacker.partie.databasePackage;

import java.io.FileInputStream;
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
//				myProperties.load(DatabaseConnection.class.getClassLoader()
//						.getResourceAsStream("database.properties"));
				
				myProperties.load(new FileInputStream("*****"));

			} catch (Exception e) {
				System.out.println(e.toString());
			}

			String drivers = myProperties.getProperty("jdbc.driver");
			String connectionURL = myProperties.getProperty("jdbc.url");
			String username = myProperties.getProperty("jdbc.username");
			String password = myProperties.getProperty("jdbc.password");
			
			System.out.println("properties: ");
			System.out.println(connectionURL);
			System.out.println(username);
			System.out.println(password);

			Class.forName(drivers);

			connect = DriverManager.getConnection(connectionURL, username,
					password);
			
			System.out.println("connect: ");
			System.out.println(connect);

		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return connect;
	}
}
