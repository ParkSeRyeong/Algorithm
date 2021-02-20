package ssafy_algo_0208;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Hamburger {
	private static int N;
	private static int C;
	private static int[][] info;
	private static ArrayList<Integer> result = new ArrayList<>();
	private static int r = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			result.clear();
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());// 재료갯수
			C = Integer.parseInt(st.nextToken());// 제한칼로리

			info = new int[N][2];// 선호점수
			for (int n = 0; n < N; n++) {
				st = new StringTokenizer(br.readLine());
				info[n][0] = Integer.parseInt(st.nextToken());
				info[n][1] = Integer.parseInt(st.nextToken());
			}

			powerSet(0, new boolean[N]);

			Collections.sort(result);
			System.out.println("#" + (i + 1) + " " + result.get(result.size() - 1));
			
		}

	}

	public static void powerSet(int cnt, boolean[] isSelected) {
		if (cnt == N) {
			int sumScore = 0;
			int sumCal = 0;
			for (int i = 0; i < N; i++) {
				if (isSelected[i]) {
					sumScore += info[i][0];
					sumCal += info[i][1];
				}
			}

			if (sumCal <= C)
				result.add(sumScore);

			return;
		}

		// 선택
		isSelected[cnt] = true;
		powerSet(cnt + 1, isSelected);
		// 비선택
		isSelected[cnt] = false;
		powerSet(cnt + 1, isSelected);
	}
}