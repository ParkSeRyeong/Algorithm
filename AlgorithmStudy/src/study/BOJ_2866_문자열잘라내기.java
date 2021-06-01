package study;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_2866_문자열잘라내기 {
	static int r, c;
	static char[][] word;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/study/문자열잘라내기_test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		word = new char[r][c];
		// HashMap<String, Integer> map = new HashMap<>();

		for (int i = 0; i < r; i++) {
			word[i] = br.readLine().toCharArray();
		}

		int start = 0, end = r - 1;
		int mid = 0;

		while (start <= end) {
			// 반 나눠서 아래만 봤을 때
			mid = (start + end) / 2;

			// 밑으로 겹치는 게 있으면 위에도 보자
			if (isDuplicate(mid, end) == true) {
				end = mid - 1;
			}
			// 없으면 위에 다 쳐내자
			else {
				start = mid + 1;
			}
		}
		System.out.println(end);
	}

	private static boolean isDuplicate(int mid, int end) {
		// 여기서 문자열 비교해서 중복되는 거 있으면 true 뱉어줄 거임.
		HashSet<String> set = new HashSet<>();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < c; i++) {
			sb.setLength(0);
			for (int j = mid; j <= end; j++) {
				sb.append(word[j][i]);
			}
			if (!set.add(sb.toString())) {
				return true;
			}
		}

		return false;
	}
}
