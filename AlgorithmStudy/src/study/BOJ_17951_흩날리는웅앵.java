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

		// 12 7 19 20 17 14 9 10
		int[] score = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int max = 0;
		for (int i : score) {
			max += i;
		}

		int left = 0;

		int right = max + 1;

		while (left + 1 < right) {
			int mid = (left + right) / 2;	// 그룹을 나누는 기준점수

			int group = 0;
			int sum = 0;
			for (int i = 0; i < N; i++) {
				sum += score[i];
				if (sum >= mid) {
					sum = 0;
					group++;
				}
			}

			if (group >= K)
				left = mid;
			else
				right = mid;

			// 12 7 19 20 17 14 9 10
			
			// L: 0 / R:109 / mid 54
			// L:0 / R:54 / mid:27
			// L:27 / R:54 / mid:40
			// L:40 / R:54 / mid 47
			// L:47 / R:54 / mid 50
			// L:50 / R:54 / mid 52
			// L:50 / R:52 / mid 51
			// L:50 / R:51 / mid 50
			// L:50 / R:50 / mid 50
		}
		System.out.println(left);
	}
}
