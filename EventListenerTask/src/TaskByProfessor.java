import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class TaskByProfessor {
        private JFrame frame;
        private JTextField intro;
        private JComboBox<String> department;
        JTextField intro2;
        JTextField intro3;
        JTextField intro4;
        JTextField intro5;
        JTextArea result;
        JRadioButton genderMan;
        JRadioButton genderWoman;
        JCheckBox watchMovie;
        JCheckBox listenMusic;
        JCheckBox takePicture;
        JCheckBox workOut;

        public TaskByProfessor() {
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

        public JPanel panel1() {
            JLabel nameText = new JLabel("성   명");
            intro = new JTextField(8);
            JLabel genderName = new JLabel("성   별");
            genderMan = new JRadioButton("남");
            genderWoman = new JRadioButton("여");

            ButtonGroup genderGroup = new ButtonGroup();
            genderGroup.add(genderMan);
            genderGroup.add(genderWoman);

            JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            panel.add(nameText);
            panel.add(intro);
            panel.add(genderName);
            panel.add(genderMan);
            panel.add(genderWoman);

            intro.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //String text = intro.getText();
                    //이벤트가 발생시킨 소스가 어디서 온건지 확인하는 함수
                    JTextField src = (JTextField) e.getSource();
                    String text = src.getText();
                    result.append("이름: " + text + "\n");
                }
            });

            /**
            ActionListener listener = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JRadioButton src = (JRadioButton) e.getSource();
                    String text = src.getText();
                    String text = e.getActionCommand();

                    result.append("성별: " + text + "\n");
                }
            };
             */

            ItemListener listener = new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {
                    if (e.getStateChange() == ItemEvent.SELECTED) {
                        JRadioButton src = (JRadioButton) e.getSource();
                        String text = src.getText();

                        result.append("성별: " + text + "\n");
                    }
                }
            };

            genderMan.addItemListener(listener);
            genderWoman.addItemListener(listener);

            return panel;
        }

        private JPanel panel2() {
            JLabel socialNumber = new JLabel("주민등록번호");
            intro2 = new JTextField(6);
            JLabel hypen = new JLabel(" - ");
            intro3 = new JTextField(7);

            JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            panel.add(socialNumber);
            panel.add(intro2);
            panel.add(hypen);
            panel.add(intro3);

            return panel;
        }

        private JPanel panel3(){
            JLabel addressName = new JLabel("주      소");
            intro4 = new JTextField(22);

            JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            panel.add(addressName);
            panel.add(intro4);

            return panel;
        }

        private JPanel panel4(){
            JLabel departmentName = new JLabel("부  서  명");
            //intro5 = new JTextField(8);
            String[] departments = {"빅데이터", "모바일소프트웨어", "웹공학", "디지털 콘텐츠"};
            department = new JComboBox<>(departments);

            JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            panel.add(departmentName);
            panel.add(department);

            /**
            department.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JComboBox<String> cb = (JComboBox<String>) e.getSource();
                    String text = (String) department.getSelectedItem();
                    //String text = (String)department.getSelectedItem();
                    result.append("부서: " + text + "\n");
                }
            });
             */

            department.addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {
                    if(e.getStateChange() == ItemEvent.SELECTED) {
                        //JComboBox<String> cb = (JComboBox<String>) e.getSource();
                        //String text = (String) department.getSelectedItem();
                        String text = (String) e.getItem();

                        result.append("부서: " + text + "\n");
                    }
                }
            });

            return panel;
        }

        private JPanel panel5(){
            JLabel hobby = new JLabel("취     미");
            //JCheckBox[] hobbies = new JCheckBox[4];
            String[] hobbyValue = {"영화", "음악 감상", "사진", "운동"};
            JCheckBox[] hobbies = new JCheckBox[hobbyValue.length];

            for (int i = 0; i < hobbyValue.length; i++) {
                hobbies[i] = new JCheckBox(hobbyValue[i]);
            }
            JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            panel.add(hobby);

            ItemListener listener = new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {
                    JCheckBox cb = (JCheckBox) e.getSource();
                    //JCheckBox cb = (JCheckBox) e.getItem();
                    String text = cb.getText();

                    result.append("취미: " + text);

                    if(e.getStateChange() == ItemEvent.SELECTED)
                        result.append(" 추가\n");
                    else
                        result.append(" 삭제\n");
                }
            };
            for(JCheckBox hb:hobbies) {
                panel.add(hb);
                hb.addItemListener(listener);
            }
            return panel;
        }

        private JPanel panel6(){
            JLabel introduce = new JLabel("자 기 소 개");
            result = new JTextArea(9, 22);
            result.setEditable(false);

            JPanel panel = new JPanel(new BorderLayout());
            panel.add(introduce, BorderLayout.NORTH);
            panel.add(result, BorderLayout.CENTER);

            return panel;
        }

        private String whatIsGender(){
            String gender = new String();

            if(genderWoman.isSelected()){
                gender = genderWoman.getText();
            } else {
                gender = genderMan.getText();
            }

            return gender;
        }

        private String whatIsYourHobby() {
            String Hobby = new String();

            if(watchMovie.isSelected())
                Hobby += watchMovie.getText() + " ";
            if(listenMusic.isSelected())
                Hobby += listenMusic.getText() + " ";
            if(takePicture.isSelected())
                Hobby += takePicture.getText() + " ";
            if(workOut.isSelected())
                Hobby += workOut.getText() + " ";

            return Hobby;
        }

        private JPanel panel7(){
            final JButton btnSave = new JButton("저장");
            JButton btnExit = new JButton("종료");
            ActionListener listener = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (e.getSource() == btnSave){
                        String text = intro.getText();
                        result.append("이름: " + text + "\n");
                        if(genderMan.isSelected())
                            result.append("성별: 남\n");
                        else
                            result.append("성별: 여\n");

                        String dept = (String)department.getSelectedItem();
                        result.append("부서: " + dept + "\n");
                    } else {
                        System.exit(0);
                    }
                }
            };

            JPanel panel = new JPanel(new FlowLayout());
            panel.add(btnSave);
            panel.add(btnExit);

            btnSave.addActionListener(listener);
            btnExit.addActionListener(listener);
            return panel;
        }
}
