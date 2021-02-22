package ssafy_algo_0221;

public class Exam04_exception {
	public static void main(String[] args) throws MyException {
		Program a = new Program();
		try {
			a.plus(3, 5);
		} catch (MyException e) {
			System.out.println("사용자 예외처리 발생!");
		}
	}
}
