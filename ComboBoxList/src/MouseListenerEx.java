import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseListenerEx extends JFrame {
    JLabel la;  // "hello" 문자열을 출력하기 위한 레이블 컴포넌트

    MouseListenerEx() {
        setTitle("Mouse 이벤트 예제");

        buildGUI();

        setSize(200, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void buildGUI() {
        // JPanel contentPane = new JPanel(); 컨텐트팬으로 사용할 패널
        // setContentPane(contentPane); 컨텐트팬 변경

        Container contentPane = this.getContentPane();
        // 프레임 객체에 대해서 참조 얻어서 사용
        contentPane.setLayout(null);    // 컨텐트팬의 배치 관리자 삭제
        // 배치 관리자로 배치하지 않겠다!
        
        contentPane.addMouseListener(new MyMouseListener());
        // 컨텐트 팬에 Mouse 리스너 달기

        la = new JLabel("hello"); // "hello" 레이블 컴포넌트 생성
        la.setSize(50, 20); //레이블의 크기 50*20 설정
        la.setLocation(30, 30); // 레이브의 위치 설정

        contentPane.add(la);    // 레이블 컴포넌트를 컨텐트팬을 추가
    }

    /* 모든 추상 메서드를 재구현해야 하기에 번거로움
    // Mouse 리스너 구현
    class MyMouseListener implements MouseListener {
        public void mouseClicked(MouseEvent e){
            
        }

        @Override
        public void mousePressed(MouseEvent e) {
            int x = e.getX();   // x
            int y = e.getY();   // y
            la.setLocation(x, y);   // 레이블 위치를 (x, y)로 이동
        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }
     */

    class MyMouseListener extends MouseAdapter{
        @Override
        public void mousePressed(MouseEvent e) {
            int x = e.getX();   // x
            int y = e.getY();   // y
            la.setLocation(x, y);   // 레이블 위치를 (x, y)로 이동
        }
    }
}
