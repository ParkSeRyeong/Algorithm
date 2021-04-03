package imple_simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Location {
	int r;
	int c;

	public Location(int r, int c) {
		super();
		this.r = r;
		this.c = c;
	}
}

public class SWTest1_PowerConnect {
	static int[][] arr;
	// static int connected_cnt = 0;
	static int connected_len = 0;
	static int min_len = 0;
	static int max_cnt = 0;
	static int processor_num;
	static ArrayList<Location> list;
	
	
	// map:배열 / len : 여기까지 오는데 전선의 길이 합 / cnt : 전원이 연결된 프로세서 개수 / n : 현재까지 지나온 프로세서
	public static void func(int[][] map, int len, int cnt, int n) {
		// 가지치기 해보기 (최소값 넘어가는 경우)
		if (n == processor_num) {
			if (max_cnt <= cnt) {
				if (max_cnt == cnt) {
					min_len = Math.min(len, min_len);
				} else {
					min_len = len;
				}
				max_cnt = Math.max(cnt, max_cnt);
			}
			return;
		}

		Location cur = list.get(n);
		int r = cur.r;
		int c = cur.c;

		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };

		for (int i = 0; i < 4; i++) {
			// 원위치에서 다시 파악하게.
			r = cur.r;
			c = cur.c;
			int cur_len = 0;
			while (true) {
				int nr = r + dr[i];
				int nc = c + dc[i];

				if (nr < 0 || nc < 0 || nr >= map.length || nc >= map.length) {

					// 여기까지 길이 더해주고
					len += cur_len;

					// 갔던 길을 표시하기 위해 2로 바꿔줬다!
					for (int k = 1; k <= cur_len; k++) {
						map[cur.r + k * dr[i]][cur.c + k * dc[i]] = 2;
					}

					// 재귀로 넘겨주고
					func(map, len, cnt + 1, n + 1);

					// 다시 다른 방향도 찾아볼 거니까 2로 바꿔줬던 길을 다시 0으로.
					for (int k = 1; k <= cur_len; k++) {
						map[cur.r + k * dr[i]][cur.c + k * dc[i]] = 0;
					}
					len -= cur_len;
					break;
				}
				if (map[nr][nc] == 1 || map[nr][nc] == 2) {
					break;
				}
				r = nr;
				c = nc;
				cur_len++;
			}
			
		}
		// 얘가 연결이 아무것도 안 돼도 다음 값으로 넘어가긴 해야지...
		func(map, len, cnt, n + 1);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int test_case = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= test_case; tc++) {
			sb.append("#").append(tc).append(" ");

			// 1. 배열 크기 입력받기
			int N = Integer.parseInt(br.readLine());

			// 2. 초기화 및 선언
			arr = new int[N][N];
			list = new ArrayList<>();
			min_len = 0;
			max_cnt = 0;
			connected_len = 0;
			processor_num = 0;
			int connected_cnt = 0;

			// 2. 정보 입력받기
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());

					// 1이면 위치값 저장
					if (arr[i][j] == 1) {
						if (i == 0 || i == N - 1 || j == 0 || j == N - 1) {
							connected_len++;
							connected_cnt++;
							continue;
						} else {
							// q.offer(new Location(i, j));
							list.add(new Location(i, j));
							processor_num++;
						}
					}
				}
			}
//			processor_num = 2;
			// q.offer(new Location(0, 2));
//			list.add(new Location(1, 2));
//			list.add(new Location(1, 5));
//			q.offer(new Location(1, 2));
//			q.offer(new Location(1, 5));
			func(arr, 0, connected_cnt, 0);

			// ------------------------입력부 끝----------------------
			// 3. 함수 실행 돌리기

			sb.append(min_len).append("\n");
			// System.out.println(min_len);
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}
