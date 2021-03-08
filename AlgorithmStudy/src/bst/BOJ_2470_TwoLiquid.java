package bst;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2470_TwoLiquid {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int start = 0;
		int end = arr.length - 1;

		int r_s = 0;
		int r_e = 0;

		int diff = Integer.MAX_VALUE;
		while (true) {
			if (start >= end) {
				break;
			}
			if (Math.abs(diff) > Math.abs(arr[start] + arr[end])) {
				diff = arr[start] + arr[end];
				r_s = start;
				r_e = end;
			}
			if (diff - Math.abs(arr[start]) > diff - Math.abs(arr[end])) {
				end--;
			} else {
				start++;
			}
		}

		bw.write(String.valueOf(arr[r_s]) + " " + String.valueOf(arr[r_e]));
		bw.flush();
		bw.close();
		br.close();
	}
}
