package study;

import java.util.Arrays;
import java.util.Stack;

public class KAKAO_03 {

	public static void show(boolean[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i]) {
				System.out.print("O ");
			} else {
				System.out.print("X ");
			}
		}
		System.out.println();
	}

	public static String solution(int n, int now, String[] cmd) {
		String answer = "";
		boolean[] arr = new boolean[n];
		Arrays.fill(arr, true);
		Stack<Integer> stack = new Stack<>();
		System.out.println("--------"+now+"--------");

		int first = 0;
		int last = n - 1;
		for (String s : cmd) {
			switch (s.charAt(0)) {
			case 'D':
				System.out.println("D : " + s.charAt(2) + " down!");
				if (now != last) {
					int tmp = now;
					int cnt = 0;
					while (cnt < s.charAt(2) - '0') {
						if (tmp == last) {
							break;
						}
						// 지워지지 않은 행이라면
						if (arr[tmp + 1]) {
							cnt++;
						}
						tmp++;
					}
					// 가장 마지막 칸이고 안 지워졌다면 그냥 마지막 칸으로 이동. 마지막칸도 지워졌다면 걍 냅둠.
					if (tmp == last) {
						if (arr[tmp]) {
							now = last;
						}
					}
					// 마지막 칸 아니고 cnt가 다 채워졌다면?
					else {
						now = tmp;
					}
				}
				System.out.print("\t현재 " + now + "행\n\t\t");
				show(arr);
				break;
			case 'U':
				System.out.println("U : " + s.charAt(2) + " Up!");
				if (now != first) {
					int tmp = now;
					int cnt = 0;
					while (cnt < s.charAt(2) - '0') {
						if (tmp == first) {
							break;
						}
						// 지워지지 않은 행이라면
						if (arr[tmp - 1]) {
							cnt++;
						}
						tmp--;
					}
					// 가장 윗칸이고 안 지워졌다면 그냥 맨 위 칸으로 이동. 맨 위 칸도 지워졌다면 걍 냅둠.
					if (tmp == first) {
						if (arr[tmp]) {
							now = first;
						}
					}
					// 맨 윗칸 아니고 cnt가 다 채워졌다면?
					else {
						now = tmp;
					}
				}
				System.out.print("\t현재 " + now + "행\n\t\t");
				show(arr);
				break;
			case 'C':
				System.out.println("C : " + now + "지운다!");
				arr[now] = false;
				stack.add(now);
				// 맨 위
				if (now == first) {
					first++;
					now++;
				}
				// 맨 아래
				else if (now == last) {
					last--;
					now--;
				}
				// 어정쩡
				else {
					now++;
				}
				System.out.print("\t현재 " + now + "행\n\t\t");
				show(arr);
				break;
			case 'Z':
				System.out.println("Z : " + stack.peek() + "복구!");
				arr[stack.pop()] = true;
				System.out.print("\t현재 " + now + "행\n\t\t");
				show(arr);
				break;
			}
		}

		return answer;
	}

	public static void main(String[] args) {
		String[] cmd = { "D 2","C","U 3","C","D 4","C","U 2","Z","Z","U 1","C"};
		solution(8, 2, cmd);
	}
}
