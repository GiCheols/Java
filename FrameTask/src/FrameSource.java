import javax.swing.*;
import java.awt.*;

public class FrameSource{
    private JFrame frame;
    public FrameSource() {
        frame = new JFrame("사원등록");

        buildGUI();

        frame.setSize(350, 420);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private void buildGUI() {
        frame.add(northPanel(), BorderLayout.NORTH);
        frame.add(panel6(), BorderLayout.CENTER);
        frame.add(panel7(), BorderLayout.SOUTH);
    }

    private JPanel northPanel(){
        JPanel panel = new JPanel(new GridLayout(5, 1));
        panel.add(panel1());
        panel.add(panel2());
        panel.add(panel3());
        panel.add(panel4());
        panel.add(panel5());

        return panel;
    }

    private JPanel panel1() {
        JLabel nameText = new JLabel("성   명");
        JTextField nameScan = new JTextField(8);
        JLabel genderName = new JLabel("성   별");
        JTextField genderInput = new JTextField(3);

        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel.add(nameText);
        panel.add(nameScan);
        panel.add(genderName);
        panel.add(genderInput);

        return panel;
    }

    private JPanel panel2() {
        JLabel socialNumber = new JLabel("주민등록번호");
        JTextField firstNum = new JTextField(6);
        JLabel hypen = new JLabel(" - ");
        JTextField lastNum = new JTextField(7);

        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel.add(socialNumber);
        panel.add(firstNum);
        panel.add(hypen);
        panel.add(lastNum);

        return panel;
    }

    private JPanel panel3(){
        JLabel addressName = new JLabel("주      소");
        JTextField address = new JTextField(22);

        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel.add(addressName);
        panel.add(address);

        return panel;
    }

    private JPanel panel4(){
        JLabel departmentName = new JLabel("부  서  명");
        JTextField departmentInput = new JTextField(8);

        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel.add(departmentName);
        panel.add(departmentInput);

        return panel;
    }

    private JPanel panel5(){
        JLabel hobby = new JLabel("취     미");
        JTextField hobbyInput = new JTextField(22);

        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel.add(hobby);
        panel.add(hobbyInput);

        return panel;
    }

    private JPanel panel6(){
        JLabel introduce = new JLabel("자 기 소 개");
        JTextArea introduceMe = new JTextArea(9, 22);

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(introduce, BorderLayout.NORTH);
        panel.add(introduceMe, BorderLayout.CENTER);

        return panel;
    }

    private JPanel panel7(){
        JButton btnSave = new JButton("저장");
        JButton btnExit = new JButton("종료");

        JPanel panel = new JPanel(new FlowLayout());
        panel.add(btnSave);
        panel.add(btnExit);

        return panel;
    }
}
