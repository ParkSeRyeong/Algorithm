package study;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_1868_지뢰찾기 {
	static boolean[][] check;
	static int[][] map;
	static int N;

	public static void update(int i, int j) {
		int[] dr = { -1, -1, -1, 0, 0, 1, 1, 1 };
		int[] dc = { -1, 0, 1, -1, 1, -1, 0, 1 };

		int cnt = 0;
		for (int k = 0; k < 8; k++) {
			int nr = i + dr[k];
			int nc = j + dc[k];
			if (nr < 0 || nc < 0 || nr >= N || nc >= N) {
				continue;
			}
			if (map[nr][nc] < 0) {
				cnt++;
			}
		}
		map[i][j] = cnt;
	}

	public static void dfs(int r, int c) {
		int[] dr = { -1, -1, -1, 0, 0, 1, 1, 1 };
		int[] dc = { -1, 0, 1, -1, 1, -1, 0, 1 };

		check[r][c] = true;
		for (int k = 0; k < 8; k++) {
			int nr = r + dr[k];
			int nc = c + dc[k];
			if (nr < 0 || nc < 0 || nr >= N || nc >= N || map[nr][nc] == -1 || check[nr][nc]) {
				continue;
			}
			check[nr][nc] = true;	
			if (map[nr][nc] == 0) {
				dfs(nr, nc);
			}
		}
	}

	public static void show() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j]);
				System.out.print(" ");
			}
			System.out.println();
		}
	}
	
	public static void showV() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(check[i][j]?1:0);
				System.out.print(" ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src/study/파핑_test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int tc = Integer.parseInt(br.readLine());

		for (int t = 1; t <= tc; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			check = new boolean[N][N];

			for (int i = 0; i < N; i++) {
				String tmp = br.readLine();
				for (int j = 0; j < N; j++) {
					// 지뢰면 -1, 아니면 0.
					if (tmp.charAt(j) == '*') {
						map[i][j] = -1;
					} else {
						map[i][j] = 0;
					}
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j]!=-1)
						update(i, j);
				}
			}
			int min_cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == 0 && !check[i][j]) {
						dfs(i, j);
						min_cnt++;
					}
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] > 0 && !check[i][j]) {
						min_cnt++;
					}
				}
			}
			sb.append("#").append(t).append(" ").append(min_cnt).append("\n");
		}
		System.out.println(sb);
	}
}
