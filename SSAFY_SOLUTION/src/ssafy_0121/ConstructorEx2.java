package ssafy_0121;

public class ConstructorEx2 {


	public ConstructorEx2() {
		this("가나다", 10);
		System.out.println("default constructor");
	}

	public ConstructorEx2(String str) {
		System.out.println(str + " constructor");
	}

	public ConstructorEx2(String str, int n) {
		this(str);
		System.out.println(str + "  " + n + " constructor");
	}

	public static void main(String[] args) {
		new ConstructorEx2();
	}

}
	/*
	 * public ConstructorEx2() {
	 * 
	 * System.out.println("생성자 짜란"); } public ConstructorEx2(String str) { this();
	 * System.out.println("문자열 생성자 짜란"); } public ConstructorEx2(String string, int
	 * i) { this(string); System.out.println("문지열+정수 생성자 짜란"); } public static void
	 * main(String[] args) { new ConstructorEx2("가나다", 10); //스택에 주소를 저장하지 않고, 힙에
	 * 메모리만 할당하는 상태! }
	 */