package study;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_1922_네트워크연결 {
	static int N;
	static int[] arr;

	static class Edge implements Comparable<Edge> {

		int from, to, weight;

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		// 항상 나 기준으로 생각. 내 거에서 남의 거 빼기.
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src/study/네트워크_test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		ArrayList<Edge> list = new ArrayList<>();

		N = Integer.parseInt(br.readLine());
		arr = new int[N + 1];
		makeSet(N);

		int M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list.add(new Edge(from, to, w));
		}
		Collections.sort(list);

		int E = 0;
		int result = 0;
		for (Edge e : list) {
			if (E == N - 1)
				break;
			if (union(e.from, e.to)) {
				result += e.weight;
				E++;
			}
		}
		System.out.println(result);
		br.close();
	}

	private static void makeSet(int n) {
		for (int i = 1; i < N + 1; i++) {
			arr[i] = i;
		}
	}

	private static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if (aRoot == bRoot) {
			return false;
		}
		// 정신차려라 세령아
		arr[aRoot] = bRoot;
		return true;
	}

	private static int findSet(int a) {
		if (arr[a] == a) // 내가 그 집합의 대표자
			return a;

		// Path Compression 후
		return arr[a] = findSet(arr[a]);
	}
}
