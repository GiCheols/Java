import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Vibration1 {
    JFrame frame;
    JButton btn;
    Thread thread;

    private Vibration1(){
        frame = new JFrame("Vibration");

        buildGUI();

        frame.setSize(200,200);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private void buildGUI(){
        btn = new JButton("진동시작");
        frame.add(btn);

        btn.addActionListener(handler);
    }

    private ActionListener handler = new ActionListener() {
        private boolean cont = true;
        private int offset = 10;

        /* frame 의 현재 위치값을 가져와서 반전시켜주는 함수, 클릭시 좌우로 흔들리는 효과
        public void actionPerformed(ActionEvent e) {
            String s = e.getActionCommand();

            frame.setLocation(frame.getLocation().x + offset, frame.getLocation().y);

            offset = -offset;
        }*/

        /*
        @Override
        public void actionPerformed(ActionEvent e) {
            String s = e.getActionCommand();
            if(s.equals("진동시작")){
                // 진동처리
                // 버튼의 텍스트를 바꾸기는 했지만 아직 화면을 갱신하지 못함
                btn.setText("진동끝");
                // cont 변수를 바꿀 수 없기 때문에 반복문을 탈출하지 못함
                while (cont){
                    // 따라서 버튼을 누르지 못함, 강제로 중지해야 함
                    frame.setLocation(frame.getLocation().x + offset, frame.getLocation().y);

                    offset = -offset;
                    try {
                        Thread.sleep(100);
                    }catch (InterruptedException e1){
                        
                    }
                }
                
            } else {
                // 진동 멈춤 처리
                btn.setText("진동시작");
                cont = false;
            }
        }*/
        
        @Override
        public void actionPerformed(ActionEvent e) {
            String s = e.getActionCommand();
            if (s.equals("진동시작")) {
                btn.setText("진동 끝");

                /* 사용자 정의 thread 추가
                thread = new vibrationThread();
                thread.start();
                 */

                /* 사용자 정의 Runnable 클래스 생성
                thread = new Tnread(new VibrationRunnable());
                thread.start();
                 */

                // 명시적으로 생성하는 것이 아닌
                thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while(thread == Thread.currentThread()) {
                            frame.setLocation(frame.getLocation().x + offset, frame.getLocation().y);

                            offset = -offset;

                            try {
                                Thread.sleep(100);
                            } catch (InterruptedException e1) { }
                        }
                    }
                });
                thread.start();
            }else {
                btn.setText("진동시작");
                thread = null;
            }
        }
    };

    /** 사용자 정의 Runnable 클래스
    class VibrationRunnable implements Runnable {
        private int offset = 10;
        @Override
        public void run() {
            while (thread == Thread.currentThread()) {
                frame.setLocation(frame.getLocation().x + offset, frame.getLocation().y);

                offset = -offset;

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e1) {
                }
            }
        }
    }*/

    /** 사용자 정의 Thread 추가
    class VibrationThread extends Thread{
        private int offset = 10;
        @Override
        public void run() {
        // Thread 가 현재 자기 자신이라면 반복
        // null 값이면 자기자신이 Thread 가 아님을 확인하고 반복문 탈출
            while (thread == Thread.currentThread()){
                frame.setLocation(frame.getLocation().x + offset, frame.getLocation().y);

                offset = -offset;

                // 지연취소
                try {
                    Thread.sleep(100);
                }catch (InterruptedException e1){

                }
            }
        }
    }*/

    public static void main(String[] args) {
        new Vibration1();
    }
}
