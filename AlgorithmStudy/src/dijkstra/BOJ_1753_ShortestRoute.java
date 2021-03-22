package dijkstra;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

class NODE implements Comparable<NODE>{
	int vertex;
	int weight;
	public NODE(int vertex, int weight) {
		super();
		this.vertex = vertex;
		this.weight = weight;
	}
	public NODE() {	}
	@Override
	public int compareTo(NODE o) {
		return o.weight-this.weight;
	}
	
}

public class BOJ_1753_ShortestRoute {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());

		int[][] adjacent = new int[V + 1][V + 1];

		int[] Dtable = new int[V + 1];
		Arrays.fill(Dtable, Integer.MAX_VALUE);
		boolean[] visit = new boolean[V + 1];

		int start = Integer.parseInt(br.readLine());
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			adjacent[a][b] = w;
		}
		Dtable[start] = 0;

		while (true) {
			// Dtable에서 최소값을 찾아서
			int min = Integer.MAX_VALUE;
			int cur = -1;
			for (int j = 1; j <= V; j++) {
				if (!visit[j] && min > Dtable[j]) {
					min = Dtable[j];
					cur = j;
				}
			}
			if (cur == -1)
				break;
			visit[cur] = true;

//			// cur : 이제 이 cur과 인접한 노드들을 볼 것.
			for (int j = 1; j <= V; j++) {
				// cur 자신이 아니고, 연결이 되어있고, 방문을 안 했다면
				if (j != cur && adjacent[cur][j] != 0 && !visit[j]) {

					// 최소값을 갱신.
					Dtable[j] = Math.min(Dtable[j], Dtable[cur] + adjacent[cur][j]);
				}
			}
//			if (list[cur] == null) {
//				continue;
//			}
//			for (Integer[] i : list[cur]) {
//				if (i[0] != cur && !visit[i[0]]) {
//					Dtable[i[0]] = Math.min(Dtable[i[0]], Dtable[cur] + i[1]);
//				}
//			}
		}
		for (int i = 1; i <= V; i++) {
			sb.append(Dtable[i] != Integer.MAX_VALUE ? String.valueOf(Dtable[i]) : "INF").append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}
