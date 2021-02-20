package ssafy_0127;

interface Shape1 {
	int r = 10; // final 생략가능

	public void draw();

	public void erase(); // abstract도 생략 가능!
}

class Circle1 implements Shape1 {
	@Override
	public void draw() {
		System.out.println("반지름이 " + r + "인 원을 그린다");
	}

	@Override
	public void erase() {
		System.out.println("원을 지운다");
	}

}

public class InterfaceEx1 {
	public static void main(String[] args) {
		Circle1 ob = new Circle1();
		ob.draw();
		ob.erase();
	}
}

/*
 * abstract class Shape1 { final int r = 10;
 * 
 * abstract public void draw();
 * 
 * abstract public void erase(); }
 * 
 * class Circle1 extends Shape1 {
 * 
 * @Override public void draw() { System.out.println("반지름이 " + r + "인 원을 그린다");
 * }
 * 
 * @Override public void erase() { System.out.println("원을 지운다"); }
 * 
 * }
 * 
 * public class InterfaceEx1 { public static void main(String[] args) { Circle1
 * ob = new Circle1(); ob.draw(); ob.erase(); } }
 */