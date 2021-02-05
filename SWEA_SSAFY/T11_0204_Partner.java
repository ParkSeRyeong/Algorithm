package ssafy_algo_0204;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class T11_0204_Partner {
	static StringBuilder sb = new StringBuilder();
	static String[] bracket = { "{", "[", "<", "(", "}", "]", ">", ")" };
	static int[] num;
	static char[] arr;
	static Stack<Character> s = new Stack<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 1. 테스트케이스 입력
		int tc = 10;

		for (int t = 1; t < tc + 1; t++) {
			sb.append("#" + t + " ");

			int len = Integer.parseInt(br.readLine());
			arr = new char[len];
			int flag = 1;
			String tmp = br.readLine();
			for (int i = 0; i < len; i++) {
				arr[i] = tmp.charAt(i);

				// 스택 구현 쪽
				// 지훈님 코드 다시 해보기!
			}

			if (flag == 0) {
				sb.append(0 + "\n");
			} else {
				sb.append(1 + "\n");
			}

		}
		System.out.println(sb.toString());
	}
}
