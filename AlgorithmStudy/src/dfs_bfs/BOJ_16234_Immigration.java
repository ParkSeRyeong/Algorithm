package dfs_bfs;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.StringTokenizer;

class Country {
	int r, c;

	public Country(int r, int c) {
		super();
		this.r = r;
		this.c = c;
	}

}

public class BOJ_16234_Immigration {
	static int[][] map;
	static ArrayList<Country> list = new ArrayList<>();
	static int N, L, R;
	static int sum = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src\\dfs_bfs\\immigration_test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}
		int tmp = 0;
		int cnt = 0;
		while (true) {
			tmp = openBorder();
			if (tmp == 1)
				break;
			cnt++;
		}
		System.out.println(cnt);
	}

	public static int openBorder() {
		boolean[][] visit = new boolean[N][N];
		int size = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sum = 0;
				if (!visit[i][j]) {
					list.clear();
					dfs(i, j, visit);
					size = Math.max(size, list.size());
					immigration();
				}
			}
		}
		return size;
	}

	public static void dfs(int r, int c, boolean[][] visit) {
		visit[r][c] = true;
		list.add(new Country(r, c));
		sum += map[r][c];

		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };

		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];

			if (nr < 0 || nc < 0 || nr >= N || nc >= N || visit[nr][nc])
				continue;

			int diff = Math.abs(map[r][c] - map[nr][nc]);

			if (diff < L || diff > R)
				continue;
			dfs(nr, nc, visit);
		}
	}

	public static void immigration() {
		Iterator<Country> iter = list.iterator();

		while (iter.hasNext()) {
			Country c = iter.next();
			map[c.r][c.c] = sum / list.size();
		}
	}
}
