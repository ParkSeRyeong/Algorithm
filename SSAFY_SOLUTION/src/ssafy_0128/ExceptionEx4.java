package ssafy_0128;

class MyException extends Exception {
	public MyException() {
		System.out.println("Not Alphabet");
	}
}

public class ExceptionEx4 {

	public static void main(String[] args) {
		char alpa = args[0].charAt(0);

		if (alpa >= 'A' && alpa <= 'Z') {
			System.out.println(alpa + "는 소문자로 " + (char) (alpa + 32) + "입니다");
		} else if (alpa >= 'a' && alpa <= 'z') {
			System.out.println(alpa + "는 대문자로 " + (char) (alpa - 32) + "입니다");
		} else {
			//throw new MyException();
		}

	}

}