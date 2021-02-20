package stack_queue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pos {
	int r;
	int c;
	int ice;

	public Pos() {
	}

	public Pos(int r, int c, int ice) {
		super();
		this.r = r;
		this.c = c;
		this.ice = ice;
	}

}

public class BOJ_2573_Iceberg {
	static int[][] map;
	static int row, col;
	static int year = 0;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static Queue<Pos> q = new LinkedList<>();
	static ArrayList<Pos> list = new ArrayList<>();

	public static void melting() {
		for (int j = 0; j < list.size(); j++) {
			int zero_cnt = 0;
			Pos ice = list.get(j);
			for (int i = 0; i < 4; i++) {
				int nr = ice.r + dr[i];
				int nc = ice.c + dc[i];

				// 인접노드가 범위 아웃이거나 바다가 아닌 빙산이면(!=0)
				if (nr < 0 || nc < 0 || nr > row - 1 || nc > col - 1 || map[nr][nc] != 0)
					continue;
				zero_cnt++;
			}
			list.get(j).ice -= zero_cnt > ice.ice ? ice.ice : zero_cnt;
		}

	}

	public static void makeZero() {
		for (int j = 0; j < list.size(); j++) {
			Pos tmp = list.get(j);
			map[tmp.r][tmp.c] = tmp.ice;

			if (tmp.ice == 0) {
				list.remove(j);
				j--;
			}
		}
	}

	/** 0으로 둘러싸여있으면 false, 하나라도 이어져있으면 true */
	public static boolean isCombined() {
		Iterator<Pos> iter = list.iterator();
		while (iter.hasNext()) {
			boolean zeros = false;
			Pos ice = iter.next();
			for (int i = 0; i < 4; i++) {
				int nr = ice.r + dr[i];
				int nc = ice.c + dc[i];

				// 인접노드가 범위 아웃이거나 바다가 아닌 빙산이면(!=0)
				if (nr >= 0 && nc >= 0 && nr < row && nc < col && map[nr][nc] != 0)
					zeros = true;
			}
			if (!zeros)
				return false;
		}
		return true;
	}

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src\\dfs_bfs\\iceberg_test.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 입력
		// row, col
		// map 정보
		StringTokenizer st = new StringTokenizer(br.readLine());
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());

		map = new int[row][col];

		for (int i = 0; i < row; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < col; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

				// 정수가 들어오면 q에 위치정보 저장 : 나중에 탐색할 필요 없게
				if (map[i][j] != 0) {
					q.offer(new Pos(i, j, map[i][j]));
					list.add(new Pos(i, j, map[i][j]));
				}
			}
		}
		boolean flag = false;
		if (isCombined()) {
			while (list.size() != 0) {
				year++;
				melting();
				makeZero();
				if (!isCombined()) {
					flag = true;
					break;
				}
			}
		}
		if (!flag)
			year = 0;
		bw.write(String.valueOf(year));
		bw.flush();
		bw.close();
		br.close();
	}
}
