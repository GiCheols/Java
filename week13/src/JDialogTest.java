import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JDialogTest extends JFrame {
    public JDialogTest() {
        super("JDialogEx");

        buildGUI();

        setBounds(120, 120, 300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void buildGUI() {
        setLayout(new FlowLayout());

        JButton button = new JButton("대화상자...");
        add(button);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JMyDialog dlg = new JMyDialog(JDialogTest.this);
                dlg.setVisible(true);   // 이 구문 없으면 대화상자 나타나지 않음

                // 아래 코드는 대화상자가 "닫혀야만" 실행됨
                String input = dlg.getInput();
                if(input != null)
                    System.out.println(input);
                else
                    System.out.println("입력되지 않음");
            }
        });
    }

    class JMyDialog extends JDialog {
        private JTextField text;
        private JButton btn;

        JMyDialog(JFrame f){
            // modal: true 이면 창을 닫기 전까지 다른 창을 건들 수 없음
            super(f, "MyDialog", true);

            buildGUI();

            Point loc = f.getLocation();
            setLocation(loc.x + 50, loc.y + 70);
            pack();
            setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            // 대화상자만 종료되도록 옵션 설정
        }

        private void buildGUI(){
            setLayout(new FlowLayout());

            text = new JTextField(10);
            btn = new JButton("확인");

            add(text);
            add(btn, BorderLayout.EAST);

            btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setVisible(false);
                    // 비활성화
                }
            });
        }

        String getInput() {
            String str = text.getText();
            if(!str.isEmpty())
                return str;
            else
                return null;
        }
    }

    public static void main(String[] args) {
        new JDialogTest();
    }
}
