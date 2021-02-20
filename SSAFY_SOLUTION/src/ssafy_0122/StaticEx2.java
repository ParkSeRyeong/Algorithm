package ssafy_0122;

public class StaticEx2 {

	public static void main(String[] args) {
		System.out.println("** 입금 당시의 금리 **");
		BankAccount ob1 = new BankAccount(1994, "kim", 1000, 0.07);
		ob1.view();
		BankAccount ob2 = new BankAccount(1998, "lee", 1000, 0.12);
		ob2.view();
		BankAccount ob3 = new BankAccount(2005, "park", 1000, 0.05);
		ob3.view();

		System.out.println("** 2005년 현재의 금리 **");
		ob1.view();
		ob2.view();
		ob3.view();

		// static 변수에 접근하는 방법 >> private니까 접근 당장 못 함.
		// ~is not visible >> 접근할 수 없다!
		//BankAccount.rate = 0.04;
		BankAccount.setRate(0.4);
		
		System.out.println("** 0.04로 변동된 금리 **");
		ob1.view();
		ob2.view();
		ob3.view();

	}
}
