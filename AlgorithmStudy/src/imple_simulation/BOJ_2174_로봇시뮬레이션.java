package imple_simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2174_로봇시뮬레이션 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int col = Integer.parseInt(st.nextToken());
		int row = Integer.parseInt(st.nextToken());

		int[][] map = new int[row + 1][col + 1];

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		// [0] : x좌표 / [1] : y좌표 / [2] : 현재 로봇 방향
		int[][] robots = new int[N + 1][3];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int c = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());

			robots[i][0] = row - r + 1;
			robots[i][1] = c;
			map[row - r + 1][c] = i;
			switch (st.nextToken()) {
			case "N":
				robots[i][2] = 0;
				break;
			case "E":
				robots[i][2] = 1;
				break;
			case "S":
				robots[i][2] = 2;
				break;
			case "W":
				robots[i][2] = 3;
				break;
			}
		}

		// [0] : 북 / [1] : 동 / [2] : 남 / [3] : 서
		int[] dr = { -1, 0, 1, 0 };
		int[] dc = { 0, 1, 0, -1 };

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			// n : 명령받을 로봇의 번호
			// order : 명령
			// loop : 반복횟수
			int now = Integer.parseInt(st.nextToken());
			char order = st.nextToken().charAt(0);
			int loop = Integer.parseInt(st.nextToken());

			// r,c : 현재 명령받는 로봇의 현 위치
			int r = robots[now][0];
			int c = robots[now][1];

			switch (order) {

			// L과 R이 들어온 경우엔 4로 나눈 나머지만큼만 반복.
			case 'L':
				for (int k = 0; k < loop % 4; k++) {
					robots[now][2] = robots[now][2] != 0 ? robots[now][2] - 1 : 3;
				}
				break;
			case 'R':
				for (int k = 0; k < loop % 4; k++) {
					robots[now][2] = robots[now][2] != 3 ? robots[now][2] + 1 : 0;
				}
				break;

			// F가 들어온 경우는 범위/로봇여부 파악하면서 이동.
			case 'F':
				map[r][c] = 0;
				for (int k = 0; k < loop; k++) {
					int nr = r + dr[robots[now][2]];
					int nc = c + dc[robots[now][2]];
					if (nr < 1 || nc < 1 || nr > row || nc > col) {
						System.out.printf("Robot %d crashes into the wall", now);
						return;
					}
					if (map[nr][nc] != 0) {
						System.out.printf("Robot %d crashes into robot %d", now, map[nr][nc]);
						return;
					}
					r = nr;
					c = nc;
				}
				map[r][c] = now;
				robots[now][0]=r;
				robots[now][1]=c;
				break;
			}
		}
	}
}
