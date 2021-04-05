package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class BOJ_12904_A와B_2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String S = br.readLine();
		String T = br.readLine();
		for (int i = 0; i < T.length(); i++) {
			sb.append(T.charAt(i));
		}

		int cnt = T.length();
		while (cnt != S.length()) {
			--cnt;

			if (sb.charAt(sb.length() - 1) == 'A') {
				sb.deleteCharAt(sb.length() - 1);
			} else {
				sb.deleteCharAt(sb.length() - 1);
				sb.reverse();
			}
		}
		System.out.println(sb.toString().equals(S) ? 1 : 0);

		br.close();
	}

}
