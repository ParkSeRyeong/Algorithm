package study;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2234_성곽 {
	static int n, m;
	static int[][] map;
	static int[][] area;
	static int area_num = 1;
	static ArrayList<Integer> list = new ArrayList<>();
	static boolean[][] adj;
	static int max_room_size = Integer.MIN_VALUE;

	public static void bfs(int sr, int sc) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { sr, sc });
		area[sr][sc] = area_num;

		int[] dr = { 0, -1, 0, 1 };
		int[] dc = { -1, 0, 1, 0 };
		int cnt = 1;

		while (!q.isEmpty()) {
			int r = q.peek()[0];
			int c = q.poll()[1];

			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];

				if (nr < 0 || nc < 0 || nr >= n || nc >= m) {
					continue;
				}
				if ((map[r][c] & (1 << i)) == (1 << i)) {
					// 벽이긴 한데 건너편에 다른 칸이 있따면 -> 이어져있다고 해보자.
					if (area[nr][nc] != 0 && area[nr][nc] != area_num && !adj[area_num][area[nr][nc]]) {
						adj[area_num][area[nr][nc]] = true;
						adj[area[nr][nc]][area_num] = true;
					}
					continue;
				}
				if (area[nr][nc] != 0) {
					continue;
				}

				area[nr][nc] = area_num;
				q.offer(new int[] { nr, nc });
				cnt++;
			}
		}
		max_room_size = Math.max(max_room_size, cnt);
		list.add(cnt);
		++area_num;
	}

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/study/성곽_test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		area = new int[n][m];
		adj = new boolean[200][200];
		list.add(0);
		for (int i = 0; i < n; i++) {
			map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}

		f: for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (area[i][j] == 0) {
					bfs(i, j);
				}
			}
		}

//		for (int i = 0; i < n; i++) {
//			System.out.println(Arrays.toString(area[i]));
//		}
//		Iterator<Integer> iter = list.iterator();
//		while (iter.hasNext()) {
//			System.out.println(iter.next());
//		}

//		for (int i = 0; i < area_num; i++) {
//			for (int j = 0; j < area_num; j++) {
//				System.out.print(adj[i][j] ? 1 + " " : 0 + " ");
//			}
//			System.out.println();
//		}

		int max_area = Integer.MIN_VALUE;
		for (int i = 0; i < area_num - 1; i++) {
			for (int j = i; j < area_num; j++) {
				if (list.get(i) + list.get(j) > max_area && adj[i][j]) {
					max_area = list.get(i) + list.get(j);
				}
			}
		}
		System.out.println(area_num - 1);
		System.out.println(max_room_size);
		System.out.println(max_area);
	}
}
