package ssafy_0225;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_2567_ColorPaper2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		boolean[][] arr = new boolean[101][101];
		int cnt = 0;
		for (int r = 0; r < N; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			for (int j = x; j < x + 10; j++) {
				for (int k = y; k < y + 10; k++) {
					arr[j][k] = true;
				}
			}
		}
		for (int i = 1; i < 101; ++i) {
			for (int j = 1; j < 101; ++j) {
				if (arr[i][j]) {
					if (!arr[i - 1][j])
						++cnt;
					if (!arr[i][j - 1])
						++cnt;
					if (!arr[i + 1][j])
						++cnt;
					if (!arr[i][j + 1])
						++cnt;
				}
			}
		}

		bw.write(String.valueOf(cnt));
		br.close();
		bw.flush();
		bw.close();
	}
}
