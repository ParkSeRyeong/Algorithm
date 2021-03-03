package ssafy_0225;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ_17413_ReverserWord2 {
	static StringBuilder sb = new StringBuilder();

	public static void reverse(ArrayList<Character> list, boolean isReverse) {
		if (isReverse) {
			Collections.reverse(list);
		}
		Iterator<Character> iter = list.iterator();

		while (iter.hasNext()) {
			sb.append(iter.next());
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		StringTokenizer st;
		ArrayList<Character> list = new ArrayList<>();
		if (str.contains("<")) {
			for (int i = 0; i < str.length(); i++) {
				System.out.println("**"+i+"**");
				if (str.charAt(i) == '<') {
					System.out.println("------ "+i);
					if (list.size()!=0) {
						System.out.println("==============="+i);
						reverse(list, true);
						list.clear();
					}
					while (str.charAt(i) != '>') {
						list.add(str.charAt(i));
						i++;
					}
					list.add(str.charAt(i));
					reverse(list, false);
					list.clear();
				} else {
					list.add(str.charAt(i));
				}

			}
		}
		 else {
			st = new StringTokenizer(str);
			while (st.hasMoreElements()) {

				list.clear();
				String tmp = st.nextToken();
				for (int i = 0; i < tmp.length(); i++) {
					list.add(tmp.charAt(i));
				}
				Collections.reverse(list);
				Iterator<Character> iter = list.iterator();

				while (iter.hasNext()) {
					sb.append(iter.next());
				}
				sb.append(" ");
			}
		}
		
		System.out.println(sb);
		sc.close();
	}
}
