package study;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_3107_IPv6 {
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/study/IPv6_test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		StringBuilder sb = new StringBuilder();

		String str = br.readLine();
		int colon_cnt = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ':')
				colon_cnt++;
		}
		String[] s = new String[colon_cnt + 1];
		int[] zero = new int[colon_cnt + 1];

		int cnt = 0;
		int zeros = 0;
		boolean flag = false;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ':') {
				s[cnt] = sb.toString().length() != 0 ? sb.toString() : "";
				
				if(i+1<str.length() && str.charAt(i+1)==':') {
					zero[cnt]=-1;
				}else {
					zero[cnt] = zeros;
				}
				sb.setLength(0);
				zeros = 0;
				cnt++;
				flag=false;
			} else {
				if (str.charAt(i) != '0') {
					flag = true;
				}
				if (!flag) {
					zeros++;
				} else {
					sb.append(str.charAt(i));
				}
			}
		}
		s[cnt] = sb.toString();
		zero[cnt] = zeros;
		sb.setLength(0);

		flag = false;
		for (int i = 0; i < s.length; i++) {
			String now = s[i];
			// 1. 4면 그냥 그대로!
			if (now.length() == 4) {
				result.append(now).append(":");
			}

			else if (now.length() > 0 && now.length() < 4) {
				String tmp = new String(new char[4-now.length()]).replace("\0", "0");
				sb.append(tmp).append(now);
				result.append(sb.toString()).append(":");
				sb.setLength(0);
			} else {
				
				// :2:33:: 부분 처리하기. 난 잔다.
				if(zero[i]!=-1) {
					result.append("0000:");
				}
				else if (!flag) {
					for (int j = 0; j < 8 - colon_cnt; j++) {
						result.append("0000:");
					}
					if (str.charAt(str.length() - 1) == ':' || str.charAt(0) == ':') {
						result.append("0000:");
					}
					flag = true;
				}
			}
		}
		result.setLength(result.length() - 1);
		System.out.println(result.toString());
		br.close();
	}
}
