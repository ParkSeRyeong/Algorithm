package ssafy_algo_0204;

import java.util.Arrays;

/*nPr ==> 3P2 = 3 * 2 = 6
-----순열-----
[1, 2]
[1, 3]
[2, 1]
[2, 3]
[3, 1]
[3, 2]
-----조합-----
[1, 2]
[1, 3]
[2, 3]
*/

public class PerCombiTest {
	static int[] num = { 1, 2, 3 }; // num = {1,2,3,4}
	static int N = 2; // N=2, N=3

	public static void makePermutation(int toSelect, int[] selected, boolean[] visited) {

		if (toSelect == N) {
			System.out.println(Arrays.toString(selected));
			return;
		}
		for (int i = 0; i < num.length; i++) {
			if (!visited[i]) {
				selected[toSelect] = num[i];
				visited[i] = true;
				makePermutation(toSelect + 1, selected, visited);
				visited[i] = false;
			}

		}
	}

	public static void makeCombination(int toSelect, int[] selected, int start) {

		if (toSelect == N) {
			System.out.println(Arrays.toString(selected));
			return;
		}

		for (int i = start; i < num.length; i++) {
			selected[toSelect] = num[i];
			makeCombination(toSelect + 1, selected, i + 1);
		}
	}

	public static void main(String[] args) {
//		1. num에서 N개를 뽑아서 만들 수 있는 순열을 모두 출력하시오.
		System.out.println("-----순열-----");
		makePermutation(0, new int[N], new boolean[num.length]);

//		2. num에서 N개를 뽑아서 만들 수 있는 조합을 모두 출력하시오.		
		System.out.println("-----조합-----");
		makeCombination(0, new int[N], 0);
	}
}
