import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class WindowEventTest {
    private JFrame mFrame;

    public WindowEventTest(){
        mFrame = new JFrame("WindowEvent Test");

        mFrame.setSize(300, 200);

        // mFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 닫기 버튼에 대한 행위를 정의해줌, 그러나 닫는 역할만 수행, 부가적인 역할하지 않음
        // ex_ 정말 닫을 것인지 물음 or 저장하고 닫을지 물음
        
        registerEventListener();
        // 따라서 이벤트 리스너 등록하는 메서드
        
        mFrame.setVisible(true);
    }

    private void registerEventListener(){
        // JFrame 에 대한 참조 필요
        mFrame.addWindowListener(mHanler);
    }

    /* 사용되지 않은 이벤트 핸들러 메소드가 많기 때문에 다소 올바르지 않은 방법임
    private WindowListener mHanler = new WindowListener() {
        // 구현되지 않은 리스너가 많음
        @Override
        public void windowOpened(WindowEvent e) {
            
        }

        @Override
        public void windowClosing(WindowEvent e) {
            System.out.println("종료합니다");
            // 창은 닫히더라도 콘솔은 종료되지 않음
            // 실행 시 닫기 버튼을 눌렀을 때 종료합니다라는 문장 출력 == 아직 끝나지 않음
            System.exit(0);
        }

        @Override
        public void windowClosed(WindowEvent e) {

        }

        @Override
        public void windowIconified(WindowEvent e) {

        }

        @Override
        public void windowDeiconified(WindowEvent e) {

        }

        @Override
        public void windowActivated(WindowEvent e) {

        }

        @Override
        public void windowDeactivated(WindowEvent e) {

        }
    };
     */

    private WindowListener mHanler = new WindowAdapter() {
        // 관심 있는 메뉴만 재정의할 수 있도록 Adapter 사용
        @Override
        public void windowClosing(WindowEvent e) {
            System.out.println("종료합니다.");
            System.exit(0);
        }
    };
}
