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

		// 1 2 3 4 5 6 7 8 9 
		//now 위치까지 왔을 때
		for (int now = 1; now < N - 1; now++) {
			// i원이 되는 경우의 수
			for (int i = 0; i < 21; i++) {
				
				// 이전 위치의 경우의 수를 봤을 때
				if (dp[now - 1][i] != 0) {
					if (i + arr[now] <= 20)
						dp[now][i + arr[now]] += dp[now - 1][i];
					
					if (i - arr[now] >= 0)
						dp[now][i - arr[now]] += dp[now - 1][i];
				}
			}
		}

		System.out.println(dp[N - 2][arr[N - 1]]);
		br.close();
	}
}
