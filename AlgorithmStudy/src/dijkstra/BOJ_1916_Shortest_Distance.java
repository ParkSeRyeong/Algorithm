package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1916_Shortest_Distance {
	// 1. 같은 출발점과 같은 도착점, 다른 비용의 경우를 생각 안 함.
	// 2. 처음에 city가 0으로 초기화인데, 버스 비용이 0보다 크거나 같아서 0도 가능.
	// 그 경우도 체크 안 해줌.
	// 3. 그럼 21퍼에서 나가린데....음...

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		int[][] city = new int[N + 1][N + 1];
		boolean[] visit = new boolean[N + 1];
		int[] dist = new int[N + 1];

		// 처음에 도시 연결 정보를 -1로 다 채워줌.
		for (int i = 1; i <= N; i++) {
			Arrays.fill(city[i], -1);
		}

		for (int i = 0; i < M; i++) {
			int[] tmp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

			// 이미 값이 있는 상태면 -> 둘 중 최소값
			if (city[tmp[0]][tmp[1]] > -1) {
				city[tmp[0]][tmp[1]] = Math.min(city[tmp[0]][tmp[1]], tmp[2]);
			}

			// 아님 걍 들어온 값 때려박기
			else {
				city[tmp[0]][tmp[1]] = tmp[2];
			}
		}

		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());

		// dist 배열은 max값으로 채워놓고
		Arrays.fill(dist, Integer.MAX_VALUE);

		// 시작 정점은 거리 0으로!
		dist[start] = 0;

		for (int i = 1; i <= N; i++) {
			int min = Integer.MAX_VALUE;
			int current = 0;
			for (int v = 1; v <= N; v++) {
				if (!visit[v] && min > dist[v]) {
					min = dist[v];
					current = v;
				}
			}

			if (current == end)
				break;
			// 현재 연결 안 된 정점 중 거리가 가장 작은 정점이 current가 됨.
			visit[current] = true;

			for (int j = 1; j <= N; j++) {

				// 방문안했고 && 인접한 도시고 && 현재 거리보다 current 거쳐가는게 더 가깝다면
				if (!visit[j] && city[current][j] > -1 && dist[j] > min + city[current][j]) {
					dist[j] = min + city[current][j];
				}
			}
		}
		System.out.println(dist[end]);
	}
}
