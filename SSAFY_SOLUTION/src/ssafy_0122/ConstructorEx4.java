package ssafy_0122;

/*기본생성자(default constructor)
-생성자가 구현되어 있지 않으면 자동 생성된다
-생성자가 1개라도 구현되어 있으면 기본생성자는 자동생성이 안된다
*/
class Member {
	private String name = "kim";
	private int age = 25;

	public Member() {
	} // default 생성자는 쓰든 안 쓰든 만들어놓는게 좋음

	public Member(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public void view() {
		System.out.println(name + " " + age);
	}

}

public class ConstructorEx4 {

	public static void main(String[] args) {
		Member ob1 = new Member("홍길동", 27);
		ob1.view();
		Member ob2 = new Member();
		ob2.view();
	}
}
