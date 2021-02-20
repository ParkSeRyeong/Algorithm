package ssafy_0125;

class Branch {
	public Branch() {
		System.out.println("Branch default constructor");
	}

	public Branch(int n) {
		this();
		System.out.println(n + "Branch constructor");
	}

}

class Leaf extends Branch {
	public Leaf() {
		this("가나다", 10);
		System.out.println("Leaf default constructor");
		
	}

	public Leaf(String str, int n) {
		super(n);
		System.out.println(str + n + " Leaf constructor");
	}
}

public class InheritanceEx3 {
	public static void main(String[] args) {
		new Leaf();
	}
}

// --------------------------------------------------
/*
 * class Branch { public Branch() {
 * System.out.println("Branch Default Constructor"); } public Branch(String str)
 * { this(); System.out.println(str + " Branch Constructor"); }
 * 
 * 
 * }
 * 
 * class Leaf extends Branch { public Leaf(String str) { super(str);
 * System.out.println(str+" Leaf Constructor"); } }
 * 
 * public class InheritanceEx3 { public static void main(String[] args) { new
 * Leaf("가나다"); } }
 */