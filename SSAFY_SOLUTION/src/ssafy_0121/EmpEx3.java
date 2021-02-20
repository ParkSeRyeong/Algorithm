package ssafy_0121;

public class EmpEx3 {
	public static void main(String[] args) {
		Emp[] ob = new Emp[] { new Emp("kim", "010-1111-1111"), 
				new Emp("lee", "010-2222-2222"),
				new Emp("park", "010-3333-3333") };
		for (Emp e : ob) {
			System.out.println(e.getName() + "\t" + e.getPhone());
		}
	}
}
