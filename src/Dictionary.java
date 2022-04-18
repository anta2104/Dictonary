import java.sql.*;
import java.io.*;
import java.util.List;


public class Dictionary {
    private Sql a = new Sql();
    String db = "dict_hh.db";
    private API_googleTranslate b = new API_googleTranslate();
    private History c = new History();


    public void Add_new_word(String s, String wordV) {
        a.insertWord(db, s, wordV);

    }

    public void Delete_word(String s) {
        a.deleteWord(db, s);
    }

    public void Change_word(String s, String wordV) {
        a.changeWord(db, s, wordV);
    }

    public List<Word> search(String s) {
       return a.searchWord(db, s, true);
    }

    public List<Word> Check(String s) {
        return a.checkWord(db, s);
    }

    public String Translates(String s) throws IOException {
        return b.translate("en", "vi", s);
    }

    public List<String> Show_history() {
       return c.IN();
    }

    public void ADD_HISTORY(String s) {
        c.ADD_HIS(s);
    }

    public void DELETE_HISTORY() {
        c.Delete();
    }

}


