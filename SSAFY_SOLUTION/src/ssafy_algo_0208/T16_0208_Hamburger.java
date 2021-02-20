package ssafy_algo_0208;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class T16_0208_Hamburger {
	static int N, LimitCalory;
	static int[][] arr;
	static int maxScore = 0;

	public static void powerset(int cnt, boolean[] selected, int calory) {
		// 넘어온 칼로리가 이미 기준치 이상이면 그냐ㅕㅇ 리턴!
		if (calory > LimitCalory) {
			return;
		}
		if (cnt == N) {
			int scoreSum = 0;
			for (int i = 0; i < N; i++) {
				if (selected[i]) {
					// 점수의 합을 더해서 max값이랑 비교하기
					scoreSum += arr[i][0];
				}
			}
			maxScore = Math.max(maxScore, scoreSum);
			return;
		}
		selected[cnt] = true;
		powerset(cnt + 1, selected, calory + arr[cnt][1]);
		// 빼면 칼로리도 당연히 안 더해줘야함ㅠㅠㅠㅠ
		selected[cnt] = false;
		powerset(cnt + 1, selected, calory);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int tc = Integer.parseInt(br.readLine());

		for (int t = 1; t < tc + 1; t++) {
			maxScore=0;
			sb.append("#").append(t).append(" ");

			String[] tmp = br.readLine().split(" ");
			
			// N : 재료 수
			// LimitCalory : 제한 칼로리
			N = Integer.parseInt(tmp[0]);
			LimitCalory = Integer.parseInt(tmp[1]);

			arr = new int[N][2];

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());

				// 인덱스 0 : 재료별 점수
				// 인덱스 1 : 재료별 칼로리
				arr[i][0] = Integer.parseInt(st.nextToken());
				arr[i][1] = Integer.parseInt(st.nextToken());
			}

			powerset(0, new boolean[N], 0);

			sb.append(maxScore).append("\n");
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb);

		br.close();
	}
}
