package ssafy_0122;

class Test {
	int x;
	int y;
	static int z;
	
	static {
		// 이 부분은 단 한 번만 호출된다!
		System.out.println("static의 초기화 영역");
	}

	public Test(int x, int y, int z1) {
		this.x = x;
		this.y = y;
		z = z1;
		System.out.println("객체의 초기화 영역");
	}

	public void view() {
		System.out.println(x + " " + y + " " + z);
	}
}

public class StaticEx1 {
	public static void main(String[] args) {
		Test ob1 = new Test(1, 2, 3);
		Test ob2 = new Test(5, 6, 7);
		ob1.view(); //
		ob2.view(); //
	}
}