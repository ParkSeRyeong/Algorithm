package ssafy_algo_0210;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_16926_RotateArray {
	static int[][] arr;
	static int N;
	static int M;
	static int R;
	int[] dr = { -1, 1, 0, 0 };
	int[] dc = { 0, 0, -1, 1 };

	public static void rotate(int n) {
		int to = N - n;
		for (int i = 0; i < to - 1; i++) {
			
		}
	}

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/tree/rotate1_test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String tmp = br.readLine();
		N = Integer.parseInt(tmp.split(" ")[0]);
		M = Integer.parseInt(tmp.split(" ")[0]);
		R = Integer.parseInt(tmp.split(" ")[0]);

		for (int i = 0; i < N; i++) {
			arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}

		for (int i = 0; i < Math.min(N, M) / 2; i++) {
			rotate(i);
		}
	}
}
