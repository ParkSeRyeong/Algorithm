package ssafy_algo_0218;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class NOT_T23_Restaurant {
	static int[] dr = { -1, 0, 1 };
	static int[][] map;
	static int row;
	static int col;
	static int cnt;

	static boolean water(int r, int c) {
		if (c == col - 1) {
			cnt++;
			return true;
		} else {
			for (int i = 0; i < 3; i++) {
				int nr = r + dr[i];
				if (nr < 0 || nr > col - 1 || map[nr][c + 1] != 0) {
					continue;
				}
				map[nr][c + 1] = 1;

				// 이걸 boolean으로 리턴받는 이유 :
				// 끝까지 도착하면 true를 반환할거고, 끝까지 도달 못하면 false를 반환.
				// 끝까지 도착하면 걍 이 water 함수를 끝내야됨.
				// 그리고 메인문의 for문에서 다음 행 실행해야하니까!
				// 그래서 일단 false면은 계속 방향 찾고, 아니면 리턴해서 끝내버리는 것.
				if (water(nr, c + 1))
					return true;
				// map[nr][c + 1] = 0; // 이 미방문처리를 하지 않는다!!!!!!!!!!

			}
		}
		return false;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src/ssafy_algo_0218/restaurant_test.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());

		map = new int[row][col];

		for (int i = 0; i < row; i++) {
			String tmp = br.readLine();
			for (int j = 0; j < col; j++) {
				if (tmp.charAt(j) == '.') {
					map[i][j] = 0;
				} else {
					map[i][j] = 1;
				}
			}
		}
		for (int i = 0; i < row; i++) {
			water(i, 0);
		}
		bw.write(String.valueOf(cnt));
		bw.flush();
		br.close();
		bw.close();
	}
}
