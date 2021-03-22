package mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MST1_Kruskal {
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

	static int V, E;
	static int parents[];
	static Edge[] edgeList;

	/* 크기가 1인 단위 집합을 생성 */
	static void make() {
		for (int i = 0; i < V; i++) {
			parents[i] = i;
		}
	}

	/* 인자로 들어온 원소가 속한 집합의 대표자를 탐색 */
	static int findSet(int a) {
		if (parents[a] == a) // 내가 그 집합의 대표자
			return a;
		// Path Compression 전
		// return findSet(parents[a]);

		// Path Compression 후
		return parents[a] = findSet(parents[a]);
		// 근데 이렇게 Path Compression을 한다고 해서 rank 관리가 되진 않는다.
		// 대표를 찾아가는 과정에서 path compression이 일어나느데, 대표끼리 union을 하면 이게 안 됨.
	}

	static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);

		// 이미 합쳐져 있는 경우
		if (aRoot == bRoot)
			return false;

		parents[bRoot] = aRoot;
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		parents = new int[V];
		edgeList = new Edge[E];

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			edgeList[i] = new Edge(from, to, weight);
		}

		Arrays.sort(edgeList);

		make();
		int result = 0; // 가중치의 합
		int count = 0; // 선택한 간선 수

		for (Edge edge : edgeList) {
			if (union(edge.from, edge.to)) {
				result += edge.weight;
				if (++count == V - 1)
					break;
			}
		}
		System.out.println(result);
	}
}
