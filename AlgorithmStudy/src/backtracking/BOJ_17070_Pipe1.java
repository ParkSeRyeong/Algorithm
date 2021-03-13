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
			System.out.println("파토!");
			return;
		}
		if (dir % 3 == 1 && (map[r - 1][c] == 1 || map[r][c - 1] == 1)) {
			return;
		}
		if (r == map.length - 1 && c == map.length - 1) {
			System.out.println("******\n도착!\n*******");
			cnt++;
			return;
		}

		if (dir % 3 == 0) { // 가로
			System.out.println("가로이동 : " + r + "," + c + "->" + r + "," + (c + 1));
			moving(dir, r, c + 1, map);
			System.out.println("대각선이동 : " + r + "," + c + "->" + (r + 1) + "," + (c + 1));
			moving(dir + 1, r + 1, c + 1, map);
		}

		else if (dir % 3 == 1) { // 대각선

			System.out.println("가로이동 : " + r + "," + c + "->" + r + "," + (c + 1));
			moving(dir - 1, r, c + 1, map);
			System.out.println("대각선이동 : " + r + "," + c + "->" + (r + 1) + "," + (c + 1));
			moving(dir, r + 1, c + 1, map);
			System.out.println("세로이동 : " + r + "," + c + "->" + (r + 1) + "," + c);
			moving(dir + 1, r + 1, c, map);
		}

		else { // 세로
			System.out.println("세로이동 : " + r + "," + c + "->" + (r + 1) + "," + c);
			moving(dir, r + 1, c, map);
			System.out.println("대각선이동 : " + r + "," + c + "->" + (r + 1) + "," + (c + 1));
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
