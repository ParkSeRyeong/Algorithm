package ssafy_algo_0218;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class DividenConquerTest_MakeRoom {
	static int[][] arr;
	static int cnt = 0;

	public static int check(int r, int c, int N) {
		int value = arr[r][c];
		for (int i = r; i < r + N; i++) {
			for (int j = c; j < c + N; j++) {
				if (value != arr[i][j]) {
					return -1;
				}
			}
		}
		return value;
	}

	public static void make(int r, int c, int N) {
		if (check(r, c, N) != -1) {
			cnt++;
			return;
		}
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		int r = 0, c = 0;
		while (true) {
		}
	}
}
