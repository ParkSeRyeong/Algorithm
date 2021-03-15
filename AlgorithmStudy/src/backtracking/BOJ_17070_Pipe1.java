package backtracking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_17070_Pipe1 {
	static int cnt = 0;

	public static void moving(int dir, int r, int c, int[][] map) {
		if (r > map.length - 1 || c > map.length - 1 || map[r][c] == 1) {
			return;
		}
		if (dir % 3 == 1 && (map[r - 1][c] == 1 || map[r][c - 1] == 1)) {
			return;
		}
		if (r == map.length - 1 && c == map.length - 1) {
			cnt++;
			return;
		}
		if (dir % 3 == 0) { // 가로
			moving(dir, r, c + 1, map);
			moving(dir + 1, r + 1, c + 1, map);
		}
		else if (dir % 3 == 1) { // 대각선
			moving(dir - 1, r, c + 1, map);
			moving(dir, r + 1, c + 1, map);
			moving(dir + 1, r + 1, c, map);
		}
		else { // 세로
			moving(dir, r + 1, c, map);
			moving(dir - 1, r + 1, c + 1, map);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		int[][] map = new int[N + 1][N + 1];
		for (int i = 1; i < N + 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j < N + 1; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		moving(0, 1, 2, map);
		bw.write(String.valueOf(cnt));
		
		bw.flush();
		bw.close();
		br.close();
	}
}
