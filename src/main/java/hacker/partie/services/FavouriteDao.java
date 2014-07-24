package hacker.partie.services;

import hacker.partie.model.Favourite;
import hacker.partie.model.ThreePartSentence;
import hacker.partie.services.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FavouriteDao extends SentenceDao {

    private static final int SEARCH_SENTENCE_NOT_FOUND = 0;
    
    public FavouriteDao() {
        super("favourites");
    }

    public List<Favourite> top10() {

        Connection connect = null;
        PreparedStatement myPreparedStatement = null;
        ResultSet myResultSet = null;

        List<Favourite> sentenceList = new ArrayList<Favourite>();

        try {
            // PreparedStatement für den SQL-Befehl
            connect = DatabaseConnection.connectDB();
            myPreparedStatement = connect
                .prepareStatement("SELECT * FROM " + this.getTableName() + " ORDER BY score DESC LIMIT 10;");

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

    public boolean insertOrUpdate(Favourite sentence) {
        boolean retVal = false;
        
        int localId = idIfExisting(sentence);
        
        if (localId == SEARCH_SENTENCE_NOT_FOUND) {
            saveFav(sentence);
            retVal = true;
        }
        else if ( localId > 0) { 
            addVote(localId); 
            retVal = true;
        }
        
        return retVal;
        
    }
    
    private boolean saveFav(Favourite toSave) {
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
            return false;

        } finally {
            closeConnections(myResultSet, myPreparedStatement, connect);
        }
    }

    /**
     * 
     * @param sentence
     * @return SEARCH_SENTENCE_NOT_FOUND if the sentence does not exit,<br>
     * the id of the entity if it exist,<br>
     * a negative value in case of database error
     */
    private int idIfExisting(Favourite sentence) {
        Connection connect = null;
        PreparedStatement myPreparedStatement = null;
        ResultSet myResultSet = null;
        int id;

        try {
            connect = DatabaseConnection.connectDB();

            // PreparedStatement für SQL-Befehl
            myPreparedStatement = connect
                .prepareStatement("SELECT id, object, verb, complement FROM " + this.getTableName()
                    + "  WHERE object=? and verb=? and complement=? ;");

            myPreparedStatement.setString(1, sentence.getSentence().getSubject());
            myPreparedStatement.setString(2, sentence.getSentence().getVerb());
            myPreparedStatement.setString(3, sentence.getSentence().getComplement());
            myResultSet = myPreparedStatement.executeQuery();

            // returns false if the cursor is not before the first record or if there are no rows in the ResultSet
            if (myResultSet.isBeforeFirst() == false) 
                id = SEARCH_SENTENCE_NOT_FOUND;
            else {
                myResultSet.next();
                id = myResultSet.getInt("id");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            id = -1;

        } finally {
            closeConnections(myResultSet, myPreparedStatement, connect);
        }

        return id;

    }
    
    private boolean addVote(int id){
            
            Connection connect = null;
            PreparedStatement myPreparedStatement = null;
            ResultSet myResultSet = null;
            boolean localSuccess = false;

            try {
                connect = DatabaseConnection.connectDB();
                myPreparedStatement = connect
                        .prepareStatement("UPDATE " + this.getTableName() +
                            " SET score = score + 1 " +
                            " WHERE id = "+ id + ";");

                if (myPreparedStatement.executeUpdate() == 0) 
                    localSuccess = true;
                
            } catch (Exception e) {
                System.out.println(e.toString());

            } finally {
                closeConnections(myResultSet, myPreparedStatement, connect);
        }
            return localSuccess;
    }
}
