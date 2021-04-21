package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SWEA_5643_키순서 {

	static int total = 0;
	static int cnt = 0;

	public static void dfs_up(int index, ArrayList<Integer>[] up, boolean[] check) {
		check[index] = true;
		cnt++;

		for (int i = 0; i < up[index].size(); i++) {
			if (!check[up[index].get(i)]) {
				dfs_up(up[index].get(i), up, check);
			}
		}
	}

	public static void dfs_down(int index, ArrayList<Integer>[] down, boolean[] check) {
		check[index] = true;
		cnt++;

		for (int i = 0; i < down[index].size(); i++) {
			if (!check[down[index].get(i)]) {
				dfs_up(down[index].get(i), down, check);
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());

		for (int t = 1; t <= tc; t++) {
			int N = Integer.parseInt(br.readLine());
			ArrayList<Integer>[] up = new ArrayList[N + 1];
			ArrayList<Integer>[] down = new ArrayList[N + 1];
			for (int i = 0; i < N + 1; i++) {
				up[i] = new ArrayList<>();
				down[i] = new ArrayList<>();
			}

			int M = Integer.parseInt(br.readLine());
			for (int i = 0; i < M; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				up[a].add(b);
				down[b].add(a);
			}

			int total = 0;
			for (int i = 1; i < up.length; i++) {
				boolean[] check = new boolean[up.length];
				cnt = 0;
				dfs_up(i, up, check);
				dfs_down(i, down, check);
				if (cnt - 1 == N)
					++total;
			}
			sb.append("#").append(t).append(" ").append(total).append("\n");
		}

		System.out.println(sb);
		br.close();
	}
}
