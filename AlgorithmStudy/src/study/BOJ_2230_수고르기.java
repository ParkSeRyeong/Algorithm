package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2230_수고르기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);

		int left = 0;
		int right = 0;
		int result = Integer.MAX_VALUE;

		while (left < N && right < N) {
			if (arr[right] - arr[left] < M) {
				right++;
			} else {
				result = Math.min(result, arr[right] - arr[left]);
				left++;
			}
		}
		System.out.println(result);
		br.close();
	}
}
