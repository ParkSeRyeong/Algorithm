package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_12865_Knapsack {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 숨바꼭질 5 풀어보기!
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[][] dp = new int[N+1][K + 1];
		int[][] knapsack = new int[N+1][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			knapsack[i][0] = Integer.parseInt(st.nextToken());
			knapsack[i][1] = Integer.parseInt(st.nextToken());
		}

		// 물건무게 i
		for (int i = 1; i <= N; i++) {
			
			int w = knapsack[i][0];
			int v = knapsack[i][1];
			
			// 가방 무게 j
			for (int j = 1; j <= K; j++) {
				
				// 현재 가방무게가 현재 물건 무게보다 적다면
				if (j < w) {
					// 그냥 이전 가방값 넣어주자.
					dp[i][j] = dp[i - 1][j];
				} 
				
				// 아니라면
				else {
					// dp[i-1][j] : 이 물건을 안 썼을 때.
					// dp[i-1][j-w]+v : 이 물건을 썼을 때.
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-w]+v);
				}
			}
		}
		System.out.println(dp[N-1][K]);
	}
}
