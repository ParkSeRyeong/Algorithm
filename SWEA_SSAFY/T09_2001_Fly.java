package ssafy_algo_0203;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class T09_2001_Fly {
	static int N, M;
	static int[][] arr;

	static int check(int start_r, int start_c) {
		// sum 더하기
		int sum = 0;
		for (int i = start_r; i < start_r + M; i++) {
			for (int j = start_c; j < start_c + M; j++) {
				sum += arr[i][j];
			}
		}
		return sum;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 테스트 케이스 개수 tc가 주어짐
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t < tc + 1; t++) {
			sb.append("#" + t + " ");

			// 배열의 크기 N, 파리채의 크기 M이 주어진다.
			String tmp = br.readLine();
			N = Integer.parseInt(tmp.split(" ")[0]);
			M = Integer.parseInt(tmp.split(" ")[1]);
			arr = new int[N][N];

			// 배열에 파리 수가 주어짐
			for (int i = 0; i < N; i++) {
				arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			}

			// 파리 합의 최대 수를 구하라
			int sum = 0, max = 0;

			for (int i = 0; i <= N - M; i++) {
				for (int j = 0; j <= N - M; j++) {
					sum = check(i, j);
					if (max < sum) {
						max = sum;
					}
				}
			}

			sb.append(max + "\n");
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());
	}
}
