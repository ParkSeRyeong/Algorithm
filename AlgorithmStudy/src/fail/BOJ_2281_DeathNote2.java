package fail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_2281_DeathNote2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] name = new int[N];
		for (int i = 0; i < N; i++) {
			name[i] = Integer.parseInt(br.readLine());
		}
		int[] dp = new int[N];
		dp[0] = M - name[0];

		int lines = 0;
		int cnt = 1;
		for (int i = 1; i < N; i++) {
			if (dp[i - 1] - 1 < name[i]) {
				if (lines != 0) {
					int prev_last = i - cnt - 1;
					int down = Math.abs(dp[i - 1] - 1 - name[prev_last]);
					int original_diff = Math.abs(dp[prev_last] - dp[i - 1]);
					int move_diff = Math.abs(down - dp[prev_last-1]);

					if (original_diff > move_diff) {
						dp[prev_last] = M - name[prev_last];
						i = prev_last;
						cnt = 1;
						continue;
					}
				}
				lines++;
				dp[i] = M - name[i];
				cnt = 1;
			} else {
				dp[i] = dp[i - 1] - 1 - name[i];
				cnt++;
			}
		}
		int sum = 0;
		for (int i = 1; i < N; i++) {
			if (dp[i - 1] <= dp[i]) {
				sum += (dp[i - 1] * dp[i - 1]);
			}
		}
		System.out.println(sum);
	}
}
