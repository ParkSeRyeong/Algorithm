package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_11503_LIS {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		int[] LIS = new int[N];
		Arrays.fill(LIS, 1);
		int max = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i] && LIS[i] < LIS[j] + 1) {
					LIS[i] = LIS[j] + 1;
				}
			}
			max = Math.max(LIS[i], max);
		}
		System.out.println(max);
	}
}
