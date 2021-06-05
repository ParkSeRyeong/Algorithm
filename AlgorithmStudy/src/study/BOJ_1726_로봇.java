package study;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1726_로봇 {
	static int M, N;
	static int[][] map;
	static boolean visit[][][];

	private static class pos {
		int r, c, dir, order;

		public pos(int r, int c, int dir, int order) {
			super();
			this.r = r;
			this.c = c;
			this.dir = dir;
			this.order = order;
		}
	}

	public static int switchDir(int n) {
		switch (n) {
		case 1: // 동
			return 0;
		case 2: // 남
			return 2;
		case 3: // 서
			return 1;
		default: // 북
			return 3;
		}
	}

	public static void bfs(int[] depart, int[] arrive) {
		// 동남서북 : 오른쪽으로 회전
		int[] dr = { 0, 1, 0, -1 };
		int[] dc = { 1, 0, -1, 0 };
		int min = Integer.MAX_VALUE;

		// 출발, 도착지
		pos start = new pos(depart[0], depart[1], switchDir(depart[2]), 0);
		pos end = new pos(arrive[0], arrive[1], switchDir(arrive[2]), 0);
		Queue<pos> q = new LinkedList<>();
		q.offer(start);
		visit[start.r][start.c][start.dir] = true;

		while (!q.isEmpty()) {
			pos now = q.poll();
			int r = now.r;
			int c = now.c;
			int dir = now.dir;
			int order = now.order;

			if (r == end.r && c == end.c && dir == end.dir) {
				min = Math.min(min, order);
				continue;
			}

			// 직진 가능?
			for (int i = 1; i <= 3; i++) {
				int nr = r + (dr[dir] * i);
				int nc = c + (dc[dir] * i);

				if (nr <= 0 || nc <= 0 || nr > M || nc > N)  continue;
				// 유효범위고
				if (map[nr][nc] == 0) {
					// 갈 수 있으면
					if (!visit[nr][nc][dir]) {
						visit[nr][nc][dir] = true;
						q.offer(new pos(nr, nc, dir, order + 1));
					}
				} else {
					break;
				}
			}

			// 회전 가능?
			int left = dir - 1 >= 0 ? dir - 1 : 3;
			int right = dir + 1 < 4 ? dir + 1 : 0;

			// 좌회전되면 좌회전
			if (!visit[r][c][left]) {
				visit[r][c][left] = true;
				q.add(new pos(r, c, left, order + 1));
			}
			// 우회전되면 우회전
			if (!visit[r][c][right]) {
				visit[r][c][right] = true;
				q.add(new pos(r, c, right, order + 1));
			}
		}
		System.out.println(min);
	}

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/study/로봇_test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[M + 1][N + 1];
		visit = new boolean[M + 1][N + 1][5];

		for (int i = 1; i < M + 1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < N + 1; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 출발지
		int[] start = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		// 도착지
		int[] arrive = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		bfs(start, arrive);
	}

}
