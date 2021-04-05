package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_9177_단어섞기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		f: for (int t = 1; t <= N; t++) {
			String[] tmp = br.readLine().split(" ");
			char[] a = tmp[0].toCharArray();
			char[] b = tmp[1].toCharArray();
			char[] c = tmp[2].toCharArray();

			Queue<Character> q = new LinkedList<>();
			for (int i = 0; i < c.length; i++) {
				q.offer(c[i]);
			}
//			System.out.println("*********************");
//			System.out.println(Arrays.toString(c));
//			System.out.println("*********************");
			int pa = 0;
			int pb = 0;
			int cnt = 0;
			while (!q.isEmpty()) {
				System.out.println("-------------");
				System.out.println("현재 비교 : " + q.peek());
				// 둘 다 똑같으면 cnt 증가.
				if(pa+cnt<a.length&&pb+cnt<b.length) {
					if (a[pa+cnt] == q.peek() && b[pb+cnt] == q.peek()) {
						System.out.println("앗 둘 다 똑같다 : "+pa+" "+pb);
						cnt++;
						q.poll();
						continue;
					}
				}
				// 둘 중 하나와만 같다면?
				System.out.println("현재 cnt : "+cnt);
				if (pa+cnt < a.length && a[pa+cnt] == q.peek()) {
					if (cnt != 0) {
						System.out.println("\tpa :" + pa+" -> "+(pa+cnt));
						pa += cnt;
						cnt = 0;
					}
					pa++;
				} else if (pb+cnt < b.length && b[pb+cnt] == q.peek()) {
					if (cnt != 0) {
						System.out.println("\tpb :" + pb+" -> "+(pb+cnt));
						pb += cnt;
						cnt = 0;
					}
					pb++;
				} else {
					sb.append("Data set ").append(t).append(": no\n");
					continue f;
				}
				q.poll();
			}
			sb.append("Data set ").append(t).append(": yes\n");
		}
		System.out.println(sb.toString());
	}
}
