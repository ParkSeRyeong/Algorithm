package ssafy_0129.lambda;

/*
[결과화면]
Java : ver 8.0
Spring : ver 5.0

*/
@FunctionalInterface
interface Ver {
	public String call(String v); // ver 8.0 또는 ver 5.0
}

public class LambdaEx4 {
	public static void main(String[] args) {
//		Item ob=()->"컴퓨터";
//		System.out.println(ob.getItem());

		// s는 내가 입력 넣을 문자열 변수이다
		Ver v = s -> s.equals("java") ? s + " ver 8.0" : s + " ver 5.0";

		System.out.println(v.call("java"));
		System.out.println(v.call("spring"));

	}
}
