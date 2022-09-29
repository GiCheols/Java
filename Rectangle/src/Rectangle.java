
public class Rectangle {
    private Point leftTop;
    private Point rightBottom;

    public Rectangle(Point a, Point b) {
        this.leftTop = a;
        this.rightBottom = b;
    }

    public int setRectWidth() {
        return rightBottom.getPointX() - leftTop.getPointX();
    }

    public int setRectHeight() {
        return rightBottom.getPointY() - leftTop.getPointY();
    }

    public int rectCumference(int a, int b) {
        return 2 * (a + b);
    }

    public int rectArea(int a, int b) {
        return a * b;
    }
}
