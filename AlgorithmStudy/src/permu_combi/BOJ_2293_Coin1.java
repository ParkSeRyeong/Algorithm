package permu_combi;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2293_Coin1 {
	static int total = 0;


	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src/dp/coin_test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		// 동전 개수
		int n = Integer.parseInt(st.nextToken());
		// 원하는 동전 합
		int k = Integer.parseInt(st.nextToken());

		int[] coin = new int[n];
		for (int i = 0; i < n; i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}
		
		int[] dp = new int[k + 1];

		for (int i = 1; i < k + 1; i++) {

			int min = Integer.MAX_VALUE;

			for (int j = 0; j < coin.length; j++) {
				if (i - coin[j] > 0 && dp[i - coin[j]] != 0) {
					min = Math.min(min, dp[i - coin[j]] + 1);
				}
			}
			dp[i] = (min != Integer.MAX_VALUE ? min : 0);
		}

		System.out.println(dp[k] != 0 ? dp[k] : -1);
	}
}
