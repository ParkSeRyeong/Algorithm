package greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_1946_Intern {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N + 1];

			for (int i = 1; i < N + 1; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				arr[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());

			}

			int cnt = 1;
			int score = arr[1];
			for (int i = 2; i < N + 1; i++) {
				if (arr[i] <= score) {
					cnt++;
					score = arr[i];
				}
			}
			sb.append(cnt).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}
