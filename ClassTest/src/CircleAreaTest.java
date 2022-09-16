import java.util.Scanner;

public class CircleAreaTest {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		/**
		 * Scanner 객체 사용 위해 java.util.Scanner를 import함 = (ctrl + shift+ O)
		 */
		
		System.out.print("반지름은? ");
		double radius = s.nextDouble();
		
		Circle c = new Circle();
		c.setRadius(radius);
		
		double area = c.getArea();
		
		System.out.print("반지름 " + c.getRadius() + "인");
		System.out.println("원의 넓이는 "+ area + "입니다.");
	}
}
