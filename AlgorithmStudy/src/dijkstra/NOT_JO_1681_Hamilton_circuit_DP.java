package dijkstra;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class NOT_JO_1681_Hamilton_circuit_DP {
	static int[][] dp;
	static int[][] dist;
	static int N;

	public static int tsp(int idx, int bit) {

		if (bit == (1 << N) - 1) {
			if (dist[idx][0] == 0)
				return Integer.MAX_VALUE;

			return dist[idx][0];
		}

		if (dp[idx][bit] != -1) {
			return dp[idx][bit];
		}

		dp[idx][bit] = Integer.MAX_VALUE;

		for (int i = 0; i < N; ++i) {

			if (dist[idx][i] == 0 || (bit & (1 << i)) != 0) {
				continue;
			}

			dp[idx][bit] = Math.min(dp[idx][bit], tsp(i, (bit | (1 << i))) + dist[idx][i]);
		}

		return dp[idx][bit];
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src/dijkstra/hamilton_test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());

		dist = new int[N][N];
		dp = new int[N][1 << N];
		for (int i = 0; i < N; i++) {
			dist[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			Arrays.fill(dp[i], -1);
		}

		int res=tsp(0,1);
		System.out.println(res!=Integer.MAX_VALUE?res:0);
		
		//답 405 나와야됨.
	}
}
