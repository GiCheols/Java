
public class Circle {
	static final double PI = 3.141592;
	/**
	 * static: 모든 함수가 접근할 수 있는
	 * final: 더 이상 바꿀 수 없는 == "상수"(C의 const char와 유사)
	 */
	double r;
	
	void setRadius(double r) {
		this.r = r;
	}
	
	double getRadius() {
		return r;
	}
	
	double getArea() {
		return r * r * PI;
	}
}