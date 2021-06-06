package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7682_틱택토 {
	static int N, ans;
	static ArrayList<node>[] list;

	private static class node {
		int to, dist;

		public node(int to, int dist) {
			this.to = to;
			this.dist = dist;
		}
	}

	public static void dfs(int start, int end, int sum, boolean[] visit) {
		visit[start] = true;
		if (start == end) {
			ans = Math.min(ans, sum);
			return;
		}

		for (int i = 0; i < list[start].size(); i++) {
			node cur = list[start].get(i);
			if (!visit[cur.to]) {
				dfs(cur.to, end, sum + cur.dist, visit);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		list = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());
			list[a].add(new node(b, dist));
			list[b].add(new node(a, dist));
		}

		StringBuilder sb = new StringBuilder();
		/* ----------- 실행부 --------------- */
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			ans = Integer.MAX_VALUE;
			dfs(from, to, 0, new boolean[N + 1]);
			sb.append(ans).append("\n");
		}
		System.out.println(sb.toString());
	}
}
