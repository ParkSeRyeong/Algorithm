package ssafy_algo_0218;

import java.util.Arrays;

public class BSTTest {
	public static void main(String[] args) {
		int[] arr = { 3, 11, 15, 20, 21, 29, 45 };
		Arrays.sort(arr);
		System.out.println(bst(arr, 15));
		System.out.println(bst(arr, 15, 0, arr.length - 1));
		System.out.println(Arrays.binarySearch(arr, 14));
	}

	private static int bst(int[] arr, int key) {
		int start = 0, end = arr.length - 1;

		while (start <= end) {
			int mid = (start + end) / 2;
			if (arr[mid] == key)
				return mid;
			else if (arr[mid] < key)
				start = mid + 1;
			else
				end = mid - 1;
		}
		return -1;
	}

	private static int bst(int[] arr, int key, int start, int end) {
		if (start <= end) {
			int mid = (start + end) / 2;
			if (arr[mid] == key)
				return mid;
			else if (arr[mid] < key)
				return bst(arr, key, mid + 1, end);
			else
				return bst(arr, key, start, mid - 1);
		}
		return -1;

	}
}
