package hacker.partie.services;

import hacker.partie.model.Favourite;
import hacker.partie.model.ThreePartSentence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FavouriteDao extends SentenceDao {

    public FavouriteDao() {
        super("favourites");
    }
    
    public List<Favourite> findFav() {

        Connection connect = null;
        PreparedStatement myPreparedStatement = null;
        ResultSet myResultSet = null;



        List<Favourite> sentenceList = new ArrayList<Favourite>();

        try {
            // PreparedStatement für den SQL-Befehl
            connect = DatabaseConnection.connectDB();
            myPreparedStatement = connect
                    .prepareStatement("SELECT * FROM " + this.getTableName() + ";");

            // SQL-Befehl wird ausgeführt
            myResultSet = myPreparedStatement.executeQuery();

            while (myResultSet.next()) {
                ThreePartSentence sentence = new ThreePartSentence(myResultSet.getInt(1),
                    myResultSet.getString(2), myResultSet.getString(3),
                    myResultSet.getString(4));
                Favourite favourite = new Favourite(sentence, myResultSet.getInt(5));
                sentenceList.add(favourite);
            }

        } catch (SQLException ex) {
            System.out.println(ex.toString());

        } finally {
            closeConnections(myResultSet, myPreparedStatement, connect);
        }

        return sentenceList;
    }
    
    public boolean saveFav(Favourite toSave) {
        Connection connect = null;
        PreparedStatement myPreparedStatement = null;
        ResultSet myResultSet = null;

        try {
            connect = DatabaseConnection.connectDB();

            // PreparedStatement für SQL-Befehl
            myPreparedStatement = connect
                    .prepareStatement("INSERT INTO " + this.getTableName() + " VALUES(default,?, ?, ?, 0)");

            myPreparedStatement.setString(1, toSave.getSentence().getSubject());
            myPreparedStatement.setString(2, toSave.getSentence().getVerb());
            myPreparedStatement.setString(3, toSave.getSentence().getComplement());

            // SQL-Befehl wird ausgeführt
            int execute = myPreparedStatement.executeUpdate();
            return (execute != 0);

        } catch (SQLException ex) {
            ex.printStackTrace();
            return  false;

        } finally {
            closeConnections(myResultSet, myPreparedStatement, connect);
        }
    }

}
