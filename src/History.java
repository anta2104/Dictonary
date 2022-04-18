
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class History {

    /**
     *
     * Lich su
     */
    public List<String> IN() {
        BufferedReader reader;
        List<String> his = new ArrayList<String>();
        try {
            reader = new BufferedReader(new FileReader("History.txt"));
            String line = reader.readLine();
            while (line != null) {
                his.add(line);
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return his;
    }


    /**
     *
     * Thêm vào lịch sử
     */
    public void ADD_HIS(String s) {
        BufferedWriter bw = null;
        FileWriter fw = null;
        try {
            File file = new File("History.txt");
            fw = new FileWriter(file.getAbsoluteFile(), true);
            bw = new BufferedWriter(fw);
            String time = String.valueOf(java.time.LocalDateTime.now());
            bw.write(   time.substring(0,10) + " vào " + time.substring(11,19) + " Tra từ : " + s + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bw != null)
                    bw.close();
                if (fw != null)
                    fw.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    /**
     *
     * Xóa lịch sử
     */
    public void Delete() {
        File file = new File("History.txt");
        file.delete();
    }

}