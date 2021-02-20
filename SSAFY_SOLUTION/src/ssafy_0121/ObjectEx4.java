package ssafy_0121;

public class ObjectEx4 {
	public static void main(String[] args) {
		// [문제1] Employee 객체 ob를 생성하고 setter를 이용해서 데이터를 넣으시오
		// 출력은 ob.toString()을 이용해서 작성하시오
		Employee ob = new Employee();
		ob.setDept("경영전략팀");
		ob.setName("전원우");
		ob.setPay(400);
		ob.setScore(96.717);
		System.out.println(ob.toString());

		// [문제2] ob.setEmployee()를 이용해서 데이터를 넣으시오
		// 출력은 getter를 이용해서 작성하시오
		ob.setEmployee("전원우", "경영전략팀", 400, 96.717);
		System.out.println("사원 이름: " + ob.getName() + " / 근무부서: " + ob.getDept() + " / 급여: " + ob.getPay() + "만원 / 입사성적: "
				+ ob.getScore() + "점");
	}
}
/*
 * [문제1] 이름은 이순신이고 개발부에 근무하며 급여는 1500000원 입사성적은 85.75입니다
 * 
 * [문제2] 사원이름 : 진달래 근무부서 : 경리부 받는급여 : 1200000원 입사점수 : 75.34점
 */
