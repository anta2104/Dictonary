import java.sql.*;
import java.io.*;
import java.util.*;
public class Sql {

    public Connection connect(String db) {
        String database = "jdbc:sqlite:" + db;
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(database);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public List<Word> searchWord(String db, String search, Boolean mode) {
        String sql = "SELECT * FROM av WHERE word LIKE ?;";
        List<Word> list = new ArrayList<Word>();
        try{
            Connection conn = this.connect(db);
            PreparedStatement stmt = conn.prepareStatement(sql);
            if (mode) {
                search += '%';
            }
            stmt.setString(1, search);
            ResultSet rs = stmt.executeQuery();
            while ( rs.next() ) {
                String  word = rs.getString("word");
                String  description = rs.getString("description");
                String  pronounce = rs.getString("pronounce");
                Word newWord = new Word(word, description,pronounce);
                list.add(newWord);
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    public List<Word> checkWord(String db, String search) {
        String sql = "SELECT * FROM av WHERE word LIKE ?;";
        String res = "";
        List<Word> list = new ArrayList<Word>();
        try{
            Connection conn = this.connect(db);
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, search);
            ResultSet rs = stmt.executeQuery();
            while ( rs.next() ) {
                String  word = rs.getString("word");
                String  description = rs.getString("description");
                String  pronounce = rs.getString("pronounce");
                Word newWord = new Word(word, description,pronounce);
                list.add(newWord);
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    public void insertWord(String db, String word, String description) {
        String sql = "INSERT INTO av(word, description) VALUES(?,?);";
        try{
            Connection conn = this.connect(db);
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, word);
            stmt.setString(2, description);
            stmt.executeUpdate();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteWord(String db, String word) {
        String sql = "DELETE from av WHERE word = ?;";
        try{
            Connection conn = this.connect(db);
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, word);
            stmt.executeUpdate();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void changeWord(String db, String word, String description) {
        String sql = "UPDATE av SET description = ? "
                + "WHERE word = ?;";
        try{
            Connection conn = this.connect(db);
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, description);
            stmt.setString(2, word);
            stmt.executeUpdate();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}