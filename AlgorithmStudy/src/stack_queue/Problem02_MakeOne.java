package stack_queue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Problem02_MakeOne {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int min = 999;
		Queue<int[]> q = new LinkedList<>();

		// [0] : 나누고 남은 수
		// [1] : 그 수에 도달하는데까지의 횟수
		q.offer(new int[] { N, 0 });
		while (!q.isEmpty()) {
			int out = q.peek()[0];
			if (q.peek()[0] == 1) {
				min = Math.min(min, q.peek()[1]);
				q.poll();
				break;
			}

			if (out % 5 == 0) {
				q.offer(new int[] { out / 5, q.peek()[1] + 1 });
			}
			if (out % 3 == 0) {
				q.offer(new int[] { out / 3, q.peek()[1] + 1 });
			}
			if (out % 2 == 0) {
				q.offer(new int[] { out / 2, q.peek()[1] + 1 });
			}
			q.offer(new int[] { out - 1, q.peek()[1] + 1 });

			q.poll();
		}
		bw.write(String.valueOf(min));

		br.close();
		bw.flush();
		bw.close();
	}
}
