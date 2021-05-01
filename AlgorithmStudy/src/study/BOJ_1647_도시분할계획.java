package study;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_1647_도시분할계획 {
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

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src/study/도시분할_test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		ArrayList<Edge> list = new ArrayList<>();

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		arr = new int[N + 1];
		makeSet(N);

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list.add(new Edge(from, to, w));
		}
		Collections.sort(list);

		// 간선이 적을 때가 프림 : 정점
		// 간선이 많을 때가 크루스칼 : 간선
		int E = 0;
		int result = 0;
		for (Edge e : list) {
			if (E == N - 2)
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
		// 정신차려라 세령아 aRoot다
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
