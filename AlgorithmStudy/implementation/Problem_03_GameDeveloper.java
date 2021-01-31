package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_03_GameDeveloper {

	static boolean check(int n, int m, int nr, int nc) {
		if (nr < 1 || nr >= n || nc < 1 || nc >= n) {
			return true;
		}
		return false;
	}

	@SuppressWarnings("unused")
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("맵 크기 입력 :");
		String[] str = br.readLine().split(" ");
		int n = Integer.parseInt(str[0]);
		int m = Integer.parseInt(str[1]);

		// -----------------------------------------------------------------------
		System.out.print("유저 위치 : ");
		str = br.readLine().split(" ");
		int r = Integer.parseInt(str[0]);
		int c = Integer.parseInt(str[1]);
		int dir = Integer.parseInt(str[2]);
		// -----------------------------------------------------------------------

		int[][] map = new int[n][m];
		boolean[][] visit = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			str = br.readLine().split(" ");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(str[j]);
			}
		}

		int[] dir_r = { -1, 0, 1, 0 };
		int[] dir_c = { 0, 1, 0, -1 };

		int nr = 0;
		int nc = 0;

		int visit_count = 0;
		int move_count = 0;

		while (true) {

			// 일단 방문한 곳은 true로, 방문 칸 수도 ++
			visit[r][c] = true;
			visit_count++;
			move++;

			// 0 1 2 3
			// 북 동 남 서
			// 북->서 / 서->남 / 남->동 / 동->북
			// 0->3 / 3->2 / 2->1 / 1->0

			nr = r + dir_r[(dir + 3) % 4];
			nc = c + dir_c[(dir + 3) % 4];

			// 바다거나 / 범위를 벗어났거나 / 이미 방문했다면
			if (map[nr][nc] == 1 || check(n, m, nr, nc) || visit[nr][nc] == true) {
				move_count++;
				if (move_count == 4) {
					System.out.println("끝!");
					break;
				}
				continue;
			}

			r = nr;
			c = nc;
		}

		br.close();
	}
}
