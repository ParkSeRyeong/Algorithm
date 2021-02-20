package ssafy_0122;

/* 싱글톤 패턴(Singleton Pattern) : 하나의 인스턴트만을 생성하고 사용하는 경우에 쓴다. */
public class Main1 {
	public static void main(String[] args) {
		Speaker1 s1 = new Speaker1();
		Speaker1 s2 = new Speaker1();
		Speaker1 s3 = new Speaker1();

		System.out.println(s1.toString());
		System.out.println(s2.toString());
		System.out.println(s3.toString());

		s1.setVolume(10);
		System.out.println(s1.getVolume());
		System.out.println(s2.getVolume());
		System.out.println(s3.getVolume());

		s2.setVolume(20);
		System.out.println(s1.getVolume());
		System.out.println(s2.getVolume());
		System.out.println(s3.getVolume());
	}
}
