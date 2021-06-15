package study;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17142_연구소_MINZ {

	static ArrayList<Pos> virus;
	static int N, M, cnt, min;
	static int[][] lab;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		lab = new int[N][N];
		virus = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				lab[i][j] = tmp;
				if (tmp == 0) { // 빈칸 갯수
					cnt++;
				} else if (tmp == 2) {
					virus.add(new Pos(i, j));
				}
			}
		}

		min = Integer.MAX_VALUE;
		if (cnt > 0)
			select(0, new int[M], 0);

		if (cnt == 0) {
			bw.write("0");
		} else if (min == Integer.MAX_VALUE) {
			bw.write("-1");
		} else {
			bw.write(String.valueOf(min));
		}

		br.close();
		bw.close();

	}

	private static void select(int toSelect, int[] selected, int start) {

		if (toSelect == M) {
			min = Math.min(min, bfs(lab, cnt, selected));
			return;
		}

		for (int i = start; i < virus.size(); i++) {
			selected[toSelect] = i;
			select(toSelect + 1, selected, i + 1);
		}

	}

	private static int bfs(int[][] lab, int cnt, int[] pos) {

		Queue<Pos> queue = new LinkedList<>();

		for (int i = 0; i < M; i++) {
			queue.add(virus.get(pos[i]));
//         lab[virus.get(pos[i]).r][virus.get(pos[i]).c]= 3;
		}

		int time = 0;
		int emptytime = 0;

		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };

		boolean[][] visited = new boolean[N][N];
		for (int i = 0; i < M; i++) {
			visited[virus.get(pos[i]).r][virus.get(pos[i]).c] = true;
		}

		while (!queue.isEmpty()) {

			int size = queue.size();
			for (int s = 0; s < size; s++) {

				Pos cur = queue.poll();
				for (int i = 0; i < dr.length; i++) {
					int nr = cur.r + dr[i];
					int nc = cur.c + dc[i];

					if (nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc]) {

						if (lab[nr][nc] == 0) {
							cnt--;
							emptytime = time + 1;
						}
//                  lab[nr][nc]= 3;
						visited[nr][nc] = true;
						queue.add(new Pos(nr, nc));

					}
				}
			}

			time++;
			if (cnt == 0) {
				return emptytime;
			}

			size = queue.size();
			for (int s = 0; s < size; s++) {

				Pos cur = queue.poll();
//            lab[cur.r][cur.c]= 3;
				queue.add(cur);

			}

		}

		return Integer.MAX_VALUE;

	}

	private static class Pos {

		int r;
		int c;

		public Pos(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

	}

}