package ssafy_0127;

class AAA {
}

class BBB extends AAA {
}

class CCC extends AAA {
}

public class InstanceofEx1 {
	public static void main(String[] args) {
		AAA a = new AAA();
		BBB b = new BBB();

		System.out.println(b instanceof AAA); //
		System.out.println(a instanceof CCC); //
		//System.out.println(b instanceof CCC); //
	}
}