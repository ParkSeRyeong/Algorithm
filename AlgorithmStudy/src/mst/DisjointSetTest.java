package mst;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DisjointSetTest {
	static int N;
	static int []parents;

	/* 크기가 1인 단위 집합을 생성 */
	static void makeSet() {
		for (int i = 0; i < N+1; i++) {
			parents[i] = i;
		}
	}

	/** 인자로 들어온 원소가 속한 집합의 대표자(ref)를 탐색 */
	static int findSet(int a) {
		if (parents[a] == a) {
			return a;
		}

		return parents[a] = findSet(parents[a]);
	}

	static boolean union(int a, int b) {
		int aRoot = findSet(a);
		
		int bRoot = findSet(b);

		// 이미 합쳐져서 같은 집합인 경우
		if (aRoot == bRoot)
			return false;

		parents[bRoot] = aRoot;
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int tc = Integer.parseInt(br.readLine());
		for(int t=1;t<=tc;t++) {
			sb.append("#").append(t).append(" ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			

			parents = new int[N+1];

			// 1. make set
			makeSet();

			// 2. operate
			int[] in = new int[3];
			for (int i = 0; i < m; i++) {
				in = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
				if (in[0] == 0) {
					union(in[1], in[2]);
				} else {
					sb.append(findSet(in[1]) == findSet(in[2]) ? 1 : 0);
				}
			}
			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
		
	}
}