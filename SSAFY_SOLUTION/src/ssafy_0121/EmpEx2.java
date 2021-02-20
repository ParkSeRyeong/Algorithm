package ssafy_0121;

public class EmpEx2 {
	public static void main(String[] args) {
		Emp[] ob=new Emp[3];
		ob[0] = new Emp("kim", "010-1111-1111");
		ob[1] = new Emp("lee", "010-2222-2222");
		ob[2] = new Emp("park", "010-3333-3333");

		for(int i=0;i<ob.length;i++) {
			System.out.println(ob[i].getName() + "\t" + ob[i].getPhone());
		}
	}
}
