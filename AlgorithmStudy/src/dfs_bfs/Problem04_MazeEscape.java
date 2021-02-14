package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem04_MazeEscape {
	static int N, M;
	static int[][] map;

	// static Stack<ArrayList<Integer>>stack=new Stack<>();

	static int[][] visited;
	static int min;
	static int[][] minArr;

	static void dfs(int r, int c, int prev) {
		if (r < 1 || r > N || c < 1 || c > M || map[r][c] == 0 || visited[r][c] != 0) {
			return;
		}
		if (minArr[r][c] == 0 || minArr[r][c] > prev + 1) {
			minArr[r][c] = prev + 1;
		}
		visited[r][c] = 1;

		if (r == 4 && c == 6) {
			//System.out.println(fxxk[4][6]);
		}

		dfs(r + 1, c, minArr[r][c]);
		dfs(r - 1, c, minArr[r][c]);
		dfs(r, c + 1, minArr[r][c]);
		dfs(r, c - 1, minArr[r][c]);
		visited[r][c] = 0;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String tmp = br.readLine();
		N = Integer.parseInt(tmp.split(" ")[0]);
		M = Integer.parseInt(tmp.split(" ")[1]);

		map = new int[N + 1][M + 1];
		visited = new int[N + 1][M + 1];
		minArr = new int[N + 1][M + 1];

		for (int i = 1; i < N + 1; i++) {
			tmp = br.readLine();
			for (int j = 1; j < M + 1; j++) {
				map[i][j] = tmp.charAt(j - 1) - '0';
			}
		}

		dfs(1, 1, 0);
		System.out.println(minArr[N][M]);

	}
}
