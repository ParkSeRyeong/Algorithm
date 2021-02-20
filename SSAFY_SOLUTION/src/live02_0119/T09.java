package live02_0119;

import java.util.Arrays;

@SuppressWarnings("unused")
public class T09 {
	public static void main(String[] args) {
		/*
		 * intArray 배열이 아래와 같이 주어졌을 때,각 숫자가 몇번 사용 되었는지 숫자별로 사용 횟수를 출력 하세요. 사용 안된 숫자는 0으로
		 * 출력하세요. ( 단, 숫자는 0-9 까지만 사용 ) [출력화면] [0, 2, 2, 2, 0, 2, 0, 3, 1, 1]
		 */

		int[] intArray = { 3, 7, 2, 5, 7, 7, 9, 2, 8, 1, 1, 5, 3 };
		int []used = new int[13];
		
		for(int i:intArray) {
			used[i]++;
		}
		
		for(int i:used) {
			System.out.print(i+" ");
		}

	}
}
