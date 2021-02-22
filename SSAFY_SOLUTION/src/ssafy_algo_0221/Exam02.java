package ssafy_algo_0221;

public class Exam02 {
	public static void main(String[] args) {
		String str = "ABC";

		try {
			System.out.println(Integer.parseInt(str));
		} catch (Exception e) {
			System.out.println("안돼!");
		}

		int a = 3;
		int b = 0;
		try {
			System.out.println(a / b);
		} catch (ArithmeticException e) {
			System.out.println("0으로 나눌 수 없음");
		}

		int[] arr = { 1, 2, 3, 4, 5 };
		try {
			for (int i = 0; i < 10; i++) {
				System.out.println(arr[i]);
			}
		} catch (Exception e) {
			System.out.println("배열 범위 초과");
		}
	}
}
