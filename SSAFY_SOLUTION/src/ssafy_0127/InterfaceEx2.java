package ssafy_0127;

// 인터페이스 ------------------------------------------
interface Cryable {
	abstract public void cry();
}

interface Flyable {
	abstract public void fly();
}

class Eagle implements Cryable, Flyable {
	@Override
	public void fly() {
		System.out.println("독수리는 날아 다닙니다");
	}

	@Override
	public void cry() {
		System.out.println("캬악~~캬악~~~");
	}

}

public class InterfaceEx2 {
	public static void main(String[] args) {
		new Eagle().fly();
		new Eagle().cry();
	}
}

//추상클래스--------------------------------------------
/*abstract class Cryable {
	abstract public void cry();
}

abstract class Flyable {
	abstract public void fly();
}

class Eagle extends Flyable {
	@Override
	public void fly() {
		System.out.println("독수리는 날아 다닙니다");
		new CryableEx().cry();
	}

	// 중첩클래스(inner class): 클래스 안에서 또 다른 클래스를 정의하는것
	// InterfaceEx2.java --> InterfaceEx2.class, Cryable.class, Flyable.class
	// Eable.class, Eagle$CryableEx.class
	class CryableEx extends Cryable {
		@Override
		public void cry() {
			System.out.println("캬약~~캬약~~~");
		}
	}
}

public class InterfaceEx2 {
	public static void main(String[] args) {
		new Eagle().fly();
	}
}*/