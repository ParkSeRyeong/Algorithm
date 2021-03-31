package mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class node implements Comparable<node> {
	int from;
	int to;
	int w;

	public node(int from, int to, int w) {
		super();
		this.from = from;
		this.to = to;
		this.w = w;
	}

	@Override
	public int compareTo(node n) {
		return Integer.compare(this.w, n.w);
	}

}

public class BOJ_1197_MST {
	static int[] node;

	public static void make() {
		for (int i = 1; i < node.length; i++) {
			node[i] = i;
		}
	}

	public static int find(int v) {
		if (node[v] == v)
			return node[v];
		return node[v] = find(node[v]); //으아악
	}

	public static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if (aRoot == bRoot)
			return false;

		//와!!!!! 윤정님이 살려줌 bRoot이다 해치웠다
		node[bRoot] = aRoot;
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());

		node = new int[V + 1];
		PriorityQueue<node> q = new PriorityQueue<>();
		make();
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			q.add(new node(a, b, w));
			q.add(new node(b, a, w));
		}

		int n = 0;
		int sum = 0;
		while (!q.isEmpty()) {
			if (n == V)
				break;
			node Node = q.poll();
			if (union(Node.from, Node.to)) {
				sum += Node.w;
				n++;
			}
		}
		System.out.println(sum);
	}
}
