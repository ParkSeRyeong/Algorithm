package study;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class BOJ_5052_전화번호목록 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int tc = Integer.parseInt(br.readLine());
		f: for (int t = 0; t < tc; t++) {
			int N = Integer.parseInt(br.readLine());
			String[] arr = new String[N];
			for (int i = 0; i < N; i++) {
				arr[i] = br.readLine();
			}

			Arrays.sort(arr);

			for (int i = 0; i < N - 1; i++) {
				if (arr[i + 1].startsWith(arr[i])) {
					bw.write("NO\n");
					continue f;
				}
			}
			bw.write("YES\n");
		}
		bw.flush();
		bw.close();
		br.close();

	}
}
