package study;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1261_알고스팟 {
	static int[][] broken;
	static boolean[][] visit;
	static int N, M;

	public static class loc {
		int r, c;

		public loc(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void dijkstra(int[][] map) {
		Queue<loc> q = new LinkedList<>();
		q.offer(new loc(1, 1));
		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };

		int min = Integer.MAX_VALUE;

		while (!q.isEmpty()) {
			int r = q.peek().r;
			int c = q.poll().c;

			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];

				// 미로 범위 안에서
				if (nr > 0 && nc > 0 && nr < N + 1 && nc < M + 1) {

					// 1. 빈 공간일 경우
					if (map[nr][nc] == 0) {
						if (broken[nr][nc] > broken[r][c]) {
							broken[nr][nc] = broken[r][c];
							q.offer(new loc(nr, nc));
						}
					}

					// 2. 벽일 경우 -> 뚫어야됨
					else {
						if (broken[nr][nc] > broken[r][c] + 1) {
							broken[nr][nc] = broken[r][c] + 1;
							q.offer(new loc(nr, nc));
						}
					}
				}
			}

		}
		System.out.println(broken[N][M]);
	}

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/study/알고스팟_test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		// 미로맵
		int[][] map = new int[N + 1][M + 1];
		for (int i = 1; i <= N; i++) {
			String tmp = br.readLine();
			for (int j = 1; j <= M; j++) {
				map[i][j] = tmp.charAt(j - 1) - '0';
			}
		}

		// 최소 거리 정보를 저장할 테이블
		broken = new int[N + 1][M + 1];

		// 방문 정보를 저장할 테이블
		visit = new boolean[N + 1][M + 1];

		for (int i = 1; i < N + 1; i++) {
			Arrays.fill(broken[i], Integer.MAX_VALUE);
		}

		// 시작 위치는 당연 0
		broken[1][1] = 0;
		dijkstra(map);
	}
}
