package ssafy_0125;

public class EmpMain {
public static void main(String[] args) {
	Emp ob1=new Emp("이순신", "010-1111-1111");
	System.out.println(ob1.toString());
	
	EmpScore ob2 = new EmpScore("강호동", "010-1234-5678", 75.3, 'C');
	System.out.println(ob2.toString());
}
}
