package study;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 활주로 {
	static int[][] map;
	static int N;
	static int X;
	static int total = 0;

	public static void airstrip() {
		f: for (int i = 0; i < N; i++) {
			int cnt = 1;
			for (int j = 0; j < N - 1; j++) {
				if (Math.abs(map[i][j] - map[i][j + 1]) > 1) {
					continue f;
				}

				if (map[i][j] - map[i][j + 1] == -1) {
					if (cnt < X) {
						continue f;
					} else {
						cnt = 1;
					}
				}

				else if (map[i][j] - map[i][j + 1] == 1) {
					cnt = 1;
					j++;
					while (j < N - 1 && map[i][j] == map[i][j + 1]) {
						j++;
						cnt++;
					}
					if (j == N - 2) {
						if (map[i][j] != map[i][j + 1]) {
							continue f;
						}
					}
					if (cnt < X) {
						continue f;
					}
					j--;
				} else {
					cnt++;
				}
			}
			total++;
		}
		f: for (int i = 0; i < N; i++) {
			int cnt = 1;
			for (int j = 0; j < N - 1; j++) {
				if (Math.abs(map[j][i] - map[j + 1][i]) > 1) {
					continue f;
				}

				if (map[j][i] - map[j + 1][i] == -1) {
					if (cnt < X) {
						continue f;
					} else {
						cnt = 1;
					}
				}

				else if (map[j][i] - map[j + 1][i] == 1) {
					cnt = 1;
					j++;
					while (j < N - 1 && map[j][i] == map[j + 1][i]) {
						j++;
						cnt++;
					}
					if (j == N - 2) {
						if (map[j][i] != map[j + 1][i]) {
							continue f;
						}
					}
					if (cnt < X) {
						continue f;
					}
					j--;
				} else {
					cnt++;
				}
			}
			total++;
		}
	}

	public static void airstrip2() {
		// 다시 짜기.
	}
	
	
	// 반 노가다성으로 짰습니다....
	// 겹치면 안 된다는 조건을 놓쳤는데 시간이 모자라서 제출합니다ㅠㅠ!
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/study/활주로_test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());

		for (int t = 0; t < tc; t++) {
			sb.append("#").append(t + 1).append(" ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			total = 0;

			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			}
			airstrip();
			sb.append(total).append("\n");
		}
		System.out.println(sb.toString());
	}
}
