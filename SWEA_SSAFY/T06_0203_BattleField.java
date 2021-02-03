package ssafy_algo_0203;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class T06_0203_BattleField {

	static char[] direction = { '^', 'v', '<', '>' };
	static char[] orderdir = { 'U', 'D', 'L', 'R' };

	public static int index(char dir) {
		for (int i = 0; i < 4; i++) {
			if (dir == direction[i]) {
				return i;
			}
			if (dir == orderdir[i]) {
				return i;
			}
		}
		return -1;
	}

	@SuppressWarnings("unused")
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int dir = -1;
		int r = -1, c = -1;
		int h=0, w=0;
		int tc = Integer.parseInt(br.readLine());
		for(int t=0;t<tc;t++) {
		String str = br.readLine();
		h = Integer.parseInt(str.split(" ")[0]);
		w = Integer.parseInt(str.split(" ")[1]);

		char[][] map = new char[h][w];
		

		for (int i = 0; i < h; i++) {
			str = br.readLine();

			for (int j = 0; j < w; j++) {
				map[i][j] = str.charAt(j);
				// 방향이면 위치 저장하기
				if (map[i][j] == '^' || map[i][j] == 'v' || map[i][j] == '>' || map[i][j] == '<') {
					dir = index(map[i][j]);
					r = i;
					c = j;
				}
			}
		}

		// -------------------------------------------------
		int orderLen = Integer.parseInt(br.readLine());
		String tmp = br.readLine();
		char[] order = new char[orderLen];
		for (int i = 0; i < orderLen; i++) {
			order[i] = tmp.charAt(i);
		}

		// -----------------------------------------------------
		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };

		for (int i = 0; i < order.length; i++) {
			map[r][c] = direction[dir];

			// 슈팅인 경우
			if (order[i] == 'S') {
				// 현재 방향으로 슈팅
				// 벽돌, *만 파괴 후 스탑
				dir = index(map[r][c]);
				int tmp_r = r;
				int tmp_c = c;
				while (true) {

					// 범위 아웃이거나 강철 벽
					if (tmp_r >= h || tmp_r < 0 || tmp_c >= w || tmp_c < 0 || map[tmp_r][tmp_c] == '#') {
						break;
					}
					
					// 벽돌이면
					if (map[tmp_r][tmp_c] == '*') {
						map[tmp_r][tmp_c] = '.';
						break;
					}
					tmp_r = tmp_r + dr[dir];
					tmp_c = tmp_c + dc[dir];
				}
				continue;
			}

			// 슈팅이 아니라면 방향 변경이니까
			else {
				dir = index(order[i]);

				int nr = r + dr[dir];
				int nc = c + dc[dir];

				// 범위 밖이거나 평지가 아니면
				if (nr > h - 1 || nc > w - 1 || nr < 0 || nc < 0 || map[nr][nc] != '.') {
					// 방향만 바꿔놓고
					map[r][c] = direction[dir];
					continue;
				}
				// 위에서 안걸리면 -> 범위 안에 있고 + 평지란 뜻
				map[r][c] = '.';
				r = nr;
				c = nc;
				map[nr][nc] = direction[dir];
			}
		}

		System.out.print("#"+(t+1)+" ");
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		}
		
	}
}
