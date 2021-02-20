package ssafy_algo_0210;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_17276_ArrayRotate3 {
	static int[][] original;
	static int[][] move;
	static int[][] rotate;
	static int N;
	static int M;

	public static void print(int[][] printArr) {
		for (int[] i : printArr) {
			for (int j : i) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
	}

	public static int[][] No_1_Updown(int[][] arr) {
		int n = arr.length;
		int m = arr[0].length;
		for (int i = 0; i < n / 2; i++) {
			for (int j = 0; j < m; j++) {
				int tmp = arr[i][j];
				arr[i][j] = arr[n - i - 1][j];
				arr[n - 1 - i][j] = tmp;
			}
		}
		return arr;
	}

	public static int[][] No_2_Leftright(int[][] arr) {
		int n = arr.length;
		int m = arr[0].length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m / 2; j++) {
				int tmp = arr[i][j];
				arr[i][j] = arr[i][m - 1 - j];
				arr[i][m - 1 - j] = tmp;
			}
		}
		return original;
	}

	public static int[][] No_3_Right90(int[][] arr) {
		int n = arr.length;
		int m = arr[0].length;
		rotate = new int[m][n];
		for (int j = 0; j < m; j++) {
			for (int i = 0; i < n; i++) {
				rotate[j][n - 1 - i] = arr[i][j];
			}
		}
		return rotate;
	}

	public static int[][] No_4_Left90(int[][] arr) {
		int n = arr.length;
		int m = arr[0].length;
		rotate = new int[m][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				rotate[m - 1 - j][i] = arr[i][j];
			}
		}
		return rotate;
	}

	public static int[][] No_5_Powerset(int[][] arr) {
		N = arr.length;
		M = arr[0].length;
		move = new int[N][M];
		for (int i = 0; i < N / 2; i++) {
			System.arraycopy(arr[i], 0, move[i], M / 2, M / 2);
			System.arraycopy(arr[i], M / 2, move[N / 2 + i], M / 2, M / 2);
			System.arraycopy(arr[N / 2 + i], M / 2, move[N / 2 + i], 0, M / 2);
			System.arraycopy(arr[N / 2 + i], 0, move[i], 0, M / 2);
		}
		return move;
	}

	public static int[][] No_6_Powerset_Reverse(int[][] arr) {
		N = arr.length;
		M = arr[0].length;
		move = new int[N][M];
		for (int i = 0; i < N / 2; i++) {
			System.arraycopy(arr[i], 0, move[N / 2 + i], 0, M / 2);
			System.arraycopy(arr[N / 2 + i], 0, move[N / 2 + i], M / 2, M / 2);
			System.arraycopy(arr[N / 2 + i], M / 2, move[i], M / 2, M / 2);
			System.arraycopy(arr[i], M / 2, move[i], 0, M / 2);
		}
		return move;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 배열 받아오기
		// 회전해서 출력할 배열 하나 더 만들기
		System.setIn(new FileInputStream("src/ssafy_algo_0210/rotate3_test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String tmp = br.readLine();
		N = Integer.parseInt(tmp.split(" ")[0]);
		M = Integer.parseInt(tmp.split(" ")[1]);
		int R = Integer.parseInt(tmp.split(" ")[2]);

		original = new int[N][M];

		for (int i = 0; i < N; i++) {
			original[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}

		int[][] show = null;
		int[] choice = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		show = original;
		for (int k : choice) {
			switch (k) {
			case 1:
				show = No_1_Updown(show);
				break;
			case 2:
				show = No_2_Leftright(show);
				break;
			case 3:
				show = No_3_Right90(show);
				break;
			case 4:
				show = No_4_Left90(show);
				break;
			case 5:
				show = No_5_Powerset(show);
				break;
			case 6:
				show = No_6_Powerset_Reverse(show);
				break;
			}
			//print(show);
			//System.out.println("-----------");
		}

		print(show);

	}

}
