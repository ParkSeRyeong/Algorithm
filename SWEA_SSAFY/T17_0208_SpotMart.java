package ssafy_algo_0208;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class T17_0208_SpotMart {
	static int N;
	static int M;
	static int Max = -1;
	static int[][] arr;

	/** 0, int 새 배열, 시작 인덱스, 배열 길이 잴 index */
	public static void Combination(int toSelect, int[] selected, int start, int index) {

		if (toSelect == 2) {
			int sum = 0;
			for (int i : selected) {
				sum += i;
			}
			if (sum <= M) {
				Max = Math.max(sum, Max);
			}
			return;
		}

		for (int i = start; i < arr[index].length; i++) {
			selected[toSelect] = arr[index][i];
			Combination(toSelect + 1, selected, i + 1, index);
		}
	}

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/ssafy_algo_0208/mart_test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int tc = Integer.parseInt(br.readLine());
		arr = new int[tc][];

		for (int t = 0; t < tc; t++) {
			sb.append("#").append(t + 1).append(" ");
			Max = -1;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			// ----------------------------------------------
			arr[t] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			// ----------------------------------------------
			Combination(0, new int[2], 0, t);
			sb.append(Max).append("\n");
		}
		System.out.println(sb);
	}
}
