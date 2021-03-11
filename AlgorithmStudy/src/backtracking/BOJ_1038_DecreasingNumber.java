package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_1038_DecreasingNumber {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<Long> q = new LinkedList<Long>();

		long n = Integer.parseInt(br.readLine());
		
		// 10이하 = 그냥 그 숫자 출력 / 1022 이상 = -1 출력
		if(n<10||n>1022) {
			System.out.println(n<10?n:-1);
			return;
		}
		
		int cnt = 0;
		for (long i = 0; i < 10; i++) {
			q.offer(i);
			cnt++;
		}
		for (int k = 0; k < 9; k++) {
			
			// 현재 큐 크기만큼 돌릴 거임
			int size = q.size();
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < q.peek() % 10; j++) {
					if (cnt == n) {
						System.out.print((q.peek() * 10 + j));
						return;
					}
					
					q.offer(q.peek() * 10 + j);
					if (q.peek() % 10 == 0 && cnt == n) {
						System.out.print(q.peek() * 10 + " ");
						return;
					}
					cnt++;	}
				q.poll();
			}
		}
	}
}
