package ssafy_0122;

public class ObjectEx {
	String name = "전원우";

	public ObjectEx() {
		super();
	}

	public void view() {
		System.out.println(name);
	}

	public static void main(String[] args) {
		ObjectEx ob = new ObjectEx();
		ob.view();
	}
}

/*
 * import java.lang.System; import java.lang.String;
 * 
 * public class ObjectEx { String name = "전원우";
 * 
 * public ObjectEx() { super(); }
 * 
 * public void view() { System.out.println(name.toString()); }
 * 
 * public static void main(String[] args) { ObjectEx ob = new ObjectEx();
 * ob.view(); } }
 */
