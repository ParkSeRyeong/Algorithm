package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Problem03_IcyWater {
	public static int[][] icebox;
	public static int N, M;

	static public void dfs(int r, int c) {
		// 범위 밖이거나 이미 방문 or 빈 공간이 아니라면?
		if (r < 0 || r == N || c < 0 || c == M || icebox[r][c] == 1) {
			return;
		}

		icebox[r][c] = 1;

		dfs(r - 1, c);
		dfs(r + 1, c);
		dfs(r, c - 1);
		dfs(r, c + 1);
	}

	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		// ------------------------입력-------------------------------
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		N = Integer.parseInt(str.split(" ")[0]);
		M = Integer.parseInt(str.split(" ")[1]);

		icebox = new int[N][M];

		// 얼음 틀 입력받기
		for (int i = 0; i < N; i++) {
			str = br.readLine();
			for (int j = 0; j < M; j++) {
				icebox[i][j] = str.charAt(j) - '0';
			}
		}

		// --------------------------------------------------------
		// DFS 시작
		int ice = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (icebox[i][j] == 0) {
					dfs(i, j);
					ice++;
				}
			}
		}
		System.out.println(ice);
	}
}
