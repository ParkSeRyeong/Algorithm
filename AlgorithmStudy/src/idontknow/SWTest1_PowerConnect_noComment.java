/*package idontknow;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Location {
	int r;
	int c;

	public Location(int r, int c) {
		super();
		this.r = r;
		this.c = c;
	}
}

public class SWTest1_PowerConnect_noComment {
	static int[][] arr;
	static int min_len = 0;
	static int max_cnt = 0;
	static int processor_num;
	static ArrayList<Location> list;

	public static void func(int[][] map, int len, int cnt, int n) {
		if (n == processor_num) {
			if (max_cnt <= cnt) {
				if (max_cnt == cnt) {
					min_len = Math.min(len, min_len);
				} else {
					min_len = len;
				}
				max_cnt = Math.max(cnt, max_cnt);
			}
			return;
		}

		Location cur = list.get(n);
		int r = cur.r;
		int c = cur.c;

		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };

		for (int i = 0; i < 4; i++) {
			r = cur.r;
			c = cur.c;
			int cur_len = 0;
			while (true) {
				int nr = r + dr[i];
				int nc = c + dc[i];

				if (nr < 0 || nc < 0 || nr >= map.length || nc >= map.length) {
					len += cur_len;

					for (int k = 1; k <= cur_len; k++) {
						map[cur.r + k * dr[i]][cur.c + k * dc[i]] = 2;
					}

					func(map, len, cnt + 1, n + 1);

					for (int k = 1; k <= cur_len; k++) {
						map[cur.r + k * dr[i]][cur.c + k * dc[i]] = 0;
					}
					len -= cur_len;
					break;
				}
				if (map[nr][nc] == 1 || map[nr][nc] == 2) {
					break;
				}
				r = nr;
				c = nc;
				cur_len++;
			}
		}
		func(map, len, cnt, n + 1);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int test_case = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= test_case; tc++) {
			sb.append("#").append(tc).append(" ");

			int N = Integer.parseInt(br.readLine());

			arr = new int[N][N];
			list = new ArrayList<>();
			min_len = 0;
			max_cnt = 0;
			processor_num = 0;
			int connected_cnt = 0;

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());

					if (arr[i][j] == 1) {
						if (i == 0 || i == N - 1 || j == 0 || j == N - 1) {
							connected_cnt++;
							continue;
						} else {
							list.add(new Location(i, j));
							processor_num++;
						}
					}
				}
			}
			func(arr, 0, connected_cnt, 0);

			sb.append(min_len).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}
*/