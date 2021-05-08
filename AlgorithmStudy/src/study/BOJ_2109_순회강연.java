package study;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_2109_순회강연 {
	private static class Lecture implements Comparable<Lecture> {
		int pay;
		int day;

		public Lecture(int pay, int day) {
			super();
			this.pay = pay;
			this.day = day;
		}

		@Override
		public int compareTo(Lecture o) {
			if (this.pay == o.pay) {
				return this.day - o.day;
			}
			return o.pay - this.pay;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Lecture> q = new PriorityQueue<>();

		int N = Integer.parseInt(br.readLine());

		// schedule을 boolean으로 한다면?
		boolean[] schedule = new boolean[10001];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			q.offer(new Lecture(p, d));
		}
		int money = 0;
		f: while (!q.isEmpty()) {
			Lecture today = q.poll();
			for (int i = today.day; i > 0; i--) {
				if (schedule[i]) {
					schedule[i] = true;
					money += today.pay;
					continue f;
				}
			}
		}
		bw.write(String.valueOf(money));
		bw.flush();
		bw.close();
		br.close();
	}
}
