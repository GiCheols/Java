import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class CircleCanvas extends JComponent {
    int x, y;
    ArrayList<Point> pointLists = new ArrayList<>();

    @Override
    public void paint(Graphics g) {
        // 해당 컴포넌트가 가시화 되었을 때 자동으로 호출됨
        g.setColor(new Color(255, 0, 0));
        for(Point n : pointLists)
            g.fillOval(n.x - 25, n.y - 25, 50, 50);
    }

    private void registerEvent() {
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                x = e.getX();
                y = e.getY();

                pointLists.add(new Point(x, y));

                repaint();
            }
        });
    }

    public CircleCanvas() {
        registerEvent();
    }
}
