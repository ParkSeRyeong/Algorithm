package ssafy_algo_0216;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class NOT_BOJ_1074_Z {

	static int index = 0;
	static int[][] arr;
	static int row;
	static int col;

	public static void Z(int r, int c, int N) {
		if (N == 2) {
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < 2; j++) {
					arr[r + i][c + j] = index;
					index++;
				}
			}
			return;
		}
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				Z(r + N / 2 * i, c + N / 2 * j, N / 2);
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());

		N = (int) Math.pow(2, N);
		arr = new int[N][N];

		Z(0, 0, N);
		bw.write(String.valueOf(arr[row][col]));
		bw.flush();
		bw.close();
		br.close();
	}
}
