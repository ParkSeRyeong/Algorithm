package greedy;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Problem02_Maximum {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		String[] input = sc.nextLine().split(" ");

		int n = Integer.parseInt(input[0]);
		int pluscntM = Integer.parseInt(input[1]);
		int maxContinueK = Integer.parseInt(input[2]);

		/**
		 * arr : int[], 입력받은 값을 저장 flag : int[], 원소별로 몇 번 더했는지 카운트
		 */

		Integer[] arr = new Integer[n];

		
		// 사용횟수
		int flag = 0;

		// -------- 입력받기 ----------
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		/**
		 * 내림차순(큰수->작은수)으로 정렬 Collections의 경우 Wrapper클래스여야 사용 가능 혹은 Primitive 클래스를 ->
		 * Wrapper로 바꿔줘야 가능하다고 해서 Integer로 선언.
		 */
		Arrays.sort(arr, Collections.reverseOrder());

		/** sum : int, 출력할 총합을 저장 */
		int sum = 0;

		/**
		 * 내림차순 = 0번째 인덱스가 가장 큼 0번 인덱스를 일단 하나 사용한다 = flag[0]++ 하고 그 다음, 얘가 최대연속가능개수, 즉
		 * 입력받은 K만큼 연속으로 썼는지 체크. flag[0] % maxContinueK 가 0이 아니라면 아직 최대개수만큼 연속된 게 아니므로
		 * 0번째 수를 더하고 0이라면 = 최대개수만큼 반복했단 뜻이므로 1번 인덱스(두번째로 큰 수)를 더함
		 */
		for (int i = 0; i < pluscntM; i++) {
			flag++;
			if (flag % maxContinueK != 0) {
				sum += arr[0];
			} else {
				sum += arr[1];
			}
		}
		System.out.println(sum);
	}
}
