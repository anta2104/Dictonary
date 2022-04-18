
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import javax.swing.*;


public class DictionaryManagement  {
    public Dicview view;

    Dictionary book = new Dictionary();

    public DictionaryManagement(Dicview view)  {
        this.view = view;

        /**
         *
         * Nút thêm
         */
        view.ADD().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Setup control = new Setup(view, book);
                control.ADD_NEW_WORD();
            }
        });

        /**
         *
         *  nút xóa
         */
        view.DELETE().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Setup control = new Setup(view, book);
                control.DELETE_WORD();

            }
        });

        /**
         *
         *  nút thêm
         */
        view.Search().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Setup control = new Setup(view, book);
                String s = String.format(view.wordSearch().getText());
                control.Add_history(s);
                if ("".equals(s)) {
                    JOptionPane.showMessageDialog(view, "Chưa nhập từ khóa ");
                } else {
                    view.getTextAreaE().setText("Result" + "\n");
                    control.SEARCH_WORD(s);
                }
            }
        });

        /**
         *
         *  nút Sửa
         */
        view.CHANGE().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Setup control = new Setup(view, book);
                control.CHANGE_WORD();
            }
        });

        /**
         *
         *  nút dịch văn bản
         */
        view.TRANSLATE().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Setup control = new Setup(view, book);
                try {
                    control.Translate();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        /**
         *
         *  nút Đọc
         */
        view.VOICE().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Setup control = new Setup(view, book);
                String s = String.format(view.wordSearch().getText());
                control.Voice(s);

            }
        });

        /**
         *
         *  nút Kiểm tra lịch sử
         */
        view.HISTORY().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Setup control = new Setup(view, book);
                control.History();
            }
        });
        view.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(1);
            }
        });

    }

    public Dicview getView() {
        return view;
    }

    public void setView(Dicview view) {
        this.view = view;
    }

    public static void main(String[] args)  {

        Dicview view = new Dicview();
        DictionaryManagement dictionaryManagement = new DictionaryManagement(view);
    }

}
