package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Pos {
	int x, y;
	public Pos(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
}

public class BOJ_9205_BeerWalking {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int tc = Integer.parseInt(br.readLine());
		for (int t = 0; t < tc; t++) {

			int n = Integer.parseInt(br.readLine());
			Pos[] list = new Pos[n + 2];

			for (int i = 0; i < n + 2; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				list[i] = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}

			int[][] dist = new int[n + 2][n + 2];
			for(int i=0;i<n+2;i++) {
				Arrays.fill(dist[i], 999999);
			}

			for (int i = 0; i < n + 2; i++) {
				for (int j = 0; j < n + 2; j++) {
					int tmp = Math.abs(list[i].x - list[j].x) + Math.abs(list[i].y - list[j].y);
					if(tmp > 1000) continue;
						dist[i][j] = tmp;
						dist[j][i] = tmp;
				}
			}
			
			for (int via = 0; via < n + 2; via++) {
				for (int start = 0; start < n + 2; start++) {
					for (int end = 0; end < n + 2; end++) {
						if (start == via) 	continue;
						if (dist[via][end] == 999999) 	continue;
						dist[start][end] = Math.min(dist[start][end], dist[start][via] + dist[via][end]);
					}
				}
			}
			if (dist[0][n + 1] > 0 && dist[0][n+1] < 999999) sb.append("happy");
			else sb.append("sad");
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
