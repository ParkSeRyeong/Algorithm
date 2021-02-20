package ssafy_algo_0202;

import java.io.IOException;
import java.util.Scanner;

public class T05_0202_Snail {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int tc = sc.nextInt();

		for (int t = 0; t < tc; t++) {
			int n = sc.nextInt();
			int[][] snail = new int[n][n];

			int[] dr = { 0, 1, 0, -1 };
			int[] dc = { 1, 0, -1, 0 };

			// k=배열에 넣을 수, i=방향벡터 인덱스
			int k = 1, r = 0, c = 0, dir = 0;
			snail[r][c] = 1;

			// k가 n^2일때까지 반복 = 다 채워질때까지!
			while (true) {
				if (k == n * n) {
					break;
				}
				for (int len = 0; len < n; len++) {
					snail[r][c] = k;

					// 방향은 4씩 반복해서 돈다.
					int nr = r + dr[dir % 4];
					int nc = c + dc[dir % 4];

					if (nr >= n || nc >= n || nr < 0 || nc < 0 || snail[nr][nc] != 0) {
						break;
					}
					r = nr;
					c = nc;
					k++;
				}
				dir++;
			}
			System.out.println("#" + (t + 1));
			for (int x = 0; x < n; x++) {
				for (int y = 0; y < n; y++) {
					//sb.append(snail[x][y]+" ");
					System.out.print(snail[x][y] + " ");
				}
				//sb.append("\n");
				System.out.println();
			}
		}
		//System.out.println(sb.toString());

		sc.close();
	}
}
