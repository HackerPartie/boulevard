package hacker.partie.services;

import org.apache.shiro.authc.credential.DefaultPasswordService;
import org.apache.shiro.authc.credential.PasswordService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by jens on 4/6/14.
 */
public class UserDao {

    public boolean doLogin(String username, String password){
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        String dbPassword = null;
        PasswordService passwordService = new DefaultPasswordService();
        Connection connection = DatabaseConnection.connectDB();
        // be conservative: make this the default
        boolean loginSuccess = false;

        try {
            preparedStatement = connection.prepareStatement("select * from user_auth where username = ?");
            preparedStatement.setString(1, username);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                dbPassword = resultSet.getString("password");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (passwordService.passwordsMatch(password, dbPassword)) {
            loginSuccess = true;
        } 
        return loginSuccess;
    }

    public boolean doRegister(String username, String encryptedPassword) {
        PreparedStatement preparedStatement;
        Connection connection = DatabaseConnection.connectDB();
        System.out.println(username);
        System.out.println(encryptedPassword);
        boolean registerSuccess;
        try {
            preparedStatement = connection.prepareStatement("insert into user_auth(username, password) values(?,?)");
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, encryptedPassword);
            preparedStatement.executeUpdate();
            registerSuccess = true;
        } catch (SQLException e) {
            e.printStackTrace();
            registerSuccess = false;
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return registerSuccess;
    }

}
