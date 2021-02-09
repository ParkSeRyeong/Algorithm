package ssafy_algo_0209;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1158_Yosepus2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		Queue<Integer> q = new LinkedList<Integer>();
		for (int i = 1; i < N + 1; i++) {
			q.offer(i);
		}
		int index = 0;
		while (!q.isEmpty()) {
			index++;
			if (index % K == 0) {
				System.out.print(q.poll()+" ");
			} else {
				q.offer(q.poll());
			}
		}
	}

}
