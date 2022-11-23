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
                dlg.setVisible(true);

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
            super(f, "MyDialog", true);

            buildGUI();

            Point loc = f.getLocation();
            setLocation(loc.x + 50, loc.y + 70);
            pack();
            setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
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
