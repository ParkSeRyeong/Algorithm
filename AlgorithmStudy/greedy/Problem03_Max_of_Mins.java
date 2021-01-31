package greedy;

import java.util.Arrays;
import java.util.Scanner;

public class Problem03_Max_of_Mins {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		
		// 입력 받기
		System.out.print("행 : ");
		int n = sc.nextInt();
		System.out.println("열 : ");
		int m = sc.nextInt();
		sc.nextLine();
		
		String[][] arr = new String[n][];
		
		// 각 행 별 최소값 중에서 최대값을 찾아야함
		// max : 비교할 최대값
		// max_row : 최대값이 들어있는 행
		int max = 0;
		int max_row = -1;

		// 1. 입력 받아서
		for (int i = 0; i < n; i++) {
			
			// 2. 쪼개고
			arr[i] = sc.nextLine().split(" ");
			
			// 3. 오름차순으로 정렬
			Arrays.sort(arr[i]);

			// 4. 그럼 각 행에서의 최소값은 0번째 인덱스에 있겠제
			int row_min = Integer.parseInt(arr[i][0]);
			
			// 5. 그거랑 최대값이랑 비교해서 이 최소값이 더 크면 최대값of최소값s 로 설정
			if (max < row_min) {
				max = row_min;
				max_row = i;
			}
			
		}
		System.out.println(max_row+"행의 "+max);

		long endTime = System.currentTimeMillis();
		System.out.println((endTime - startTime)/1000.0+"초 수행");
	}
}
