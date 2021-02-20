package ssafy_0126.shape;

public class ShapeMain {
	public static void main(String[] args) {
		// 정적 바인딩
		Rectangle obR = new Rectangle(4, 5);
		Triangle obT = new Triangle(3, 7);

		// 동적 바인딩
		Shape ob = new Rectangle(4, 5);
		System.out.println("사각형의 넓이=" + ob.getSize()); // 20

		ob = new Triangle(3, 7);
		System.out.println("삼각형의 넓이=" + ob.getSize()); // 10.5
		// 이 때 아까 참조했던 Rectangle 객체는 Garbage Collection의 대상이 된다!
	}
}
/*
 * 사각형의 넓이: 20 삼각형의 넓이: 10.5
 */