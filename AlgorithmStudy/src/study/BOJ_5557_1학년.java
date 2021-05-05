package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_5557_1학년 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		long[][] dp = new long[N - 1][21];
		dp[0][arr[0]] = 1;

		for (int now = 1; now < N - 1; now++) {
			for (int j = 0; j < 21; j++) {
				if (dp[now - 1][j] != 0) {
					if (j + arr[now] <= 20)
						dp[now][j + arr[now]] += dp[now - 1][j];
					if (j - arr[now] >= 0)
						dp[now][j - arr[now]] += dp[now - 1][j];
				}
			}
		}

		System.out.println(dp[N - 2][arr[N - 1]]);
		br.close();
	}
}
