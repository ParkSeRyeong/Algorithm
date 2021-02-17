package ssafy_algo_0215;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_2961_DoYoung {
	static int[] Sour;
	static int[] Bitter;
	static int N;
	static int Min = 9999;

	public static void powerset(int cnt, boolean[] visited, int sourSum, int bitterSum, int used) {
		if (cnt == N) {
			if (used == 0)
				return;
			for (int i = 0; i < N; i++) {
				if (visited[i]) {
					//System.out.print(Sour[i] + " " + Bitter[i]);
					System.out.print(i+" ");
				}
			}
			System.out.println();
//			System.out.println("\t" + sourSum +" "+ bitterSum);
			Min = Math.min(Min, Math.abs(sourSum - bitterSum));
			return;
		}

		visited[cnt] = true;
		powerset(cnt + 1, visited, sourSum * Sour[cnt], bitterSum + Bitter[cnt], used + 1);
		visited[cnt] = false;
		powerset(cnt + 1, visited, sourSum, bitterSum, used);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		Sour = new int[N];
		Bitter = new int[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			Sour[i] = Integer.parseInt(st.nextToken());
			Bitter[i] = Integer.parseInt(st.nextToken());
		}
		powerset(0, new boolean[N], 1, 0, 0);
		bw.write(String.valueOf(Min));
		bw.flush();
		bw.close();
		br.close();
	}
}
