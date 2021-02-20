package ssafy_0129.lambda;

// ------------------------ 람다식 형태 -------------------------------
public class LambdaEx1 {

	public static void main(String[] args) {
		Print m=()->System.out.println("Hello Lambda");
		m.view1();
	}
}

// ------------ 익명 중첩메서드 형태 (Anonymous inner Class) ------------
/*public class LambdaEx1 {

	public static void main(String[] args) {

		// 아앗 인터페이스로는 자기 자신의 객체를 못 만든당...!
		// Print m=new Print();	--> 빨간 줄ㅠ

		// 그럼 이렇게 해야징
		Print m = new Print() {

			@Override
			public void view() {
				System.out.println("Hello Lambda");
			}
		};
		m.view();
	}
}*/

// ------------------------ 일반 메서드 형태 ---------------------------------
/*
public class LambdaEx1 implements Print {

	@Override
	public void view1() {
	}
//
//	@Override
//	public void view2() {
//	}	
	
	public static void main(String[] args) {
		new LambdaEx1().view1();
	}
}
*/