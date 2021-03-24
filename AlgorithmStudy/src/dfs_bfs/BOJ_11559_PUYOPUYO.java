package dfs_bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

class Point {
	int r, c;

	public Point(int r, int c) {
		super();
		this.r = r;
		this.c = c;
	}

}

public class BOJ_11559_PUYOPUYO {
	static char[][] map;
	static boolean[][] visit;
	static ArrayList<Point> list = new ArrayList<>();
	static int height = 0;
	static int idx = 1;
	static int remove_cnt = 0;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void remove() {
		Iterator<Point> iter = list.iterator();
		while (iter.hasNext()) {
			Point p = iter.next();
			map[p.r][p.c] = '.';
		}
	}

	public static void falling() {
		for (int i = 0; i < 6; i++) {
			int j = height - 1;
			int cnt=0;
			while (map[j][i] != '.'&&j>0) {
				j--;
			}
			while (map[j][i] == '.'&&j>0) {
				j--;
				cnt++;
			}
			if(cnt!=0 && j>=0) {
				for(;j>=0;j--) {
					map[j+cnt][i]=map[j][i];
					map[j][i]='.';
				}
			}
		}
	}

	public static int puyo() {
		visit = new boolean[height][6];
		int bomb = 0;
		for (int i = height - 1; i >= 0; i--) {
			for (int j = 0; j < 6; j++) {
				if (!visit[i][j] && map[i][j] != '.') {
					idx = 0;
					list.clear();
					dfs(i, j, map[i][j], 1);
					if (idx >= 4) {
						remove();
						bomb++;
					}
				}
			}
		}
		falling();
		return bomb;
	}

	public static void dfs(int r, int c, char color, int cnt) {
		visit[r][c] = true;
		list.add(new Point(r, c));
		idx++;
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];

			if (nr < 0 || nc < 0 || nr >= map.length || nc >= map[0].length || visit[nr][nc] || map[nr][nc] != color) {
				continue;
			}
			dfs(nr, nc, color, cnt + 1);
		}
	}

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src\\dfs_bfs\\puyopuyo.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		boolean flag = false;
		int start = 0;
		for (int i = 0; i < 12; i++) {
			String tmp = br.readLine();
			if (!flag) {
				if (tmp.contains("R") || tmp.contains("G") || tmp.contains("B") || tmp.contains("P")
						|| tmp.contains("Y")) {
					flag = true;
					height = 12 - start;
					map = new char[height][6];
				} else
					start++;
			}
			if (flag) {
				for (int j = 0; j < 6; j++) {
					map[i - start][j] = tmp.charAt(j);
				}
			}
		}
		if(!flag) {
			System.out.println(0);
			return;
		}
		
		int bomb = 0;
		while (true) {
			bomb = puyo();
			if (bomb == 0)
				break;
			remove_cnt++;
		}
		System.out.println(remove_cnt);
	}
}
