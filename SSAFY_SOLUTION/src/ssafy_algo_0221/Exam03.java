package ssafy_algo_0221;

class Branch {
	public Branch() {
		System.out.println("Branch Default Constructor");
	}

	public Branch(String str, int n) {
		this();
		System.out.println(str + " " + n + " " + "Branch Constructor");
	}
}

class Leaf extends Branch {

	public Leaf() {
		this("ABC");
		System.out.println("Leaf Default Constructor");
	}

	public Leaf(String str) {
		super(str, 10);
		System.out.println(str + " Leaf Constructor");
	}

}

public class Exam03 {
	public static void main(String[] args) {
		new Leaf();
	}
}
