package fail;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class FAIL_BOJ_16236_아기상어 {
	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int[] fishes = new int[7];
	static int dist = 0;

	private static class fish {
		int r;
		int c;
		int dist;

		public fish() {
		}

		public fish(int r, int c, int dist) {
			this.r = r;
			this.c = c;
			this.dist = dist;
		}
	}

	public static void init() {
		for (int i = 0; i < N; i++) {
			Arrays.fill(visited[i], false);
		}
	}

	public static void show() {
		for (int i = 0; i < N; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
	}

	public static void bfs(int sr, int sc) {
		Queue<fish> q = new LinkedList<>();
		int r = sr;
		int c = sc;
		q.offer(new fish(r, c, dist));
		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };

		int shark_size = 2;
		int eat = 0;
		w: while (!q.isEmpty()) {
			fish now = q.poll();
			for (int i = 0; i < 4; i++) {
				int nr = now.r + dr[i];
				int nc = now.c + dc[i];
				// 범위 밖이거나 or 이미 방문했거나 or 물고기 크기가 상어보다 크다면?
				if (nr < 0 || nc < 0 || nr >= N || nc >= N || visited[nr][nc] || map[nr][nc] > shark_size) {
					continue;
				}

				visited[nr][nc] = true;
				// 물고기 크기가 나보다 작다면
				if (map[nr][nc] != 0 && map[nr][nc] < shark_size) {
					// 이 칸은 다시 안 지나가도 돼!
					System.out.println("-------------------------------------------");
					System.out.printf("(%d, %d)에 물고기 발견, 먹는다! dist : %d\n", nr, nc, now.dist + 1);
					System.out.println("-------------------------------------------");
					dist = now.dist + 1;
					++eat;
					--fishes[map[nr][nc]];

					if (dist == 56)
						show();

					// 나보다 작은 물고기 다 잡아먹었는데 상어크기보다 적게 잡아먹었다면?
					if (shark_size < 7 && fishes[shark_size - 1] == 0 && eat != shark_size) {
						return;
					}
					// 잡아먹은 물고기 수가 상어 크기랑 같다면?
					else if (eat == shark_size) {
						++shark_size;
						eat = 0;

					}
					init();
					visited[nr][nc] = true;
					map[nr][nc] = 0;
					q.clear();
					q.offer(new fish(nr, nc, now.dist + 1));
					continue w;
				}
				System.out.printf("(%d, %d) 방문, dist : %d\n", nr, nc, now.dist + 1);
				q.offer(new fish(nr, nc, now.dist + 1));
			}
		}
	}

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/study/아기상어_test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];

		int sr = 0;
		int sc = 0;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) {
					sr = i;
					sc = j;
					visited[sr][sc] = true;
					map[i][j] = 0;
				} else if (map[i][j] != 0) {
					fishes[map[i][j]]++;
				}
			}
		}
		bfs(sr, sc);
		System.out.println(dist);
	}
}
