package ssafy_algo_0217;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_1992_QuardTree2 {
	static int[][] arr;
	static StringBuilder sb = new StringBuilder();

	public static int isSame(int r, int c, int N) {
		int value = arr[r][c];
		for (int i = r; i < r + N; i++) {
			for (int j = c; j < c + N; j++) {
				if (arr[i][j] != value) {
					return -1;
				}
			}
		}
		return value;
	}

	public static void four_divide(int r, int c, int N) {
		int value = isSame(r, c, N);
		if (value != -1) {
			sb.append(value);
		} else {
			sb.append("(");
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < 2; j++) {
					four_divide(r+i * N / 2, c+j * N / 2, N / 2);
				}
			}
			sb.append(")");
		}
	}

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/ssafy_algo_0217/quard_tree_test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			String tmp = br.readLine();
			for (int j = 0; j < tmp.length(); j++) {
				arr[i][j] = tmp.charAt(j) - '0';
			}
		}
		four_divide(0, 0, N);
		bw.write(String.valueOf(sb));
		bw.flush();
		bw.close();
		br.close();
	}
}
