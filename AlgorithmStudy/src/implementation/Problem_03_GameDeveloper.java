package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_03_GameDeveloper {

	static boolean alreadyVisit(int n, int m, int nr, int nc) {
		if (nr < 0 || nr >= n || nc < 0 || nc >= n) {
			return true;
		}
		return false;
	}

	@SuppressWarnings("unused")
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// -----------------------------------------------------------------------
		// 입력받기
		System.out.print("맵 크기 입력 :");
		String[] str = br.readLine().split(" ");
		int n = Integer.parseInt(str[0]);
		int m = Integer.parseInt(str[1]);

		System.out.print("유저 위치 : ");
		str = br.readLine().split(" ");
		int r = Integer.parseInt(str[0]);
		int c = Integer.parseInt(str[1]);
		int dir = (Integer.parseInt(str[2]) + 3) % 4;
		// -----------------------------------------------------------------------
		// 맵 정보, 방문 정보 받기
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

		int visit_count = 1;
		int move_count = 0;

		while (true) {

			// 일단 방문한 곳은 true로, 방문 칸 수도 ++
			visit[r][c] = true;

			nr = r + dir_r[dir];
			nc = c + dir_c[dir];

			// 범위를 벗어났거나 / 바다거나 / 이미 방문했다면
			if (alreadyVisit(n, m, nr, nc) || map[nr][nc] == 1 || visit[nr][nc] == true) {
				move_count++;
				if (move_count == 4) {
					nr = r - dir_r[dir];
					nc = c - dir_c[dir];
					if (map[nr][nc] == 1) {
						break;
					}
					r = nr;
					c = nc;
					continue;
				}
				// 북->서 / 서->남 / 남->동 / 동->북
				// 0->3 / 3->2 / 2->1 / 1->0
			}

			// 네 방향 다 보면
			else {
				visit_count++;
				r = nr;
				c = nc;
				move_count = 0;
			}
			dir = (dir + 3) % 4;
			System.out.println(visit_count);
			br.close();
		}
	}
}
