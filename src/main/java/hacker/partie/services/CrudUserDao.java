package hacker.partie.services;

import hacker.partie.model.DatabaseConnection;
import org.apache.shiro.authc.credential.DefaultPasswordService;
import org.apache.shiro.authc.credential.PasswordService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by jens on 4/6/14.
 */
public class CrudUserDao {

    public boolean doLogin(String username, String password){
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        String u = null;
        String p = null;
        PasswordService passwordService = new DefaultPasswordService();
        Connection connection = DatabaseConnection.connectDB();
        boolean l;


        try {
            preparedStatement = connection.prepareStatement("select * from user_auth where username = ?");
            preparedStatement.setString(1, username);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                u = resultSet.getString("username");
                p = resultSet.getString("password");
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

        if (passwordService.passwordsMatch(password, p)) {
            //session.setAttribute("user", u);
            //Cookie cookie = new Cookie(u, sessionId);
            //cookie.setHttpOnly(true);
            l = true;
        } else {
            l = false;
        }
        return l;
    }

    public boolean doRegister(String username, String encryptedPassword) {
        PreparedStatement preparedStatement;
        Connection connection = DatabaseConnection.connectDB();
        System.out.println(username);
        System.out.println(encryptedPassword);
        boolean r;
        try {
            preparedStatement = connection.prepareStatement("insert into user_auth(username, password) values(?,?)");
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, encryptedPassword);
            preparedStatement.executeUpdate();
            r = true;
        } catch (SQLException e) {
            e.printStackTrace();
            r = false;
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return r;
    }

}
