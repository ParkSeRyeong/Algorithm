package study;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_2812_크게만들기2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		String str = br.readLine();
		int del = 0;

		Stack<Integer> s = new Stack<>();
		s.push(str.charAt(0) - '0');

		for (int i = 1; i < N; i++) {
			int now = str.charAt(i) - '0';
			if(!s.isEmpty() && s.peek() < now) {
				while (!s.isEmpty() && s.peek() < now && del < K) {
					s.pop();
					del++;
				}
			}
			s.push(now);
		}
		while(!s.isEmpty()) {
			sb.append(s.pop());
		}
		sb.reverse().setLength(N-K);
		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();
	}
}
