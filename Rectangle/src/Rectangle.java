
public class Rectangle {
	Point leftTop, rightBottom;
		
	Rectangle(Point a, Point b){
		this.leftTop = a;
		this.rightBottom = b;
	}

	int rectWidth(){
		return rightBottom.x - leftTop.x;
	}

	int rectHeight() {
		return rightBottom.y - leftTop.y;
	}

	int rectCumference(int a, int b) {
		return 2*(a+b);
	}
	
	int rectArea(int a, int b) {
		return a*b;
	}
}
