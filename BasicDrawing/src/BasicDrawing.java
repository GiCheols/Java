import javax.swing.*;
import java.awt.*;

public class BasicDrawing extends JFrame {
    public BasicDrawing(){
        super("LogicalFontTestCanvas");

        buildGUI();
        setLocation(500, 200);
        setSize(400, 300);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void buildGUI() {
        BasicCanvas drawingCanvas = new BasicCanvas();
        add(drawingCanvas);
    }

    class BasicCanvas extends JComponent{

        /*그냥 직선 하나 그리기
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            // 기존 컴포넌트가 처리할 내용을 그리는 내용

            g.drawLine(0, 0, 100, 50);
            // (0, 0) ~ (100, 50)까지 선분을 그림
        }
        */

        /* 화면에 글씨 쓰고 밑줄 치기
        static final int x = 150;
        static final int y = 100;
        @Override
        public void paint(Graphics g) {
            g.drawString("Hello, World", x, y);
            g.drawLine(x - 3, y + 10, x + 70, y + 10);
        }
        */

        /*
        @Override
        public void paint(Graphics g) {
            g.drawRect(100, 110, 200, 40);
            g.drawRect(150, 70, 100, 40);
            // 원의 경우 (x, y)좌표에 (w, h)사각형을 그리고 내접하는 원을 그림
            g.drawOval(125, 150, 30, 30);
            g.drawOval(245, 150, 30, 30);
            g.drawLine(50, 180, 350, 180);
        }
        */


        public void paint(Graphics g) {
            Color c = new Color(255, 0, 0, 128);
            g.setColor(c);
            // g.drawRect => fillRect 로 변경해 색 채우기
            g.fillRect(100, 110, 200, 40);
            g.fillRect(150, 70, 100, 50);
            // 원의 경우 (x, y)좌표에 (w, h)사각형을 그리고 내접하는 원을 그림
            g.setColor(Color.BLACK);
            // g.drawOval => fillOval 로 변경해 색 채우기
            g.fillOval(125, 150, 30, 30);
            g.fillOval(245, 150, 30, 30);
            g.drawLine(50, 180, 350, 180);
        }
    }

    class LogicalFontTestCanvas extends JComponent {
        Font[] font = new Font[5];

        LogicalFontTestCanvas() {
            font[0] = new Font("Serif", Font.PLAIN, 20);
            font[1] = new Font("SansSerif", Font.PLAIN, 20);
            font[2] = new Font("Monospaced", Font.PLAIN, 20);
            font[3] = new Font("Dialog", Font.PLAIN, 20);
            font[4] = new Font("DialogInput", Font.PLAIN, 20);
        }

        @Override
        public void paint(Graphics g) {
            for(int i = 0; i < font.length; i++) {
                g.setFont(font[i]);
                g.drawString("ABCDEFGHIJKLMNOPQRSTUVWXYZ", 10, 50+20 * i);
            }
        }
    }

    class ImageCanvas extends JComponent{
        Image img = Toolkit.getDefaultToolkit().getImage("image1.gif");

        @Override
        public void paint(Graphics g) {
            g.drawImage(img, 50, 100, this);
            g.drawImage(img, 200, 100, 100, 100, this);
        }
    }

    public static void main(String[] args) {
        new BasicDrawing();
    }
}
