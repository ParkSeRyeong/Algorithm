package dfs_bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_11724_연결요소의개수 {
	static int[] arr;

	public static int find(int a) {
		if (arr[a] == a) {
			return a;
		}
		return arr[a] = find(arr[a]);
	}

	public static void union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);

		arr[bRoot] = aRoot;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		arr = new int[N + 1];
		int group = N;

		for (int i = 1; i <= N; i++) {
			arr[i] = i;
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			if (find(u) == find(v))
				continue;
			union(u, v);
			group--;
		}

		bw.write(String.valueOf(group));

		bw.flush();
		bw.close();
		br.close();
	}
}
