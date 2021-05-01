package study;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_6137_문자열생성 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src/study/문자열_test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		char[] arr = new char[N];

		for (int i = 0; i < N; i++) {
			arr[i] = br.readLine().charAt(0);
			sb.append(arr[i]);
		}

		String str = sb.toString();
		sb = new StringBuilder();

		int left = 0;
		int right = N - 1;
		int cnt = 0;
		while (left <= right) {
			// 앞글자가 뒷글자보다 작다
			if (arr[left] < arr[right]) {
				sb.append(arr[left]);
				left++;
			}

			// 뒷글자가 앞글자보다 작다
			else if (arr[left] > arr[right]) {
				sb.append(arr[right]);
				right--;
			}

			// 하나 남았당
			else if (left == right) {
				sb.append(arr[left]);
				break;
			}

			// 앞뒤글자가 똑같다면?
			else {
				int s = left;
				int e = right;
				int tmp_cnt = 0;
				while (s<e) {

					// 계속 똑같은거 타고 들어가다가 다른 글자가 나온다면
					if (arr[s] != arr[e])
						break;
					s++;
					e--;
					tmp_cnt++;
						// FFFF H A FFFF -> FFFFA FFFFH
				}
				// 와 개행이었다
				if (arr[s] < arr[e]) {
					sb.append(arr[left]);
					left++;
				} else {
					sb.append(arr[right]);
					right--;
				}
			}
			cnt++;
			if (cnt % 80 == 0)
				sb.append("\n");
		}
		System.out.println(sb);
		br.close();
	}
}
