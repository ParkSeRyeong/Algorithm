package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_10026_적록색약 {
	static int N;
	static char[][] map;
	static boolean[][] check;

	private static class Pos {
		int r;
		int c;

		public Pos() {
		}

		public Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void BFS_normal(int i, int j) {
		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };

		Queue<Pos> q = new LinkedList<>();
		q.offer(new Pos(i, j));
		check[i][j] = true;

		while (!q.isEmpty()) {
			int r = q.peek().r;
			int c = q.poll().c;
			char color = map[r][c];

			for (int k = 0; k < 4; k++) {
				int nr = r + dr[k];
				int nc = c + dc[k];
				if (nr < 0 || nc < 0 || nr >= N || nc >= N || map[nr][nc] != color || check[nr][nc]) {
					continue;
				}
				q.offer(new Pos(nr, nc));
				check[nr][nc] = true;
			}
		}
	}

	private static void BFS_Color_Blindness(int i, int j) {
		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };

		Queue<Pos> q = new LinkedList<>();
		q.offer(new Pos(i, j));
		check[i][j] = true;

		while (!q.isEmpty()) {
			int r = q.peek().r;
			int c = q.poll().c;
			char color = map[r][c];

			for (int k = 0; k < 4; k++) {
				int nr = r + dr[k];
				int nc = c + dc[k];
				if (nr < 0 || nc < 0 || nr >= N || nc >= N || check[nr][nc]) {
					continue;
				}
				if ((color == 'R' || color == 'G') && map[nr][nc] != 'B') {
					q.offer(new Pos(nr, nc));
					check[nr][nc] = true;
				} else if (color == 'B' && map[nr][nc] == 'B') {
					q.offer(new Pos(nr, nc));
					check[nr][nc] = true;
				}
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		map = new char[N][N];
		check = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}

		int normal = 0;
		int color_blindness = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!check[i][j]) {
					BFS_normal(i, j);
					normal++;
				}
			}
		}

		for (int i = 0; i < N; i++) {
			Arrays.fill(check[i], false);
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!check[i][j]) {
					BFS_Color_Blindness(i, j);
					color_blindness++;
				}
			}
		}

		System.out.println(normal + " " + color_blindness);
		br.close();
	}

}
