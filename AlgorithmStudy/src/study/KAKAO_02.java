package study;

import java.util.Arrays;

public class KAKAO_02 {
	public static int[] solution(String[][] places) {
		int[] answer = new int[5];
		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };
		

		for (int i = 0; i < 5; i++) {
			boolean flag = true;
			char[][] map = new char[5][5];
			for (int j = 0; j < 5; j++) {
				map[j] = places[i][j].toCharArray();
			}

			f: for (int r = 0; r < 5; r++) {
				for (int c = 0; c < 5; c++) {
					if (map[r][c] == 'P') {
						for (int k = 0; k < 4; k++) {
							// 사방탐색
							int nr = r + dr[k];
							int nc = c + dc[k];

							// 범위 안에 있고 + P면 탈락, O면 한 번 더.
							if (nr >= 0 && nc >= 0 && nr < 5 && nc < 5) {
								if (map[nr][nc] == 'P') {
									flag = false;
									break f;
								}

								else if (map[nr][nc] == 'O') {
									// 테이블이니까 한 번 더 사방탐색.
									for (int m = 0; m < 4; m++) {
										int mr = nr + dr[m];
										int mc = nc + dc[m];
										if (mr != r && mc != c && mr >= 0 && mc >= 0 && mr < 5 && mc < 5
												&& map[mr][mc] == 'P') {
											flag = false;
											break f;
										}
									}
								}
							}
						}
					}
				}

			}
			answer[i] = flag ? 1 : 0;
		}

		return answer;
	}

	public static void main(String[] args) {
		String [][]places={{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"PXOPX", "OXOXP", "OXPXX", "OXXXP", "POOXX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
		System.out.println(Arrays.toString(solution(places)));
	}
}
