package dp;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2294_Coin2 {
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/dp/coin_test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[] coin = new int[n];
		for (int i = 0; i < n; i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}

		int[] dp = new int[k + 1];

		// 재화 단위는 다 1로 변환.
		for (int i = 0; i < coin.length; i++) {
			if (coin[i] > k)
				break;
			dp[coin[i]] = 1;
		}

		for (int i = 1; i < k + 1; i++) {

			// 재화단위면 스킵
			if (dp[i] == 1) 
				continue;

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
