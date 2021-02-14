package bst;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Problem04_FindParts2 {

	static int[] arr;

	static int N;
	static int M;

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src/bst/bst_tc.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		/** 1. 전체 부품 개수 N */
		N = Integer.parseInt(br.readLine());

		/** 2. 부품 요소 입력 받기 */
		String str = br.readLine();
		arr = Arrays.stream(str.split(" ")).mapToInt(Integer::parseInt).toArray();

		/** 3. 손님이 찾는 부품 개수 */
		M = Integer.parseInt(br.readLine());
		String[] tmp = br.readLine().split(" ");

		boolean flag = true;
		for (int i = 0; i < M; i++) {
			if (!str.contains(tmp[i])) {
				flag = false;
			}
		}
		System.out.println(flag == true ? "yes" : "no");

	}
}
