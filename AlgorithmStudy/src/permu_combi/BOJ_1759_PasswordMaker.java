package permutation_combination;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_1759_PasswordMaker {
	static String[] arr;
	static String vowels = "aeiou";
	static ArrayList<String[]> list = new ArrayList<>();
	static int pwLen;
	static int word;
	static int index = 0;

	static void combi(int toSelect, String[] selected, int start) {
		if (toSelect == pwLen) {
			int vowel = 0;
			int not_vowel = 0;

			for (String s : selected) {
				if (vowels.contains(s)) {
					vowel++;
				} else {
					not_vowel++;
				}
			}

			if (vowel < 1 || not_vowel < 2)
				return;
			String[] tmp = Arrays.copyOfRange(selected, 0, pwLen);
			Arrays.sort(tmp);
			list.add(tmp);
			return;
		}

		for (int i = start; i < word; i++) {
			selected[toSelect] = arr[i];
			combi(toSelect + 1, selected, i + 1);
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		pwLen = Integer.parseInt(st.nextToken());
		word = Integer.parseInt(st.nextToken());
		arr = br.readLine().split(" ");

		// 지훈님 : 먼저 정렬해주고, 그다음에
		// 
		combi(0, new String[pwLen], 0);
		Collections.sort(list, new Comparator<String[]>() {
			
			public int compare(String[] a, String[] b) {
				for (int i = 0; i < a.length; i++) {
					// 똑같지 않다면 바로 리턴해주고
					if (!a[i].equals(b[i])) {
						return a[i].compareTo(b[i]);
					}
					// 똑같다면 다음 값을 비교하게 넘어간다!
				}
				return a[pwLen - 1].compareTo(b[pwLen - 1]);
			}
		});
		for (String[] s : list) {
			for (String i : s) {
				sb.append(i);
			}
			sb.append("\n");
		}
		bw.write(String.valueOf(sb));
		
		bw.flush();
		bw.close();
		br.close();
	}
}
