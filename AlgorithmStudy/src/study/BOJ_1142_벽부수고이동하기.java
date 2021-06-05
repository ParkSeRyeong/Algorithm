package study;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1142_벽부수고이동하기 {

	private static class pos {
		int r, c, bomb, dist;

		public pos(int r, int c, int bomb, int dist) {
			this.r = r;
			this.c = c;
			this.bomb = bomb;
			this.dist = dist;
		}
	}

	public static void bfs(int[][] map, int N, int M, int K) {
		int[] dr = { 0, 0, -1, 1 };
		int[] dc = { -1, 1, 0, 0 };

		Queue<pos> q = new LinkedList<>();
		map[1][1] = 2; // 시작점 방문처리
		q.offer(new pos(1, 1, 0, 1));

		while (!q.isEmpty()) {
			pos now = q.poll();
			int r = now.r;
			int c = now.c;
			int bomb = now.bomb;
			int dist = now.dist;

			if (r == N && c == M) {
				System.out.println(dist);
				return;
			}

			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				// 유효범위라면
				if (nr > 0 && nc > 0 && nr < N + 1 && nc < M + 1) {
					// 1. 그냥 갈 수 있을 때
					if (map[nr][nc] == 0) {
						map[nr][nc] = 2; // 방문처리 = 2 << 여기
						q.offer(new pos(nr, nc, bomb, dist + 1));
					}
					// 2. 뿌수고 가야할 때
					else if (map[nr][nc] == 1 && bomb < K) {
						map[nr][nc] = 2; // 방문처리 = 2
						q.offer(new pos(nr, nc, bomb + 1, dist + 1));
					}
				}
			}
		}
		System.out.println("-1");
	}

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/study/벽부수기_test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[][] map = new int[N + 1][M + 1];
		for (int i = 1; i < N + 1; i++) {
			String tmp = br.readLine();
			for (int j = 1; j < M + 1; j++) {
				map[i][j] = tmp.charAt(j - 1)-'0';
			}
		}

		bfs(map, N, M, K);
	}
}
