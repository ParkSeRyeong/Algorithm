package ssafy_algo_0218;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class T24_Alphabet {
	static int row, col;
	static int[][] map;
	static boolean[] visit = new boolean[26];
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int Max = 0;

	public static void go(int r, int c, int cnt) {
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];

			// 범위 아웃 or 이미 방문했으면 continue
			if (nr < 0 || nc < 0 || nr > row - 1 || nc > col - 1 || visit[map[nr][nc]]) {
				continue;
			}
			// 인접한 곳으로 방문하고,
			visit[map[nr][nc]] = true;
			
			// 그 칸으로 이동해서 다시 재귀.
			go(nr, nc, cnt + 1);
			
			// 다른 경로로 그 칸을 다시 방문할 수도 있으니 미방문처리.
			visit[map[nr][nc]] = false;
		}
		
		// 포문을 나왔다 = 인접노드는 다 돌아봤다! = 이 때 Max 값 업데이트
		Max = Math.max(Max, cnt);
	}

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/ssafy_algo_0218/alpha_test.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());

		map = new int[row][col];

		for (int i = 0; i < row; i++) {
			String tmp = br.readLine();
			for (int j = 0; j < col; j++) {
				map[i][j] = tmp.charAt(j) - 65;
			}
		}

		visit[map[0][0]] = true;
		go(0, 0, 1);
		bw.write(String.valueOf(Max));

		bw.flush();
		bw.close();
		br.close();
	}
}
