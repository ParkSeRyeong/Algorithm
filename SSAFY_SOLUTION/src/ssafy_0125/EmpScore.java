package ssafy_0125;

public class EmpScore extends Emp {
	private double score;
	private char grade;

	public EmpScore() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmpScore(String name, String phone, double score, char grade) {
		super(name, phone);
		this.score = score;
		this.grade = grade;
	}

	@Override
	public String toString() {
		//부모의 toString도 가져오려면 그것도 super.toString으로 받아와야한다!
		return super.toString() + "\n나의 점수는 " + grade + "이고 학점은 " + grade + "입니다.";
	}

}
