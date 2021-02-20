package ssafy_0122;

public class OverloadEx {
	int a = 20;
	int b = 15;

	public int max() {
		return (a > b) ? a : b;
	}

	public int max(int a, int b) {
		return (a > b) ? a : b;
	}
	

	public static void main(String[] args) {
		OverloadEx ob = new OverloadEx();
		System.out.println("큰수 : " + ob.max());
		System.out.println("큰수 : " + ob.max(30,50));
		//System.out.println("큰수 : " + ob.max('Z','B'));
	}
}
