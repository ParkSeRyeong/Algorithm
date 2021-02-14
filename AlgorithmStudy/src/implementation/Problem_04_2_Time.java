package implementation;

import java.io.IOException;
import java.util.Scanner;

public class Problem_04_2_Time {

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.gc();
		long preUseMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

//		BufferedReader는 메모리 사용량이 좀 더 크고, 속도가 더 빠름.
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int N = Integer.parseInt(br.readLine());

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int cnt = 0;

		for (int hour = 0; hour <= N; hour++) {
			for (int min = 0; min < 60; min++) {
				for (int sec = 0; sec < 60; sec++) {

					if((hour/10==3)||(hour%10==3)||(min/10==3)||(min%10==3)||(sec/10==3)||(sec%10==3)) cnt++;
					
					// 그런데 이렇게 문자열로 더해서 연산하는 방법은 코드를 복잡하게 한다고 함 -> 메서드로 따로 빼라던데
					/*String time = Integer.toString(hour) + Integer.toString(min) + Integer.toString(sec);
					if (time.contains("3")) {
						cnt++;
					}*/
				}
			}
		}
		System.out.println("cnt : " + cnt);
		// br.close();
		sc.close();

		System.gc();
		long afterUseMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		System.out.println("메모리 사용량 : " + (preUseMemory - afterUseMemory) / 1024 +"byte");
	}
}


