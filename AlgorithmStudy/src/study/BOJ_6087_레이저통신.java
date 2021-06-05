package study;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_6087_레이저통신 {
	static int N, M, empty, virus_cnt;
	static int result = Integer.MAX_VALUE;
	static ArrayList<pos> list;
	static int[][] map;

	private static class pos {
		int r, c;

		public pos(int r, int c) {
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return r + "," + c;
		}

	}

	public static void combi(int start, int count, boolean[] check) {
		if (count == M) {
			// 방문 배열 만들어서 -1로 채워주기.
			int[][] visit = new int[N][N];
			for (int i = 0; i < N; i++) {
				Arrays.fill(visit[i], -1);
			}
			Queue<pos> q = new LinkedList<>();
			for (int i = 0; i < virus_cnt; i++) {
				// 뽑힌 활성화 바이러스들의 위치를 큐에 넣어서 BFS를 돌릴 것!
				if (check[i]) {
					pos cur = list.get(i);
					q.offer(new pos(cur.r, cur.c));
					visit[cur.r][cur.c] = 0;
				}
			}
			BFS(visit, q);
			return;
		}

		for (int i = start; i < virus_cnt; i++) {
			if (!check[i]) {
				check[i] = true;
				combi(i + 1, count + 1, check);
				check[i] = false;
			}
		}
	}

	private static void BFS(int[][] visit, Queue<pos> q) {
		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };
		int virus = 0;
		int time = 0;

		while (!q.isEmpty()) {
			pos now = q.poll();
			for (int i = 0; i < 4; i++) {
				int nr = now.r + dr[i];
				int nc = now.c + dc[i];

				if (nr < 0 || nc < 0 || nr > N - 1 || nc > N - 1)
					continue;

				// 위치가 벽이 아니고 방문을 아직 안 했다면
				if (map[nr][nc] != 1 && visit[nr][nc] == -1) {
					visit[nr][nc] = visit[now.r][now.c] + 1;
					q.offer(new pos(nr, nc));

					// 빈 칸일 때만 감염시간을 증가시켜야됨!
					if (map[nr][nc] == 0) {
						++virus;
						time = visit[nr][nc];
					}
				}
			}
		}
		// 감염시킨 바이러스가 빈 공간 수랑 똑같다면
		if (virus == empty) {
			result = Math.min(result, time);
		}
	}

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/study/연구소3_test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		list = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					list.add(new pos(i, j));
					++virus_cnt;
				} else if (map[i][j] == 0) {
					++empty;
				}
			}
		}
		combi(0, 0, new boolean[virus_cnt]);
		System.out.println(result == Integer.MAX_VALUE ? -1 : result);
	}
}
