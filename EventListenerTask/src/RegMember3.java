import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class RegMember3 {
    private JFrame frame;
    private JTextArea result;
    JRadioButton[] genders = new JRadioButton[2];
    JCheckBox[] Hobbies = new JCheckBox[4];
    String[] names = {"영화", "음악감상", "사진", "운동"};

    public RegMember3() {
        frame = new JFrame("사원등록");

        buildGUI();

        frame.setSize(350, 420);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private void buildGUI() {
        frame.add(northPanel(), BorderLayout.NORTH);
        frame.add(panel6(), BorderLayout.CENTER);
        /**frame.add(panel7(), BorderLayout.SOUTH);*/
    }

    private JPanel northPanel() {
        JPanel panel = new JPanel(new GridLayout(5, 1));
        panel.add(panel1());
        panel.add(panel2());
        panel.add(panel3());
        panel.add(panel4());
        panel.add(panel5());

        return panel;
    }

    class RadioEventListener implements ItemListener {
        public void itemStateChanged(ItemEvent e){
            String gender;

            if(e.getStateChange() == ItemEvent.DESELECTED)
                return;
            if(genders[0].isSelected())
                gender = genders[0].getText();
            else
                gender = genders[1].getText();

            result.append(gender + "를 선택하셨습니다.\n");
        }
    }

    public JPanel panel1() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel nameText = new JLabel("성   명");
        JTextField nameInput = new JTextField(8);
        JLabel genderName = new JLabel("성   별");

        panel.add(nameText);
        panel.add(nameInput);
        panel.add(genderName);

        nameInput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameInput.getText();
                result.append(name + "\n");

                nameInput.setText("");
            }
        });

        genders[0] = new JRadioButton("남");
        genders[1] = new JRadioButton("여");
        ButtonGroup genderGroup = new ButtonGroup();
        for(int i = 0; i < 2; i++){
            genderGroup.add(genders[i]);
            panel.add(genders[i]);

            genders[i].addItemListener(new RadioEventListener());
        }

        return panel;
    }

    private JPanel panel2() {
        JLabel socialNumber = new JLabel("주민등록번호");
        JTextField firstNum = new JTextField(6);
        JLabel hypen = new JLabel(" - ");
        JTextField lastNum = new JTextField(7);

        firstNum.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String firstnum = firstNum.getText();
                result.append(firstnum + " - ");

                firstNum.setText("");
            }
        });

        lastNum.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String lastnum = lastNum.getText();
                result.append(lastnum + "\n");

                lastNum.setText("");
            }
        });

        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel.add(socialNumber);
        panel.add(firstNum);
        panel.add(hypen);
        panel.add(lastNum);

        return panel;
    }

    private JPanel panel3() {
        JLabel addressName = new JLabel("주      소");
        JTextField addressInput = new JTextField(22);

        addressInput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String address = addressInput.getText();
                result.append(address + "\n");

                addressInput.setText("");
            }
        });

        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel.add(addressName);
        panel.add(addressInput);

        return panel;
    }

    private JPanel panel4() {
        JLabel departmentName = new JLabel("부  서  명");
        JTextField departmentInput = new JTextField(8);

        departmentInput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String department = departmentInput.getText();
                result.append(department + "\n");

                departmentInput.setText("");
            }
        });

        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel.add(departmentName);
        panel.add(departmentInput);

        return panel;
    }

    class CheckboxEventListener implements ItemListener {
        String whatIsHobby;
        public void itemStateChanged(ItemEvent e){
            if(e.getStateChange() == ItemEvent.SELECTED){
                if(e.getItem() == Hobbies[0])
                    whatIsHobby = names[0] + " ";
                else if(e.getItem() == Hobbies[1])
                    whatIsHobby = names[1] + " ";
                else if(e.getItem() == Hobbies[2])
                    whatIsHobby = names[2] + " ";
                else
                    whatIsHobby = names[3] + " ";
                result.append(whatIsHobby);
                result.append("을(를) 선택하셨습니다.\n");
            } else {
                if(e.getItem() == Hobbies[0])
                    whatIsHobby = names[0] + " ";
                else if(e.getItem() == Hobbies[1])
                    whatIsHobby = names[1] + " ";
                else if(e.getItem() == Hobbies[2])
                    whatIsHobby = names[2] + " ";
                else
                    whatIsHobby = names[3] + " ";
                result.append(whatIsHobby);
                result.append("을(를) 선택 해제하셨습니다.\n");
            }
        }
    }

    private JPanel panel5() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        JLabel hobby = new JLabel("취     미");
        panel.add(hobby);
        for(int i = 0; i < 4; i++){
            Hobbies[i] = new JCheckBox(names[i]);
            panel.add(Hobbies[i]);
            Hobbies[i].addItemListener(new CheckboxEventListener());
        }
        return panel;
    }

    private JPanel panel6() {
        JLabel introduce = new JLabel("자 기 소 개");
        result = new JTextArea(9, 22);
        result.setEditable(false);

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(introduce, BorderLayout.NORTH);
        panel.add(result, BorderLayout.CENTER);

        return panel;
    }

    /**
    private JPanel panel7() {
        JButton btnSave = new JButton("저장");
        JButton btnExit = new JButton("종료");

        JPanel panel = new JPanel(new FlowLayout());


        panel.add(btnSave);
        panel.add(btnExit);

        return panel;
    }
    */
}

