package ssafy_0122;

public class ConstructorEx5 {

	public ConstructorEx5() {
		System.out.println("default constructor");
	}

	public ConstructorEx5(String str) {
		this(str, 10);
		System.out.println(str + " constructor");
	}

	public ConstructorEx5(String str, int n) {
		this();
		System.out.println(str + " " + n + " constructor");
	}

	public static void main(String[] args) {
		new ConstructorEx5("가나다");
	}
}
