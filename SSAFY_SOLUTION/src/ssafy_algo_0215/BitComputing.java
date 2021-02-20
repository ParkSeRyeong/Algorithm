package ssafy_algo_0215;

import java.util.Arrays;
import java.util.Scanner;

public class BitComputing {
	static int N = 3;
	static int[] arr;
	static int[] input;

	public static void permutation(int cnt, int flag) {
		if (cnt == N) {
			System.out.println(Arrays.toString(arr));
		}
		for (int i = 0; i < N; i++) {
			if ((flag & 1 << i) != 0)
				continue;
			arr[cnt] = input[i];
			permutation(cnt + 1, flag | 1 << i);
		}
	}

	public static void main(String[] args) {
		int test = 0;
		int k = 0xa5; // 1010 0101
		// k 비트열의 상태 중 오른쪽에서 1만큼 떨어진 비트 확인
		// 1010 0101
		// 0000 0001 -> 이 두개를 & 연산하면 -> 0이거나 / 0이아니거나=1이거나
		// System.out.println(k & 1 << 1);
		// k 비트열의 상태 중 오른쪽에서 2만큼 떨어진 비트 확인
		// System.out.println(k & 1 << 2);

		// k 비트열의 오른족에서 1만큼 떨어진 자리를 1비트로 만들기
		// System.out.println(1 << 3);
		test |= 0x03;
		// System.out.println(test);
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		input = new int[N];
//		arr=new int[N];
		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}
		Arrays.sort(input);

	}

	public static boolean np() {

		// 1. 꼭대기를 찾아라!
		int i = N - 1;
		// 현재 위치의 앞에 있는 수가 현재 위치보다 크면 -> 올라가는 형태 ↖
		// 현재 위치 앞에 수가 있긴 해야하니까 i > 0
		while (i > 0 && input[i - 1] >= input[i]) {
			--i;
		}
		// 2. 쭉쭉 올라갔는데 더 이상 앞자리가 없는 상황이라면
		// => 현 순열의 상태가 가장 큰 순열 (마지막 순열)
		if (i == 0) {
			return false;
		}

		// 3. 교환지점 찾으면 -> 얘랑 교환할 값 찾기
		// => 나 다음의 값들 중, 나보다 큰 첫번째 값을 찾아내자
		int j = N - 1;
		while (input[i - 1] >= input[j]) {
			--j;
		}
		swap(i - 1, j);

		// 4. 교환하고 나면? -> 뒷 순열은 다시 가장 작은 순열, 즉 오름차순이 돼야지
		// Arrays.sort(input, i, N - 1);
		int k = N - 1;
		while (i < k) {
			swap(i++, k--);
		}
		return true;
	}

	public static void swap(int i, int j) {
		int temp = input[i];
		input[i] = temp;
		input[j] = temp;
	}
}
