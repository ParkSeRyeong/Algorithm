package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_1038_DecreasingNumber {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// Queue<Integer> q = new LinkedList<Integer>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<Integer> q = new LinkedList<Integer>();

		// 현재 cnt는 10. 시작.
		long n = Integer.parseInt(br.readLine());
		if (n < 10) {
			System.out.println(n);
			return;
		}

		int cnt = 0;
		for (int i = 0; i < 10; i++) {
			q.offer(i);
			cnt++;
		}
		int len = 10;
		for (int k = 0; k < 6; k++) {	
			int size = q.size();

			for (int i = 0; i < size; i++) {
				long end = q.peek();
				while (end / 10 > 0) {
					end %= 10;
				}

				for (int j = 0; j < end; j++) {
					if (cnt == n) {
						System.out.println(q.peek() * len + j);
						return;
					}
					System.out.print(q.peek() * len + j + " ");
					q.offer(q.peek() * len + j);
					if (end == 0 && cnt == n) {
						System.out.print(q.peek() * len+" ");
						return;
					}
					cnt++;
				}
				System.out.println();
				q.poll();
			}
		}

		System.out.println(-1);
	}
}
