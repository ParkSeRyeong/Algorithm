package ssafy_0121;

//Setter & Getter: 필드(멤버변수) 하나당 하나씩 값을 대입하는 setter와 그 값을 리턴하는 getter
class Member {
	public String name;
	public int age;
	public double tall;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getTall() {
		return tall;
	}

	public void setTall(double tall) {
		this.tall = tall;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

public class ObjectEx3 {
	public static void main(String[] args) {
		Member ob = new Member();
		ob.setName("전원우");
		ob.setAge(26);
		ob.setTall(182.0);

		System.out.println("이름 : " + ob.getName());
		System.out.println("나이 : " + ob.getAge());
		System.out.println("키 : " + ob.getTall() + "cm");
	}
}
