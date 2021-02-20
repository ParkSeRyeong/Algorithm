package ssafy_0129.lambda;

@FunctionalInterface
// 함수 여러 개를 못 넣게 해주는 어노테이션...!
// 람다식을 적용할 클래스/인터페이스에는 함수가 꼭 하나만 있어야한다

public interface Print {	// 자바 함수형 Interface, 람다식으로 사용할 것을 선언.
	public void view1();	// 함수는 반드시 1개만 구현할 수 있다.
	//public void view2();
	
}
