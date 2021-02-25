package ssafy_0225;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_3985_RollCake {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int L = Integer.parseInt(br.readLine());
		int people = Integer.parseInt(br.readLine());

		int[] rollcake = new int[L];
		int[] cnt = new int[people];

		int predict = 0;
		int predict_idx = 0;
		int Max = Integer.MIN_VALUE;
		int Max_idx = -1;

		for (int i = 0; i < people; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			for (int j = start; j <= end; j++) {
				if (rollcake[j] == 0) {
					rollcake[j] = i + 1;
					cnt[i]++;
				}
			}
			if (Max < cnt[i]) {
				Max = cnt[i];
				Max_idx = i + 1;
			}
			if (predict < end - start) {
				predict = end - start;
				predict_idx = i + 1;
			}
		}
		sb.append(predict_idx).append("\n").append(Max_idx);
		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();

	}
}
