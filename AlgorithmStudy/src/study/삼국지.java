package study;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 삼국지 {
	static int N;
	static int[][] map;
	static int[][] soldiers;
	static int[][] implement;
	static int[] own;

	public static void show_soldiers() {
		System.out.println("-----병력정보------");
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(soldiers[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("--------------------");
	}

	public static void show_own() {
		System.out.println("-------소유정보------");
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("--------------------");
	}

	public static void attack(int now) {
		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };
		int[][] tmp = new int[N][N];

		// 병력이 없는 나라가 있다면 진행하지 않는다.

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {

				// 돌면서 우리 나라 아닌 나라 찾기. 산악지역은 스킵해야됨.
				if (map[i][j] != now && map[i][j] != 0) {
					int our_soldiers = 0;

					// 상대 나라 찾으면. 이제 인접한 지역 중 우리나라 찾기.
					for (int k = 0; k < 4; k++) {
						int nr = i + dr[k];
						int nc = j + dc[k];
						if (nr < 0 || nc < 0 || nr >= N || nc >= N || map[nr][nc] == 0 || soldiers[nr][nc] <= 0)
							continue;

						// 찾아서 그 나라 인접한 나라 중 우리 나라 병력 다 더해서
						if (map[nr][nc] == now)
							our_soldiers += soldiers[nr][nc];
					}

					// 다섯 배 "초과"인지 확인.
					if (soldiers[i][j] * 5 < our_soldiers) {
						// 다섯배가 넘는다면 : 해당 상대방 지역 점령 / 소유 나라 수 업데이트, 지역정보 업데이트
						soldiers[i][j] -= (our_soldiers / 4);
						own[map[i][j]]--;
						own[now]++;

						// 다섯배가 넘는다면 : 인접한 우리 나라의 각 1/4씩 뺌. 바로 빼지말고 어디 tmp에 저장하기.
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
				if (soldiers[i][j] < 0) {
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
					}
					our_soldiers += soldiers[nr][nc];
				}

				// 인접 나라 중 다른 나라 지역이 없는 경우 : 모든 인접 지역으로 병력의 1/5 각각 지원
				if (!flag) {
					//System.out.printf("현 위치 %d, %d / 주변에 상대국 없음! 나눠준다!\n", i, j);
					for (int k = 0; k < 4; k++) {
						int nr = i + dr[k];
						int nc = j + dc[k];
						if (nr < 0 || nc < 0 || nr >= N || nc >= N || map[nr][nc] == 0)
							continue;
						//System.out.printf("%d,%d 가져가라 : %d만큼!\n", nr, nc, soldiers[i][j]/5);
						tmp[nr][nc] += soldiers[i][j] / 5;
						tmp[i][j] -= soldiers[i][j] / 5;
					}
					//System.out.printf("\t현재 soliders[i][j] : %d, tmp[i][j] : %d\n\n", soldiers[i][j],tmp[i][j]);
				}

				// 인접 나라 중 다른 나라 지역이 있는 경우 :
				// 그 지역 병력이 인접한 우리 나라 병력 5배 초과일 때만 그 지역 병력의 1/5를 인접 지역으로 지원
				else if (flag && soldiers[i][j] > our_soldiers * 5) {
					//System.out.printf("현 위치 %d, %d / 상대국 있지만 내가 더 쎄다!\n", i, j);
					for (int k = 0; k < 4; k++) {
						int nr = i + dr[k];
						int nc = j + dc[k];
						if (nr < 0 || nc < 0 || nr >= N || nc >= N || map[nr][nc] == 0)
							continue;

						// 우리 아군 땅에만 현재 지역 병력 1/5 나눠줌.
						if (map[nr][nc] == now) {
							tmp[nr][nc] += soldiers[i][j] / 5;
							tmp[i][j] -= soldiers[i][j] / 5;
						}
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
			System.out.println("초기 산악 수 : "+mountains);
			while (own[now] != N * N - mountains) {
				System.out.println("========"+now+"번 나라 턴=======");
				
				if (own[now] == 0) {
					now = now == 3 ? 1 : now + 1;
					continue;
				}
				attack(now);
				//show_soldiers();
				support(now);
				//show_soldiers();
				implement();
				//show_soldiers();
				//show_own();
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
