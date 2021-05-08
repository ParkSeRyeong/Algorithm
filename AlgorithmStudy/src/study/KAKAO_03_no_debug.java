package study;

import java.util.Arrays;
import java.util.Stack;

public class KAKAO_03_no_debug {

	public static String solution(int n, int now, String[] cmd) {
		String answer = "";
		StringBuilder sb = new StringBuilder();
		boolean[] arr = new boolean[n];
		Arrays.fill(arr, true);
		Stack<Integer> stack = new Stack<>();

		int first = 0;
		int last = n - 1;
		for (String s : cmd) {
			switch (s.charAt(0)) {
			case 'D':
				if (now != last) {
					int tmp = now;
					int cnt = 0;
					while (cnt < s.charAt(2) - '0') {
						if (tmp == last) {
							break;
						}
						if (arr[tmp + 1]) {
							cnt++;
						}
						tmp++;
					}
					if (tmp == last) {
						if (arr[tmp]) {
							now = last;
						}
					} else {
						now = tmp;
					}
				}
				break;
			case 'U':
				if (now != first) {
					int tmp = now;
					int cnt = 0;
					while (cnt < s.charAt(2) - '0') {
						if (tmp == first) {
							break;
						}
						if (arr[tmp - 1]) {
							cnt++;
						}
						tmp--;
					}
					if (tmp == first) {
						if (arr[tmp]) {
							now = first;
						}
					} else {
						now = tmp;
					}
				}
				break;
			case 'C':
				if (first == last) {
					arr[now] = false;
					stack.add(now);
					continue;
				}
				arr[now] = false;
				stack.add(now);
				// 맨 위
				if (now == first) {
					first++;
					now++;
				} else if (now == last) {
					last--;
					now--;
				} else {
					now++;
				}
				break;
			case 'Z':
				if (!stack.isEmpty()) {
					int re = stack.peek();
					arr[stack.pop()] = true;
					if (first == last) {
						first = last = re;
					}
				}
				break;
			}
		}

		for (int i = 0; i < n; i++) {
			sb.append(arr[i] ? "O" : "X");
		}
		answer = sb.toString();
		return answer;
	}

	public static void main(String[] args) {
		String[] cmd = { "C", "C", "C", "C", "D" };
		System.out.println(solution(3, 0, cmd));
	}
}
