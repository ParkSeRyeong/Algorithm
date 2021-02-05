package ssafy_algo_0204;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class T10_0204_pwMaker {
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<Integer> q = new LinkedList<>();
		int tc = 10;

		for (int n = 0; n < tc; n++) {
			int t = Integer.parseInt(br.readLine());
			sb.append("#" + t + " ");
			q.clear();
			StringTokenizer st = new StringTokenizer(br.readLine());
			while (st.hasMoreElements()) {
				q.offer(Integer.parseInt(st.nextToken()));
			}
			int i = 0;
			while (true) {
				int tmp = q.poll();
				if (tmp - (i % 5 + 1) <= 0) {
					q.offer(0);
					break;
				}
				q.offer(tmp - (i % 5 + 1));
				i++;
			}
			// poll할 때마다 queue 사이즈가 바뀌니까! 그래서 반토막 나는 겄!!!!
			while(!q.isEmpty()) {
				sb.append(q.poll() + " ");
			}
			
			
			
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
