package ssafy_algo_0208;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Algo2_서울_9_박세령 {
	public static void main(String[] args) throws IOException {

		// 입력 및 선언부
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		// possibleClub : 가능한 동아리의 수를 카운트한다.
		int possibleClub = 0;
		int[][] arr = new int[N][3];

		// 탈락한 동아리는 out = true
		boolean[] out = new boolean[N];

		// 1. 동아리 수만큼 반복한다.
		for (int i = 0; i < N; i++) {

			// 2. N번만큼 새로 동아리원들의 능력치를 받아온다.
			arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			int sum = 0;

			// 한 명이라도 개인 능력치(j)가 M미만이면 out = true로 바꾸고 break
			// 아니라면 계속 개인 능력치의 합을 구한다.
			for (int j = 0; j < 3; j++) {
				if (arr[i][j] < M) {
					out[i] = true;
					break;
				}
				sum += j;
			}
			// 합이 S미만이라면 out를 true로 바꾼다.
			if (sum < S && out[i]) {
				out[i] = true;
			}

			// out가 false라면 가능한 동아리 수를 증가시킨다.
			if (!out[i]) {
				possibleClub++;
			}
		}

		// out가 false인, 즉 탈락하지 않은 동아리의 동아리원 점수들을 출력한다.
		for (int i = 0; i < N; i++) {
			if (!out[i]) {
				for (int j : arr[i]) {
					sb.append(j + " ");
				}
			}
		}
		System.out.println(possibleClub);
		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());
	}
}
