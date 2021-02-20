package ssafy_algo_0215;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class BOJ_3040_0215_Snowwhite {

	static int[] num = new int[9];
	static int N = 7;
	static StringBuilder sb = new StringBuilder();
	static int flag = 0;

	public static void Combination(int toSelect, int[] selected, int start) {
		if (toSelect == N) {
			int sum = 0;
			for (int i : selected) {
				sum += i;
			}
			if (sum == 100 && flag == 0) {
				//Arrays.sort(selected);
				for (int i : selected) {
					sb.append(i);
					sb.append("\n");
				}
				flag = 1;
			}
			return;
		}

		for (int i = start; i < 9; i++) {
			selected[toSelect] = num[i];
			Combination(toSelect + 1, selected, i + 1);
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int i = 0; i < 9; i++) {
			num[i] = Integer.parseInt(br.readLine());
		}
		Combination(0, new int[7], 0);
		bw.write(String.valueOf(sb));

		bw.flush();
		bw.close();
		br.close();
	}
}
