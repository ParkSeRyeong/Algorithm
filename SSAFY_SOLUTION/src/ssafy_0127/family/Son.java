package ssafy_0127.family;

public class Son extends Family implements Job {

	String name;

	@Override
	public String work() {
		return "아들은 공부를 한다";
	}

	public Son() {
	}

	public Son(String name) {
		super();
		this.name = name;
	}

	@Override
	public String toString() {
		return super.toString() + name + "\n" + work() + "\n";
	}
}
