package bst;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class BOJ_10816_숫자카드2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int tc = Integer.parseInt(br.readLine());
		for (int t = 0; t < tc; t++) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			Arrays.sort(arr);
			int M = Integer.parseInt(br.readLine());
			int[] find = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

			for (int i = 0; i < M; i++) {
				bw.write(Arrays.binarySearch(arr, find[i]) >= 0 ? "1\n" : "0\n");
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
