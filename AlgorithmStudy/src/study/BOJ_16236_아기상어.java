package study;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16236_아기상어 {
	static int N;
	static int[][] map;
	static int[][] check;
	static int[] fishes = new int[7];
	static int shark_size = 2;
	static int min_r = Integer.MAX_VALUE;
	static int min_c = Integer.MAX_VALUE;
	static int min_d = Integer.MAX_VALUE;

	private static class fish {
		int r;
		int c;

		public fish() {
		}

		public fish(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void init() {
		min_d = min_r = min_c = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			Arrays.fill(check[i], -1);
		}
	}

	public static void show_map() {
		for (int i = 0; i < N; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
	}

	// BFS에서 바로 상어를 움직이는게 아님에 주의.
	// BFS에선 갈 수 있는 거리만 UPDATE 해주는 것.
	public static void bfs(int sr, int sc) {
		Queue<fish> q = new LinkedList<>();
		q.offer(new fish(sr, sc));
		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };
		check[sr][sc] = 0;

		while (!q.isEmpty()) {
			fish now = q.poll();
			int r = now.r;
			int c = now.c;
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				// 범위 밖이거나 or 이미 방문했거나 or 물고기 크기가 상어보다 크다면?
				if (nr < 0 || nc < 0 || nr >= N || nc >= N || check[nr][nc] != -1 || map[nr][nc] > shark_size) {
					continue;
				}
				// 거리를 업데이트 해줘요.
				check[nr][nc] = check[r][c] + 1;

				// 이동만 할 거리 업데이트는 같거나 작은 크기의 물고기들이지만
				// 이동해서 잡아먹을 위치는 나보다 작은 물고기만 가능하니까!
				if (map[nr][nc] > 0 && map[nr][nc] < shark_size) {

					// 최소 거리, 같다면 아래보단 위, 오른쪽보단 왼쪽으로 이동해야하니까
					// 최소를 판단.
					if (check[nr][nc] < min_d) {
						min_r = nr;
						min_c = nc;
						min_d = check[nr][nc];
					}
					// 같은 거리라면 위쪽, 둘 다 위쪽이면 왼쪽.
					else if (check[nr][nc] == min_d) {
						// 둘 다 위쪽
						if (nr == min_r) {
							if (nc < min_c) {
								min_r = nr;
								min_c = nc;
							}
						}
						// 하나가 더 위쪽
						else if (nr < min_r) {
							min_r = nr;
							min_c = nc;
						}
					}
				}
				q.offer(new fish(nr, nc));
			}
		}
	}

	public static void show_check() {
		for (int i = 0; i < N; i++) {
			// System.out.println(Arrays.toString(check[i]));
			for (int j = 0; j < N; j++) {
				System.out.print(check[i][j] != -1 ? check[i][j] : 0);
				System.out.print(" ");
			}
			System.out.println();
		}
		System.out.println("------------------------");
	}

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/study/아기상어_test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		check = new int[N][N];

		int sr = 0;
		int sc = 0;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) {
					sr = i;
					sc = j;
					check[sr][sc] = 0;
					map[i][j] = 0;
				}
			}
		}

		int eat = 0;
		int total = 0;
		while (true) {
			init();
			bfs(sr, sc);
			//show_check();
			if (min_r == Integer.MAX_VALUE || min_c == Integer.MAX_VALUE)
				break;

			total += check[min_r][min_c];
			eat++;
			if (eat == shark_size) {
				shark_size++;
				eat = 0;
			}
			map[min_r][min_c] = 0;
			sr = min_r;
			sc = min_c;
		}
		System.out.println(total);
	}

}
