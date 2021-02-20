package ssafy_0125;

class SuperEx {
	public void view() {
		System.out.println("view1 method");
	}
}

class SubEx extends SuperEx {
	public void view() {
		super.view();
		System.out.println("view2 method");
	}
}

public class InheritanceEx1 {
	public static void main(String[] args) {
		SubEx ob = new SubEx();
		ob.view();
	}
}

//---------------------------------------------------

/*class SuperEx {
	public void view1() {
		System.out.println("view1 method");
	}
}

class SubEx extends SuperEx {
	public void view2() {
		System.out.println("view2 method");
	}
}

public class InheritanceEx1 {
	public static void main(String[] args) {
		SubEx ob = new SubEx();
		ob.view1();
		ob.view2();
	}
}
*/