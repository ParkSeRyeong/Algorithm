package ssafy_0118;

public class DigitTest1 {
	public static void main(String[] args) {
		int count=0;
		for (int i = 0; i < 5; i++) {

			for (int j = 0; j < 5; j++) {
				if (j < i) {
					System.out.printf("%3s", " ");
					// i가 j보다 크면 그만큼 공백을 채워주겠다는 의미
					// 저 3은 자리수를 의미.
					// %3s는, 3칸의 공간을 차지해달라는 뜻. 문자열을 의미.
				} else {
					System.out.printf("%3d", ++count);
				}
			}
			System.out.println();

		}
	}
	
}
