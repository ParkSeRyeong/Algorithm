package dijkstra;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class JO_1681_Hamilton_circuit_BF {
	static int N;
	static int[][] dist;
	static int Min = Integer.MAX_VALUE;

	// cur이 현재 도시, visit은 도시의 방문 정보를 비트마스킹으로 표현할 int형 변수.
	public static void permu(int toSelect, int[] selected, boolean[] visited, int sum, int cur) {
		if (sum > Min) {
			return;
		}
		if (toSelect == N) {
			selected[0] = 0;
			if(dist[cur][0]!=0)		// 마지막까지 방심하지 마러라!
				Min = Math.min(Min, sum + dist[cur][0]);
			return;
		}

		for (int i = 1; i < N; i++) {
			if (dist[cur][i] == 0)
				continue;
			if (!visited[i]) {
				visited[i] = true;
				selected[toSelect] = i;
				permu(toSelect + 1, selected, visited, sum + dist[cur][i], i);
				visited[i] = false;
			}
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src/dijkstra/hamilton_test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());

		dist = new int[N][N];
		for (int i = 0; i < N; i++) {
			dist[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}
		permu(1, new int[N], new boolean[N], 0, 0);
		System.out.println(Min != Integer.MAX_VALUE ? Min : 0);
	}
}
