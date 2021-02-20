package ssafy_algo_0217;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class BOJ_15686_Chicken {
	static ArrayList<int[]> store = new ArrayList<>();
	static ArrayList<int[]> home = new ArrayList<>();
	static int N = 0;
	static int M = 0;
	static int total_min = 9999;

	public static void Combination(int toSelect, int[][] selected, int start) {
		if (toSelect == M) {
			int min_dist = 0;

			for (int i = 0; i < home.size(); i++) {
				int min = 9999;
				for (int j = 0; j < toSelect; j++) {
					int dist = Math.abs(home.get(i)[0] - selected[j][0]) + Math.abs(home.get(i)[1] - selected[j][1]);
					min = Math.min(dist, min);
				}
				min_dist += min;
			}
			total_min = Math.min(total_min, min_dist);
			return;
		}
		for (int i = start; i < store.size(); i++) {
			selected[toSelect][0] = store.get(i)[0];
			selected[toSelect][1] = store.get(i)[1];
			Combination(toSelect + 1, selected, i + 1);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		int[][] map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					store.add(new int[] { i, j });
				} else if (map[i][j] == 1) {
					home.add(new int[] { i, j });
				}
			}
		}

		Combination(0, new int[M][2], 0);
		bw.write(String.valueOf(total_min));

		br.close();
		bw.flush();
		bw.close();
	}
}
