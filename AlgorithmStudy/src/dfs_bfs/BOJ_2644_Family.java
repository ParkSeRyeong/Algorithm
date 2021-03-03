package dfs_bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class BOJ_2644_Family {

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/dfs_bfs/family_test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		ArrayList<Integer>[] people = new ArrayList[n + 1];
		for (int i = 0; i < people.length; i++) {
			people[i] = new ArrayList<>();
		}
		boolean[] visited = new boolean[n + 1];

		st = new StringTokenizer(br.readLine());
		int person_1 = Integer.parseInt(st.nextToken());
		int person_2 = Integer.parseInt(st.nextToken());

		int m = Integer.parseInt(br.readLine());
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			people[a].add(b);
			people[b].add(a);
		}

		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(person_1);
		visited[person_1] = true;
		int cnt = 0;

		out: while (true) {
			if (q.isEmpty()) {
				cnt = -1;
				break;
			}

			int size = q.size();
			for (int i = 0; i < size; i++) {
				int tmp = q.poll();
				for (int k : people[tmp]) {
					if (k == person_2)
						break out;
					if (!visited[k]) {
						visited[k] = true;
						q.offer(k);
					}
				}
			}
			cnt++;
		}

		bw.write(person_1 == person_2 ? String.valueOf(0) : String.valueOf(cnt));
		bw.flush();
		bw.close();
		br.close();
	}
}
