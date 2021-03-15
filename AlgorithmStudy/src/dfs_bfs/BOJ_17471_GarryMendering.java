package dfs_bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_17471_GarryMendering {
	static int total = 0;
	static int Min = Integer.MAX_VALUE;
	static int[] people;
	static int[] area;
	static boolean[][] connected;
	static boolean[] visited;
	static int N;

	public static void dfs(int cnt, int areaNum, int areaSum) {
		if (cnt == N + 1) {
			// System.out.println(Arrays.toString(area));
			// 1구역과 2구역의 수를 각각 센당.
			int area1 = areaNum, area2 = N - areaNum;

			visited = new boolean[N + 1];

			int rs = 0;
			for (int i = 1; i <= N; i++) {
				if (!visited[i]) {
					// 이 check 함수를 거치고 나면 그랑 연결된 구역이 visit됨.
					check(i, area[i]);
					// System.out.println("\t"+Arrays.toString(visited));
					rs++;
				}
			}
			// System.out.println("\t"+rs);
			// rs가 2가 아니라면 -> 구역이 제대로 나눠진게 아니란 뜻.
			if (rs == 2) {
				Min = Math.min(Min, Math.abs((total - areaSum) - areaSum));
			}
			return;
		}

		area[cnt] = 1;
		dfs(cnt + 1, areaNum + 1, areaSum + people[cnt]);
		area[cnt] = 2;
		dfs(cnt + 1, areaNum, areaSum);
	}

	private static void check(int index, int belongArea) {
		// index : 현재 연결된 다른 구역을 찾으려는 구역.
		// 2-1,2,5,6 인 상태에서, index = 2라고 해보자.
		visited[index] = true;

		for (int i = 1; i <= N; i++) {
			// ex) i=1일 때
			// 1과2가이어져있고 & 1을아직방문안했고 & 1의구역이 2의구역과같다면?!
			if (connected[index][i] && !visited[i] && area[i] == belongArea) {
				// 1이랑 이어져있는 애도 보자.
				check(i, belongArea);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		/* 입력부 */
		N = Integer.parseInt(br.readLine());
		people = new int[N + 1];
		area = new int[N + 1];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i < N + 1; i++) {
			people[i] = Integer.parseInt(st.nextToken());
			total += people[i];
		}

		connected = new boolean[N + 1][N + 1];
		for (int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine());
			st.nextToken();
			while (st.hasMoreTokens()) {
				int tmp = Integer.parseInt(st.nextToken());
				connected[i][tmp] = true;
				connected[tmp][i] = true;
			}
		}
		/* 함수 실행부 */
		dfs(1, 0, 0);
		bw.write(String.valueOf(Min!=Integer.MAX_VALUE?Min:-1));

		bw.flush();
		bw.close();
		br.close();
	}
}
