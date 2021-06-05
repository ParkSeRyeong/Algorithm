package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_17951_흩날리는웅앵 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] score = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int max = 0;
		for (int i : score) {
			max += i;
		}

		int left = 0;
		// 와 이 +1때문에 틀림. 왜 +1인가?
		int right = max + 1;
		// 이게 왜 +1이어야 하는가?
		while (left + 1 < right) {
			int mid = (left + right) / 2;

			int count = 0;
			int sum = 0;
			for (int i = 0; i < N; i++) {
				sum += score[i];
				if (sum >= mid) {
					sum = 0;
					count++;
				}
			}

			if (count >= K)
				left = mid;
			else
				right = mid;
		}
		System.out.println(left);
	}
}
