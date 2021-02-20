package ssafy_0128;

// run as 하기 전에 꼭 실행 한 번 그냥 시켜주기!
public class ExceptionEx1 {
	public static void main(String[] args) {
		int val = 5;
		
		try {
	         int n=Integer.parseInt(args[0]);
	         System.out.println(val/n);
	      }catch(Exception e) {
	         System.out.println("입력값에 오류 있음");
	      }
		
/*
		try {
			int n = Integer.parseInt(args[0]);
			System.out.println(val / n);
		} catch (NumberFormatException e) {
			System.out.println("숫자로 바꿀 수 없음!");
		} catch (ArithmeticException e) {
			System.out.println("0으로 나눌 수 없음!");
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("입력 값이 없음");
		} finally {
			System.out.println("** 무조건 실행 **");
			// JAVA에서 DB를 연동하고, 끝나면 연결 객체를 해제시켜줘야한다.
			// 그 연결 해제를 finally에 해놓는다. 무조건 필요!
		}*/
	}
}
