package backtracking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 
 * boolean 배열로 해서 해보기
 * 
 */
public class BOJ_1062_Teaching {
	static int Max = 0;
	static int words_cnt = 0;
	static String[] word;
	// static char[] exist;

	public static void combi(char[] exist, int k, int toSelect, char[] selected, int start) {
		if (toSelect == k || toSelect == words_cnt) {
			int possible_word = word.length;
			String combi_str = String.valueOf(selected);
			for (String s : word) {
				for (int i = 0; i < s.length(); i++) {
					String c = String.valueOf(s.charAt(i));
					if (!"antic".contains(c) && !combi_str.contains(c)) {
						possible_word--;
						break;
					}
				}
			}
			Max = Math.max(Max, possible_word);
			return;
		}

		for (int i = start; i < exist.length; i++) {
			selected[toSelect] = exist[i];
			combi(exist, k, toSelect + 1, selected, i + 1);
		}
	}

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/backtracking/teaching_test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		word = new String[N];

		if (K >= 5) {
			boolean[] visited = new boolean[26];
			visited['a' - 'a'] = true;
			visited['n' - 'a'] = true;
			visited['t' - 'a'] = true;
			visited['i' - 'a'] = true;
			visited['c' - 'a'] = true;

			for (int i = 0; i < N; i++) {
				String str = br.readLine();				
				str = str.substring(4, str.length() - 4);
				word[i] = str;
				for (int j = 0; j < str.length(); j++) {
					if (!visited[str.charAt(j) - 'a']) {
						visited[str.charAt(j) - 'a'] = true;
						words_cnt++;
					}
				}
			}

			char[] exist = new char[words_cnt];
			int idx = 0;
			for (int i = 0; i < 26; i++) {
				if (visited[i] && !"antic".contains(String.valueOf((char) (i + 97)))) {
					exist[idx] = (char) (i + 97);
					idx++;
				}
			}
			
			if (K - 5 > words_cnt)
				combi(exist, K - 5, 0, new char[words_cnt], 0);

			else
				combi(exist, K - 5, 0, new char[K - 5], 0);
		}
		else if (K < 5) 	Max=0;
		else if (K == 26) 	Max=N;

		bw.write(String.valueOf(Max));
		br.close();
		bw.flush();
		bw.close();
	}
}
