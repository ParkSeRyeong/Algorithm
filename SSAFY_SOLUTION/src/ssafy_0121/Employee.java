package ssafy_0121;

/* -name:String                    
 * -dept:String 
 * -pay:int
 * -score:double
 * 
 * +setName(name:String):void
 * +setDept(dept:String):void
 * +setPay(pay:int):void 
 * +setScore(score:double):void
 * +getName():String
 * +getDept():String
 * +getPay():int
 * +getScore():double
 * 
 * +setEmployee(name:String, dept:String, pay:int, score:double):void
 * +toString():String 
 */
public class Employee {
	private String name;
	private String dept;
	private int pay;
	private double score;

	public void setEmployee(String name, String dept, int pay, double score) {
		this.dept = dept;
		this.name = name;
		this.pay = pay;
		this.score = score;
	}

	public String toString() {
		return "이름은 " + name + "고, " + dept + "에서 근무하며 급여는 " + pay + "만원, 입사성적은 " + score + "점입니다.";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public int getPay() {
		return pay;
	}

	public void setPay(int pay) {
		this.pay = pay;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

}
