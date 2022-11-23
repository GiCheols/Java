import javax.swing.*;

public class DrawCircle extends JFrame {
    public DrawCircle(){
        super("원 그리기");

        buildGUI();
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void buildGUI(){
        add(new CircleCanvas());
    }

    public static void main(String[] args) {
        setDefaultLookAndFeelDecorated(true);
        new DrawCircle();
    }
}
