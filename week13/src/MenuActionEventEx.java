import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuActionEventEx extends JFrame {
    private JLabel imgLabel = new JLabel(); // 빈 이미지를 가진 레이블

    public MenuActionEventEx(){
        setTitle("Menu 에 Action 리스너 만들기 예제");

        createMenu();   // 추가됨, 메뉴 구성 담당 메서드
        buildGUI();

        setSize(250, 220);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void buildGUI(){
        // getContentPane().add(imgLabel, BorderLayout.CENTER);
        add(imgLabel);
    }

    // 메뉴 아이템 처리 Action 리스너
    class MenuActionListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String cmd = e.getActionCommand();
            // 사용자가 선택한 메뉴 아이템의 문자열 리턴

            switch (cmd){
                //메뉴 아이템의 종류 구분
                case "Load":
                    if(imgLabel.getIcon() != null)
                        return; // 이미 로딩되어 있으면 리턴

                    imgLabel.setIcon(new ImageIcon("images/img.jpg"));
                    break;

                case "Hide":
                    imgLabel.setVisible(false);
                    break;

                case "ReShow":
                    imgLabel.setVisible(true);
                    break;

                case "Exit":
                    System.exit(0);
                    break;
            }
        }
    }

    private void createMenu(){
        // 메뉴바와 Screen 메뉴 생성. Screen 메뉴에 4개의 메뉴아이템 삽입
        JMenuBar mb = new JMenuBar();   //메뉴 바 생성
        this.setJMenuBar(mb);   //메뉴바를 프레임에 부착

        JMenu screenMenu = new JMenu("Screen");
        mb.add(screenMenu); // 메뉴바에 Screen 메뉴 삽입

        JMenuItem [] menuItem = new JMenuItem[4];
        String[] itemTitle = {"Load", "Hide", "ReShow", "Exit"};

        MenuActionListener listener = new MenuActionListener(); //Action 리스너 생성
        
        for(int i = 0; i < menuItem.length; i++){
            menuItem[i] = new JMenuItem(itemTitle[i]);  // 메뉴 아이템 생성
            menuItem[i].addActionListener(listener);    //메뉴 아이템에 Action 리스너 등록
            screenMenu.add(menuItem[i]);    //메뉴 아이템을 Screen 메뉴에 삽입
        }
    }
}