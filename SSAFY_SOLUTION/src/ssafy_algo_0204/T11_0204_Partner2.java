package ssafy_algo_0204;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class T11_0204_Partner2 {
	static StringBuilder sb = new StringBuilder();
	static String[] bracket = { "{", "[", "<", "(", "}", "]", ">", ")" };
	static int[] num;
	static String[] arr;

	public static void match(String bracket) {
		switch (bracket) {
		case "{":
			num[0]++;
			break;
		case "[":
			num[1]++;
			break;
		case "<":
			num[2]++;
			break;
		case "(":
			num[3]++;
			break;
		case "}":
			num[4]++;
			break;
		case "]":
			num[5]++;
			break;
		case ">":
			num[6]++;
			break;
		case ")":
			num[7]++;
			break;

		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 1. 테스트케이스 입력
		int tc = 10;

		for (int t = 1; t < tc + 1; t++) {
			sb.append("#" + t + " ");

			int len = Integer.parseInt(br.readLine());
			arr = new String[len];
			num = new int[len];
			String tmp = br.readLine();
			for (int i = 0; i < len; i++) {
				arr[i] = String.valueOf(tmp.charAt(i));

				match(arr[i]);
			}

			int flag = 1;
			for (int i = 0; i < 4; i++) {
				if (num[i] != num[i + 4]) {
					flag = 0;
					break;
				}
			}
			sb.append(flag + "\n");
			
		}
		System.out.println(sb.toString());
	}
}
