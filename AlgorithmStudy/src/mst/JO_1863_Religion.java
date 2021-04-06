package mst;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.StringTokenizer;
import java.io.IOException;

public class JO_1863_Religion {
	static int[] students;
	static BitSet bs;
	static int N;

	public static void makeSet() {
		for (int i = 1; i < N + 1; i++) {
			students[i] = i;
			bs.set(i);
		}
	}

	public static int findSet(int a) {
		if (students[a] == a)
			return a;
		return students[a] = findSet(students[a]);
	}

	public static boolean unionSet(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if (aRoot == bRoot)
			return false;
		students[bRoot] = aRoot;
		bs.clear(bRoot);
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		students = new int[N + 1];
		bs = new BitSet(N + 1);

		makeSet();
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			unionSet(a, b);
		}
		int cnt = 0;
		for (int i = 0; i < N + 1; i++) {
			if (bs.get(i))
				cnt++;
		}
		System.out.println(cnt);
	}
}
