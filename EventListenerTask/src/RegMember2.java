import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegMember2 {
    private JFrame frame;
    JTextField intro;
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

    public RegMember2() {
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
        intro5 = new JTextField(8);

        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel.add(departmentName);
        panel.add(intro5);

        return panel;
    }

    private JPanel panel5(){
        JLabel hobby = new JLabel("취     미");
        watchMovie = new JCheckBox("영화");
        listenMusic = new JCheckBox("음악감상");
        takePicture = new JCheckBox("사진");
        workOut = new JCheckBox("운동");

        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel.add(hobby);
        panel.add(watchMovie);
        panel.add(listenMusic);
        panel.add(takePicture);
        panel.add(workOut);

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
        JButton btnSave = new JButton("저장");
        JButton btnExit = new JButton("종료");

        JPanel panel = new JPanel(new FlowLayout());

        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String introduceMySelf = intro.getText() + "\n"
                        + "(" + whatIsGender() + ")" + "\n"
                        + intro2.getText() + "-" + intro3.getText() + "\n"
                        + intro4.getText() + "\n"
                        + intro5.getText() + "\n"
                        + whatIsYourHobby();

                intro.setText("");
                intro2.setText("");
                intro3.setText("");
                intro4.setText("");
                intro5.setText("");

                result.setText(introduceMySelf);
            }
        });

        panel.add(btnSave);
        panel.add(btnExit);

        return panel;
    }
}
