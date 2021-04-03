package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 보이어무어로 했으나 시간초과ㅠㅡㅠ
// 백준은 최악의 경우를 주기 때문인듯 함.
public class BOJ_16916_부분문자열 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		char[] text = in.readLine().toCharArray();
		char[] sub = in.readLine().toCharArray();
		int len = sub.length;

		int[] skip = new int[26];
		for (int i = 0; i < 26; i++)
			skip[i] = len;
		for (int i = 0; i < len; i++) {
			skip[sub[i] - 97] = len - i - 1;
		}

		int ptxt = len - 1;
		int ppat = len - 1;
		while (ptxt < text.length) {
			ppat = len - 1;
			// 값이 같은 동안 계속 이동
			while (text[ptxt] == sub[ppat]) {
				if (ppat == 0) {
					System.out.println(1);
					return;
				}
				ptxt--;
				ppat--;
			}

			ptxt += skip[sub[ppat] - 97] > len - ppat ? skip[sub[ppat] - 97] : len - ppat;
		}
		System.out.println(0);
	}
}
