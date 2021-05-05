package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class BOJ_1715_카드정렬하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> q = new PriorityQueue<>();
		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			q.offer(Integer.parseInt(br.readLine()));
		}

		int total = 0;
		while (q.size() != 1) {
			int sum = 0;
			sum += q.poll();
			sum += q.poll();
			total += sum;
			q.offer(sum);
		}
		System.out.println(total);
		br.close();
	}
}
