package bst;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_6236_용돈관리 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] money = new int[N];
		int min = Integer.MAX_VALUE;
		int max = 0;

		for (int i = 0; i < N; i++) {
			money[i] = Integer.parseInt(br.readLine());
			min = Math.min(min, money[i]);
			max += money[i];
		}
		int left = min;
		int right = max;
		int result=0;
		while (left <= right) {
			int mid = (left + right) / 2;
			boolean flag = withdraw(M, mid, money);
			if (!flag) {
				left = mid + 1;
			} else {
				result=mid;
				right = mid - 1;
			}
		}
		System.out.println(result);
	}

	private static boolean withdraw(int M, int K, int[] money) {
		int now = 0;
		int count = 1;
		for (int i = 0; i < money.length; i++) {
			if (K < money[i]) {
				return false;
			}
			if (now + money[i] > K) {
				now = 0;
				count++;
			}
			now += money[i];
		}
		return M >= count;
	}

}
