package ssafy_algo_0209;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 안돌아감.과제할래.

public class T20_0209_1974_Sudoku {
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src/ssafy_algo_0209/sudoku_test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t < tc + 1; t++) {
			sb.append("#").append(t).append(" ");

			int[][] arr = new int[10][10];
			for (int i = 1; i < 10; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 1; j < 10; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int[] visited_r = new int[10];
			int[] visited_c = new int[10];
			boolean flag = true;

			f: for (int i = 1; i < 10; i++) {
				Arrays.fill(visited_r, 0);
				Arrays.fill(visited_c, 0);
				for (int j = 1; j < 10; j++) {
					System.out.println(arr[i][j] + " " + arr[j][i]);
					if (visited_c[arr[i][j]] != 0) {
						flag = false;
						break f;
					}
					if (visited_r[arr[j][i]] != 0) {
						flag = false;
						break f;
					}
					visited_r[arr[j][i]]++;
					visited_c[arr[i][j]]++;
				}
			}
			Arrays.fill(visited_r, 0);
			Arrays.fill(visited_c, 0);
			System.out.println("-------------------------");
			f: for (int i = 1; i < 10; i += 3) {
				for (int j = 1; j < 3; j++) {
					System.out.println(i+","+j+"시작");
					if (visited_r[arr[i][i + j]] != 0) {
						System.out.println("\t"+i+","+(i+j)+"에서 탈락");
						flag = false;
						break f;
					}
					if (visited_c[arr[i + j][i]] != 0) {
						flag = false;
						break f;
					}
					visited_r[arr[i][i + j]]++;
					visited_c[arr[i + j][i]]++;
				}
			}
			System.out.println(flag);
		}
	}
}
