package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1240_노드사이의거리 {
	static int N;

	public static int dijkstra(int start, int end, int[][] adj) {
		int[] dist = new int[N + 1];
		boolean[] visit = new boolean[N + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start] = 0;

		for (int i = 1; i <= N; i++) {
			int min = Integer.MAX_VALUE;
			int cur = 0;

			for (int j = 1; j <= N; j++) {
				if (!visit[j] && min > dist[j]) {
					min = dist[j];
					cur = j;
				}
			}
			visit[cur] = true;
			if (cur == end)
				break;

			for (int j = 1; j <= N; j++) {
				if (!visit[j] && adj[cur][j] != 0 && dist[j] > min + adj[cur][j]) {
					dist[j] = min + adj[cur][j];
				}
			}
		}
		return dist[end];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		/* ----------- 입력부 --------------- */
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] adj = new int[N + 1][N + 1];

		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());
			adj[a][b] = dist;
			adj[b][a] = dist;
		}
		
		StringBuilder sb=new StringBuilder();
		/* ----------- 실행부 --------------- */
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			sb.append(dijkstra(from, to, adj)).append("\n");
		}
		System.out.println(sb.toString());
	}
}
