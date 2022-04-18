import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

public class Dicview extends JFrame {
    private JTextField wordSearch;
    private JButton search, add, delete, fix, translate, voice, history;
    private JTextArea textAreaE;

    public Dicview()  {

        setTitle("DICTIONARY");

        // tạo các label hằng số
        JLabel label = new JLabel("Nhập từ cần tìm :");
        label.setBounds(300, 120, 170, 50);
        label.setFont(new Font("" ,Font.PLAIN,20));

        // tạo các trường nhập hằng số label
        wordSearch = new JTextField();
        wordSearch.setBounds(470, 120, 200, 55);
        wordSearch.setFont(new Font("" ,Font.PLAIN,20));

        // tạo button search
        ImageIcon image = new ImageIcon(new ImageIcon("search1.png").getImage().getScaledInstance(50, 40, Image.SCALE_DEFAULT));
        search = new JButton();
        search.setIcon(image);
        search.setBounds(700, 120, 100, 50);

        //tao button phat am
        ImageIcon image2 = new ImageIcon(new ImageIcon("speech3.png").getImage().getScaledInstance(50, 40, Image.SCALE_DEFAULT));
        voice = new JButton();
        voice.setIcon(image2);
        voice.setBounds(830,120,100,50);

        // tao button add
        add = new JButton("Thêm");
        add.setBounds(0, 200, 130, 40);

        //tao button delete
        delete = new JButton("Xóa");
        delete.setBounds(0, 250, 130, 40);

        //tao button fix
        fix = new JButton("Sửa");
        fix.setBounds(0, 300, 130, 40);

        //tao button translate
        translate = new JButton("Dịch văn bản");
        translate.setBounds(0,350,130,40);

        //tao button lich su
        history = new JButton("Lịch sử tra");
        history.setBounds(0,400,130,40);


        // tạo textarea để hiện thị kết quả
        textAreaE = new JTextArea("Result" + "\n");
        textAreaE.setBounds(200, 200, 800, 700);
        textAreaE.setFont(new Font("" ,Font.PLAIN,20));
        textAreaE.setLineWrap(true);
        textAreaE.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(textAreaE);
        scrollPane.setBounds(200,200,800,700);

        try {
            final Image backgroundImage = javax.imageio.ImageIO.read(new File("b1.jpg"));
            setContentPane(new JPanel(new BorderLayout()) {
                @Override public void paintComponent(Graphics g) {
                    g.drawImage(backgroundImage,0,0,1200,1000,null);
                }
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // add các đối tượng vào jframe
        add(label);
        add(wordSearch);
        add(search);
        add(add);
        add(delete);
        add(fix);
        add(translate);
        add(voice);
        add(history);
        add(scrollPane);


        // thiết lập bố cục (layout)
        setLayout(null);

        // thiết lập kích thước jframe
        setSize(1200, 1000);

        // hiển thị jframe
        setVisible(true);
    }


    public JTextField wordSearch() {
        return wordSearch;
    }

    public void setTextFieldA(JTextField textFieldA) {
        this.wordSearch = textFieldA;
    }

    public JButton Search() {
        return search;
    }

    public JButton ADD() {
        return add;
    }

    public JButton DELETE() { return delete; }

    public JButton CHANGE() { return fix; }

    public JButton TRANSLATE() { return translate; }

    public JButton HISTORY() { return history;}

    public void setBtnKetQua(JButton btnKetQua) {
        this.search = btnKetQua;
    }

    /** tra ve khung . */
   public JTextArea getTextAreaE() {
        return textAreaE;
    }

    public void setTextAreaE(JTextArea textArea) {
        this.textAreaE = textArea;
    }


   public void setVoice(JButton voice) {
        this.voice = voice;
   }

   public JButton VOICE() {
        return voice;
   }
}