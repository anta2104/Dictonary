
// PROGRAM PROCEDURE

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

public class Setup {
    Dicview view;
    Dictionary book;

    Setup(Dicview view,Dictionary book ) {
        this.view = view;
        this.book = book;
    }

    public void ADD_NEW_WORD() {
        JLabel label1 = new JLabel("Tiếng Anh");
        label1.setBounds(50, 10, 100, 30);
        JLabel label2 = new JLabel("Tiếng Việt");
        label2.setBounds(250, 10, 100, 30);
        JTextField wordAdd1, wordAdd2;
        JFrame f = new JFrame();
        f.setTitle("Thêm Từ");
        f.setSize(400, 200);
        f.setLayout(null);
        f.setVisible(true);
        wordAdd1 = new JTextField();
        wordAdd1.setBounds(50, 40, 100, 30);
        wordAdd2 = new JTextField();
        wordAdd2.setBounds(250, 40, 100, 30);
        JButton ok = new JButton("OK");
        ok.setBounds(170, 100, 70, 30);
        f.add(wordAdd1);
        f.add(wordAdd2);
        f.add(label1);
        f.add(label2);
        f.add(ok);
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String  newWord = wordAdd2.getText() + " " + wordAdd1.getText();
                if (book.Check(wordAdd1.getText()).size() == 0 && !"".equals(wordAdd1.getText()) && !"".equals(wordAdd2.getText())) {
                    book.Add_new_word(wordAdd1.getText(), wordAdd2.getText());
                    f.dispose();
                    JOptionPane.showMessageDialog(view, "Thêm từ thành công");
                } else if (book.Check(wordAdd1.getText()).size() != 0 && !"".equals(wordAdd1.getText())){
                    f.dispose();
                    JOptionPane.showMessageDialog(view, "Từ này đã có");
                } else  {
                    JOptionPane.showMessageDialog(view, "Chưa nhập từ khóa");
                }
            }
        });
   }
    public void DELETE_WORD() {
       JLabel label1 = new JLabel("Tiếng Anh");
       label1.setBounds(175, 10, 120, 30);
       JTextField wordDELETE1;
       JFrame f = new JFrame();
       f.setTitle("Xóa từ");
       f.setSize(400, 200);
       f.setLayout(null);
       f.setVisible(true);
       wordDELETE1 = new JTextField();
       wordDELETE1.setBounds(150, 40, 110, 30);
       JButton ok = new JButton("OK");
       ok.setBounds(170, 80, 70, 30);
       f.add(wordDELETE1);
       f.add(label1);
       f.add(ok);
       ok.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               String newWord = wordDELETE1.getText();
               if (book.Check(newWord).size() != 0) {
                   book.Delete_word(newWord);
                   f.dispose();
                   JOptionPane.showMessageDialog(view, "Xóa thành công");
               } else {
                   f.dispose();
                   JOptionPane.showMessageDialog(view, "Không có từ này");
               }
           }
       });
    }
    public void CHANGE_WORD() {
        JLabel label1 = new JLabel("Tiếng Anh");
        label1.setBounds(50, 10, 100, 30);
        JLabel label2 = new JLabel("Tiếng Việt");
        label2.setBounds(250, 10, 100, 30);
        JTextField wordCHANGE1, wordCHANGE2;
        JFrame f = new JFrame();
        f.setTitle("Sửa từ");
        f.setSize(400, 200);
        f.setLayout(null);
        f.setVisible(true);
        wordCHANGE1 = new JTextField();
        wordCHANGE1.setBounds(50, 40, 100, 30);
        wordCHANGE2 = new JTextField();
        wordCHANGE2.setBounds(250, 40, 100, 30);
        JButton ok = new JButton("OK");
        ok.setBounds(170, 100, 70, 30);
        f.add(wordCHANGE1);
        f.add(wordCHANGE2);
        f.add(label1);
        f.add(label2);
        f.add(ok);
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String word1 = wordCHANGE1.getText();
                String word2 = wordCHANGE2.getText();
                if (book.search(word1).size() != 0 && !"".equals(word1) && !"".equals(word2)) {
                    book.Change_word(word1, word2);
                    f.dispose();
                    JOptionPane.showMessageDialog(view, "Sửa thành công");
                } else  {
                    JOptionPane.showMessageDialog(view, "Chưa nhập từ khóa");
                }
            }
        });
    }

    public void SEARCH_WORD(String s) {
        if (book.search(s).size() == 0) JOptionPane.showMessageDialog(view, "Không có từ này");
        List<Word> list = book.search(s);
        int Count = 0;
        for(Word word:list) {
            view.getTextAreaE().append(word.getWord() + " /" + word.getPronounce() + "/ " + " : " + word.getDescription() + "\n\n");
        }

    }

    public void Translate() throws IOException {
        JLabel label1 = new JLabel("Tiếng Anh");
        label1.setBounds(50, 10, 100, 30);
        JLabel label2 = new JLabel("Tiếng Việt");
        label2.setBounds(50, 370, 100, 30);
        JTextArea textArea1, textArea2;
        JFrame f = new JFrame();
        f.setTitle("Dịch văn bản");
        f.setSize(1000, 800);
        f.setLayout(null);
        f.setVisible(true);
        textArea1 = new JTextArea();
        textArea1.setBounds(50, 40, 900, 250);
        textArea2 = new JTextArea();
        textArea2.setBounds(50, 400, 900, 250);
        JButton ok = new JButton("Dịch");
        ok.setBounds(400, 330, 70, 30);
        JButton voice = new JButton("Đọc");
        voice.setBounds(500,330,70,30);
        f.add(textArea1);
        f.add(textArea2);
        f.add(label1);
        f.add(label2);
        f.add(ok);
        f.add(voice);
        voice.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TextSpeech a = new TextSpeech();
                String s = textArea1.getText();
                a.Speech(s);
            }
        });
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = textArea1.getText();
                int count = 0;
                if (s.equals("")) {
                    f.dispose();
                    JOptionPane.showMessageDialog(view, "Chưa nhập đoạn văn");
                }
                try {
                    s =  book.Translates(s);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                    int size = s.length();
                    for (int i = 0; i < size; i++) {
                        if (s.charAt(i) == ' ' ) {
                            count++;
                        }
                        if (count <= 34) {
                            String s1 = String.valueOf(s.charAt(i));
                            textArea2.append(s1);
                        } else {
                            textArea2.append("\n");
                            count = 0;
                        }
                    }
            }
        });
    }

    public void Voice(String s) {
        TextSpeech a = new TextSpeech();
        if (book.Check(s).size() != 0 && !s.equals("")) {
            a.Speech(s);
        } else if (s.equals("")) {
            JOptionPane.showMessageDialog(view, "Chưa nhập");
        } else  JOptionPane.showMessageDialog(view, "Không có từ này");
    }

    public void History() {
           JFrame f = new JFrame();
           f.setTitle("Lịch sử tra");
           f.setSize(800, 600);
           f.setLayout(null);
           f.setVisible(true);
           JTextArea textArea ;
           textArea = new JTextArea();
           textArea.setBounds(0, 0, 800, 500);
           JButton DEl = new JButton("Xóa");
           DEl.setBounds(380,500,60,30);
           f.add(DEl);
           f.add(textArea);
           List<String> list = book.Show_history();
           textArea.setFont(new Font("" ,Font.PLAIN,20));
           for (String line:list) {
               textArea.append(line + "\n");
           }
           DEl.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
               book.DELETE_HISTORY();
               textArea.setText("");
               }
           });

    }

    public void Add_history(String s) {
        book.ADD_HISTORY(s);
    }

}

