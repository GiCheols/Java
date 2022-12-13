import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

public class test extends JFrame {

    public JTextArea ta = new JTextArea();
    JFileChooser chooser = new JFileChooser();
    JMenuBar mb = new JMenuBar();

    // 생성자
    public test() {

        this.setTitle("Notepad");
        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);




        // 2. 메뉴생성
        String[] smenu = { "파일" };
        JMenu[] mfile = new JMenu[10];
        for (int i = 0; i < smenu.length; i++) {
            mfile[i] = new JMenu(smenu[i]);
            mb.add(mfile[i]);
        }


        String[] ScrItem = { "새파일", "열기", "저장", "다른이름으로저장", "종료" };
        JMenuItem[] item = new JMenuItem[5];
        for (int i = 0; i < ScrItem.length; i++) {
            item[i] = new JMenuItem(ScrItem[i]);
            // 1. 이벤트 소스: JMenuItem
            // 4. 메뉴바 설정
            this.setJMenuBar(mb);
            mfile[0].add(item[i]);

        }

        // 컴포넌트 추가
        this.add(ta);

        this.setVisible(true);
    }
    public static void main(String[] args) {
        new test();
    }

}
