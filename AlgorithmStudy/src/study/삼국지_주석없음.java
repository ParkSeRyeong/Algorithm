package study;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 삼국지_주석없음 {
	static int N;
	static int[][] map;
	static int[][] soldiers;
	static int[][] implement;
	static int[] own;

	public static void attack(int now) {
		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };
		int[][] tmp = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {

				if (map[i][j] != now && map[i][j] != 0) {
					int our_soldiers = 0;

					for (int k = 0; k < 4; k++) {
						int nr = i + dr[k];
						int nc = j + dc[k];
						if (nr < 0 || nc < 0 || nr >= N || nc >= N || map[nr][nc] == 0 || soldiers[nr][nc] <= 0)
							continue;

						if (map[nr][nc] == now)
							our_soldiers += soldiers[nr][nc];
					}

					if (soldiers[i][j] * 5 < our_soldiers) {
						soldiers[i][j] -= (our_soldiers / 4);
						own[map[i][j]]--;
						own[now]++;

						for (int k = 0; k < 4; k++) {
							int nr = i + dr[k];
							int nc = j + dc[k];
							if (nr < 0 || nc < 0 || nr >= N || nc >= N || map[nr][nc] == 0 || soldiers[nr][nc] < 0)
								continue;
							if (map[nr][nc] == now)
								tmp[nr][nc] += soldiers[nr][nc] / 4;
						}

					}
				}

			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j]!=0 && soldiers[i][j] <= 0) {
					map[i][j]=now;
					soldiers[i][j]=-soldiers[i][j];
				}
				soldiers[i][j] -= tmp[i][j];
			}
		}

	}

	public static void support(int now) {
		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };
		int[][] tmp = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				boolean flag = false;
				int our_soldiers = 0;
				
				if (map[i][j] != now)
					continue;
				for (int k = 0; k < 4; k++) {
					int nr = i + dr[k];
					int nc = j + dc[k];
					if (nr < 0 || nc < 0 || nr >= N || nc >= N || map[nr][nc] == 0)
						continue;
					if (map[nr][nc] != now) {
						flag = true;
						continue;
					}
					our_soldiers += soldiers[nr][nc];
				}

//				if (!flag) {
//					for (int k = 0; k < 4; k++) {
//						int nr = i + dr[k];
//						int nc = j + dc[k];
//						if (nr < 0 || nc < 0 || nr >= N || nc >= N || map[nr][nc] == 0)
//							continue;
//						tmp[nr][nc] += soldiers[i][j] / 5;
//						tmp[i][j] -= soldiers[i][j] / 5;
//					}
//				}
//
//				else if (flag && soldiers[i][j] > our_soldiers * 5) {
//					for (int k = 0; k < 4; k++) {
//						int nr = i + dr[k];
//						int nc = j + dc[k];
//						if (nr < 0 || nc < 0 || nr >= N || nc >= N || map[nr][nc] == 0)
//							continue;
//
//						if (map[nr][nc] == now) {
//							tmp[nr][nc] += soldiers[i][j] / 5;
//							tmp[i][j] -= soldiers[i][j] / 5;
//						}
//					}
//				}
				for (int k = 0; k < 4; k++) {
					int nr = i + dr[k];
					int nc = j + dc[k];
					if (nr < 0 || nc < 0 || nr >= N || nc >= N || map[nr][nc] == 0)
						continue;

					if(flag && soldiers[i][j] > our_soldiers * 5) {
						if (map[nr][nc] == now) {
							tmp[nr][nc] += soldiers[i][j] / 5;
							tmp[i][j] -= soldiers[i][j] / 5;
						}
					}else if(!flag) {
						tmp[nr][nc] += soldiers[i][j] / 5;
						tmp[i][j] -= soldiers[i][j] / 5;
					}
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				soldiers[i][j] += tmp[i][j];
			}
		}
	}

	public static void implement() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				soldiers[i][j] += implement[i][j];
			}
		}
	}

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/study/삼국지_test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int tc = Integer.parseInt(br.readLine());

		for (int t = 1; t <= tc; t++) {
			sb.append("#").append(t).append(" ");
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			soldiers = new int[N][N];
			implement = new int[N][N];
			own = new int[4];
			int mountains = 0;

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 0) {
						mountains++;
					} else {
						++own[map[i][j]];
					}
				}
			}
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					soldiers[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					implement[i][j] = Integer.parseInt(st.nextToken());

				}
			}

			// 순서대로 공격, 지원, 보충.
			int now = 1;
			while (own[now] != N * N - mountains) {
				if (own[now] == 0) {
					now = now == 3 ? 1 : now + 1;
					continue;
				}
				attack(now);
				support(now);
				implement();
				now = now == 3 ? 1 : now + 1;
			}
			
			int total=0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					total+=soldiers[i][j];
				}
			}
			sb.append(total).append("\n");
		}
		System.out.println(sb);
		br.close();
	}
}
