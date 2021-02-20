package ssafy_algo_0205;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class T13_0205_SquareRoom {
	static int Max = 0;
	static int Max_r = 0;
	static int Max_c = 0;
	static int N;
	static int[][] room;
	static Stack<Integer> stack = new Stack<>();
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void moving(int r, int c) throws InterruptedException {

		stack.push(room[r][c]);

		// 범위 안에 들어오면
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];

			// 이동할 위치(인접한 상하좌우)가 범위 밖이거나 or 차이가 1이 아니면
			if (nr < 0 || nr > N - 1 || nc < 0 || nc > N - 1) {
			} else if (Math.abs(room[r][c] - room[nr][nc]) != 1) {
			} else if (stack.contains(room[nr][nc])) {
			} else {
				moving(nr, nc);
			}
		}
		return;
	}

	public static void main(String[] args) throws NumberFormatException, IOException, InterruptedException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int tc = Integer.parseInt(br.readLine());

		for (int t = 0; t < tc; t++) {
			Max = 0;
			sb.append("#");
			sb.append(t + 1);
			sb.append(" ");
			N = Integer.parseInt(br.readLine());
			room = new int[N][N];

			for (int i = 0; i < N; i++) {
				room[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					stack.clear();
					Max_r = 0;
					Max_c = 0;
					moving(i, j);
					int cur = stack.size();
					if (Max == cur) {
						if (room[i][j] < room[Max_r][Max_c]) {
							System.out.println(Max_r+","+Max_c);
							Max_r = i;
							Max_c = j;
							System.out.println("\t작은 애로 변경 : " + i + "," + j + "->" + Max_r + "," + Max_c);
						}
					} else if (Max < cur) {
						Max = cur;
						Max_r = i;
						Max_c = j;
					} else {
					}
					;
				}

			}
			sb.append(room[Max_r][Max_c] + " " + Max + "\n");
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());
	}
}
