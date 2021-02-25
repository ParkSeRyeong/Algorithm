package ssafy_0225;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import ssafy_0129.io.OutputStreamEx;

public class BOJ_2999_SecretEmail {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		String pw = br.readLine();

		int r = 0;
		int c = 0;
		for (int i = 1; i < pw.length(); i++) {
			if (pw.length() % i == 0) {
				if (pw.length() / i < i) {
					break;
				}
				r = i;
				c = pw.length() / i;
			}
		}
		char[][] arr = new char[r][c];
		int index = 0;

		for (int j = 0; j < c; j++) {
			for (int i = 0; i < r; i++) {
				arr[i][j] = pw.charAt(index);
				index++;
			}
		}
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				sb.append(arr[i][j]);
			}
		}
		bw.write(String.valueOf(sb.toString()));
		bw.flush();
		bw.close();
		br.close();
	}
}
