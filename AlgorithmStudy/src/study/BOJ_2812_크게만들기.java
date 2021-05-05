package study;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_2812_크게만들기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		String str = br.readLine();
		int del = 0;

		Deque<Integer> deque = new LinkedList<Integer>();
		deque.add(str.charAt(0) - '0');

		for (int i = 1; i < N; i++) {
			int now = str.charAt(i) - '0';

			// 1. 큐 맨 끝이 나보다 클 땐 그냥 넣기.
			if (deque.peekLast() < now) {

				while (!deque.isEmpty() && deque.peekLast() < now && del < K) {
					deque.pollLast();
					del++;
				}
			}
			deque.offer(now);
		}
		for (int i = 0; i < N - K; i++) {
			sb.append(deque.poll());
		}
		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();
	}
}
