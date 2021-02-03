package ssafy_algo_0203;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class T08_0203_Food {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < tc; t++) {
			
			sb.append("#" + (t + 1));
			
			int n = Integer.parseInt(br.readLine());
			int[][] arr = new int[n][n];

			for (int i = 0; i < n; i++) {
				String str = br.readLine();
				for (int j = 0; j < n; j++) {
					arr[i][j] = str.charAt(j) - 48;
				}
			}

			int sum = 0;
			for (int i = 0; i < n / 2; i++) {
				for (int j = n / 2 - i; j <= n / 2 + i; j++) {
					sum += arr[i][j];
				}
			}

			for (int i = n / 2; i >= 0; i--) {
				for (int j = n / 2 - i; j <= n / 2 + i; j++) {
					sum += arr[n - i - 1][j];
				}
			}
			sb.append(" " + sum + "\n");
		}
		System.out.println(sb.toString());
	}
}
