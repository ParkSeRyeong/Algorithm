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

public class ASDSAD {
	static ArrayList<String> words = new ArrayList<>();
	static int Max = 0;

	public static void combi(ArrayList<Character> list, int k, int toSelect, char[] selected, int start) {
		if (toSelect == k || start==list.size()) {
//			System.out.println("---------------------");
//			System.out.println(Arrays.toString(selected));
			String tmp = String.valueOf(selected);
			String antic = "antic";
			int possible_word = words.size();

			/** 문제 조건 질문하기!!!!!!!!!!!! */
			for (String s : words) {
				for (int i = 0; i < s.length(); i++) {
					//System.out.print(s.charAt(i) + " ");
					if (!antic.contains(String.valueOf(s.charAt(i))) && !tmp.contains(String.valueOf(s.charAt(i)))) {
						//System.out.println("out");
						possible_word--;
						break;
					}
				}
				//System.out.println();
			}
			//System.out.println("\t\t" + possible_word);
			Max = Math.max(Max, possible_word);
			return;
		}

		for (int i = start; i < list.size(); i++) {
			selected[toSelect] = list.get(i);
			combi(list, k, toSelect + 1, selected, i + 1);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		String antic = "antic";
		ArrayList<Character> list = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			str = str.substring(4, str.length() - 4);
			words.add(str);
			/* 여기가 문젠가............*/
			for (int j = 0; j < str.length(); j++) {
				if (!list.contains(str.charAt(j)) && !antic.contains(String.valueOf(str.charAt(j)))) {
					list.add(str.charAt(j));
				}
			}
		}

		if (K - 5 > list.size()) {
			combi(list, K - 5, 0, new char[list.size()], 0);
		}

		if (K - 5 >= 0)
			combi(list, K - 5, 0, new char[K - 5], 0);
		bw.write(String.valueOf(Max));
		br.close();
		bw.flush();
		bw.close();
	}
}
