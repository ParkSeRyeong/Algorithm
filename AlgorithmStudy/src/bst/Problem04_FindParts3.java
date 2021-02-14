package bst;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Problem04_FindParts3 {

	static int[] arr;

	static int N;
	static int M;
	static boolean flag = false;

	
	// ㅁ ㅁ ㅁ ㅁ ㅁ ㅁ ㅁ ㅁ ㅁ ㅁ ㅁ
	//        ㅇ
	public static void find(int start, int end, int key) {
		// 이 부등호가 중요
		// 2 3 7 8 9에서 3을 찾는다고 했을 때, 7 -> 2 -> 3 순으로 비교해보기 때문에 >= 하면 3을 못 찾는다.
		if (start > end) {
			flag = false;
			return;
		}
		int mid = (start + end) / 2;

		if (key == arr[mid]) {
			return;
		} else if (key < arr[mid]) {
			find(start, mid - 1, key);
		} else {
			find(mid + 1, end, key);
		}
		return;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src/bst/bst_tc.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		/** 1. 전체 부품 개수 N */
		N = Integer.parseInt(br.readLine());

		/** 2. 부품 요소 입력 받기 */
		arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		Arrays.sort(arr);

		/** 3. 손님이 찾는 부품 개수 */
		M = Integer.parseInt(br.readLine());
		String[] tmp = br.readLine().split(" ");
		
	//--------------------------------------------------------------------------------
		flag = true;
		
		for (int i = 0; i < M; i++) {

			int key = Integer.parseInt(tmp[i]);
			find(0, N - 1, key);

		}
		System.out.println(flag == true ? "Yes" : "No");
	}
}
