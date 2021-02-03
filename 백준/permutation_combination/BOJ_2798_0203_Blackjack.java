package permutation_combination;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2798_0203_Blackjack {
	static int N, M;
	static int[] card;
	static int min_diff = 99999;
	static int result = 0;
	static boolean flag = false;

	public static void Combination(int toSelect, int[] selected, int start) {

		if (flag == true)
			return;

		if (toSelect == 3) {
			int sum = 0;
			for (int i = 0; i < 3; i++) {
				sum += selected[i];
			}

			if (sum > M) {
				return;
			}
			if (M - sum < min_diff) {
				result = sum;
				min_diff = M - sum;
				return;
			}
			return;
		}

		for (int i = start; i < card.length; i++) {
			selected[toSelect] = card[i];
			Combination(toSelect + 1, selected, i + 1);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 카드 개수 N 딜러가 외칠 숫자 M 입력, 사용자는 3장으로 픽스
		String input = br.readLine();
		N = Integer.parseInt(input.split(" ")[0]);
		M = Integer.parseInt(input.split(" ")[1]);

		// 각 카드에 쓰여있는 수 입력, " "로 구분
		card = new int[N];
		card = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		// N장의 카드 중에서 M에 최대한 가까운 카드 3장의 합을 구하기
		// nC3을 구해서
		// 각각 돌리기
		Combination(0, new int[3], 0);
		
/*		Arrays.sort(card);
		for (int i = 0; i < N - 2; i++) {
			for (int j = i + 1; j < N - 1; j++) {
				for (int k = j + 1; k < N; k++) {

					int sum = card[i] + card[j] + card[k];
					if (sum > M) {
						break;
					}

					if (M - sum < min_diff) {
						min_diff = M - sum;
						result = card[i] + card[j] + card[k];
					}
				}
			}
		}*/

		System.out.println(result);
	}
}
