package ssafy_algo_0221;

class AA {
	int a;
	char b;
	String c;

	public AA() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AA(int a) {
		super();
		this.a = a;
	}

	public AA(int a, char b, String c) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;
	}

	@Override
	public String toString() {
		return super.toString();
	}
}

class BB {
	int a;

	public BB() {
	}

}

class CC extends BB {

	int b;

	public CC() {
	}
}

public class Exam01 {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		AA test1 = new AA();
		AA test2 = new AA(37);
		AA test3 = new AA(25, 'F', "SR");

	}
}
