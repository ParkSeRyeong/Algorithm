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
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_6087_레이저통신 {
	static int W, H;
	 
	private static class pos implements Comparable<pos> {
		int r, c, dir, mirror;

		public pos(int r, int c, int dir, int mirror) {
			this.r = r;
			this.c = c;
			this.dir = dir;
			this.mirror = mirror;
		}

		@Override
		public String toString() {
			return r + "," + c + " / 방향 " + dir + " / 거울 " + mirror + "개";
		}

		@Override
		public int compareTo(pos o) {
			return this.mirror - o.mirror;
		}
	}

	private static void BFS(pos start, pos end, char[][] map, int[][] visit) {
		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };
		// PriorityQueue로 하면 훨씬 짧아진다!
		PriorityQueue<pos> q = new PriorityQueue<>();
		
		/* ------- 시작할 때 일단 사방으로 넣어준다 --------- */
		for (int i = 0; i < 4; i++) {
			// 시작 위치 + 사방 방향을 넣어준다!
			// 거울 개수는 당연히 0개.
			q.offer(new pos(start.r, start.c, i, 0));
		}
		visit[start.r][start.c] = 0;

		while (!q.isEmpty()) {
			pos now = q.poll();
			if (now.r == end.r && now.c == end.c)
				break;

			for (int i = 0; i < 4; i++) {
				int nr = now.r + dr[i];
				int nc = now.c + dc[i];
				int mirror = now.mirror;

				// 1. 유효 범위 / 벽 여부 판단
				if (nr < 0 || nc < 0 || nr > H - 1 || nc > W - 1 || map[nr][nc] == '*')
					continue;

				// 2. 현재 판단중인 이동할 방향(i)이 dir과 다르다면 = 거울 필요
				if (now.dir != i) {
					mirror += 1;
				}

				// 3. 방문 안 했거나(MAX VALUE), 방문 했는데 거울 갯수가 많다면
				if (visit[nr][nc] >= mirror) {
					visit[nr][nc] = mirror;
					q.offer(new pos(nr, nc, i, mirror));
				}
			}
		}
		System.out.println(visit[end.r][end.c]);
	}

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/study/레이저통신_test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		char[][] map = new char[H][W];
		int[][] visit = new int[H][W];
		pos start = null;
		pos end = null;
		boolean flag = false;

		/* ----------- 입력부 --------------- */
		for (int i = 0; i < H; i++) {
			String tmp = br.readLine();
			for (int j = 0; j < W; j++) {
				visit[i][j] = Integer.MAX_VALUE;
				map[i][j] = tmp.charAt(j);
				if (map[i][j] == 'C') {
					if (!flag) {
						// 처음에 들어오는 'C'는 시작 위치로
						start = new pos(i, j, 0, 0);
						flag = !flag;
					} else {
						// 그 다음 'C'는 끝 위치로
						end = new pos(i, j, 0, 0);
					}
				}
			}
		}
		/* ----------- 실행부 --------------- */
		BFS(start, end, map, visit);
	}
}
