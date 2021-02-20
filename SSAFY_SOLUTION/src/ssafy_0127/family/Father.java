package ssafy_0127.family;

public class Father extends Family implements Job {

	String name;

	public Father() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Father(String name) {
		super();
		this.name = name;
	}

	@Override
	public String work() {
		return "아빠는 나가서 일을 한다";
	}

	@Override
	public String toString() {
		return super.toString() + name + "\n" + work() + "\n";
	}

}
