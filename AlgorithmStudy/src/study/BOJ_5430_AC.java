package study;

import java.io.*;
import java.lang.*;
import java.util.*;

public class BOJ_5430_AC {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());

		f: for (int t = 0; t < tc; t++) {

			// 1. 입력받은 함수 ex) RDRD
			String func = br.readLine();

			// 2. 정수의 개수 / 정수배열
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine(), "\\[|\\]|,");
			// 3. 0개면 그냥 D있으면 error, 없으면 [] 출력.
			if (N == 0) {
				if (func.contains("D")) {
					sb.append("error\n");
				} else {
					sb.append("[]\n");
				}
				continue f;
			}

			// 4. 입력부
			int[] arr = new int[N];
			int j = 0;
			while (st.hasMoreTokens()) {
				String s = st.nextToken();
				if (s.equals(" "))
					continue;
				arr[j] = Integer.parseInt(s);
				j++;
			}

			// 5. tp[0]은 left, tp[1]은 right
			int[] tp = new int[2];
			tp[0] = 0;
			tp[1] = N - 1;

			int now = 0;
			for (int i = 0; i < func.length(); i++) {

				// left가 right를 초과 = 배열이 비었다
				if (tp[0] > tp[1]) {
					sb.append("error\n");
					continue f;
				}

				char NOW = func.charAt(i);
				switch (NOW) {
				case 'R':
					now = (now + 1) % 2;
					break;
				case 'D':
					if (now == 0)
						tp[0]++;
					else
						tp[1]--;
					break;
				}
			}

			// 마지막에 다 지워서 길이가 0일 때 에러남. 그거 방지하려고 if문 하나 넣어줌.
			sb.append("[");
			if (tp[0] <= tp[1]) {
				if (now == 0) {
					for (int i = tp[0]; i <= tp[1]; i++) {
						sb.append(arr[i]).append(",");
					}
				} else {
					for (int i = tp[1]; i >= tp[0]; i--) {
						sb.append(arr[i]).append(",");
					}
				}
				sb.setLength(sb.length() - 1);
			}
			sb.append("]\n");
		}
		System.out.println(sb);

	}
}
