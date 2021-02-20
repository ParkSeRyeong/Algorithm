package ssafy_0121;

public class EmpEx1 {
	public static void main(String[] args) {
		Emp ob1 = new Emp("kim", "010-1111-1111");
		Emp ob2 = new Emp("lee", "010-2222-2222");
		Emp ob3 = new Emp("park", "010-3333-3333");

		System.out.println(ob1.getName() + "\t" + ob1.getPhone());
		System.out.println(ob2.getName() + "\t" + ob2.getPhone());
		System.out.println(ob3.getName() + "\t" + ob3.getPhone());
	}

}
