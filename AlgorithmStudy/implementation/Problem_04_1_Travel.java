package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

//@SuppressWarnings("unused")
//public class Problem_04_1 {
//	public static void main(String[] args) throws NumberFormatException, IOException {
//		
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//		int N = Integer.parseInt(br.readLine());
//		int r = 1;
//		int c = 1;
//
//		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//		
//		while (st.hasMoreElements()) {
//			switch (st.nextToken()) {
//			case "L":
//				if (c - 1 < 1)
//					continue;
//				c--;
//				break;
//			case "R":
//				if (c + 1 > N)
//					continue;
//				c++;
//				break;
//			case "U":
//				if (r - 1 < 1)
//					continue;
//				r--;
//				break;
//			case "D":
//				if (r + 1 > N)
//					continue;
//				r++;
//				break;
//			}
//		}
//		System.out.println(r + " " + c);
//	}
//}




//public class Problem_04_1 {
//	public static void main(String[] args) throws NumberFormatException, IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//		// ------------- 변수 선언 -----------------
//		int r = 1;
//		int c = 1;
//		int nr = r;
//		int nc = c;
//
//		int[] dir_r = { 0, -1, 0, 1 };
//		int[] dir_c = { -1, 0, 1, 0 };
//		
//		String[] move = { "L", "R", "U", "D" };
//
//		// ------------ 입력부 -----------------
//		System.out.print("공간 크기 입력 : ");
//		int N = Integer.parseInt(br.readLine());
//
//		System.out.println("이동 계획서 입력");
//		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//
//		while (st.hasMoreTokens()) {
//			for (int i = 0; i < 4; i++) {
//				if (move[i] == st.nextToken()) {
//					nr += r + dir_r[i];
//					nc += c + dir_c[i];
//					break;
//				}
//			}
//			if (nr > N || nr < 1 || nc > N || nc < 1) {
//				continue;
//			}
//			r = nr;
//			c = nc;
//		}
//		System.out.println(r + " " + c);
//	}
//}

public class Problem_04_1_Travel {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// ------------- 변수 선언 -----------------
		int r = 1;
		int c = 1;
		
		Map<String, List<Integer>> map = new HashMap<>();
		map.put("L", Arrays.asList(0, -1));
		map.put("R", Arrays.asList(0, 1));
		map.put("U", Arrays.asList(-1, -0));
		map.put("D", Arrays.asList(1, 0));

		// ------------ 입력부 -----------------
		System.out.print("공간 크기 입력 : ");
		int N = Integer.parseInt(br.readLine());

		System.out.println("이동 계획서 입력");
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		while (st.hasMoreTokens()) {
			String s = st.nextToken();

			int nr = r + map.get(s).get(0);
			int nc = c + map.get(s).get(1);

			if (nr > N || nr < 1 || nc > N || nc < 1) {
				continue;
			}
			r = nr;
			c = nc;
		}
		System.out.println(r + " " + c);
	}
}
