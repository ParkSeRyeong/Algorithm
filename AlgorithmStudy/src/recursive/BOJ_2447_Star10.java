package recursive;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class BOJ_2447_Star10 {
	static char[][] arr;

	public static void star(int n, int r, int c) {
		if (n / 3 == 1) {
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if (i == 1 && j == 1) {
						continue;
					}
					arr[r + i][c + j] = '*';
				}
			}
			return;
		}
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (i == 1 && j == 1) {
					continue;
				} else {
					star(n / 3, r + i * n / 3, c + j * n / 3);
				}

			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		arr = new char[N][N];
		for (int i = 0; i < N; i++) {
			Arrays.fill(arr[i], ' ');
		}

		star(N, 0, 0);

		for (char[] c : arr) {
			for (char cc : c) {
				bw.write(String.valueOf(cc));
			}
			bw.write("\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
