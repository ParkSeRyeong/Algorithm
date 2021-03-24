package mst;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Pos implements Comparable<Pos> {
	int x, y;
	double dist;

	public Pos(int x, int y, double dist) {
		super();
		this.x = x;
		this.y = y;
		this.dist = dist;
	}

	@Override
	public int compareTo(Pos o) {
		return (int) (this.dist - o.dist);
	}
}

public class SWEA_1251_Hanaro {
	static int N;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/mst/Hanaro_test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int tc = Integer.parseInt(st.nextToken());
		
		for (int t = 1; t <= tc; t++) {
			System.out.print("#"+t+" ");
			N = Integer.parseInt(br.readLine());
			// 각 x,y좌표 입력받기.
			long[] x = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
			long[] y = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
			double E = Double.parseDouble(br.readLine());
			boolean[] visit = new boolean[N];
			// q.clear();

			long[][] adj = new long[N][N];
			long[] minEdge = new long[N];

			for (int i = 0; i < N - 1; i++) {
				for (int j = i + 1; j < N; j++) {
					long dist = ((x[i] - x[j]) * (x[i] - x[j])) + ((y[i] - y[j]) * (y[i] - y[j]));
					adj[i][j] = dist;
					adj[j][i] = dist;
				}
				minEdge[i] = Long.MAX_VALUE;
			}
			minEdge[N - 1] = Long.MAX_VALUE;

			long result = 0;
			minEdge[0] = 0;
			for (int j = 0; j < N; j++) {
				long min = Long.MAX_VALUE;
				int minVertex = 0;

				/* 현재 최소 간선 찾기 */
				for (int i = 0; i < N; i++) {
					if (!visit[i] && minEdge[i] < min) {
						min = minEdge[i];
						minVertex = i;
					}
				}
				result += min;
				visit[minVertex] = true;
				
				/* 현재 섬에서 최소 간선인 섬 찾아서 업데이트*/
				for (int i = 0; i < N; i++) {
					if (!visit[i] && adj[minVertex][i] != 0 && minEdge[i] > adj[minVertex][i]) {
						minEdge[i] = adj[minVertex][i];
					}
				}
			}
			System.out.println(Math.round(result*E));
		}
	}
}
