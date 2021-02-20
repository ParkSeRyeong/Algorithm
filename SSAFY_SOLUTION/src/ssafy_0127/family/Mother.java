package ssafy_0127.family;

public class Mother extends Family implements Job {

	String name;

	public Mother() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Mother(String name) {
		super();
		this.name = name;
	}

	@Override
	public String work() {
		return "엄마는 집안일을 한다";
	}

	@Override
	public String toString() {
		return super.toString() + name + "\n" + work() + "\n";
	}

}