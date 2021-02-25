package ssafy_algo_0221;

public class Program {
	public Program() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void plus(int a, int b) throws MyException {
		if (a + b > 10) {
			System.out.println(a + b);
		} else {
			throw new MyException();
		}
	}

}
