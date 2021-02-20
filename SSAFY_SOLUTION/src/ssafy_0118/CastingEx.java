package ssafy_0118;

public class CastingEx {
	public static void main(String[] args) {

		int salary=857650;
		double tax=0.033;
		int result=(int)(salary*(1-tax));
		
		System.out.println("세금을 제외한 급여:" + result); // 829348
		
		//		int k=87, e=88, m=75;
//        int tot=k+e+m;
//        double avg1=tot/3.0;	// 자동 형변환
//        double avg2=(double)tot/3; // 강제형변환   
//        
//        System.out.printf("평균:%.2f\n", avg2);
		
//		byte a = 100;
//		int b = a;
//		// byte < int 라서 변환 가능.
//
//		double c = 74.35;
//		// int d=c;
//		// int < double이라서 변환 불가능.
//		int d = (int) c;
//		// 그래서 강제 형변환
//
//		System.out.println(a + " " + b);
//		System.out.println(c + " " + d);
//		// 대신 소수점 뒷자리가 잘
	}
}
