package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_20056_마법사상어와파이어볼 {

	private static class fireball {
		int r, c, m, s, d, idx;

		public fireball(int r, int c, int m, int s, int d, int idx) {
			super();
			this.r = r;
			this.c = c;
			this.m = m;
			this.s = s;
			this.d = d;
			this.idx = idx;
		}

		public fireball() {
			super();
		}
	}

	static int N, M, K;
	static int[][] map;
	static int[][][] visit;
	static ArrayList<fireball> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		map = new int[N + 1][N + 1];
		visit = new int[N + 1][N + 1][2];
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		for (int i = 0; i < M; i++) {
			int[] tmp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			list.add(new fireball(tmp[0], tmp[1], tmp[2], tmp[3], tmp[4], i));
			map[tmp[0]][tmp[1]] = i;
		}

		for (int t = 0; t < K; t++) {
			move();
		}
	}

	private static void move() {
		int[] dr = { -1, -1, 0, 1, 1, 1, 0, -1 };
		int[] dc = { 0, 1, 1, 1, 0, -1, -1, -1 };

		for (int i = 0; i < M; i++) {
			fireball f = list.get(i);
			// 원래 위치 비워놓고
			// map[f.r][f.c] = 0;
			visit[f.r][f.c][0] = 0;
			visit[f.r][f.c][1] = 0;

			// 위치 이동. 원위치 + 방향*속도 % 크기
			int nr = (f.r + dr[f.d] * f.s);
			nr = nr > N ? nr % (N + 1) + 1 : nr;
			int nc = (f.c + dc[f.d] * f.s);
			nc = nc > N ? nc % (N + 1) + 1 : nc;

			// 그 위치가 합쳐진 적 없으면 방문
			if (visit[nr][nc][0] != 0) {
				// map[nr][nc] = f.idx;
				visit[nr][nc][0] = f.m;
				visit[nr][nc][1] = 1;
			}

			// 그 위치가 합쳐직 적 있으면?
			else {
				visit[nr][nc][0] += f.m;
				visit[nr][nc][1]++;
				
			}
		}
	}
}
