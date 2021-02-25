package ssafy_0225;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_8958_OXQuiz {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < N; tc++) {
			int sum = 0;
			String str = br.readLine();
			int[] arr = new int[str.length()];
			if (str.charAt(0) == 'O') {
				arr[0] = 1;
				sum += arr[0];
			}
			for (int i = 1; i < str.length(); i++) {
				if (str.charAt(i) == 'X')
					continue;

				arr[i] = arr[i - 1] + 1;
				sum += arr[i];
			}
			sb.append(sum).append("\n");
		}
		bw.write(String.valueOf(sb));
		bw.flush();
		bw.close();
		br.close();
		
	}
}
