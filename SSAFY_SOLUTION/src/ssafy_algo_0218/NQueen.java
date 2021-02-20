package ssafy_algo_0218;

import java.util.Scanner;

public class NQueen {
	static int N;
	static int[] col;
	static int ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		col = new int[N + 1];
		Queens(0);
		System.out.println(ans);
		sc.close();
	}

	public static void Queens(int rowNo) {
		// rowNo : 현재 퀸번호

		// 현재 노드가 유망하지 않다면 빽해라
		if (!isAvailable(rowNo)) {
			return;
		}
		if (rowNo == N) {
			ans++;
			return;
		}
		for (int i = 1; i <= N; i++) {
			col[rowNo + 1] = i;
			Queens(rowNo + 1);
		}
	}

	public static boolean isAvailable(int rowNo) {
		// 같은 행에는 안두니까 가로는 검사 필요 x

		// i는 비교하는 기존의 퀸들 값
		for (int i = 1; i < col.length; i++) {
			// 퀸이 서로 위협적인 위치면 false
			if (col[rowNo] == col[i] || Math.abs(col[rowNo] - col[i]) == rowNo - i) {
				return false;
			}
		}
		return true;
	}
}
