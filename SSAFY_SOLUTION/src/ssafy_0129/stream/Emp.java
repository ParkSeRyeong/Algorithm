package ssafy_0129.stream;


public class Emp{
	private String name;
	private int age;
	private double score;
	
	public Emp() {
		super();
	}
	public Emp(String name, int age, double score) {
		super();
		this.name = name;
		this.age = age;
		this.score = score;
	}
	@Override
	public String toString() {
		return name+" "+age+" "+score;
	}
}
