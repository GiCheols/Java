import javax.swing.*;
import java.awt.*;

public class JFrameTest1 extends JFrame{
    public JFrameTest1(){
        super("사원 등록");

        setSize(350, 420);

        buildGUI();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void buildGUI(){
        JLabel label = new JLabel("Hello World");

        add(createInputPanel(), BorderLayout.CENTER);
        add(label, BorderLayout.SOUTH);
    }

    private JPanel createInputPanel(){
        JTextField text = new JTextField(10);
        JButton btn = new JButton("확인");

        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        panel.add(text);
        panel.add(btn);
        panel.setBackground(Color.ORANGE);

        return panel;
    }
}
