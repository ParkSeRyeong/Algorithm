package ssafy_0125;

public class Emp {
	private String name;
	private String phone;

	public Emp() {
		super();
	}

	public Emp(String name, String phone) {
		super();
		this.name = name;
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "나의 연락처는 " + this.name + "이고 연락처는 " + this.phone + "입니다.";
	}

	
}
