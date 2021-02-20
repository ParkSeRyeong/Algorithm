package ssafy_0129.lambda;

@FunctionalInterface
interface Function {
	public double size(int r);

	default int size(int a, int b) {
		return a * b;
	}

	default double size(int a, int b, int c) {
		return (double) (a + b) / 2 * c;
	}
}

public class LambdaEx6 {
	public static void main(String[] args) {
		Function m = (r) -> r * r * 3.14;

		System.out.println("원의 넓이 : "+m.size(5));
		System.out.println("사각형의 넓이 : " + m.size(4, 5));
		System.out.println("사다리꼴의 넓이 : " + m.size(3, 6, 7));
	}

}

/*
 * Function m1 = (a, b) -> a + b; Function m2 = (a, b) -> a - b;
 * 
 * int m3 = m1.calc(10, 20) + m2.calc(30, 40); System.out.println("결과 : " + m3);
 */
