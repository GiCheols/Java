public class RectangleTest {
    public static void main(String[] args) {
        Point point1 = new Point(10, 10);
        Point point2 = new Point(30, 20);
        Rectangle rect1 = new Rectangle(point1, point2);

        int width = rect1.setRectWidth();
        int height = rect1.setRectWidth();

        int cumfer = rect1.rectCumference(width, height);
        int area = rect1.rectArea(width, height);

        System.out.print("Point 1의 좌표 (" + point1.getPointX() + ", " + point1.getPointY() + "), ");
        System.out.print("Point 2의 (" + point2.getPointX() + ", " + point2.getPointY() + ")인 ");
        System.out.println("사각형의 \n둘레는" + cumfer);
        System.out.println("넓이는 " + area);
    }
}
