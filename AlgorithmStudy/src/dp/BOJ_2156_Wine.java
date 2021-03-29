package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2156_Wine {
	static int N;
	static int[] arr;
	static int[][] dp;
	static int Max = Integer.MIN_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		dp = new int[N][2];

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		// 0 : 나 씀
		// 1 : 나 안 씀

		dp[0][0] = arr[0];
		dp[0][1] = 0;
		if(N==1) {
			System.out.println(dp[0][0]);
			return;
		}
		dp[1][0] = arr[0] + arr[1];
		dp[1][1] = arr[0];
		if(N==2) {
			System.out.println(dp[1][0]);
			return;
		}
		dp[2][0] = Math.max(arr[0], arr[1]) + arr[2];
		dp[2][1] = dp[1][0];
		if (N == 3) {
			System.out.println(Math.max(dp[2][0], dp[2][1]));
		} else {
			//Max = dp[1][1];

			for (int n = 3; n < N; n++) {
				dp[n][0] = Math.max(Math.max(dp[n - 2][1] + arr[n - 1], dp[n - 1][1]), dp[n - 3][0]) + arr[n];
				dp[n][1] = Math.max(dp[n - 1][0], dp[n - 1][1]);
				Max = Math.max(Math.max(dp[n][0], dp[n][1]), Max);
			}
//		for(int []i:dp) {
//			for(int j:i) {
//				System.out.print(j+" ");
//			}
//			System.out.println();
//		}
			System.out.println(Max);
		}
	}
}
