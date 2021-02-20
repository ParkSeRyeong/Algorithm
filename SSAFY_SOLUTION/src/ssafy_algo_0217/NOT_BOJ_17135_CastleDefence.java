package ssafy_algo_0217;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/*미해결*/
public class NOT_BOJ_17135_CastleDefence {
	static int N;
	static int M;
	static int D;
	static int[][] map;
	static int[][] init;
	static int[] dr;
	static int[] dc;
	static int enemy = 0;
	static int max_enemy = 0;

	public static void down() {
		for (int i = 1; i < N; i++) {
			System.arraycopy(map[N - (i + 1)], 0, map[N - i], 0, map[N - i].length);
		}
		Arrays.fill(map[0], 0);
	}

	public static void kill(int r, int c) {
		for (int i = 0; i < D * D; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if (nr < 0 || nr > N - 1 || nc < 0 || nc > M - 1) {
				continue;
			}
			if (map[nr][nc] == 1) {
				System.out.println(nr + " " + nc + "에서 적 발견 -> " + r + " " + c + "가 처치");
				enemy++;
				map[nr][nc] = 0;
				break;
			}
		}
	}

	public static void Combination(int toSelect, int[] selected, int start) {
		if (toSelect == 3) {
			for (int i = 0; i < N; i++) {
				System.arraycopy(init[i], 0, map[i], 0, map[i].length);
			}
			enemy = 0;
			// 궁수 공격 시작
			for (int k = 0; k < N; k++) {
				for (int i : selected) {
					kill(N, i);
				}
				System.out.println("-------------------");
				// 궁수 공격 끝 -> down
				down();
			}
			max_enemy = Math.max(max_enemy, enemy);
			System.out.println("************************************");
			return;
		}

		for (int i = start; i < M; i++) {
			selected[toSelect] = i;
			Combination(toSelect + 1, selected, i + 1);
		}
	}

	public static void main(String[] args) throws IOException {
//		4 4 3
//		0 1 1 0
//		0 0 1 1
//		1 0 1 0
//		1 1 1 0
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		init = new int[N][M];
		dr = new int[D * D];
		dc = new int[D * D];

		for (int i = 0; i < N; i++) {
			String tmp = br.readLine();
			map[i] = Arrays.stream(tmp.split(" ")).mapToInt(Integer::parseInt).toArray();
			init[i] = Arrays.stream(tmp.split(" ")).mapToInt(Integer::parseInt).toArray();
		}
		int index = 0;
		for (int i = D - 1; i >= 0; i--) {
			for (int j = -i; j <= i; j++) {
				dr[index] = -D + i;
				dc[index] = j;
				index++;
			}
		}
		Combination(0, new int[3], 0);
		bw.write(String.valueOf(max_enemy));
		bw.flush();
		bw.close();
		br.close();
	}
}
