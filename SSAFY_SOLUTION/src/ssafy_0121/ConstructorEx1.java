package ssafy_0121;

public class ConstructorEx1 {
	public ConstructorEx1() {
		System.out.println("생성자 짜란");
	}
	public ConstructorEx1(String str) {
		System.out.println("인수 받는 생성자 짜란");
	}
	public ConstructorEx1(String string, int i) {
		System.out.println("인수가 두개인 생성자 짜란");
	}
	public static void main(String[] args) {
		new ConstructorEx1();
		new ConstructorEx1("가나다");
		new ConstructorEx1("가나다", 10);
		//스택에 주소를 저장하지 않고, 힙에 메모리만 할당하는 상태!
	}
}
