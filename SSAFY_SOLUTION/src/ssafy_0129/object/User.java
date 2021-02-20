package ssafy_0129.object;

import java.io.Serializable;

class User implements Serializable {	//객체 직렬화(한줄만 써주면 됨)
	private String name;
	private int age;
	private double score;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String name, int age, double score) {
		super();
		this.name = name;
		this.age = age;
		this.score = score;
	}

	public void disp() {
		System.out.print("이름 : " + name);
		System.out.print("\t나이 : " + age);
		System.out.println("\t점수 : " + score);
	}
}
