package study;

import java.util.*;
import java.io.*;

public class SOFTEER_차세대지능형교통시스템 {
	private static class TL {
		int[] dr;
		int[] dc;

		public TL(int[] dr, int[] dc) {
			this.dr = dr;
			this.dc = dc;
		}
	}

	private static class Car {
		int r, c, dir, ic_count, time;

		public Car(int r, int c, int dir, int ic_count, int time) {
			this.r = r;
			this.c = c;
			this.dir = dir;
			this.ic_count = ic_count;
			this.time = time;
		}
	}

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());

		TL[] signal = new TL[13];
		signal[1] = new TL(new int[] { -1, 0, 1 }, new int[] { 1, 1, 1 });
		signal[2] = new TL(new int[] { -1, -1, -1 }, new int[] { -1, 0, 1 });
		signal[3] = new TL(new int[] { -1, 0, 1 }, new int[] { -1, -1, -1 });
		signal[4] = new TL(new int[] { 1, 1, 1 }, new int[] { -1, 0, 1 });

		signal[5] = new TL(new int[] { -1, 0 }, new int[] { 1, 1 });
		signal[6] = new TL(new int[] { -1, -1 }, new int[] { -1, 0 });
		signal[7] = new TL(new int[] { 0, 1 }, new int[] { -1, -1 });
		signal[8] = new TL(new int[] { 1, 1 }, new int[] { 0, 1 });

		signal[9] = new TL(new int[] { 0, 1 }, new int[] { 1, 1 });
		signal[10] = new TL(new int[] { -1, -1 }, new int[] { 0, 1 });
		signal[11] = new TL(new int[] { -1, 0 }, new int[] { -1, -1 });
		signal[12] = new TL(new int[] { 1, 1 }, new int[] { -1, 0 });

		int[][][] map = new int[N][N][4];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				map[i][j][0] = Integer.parseInt(st.nextToken());
				map[i][j][1] = Integer.parseInt(st.nextToken());
				map[i][j][2] = Integer.parseInt(st.nextToken());
				map[i][j][3] = Integer.parseInt(st.nextToken());
			}
		}
		int total = Integer.MIN_VALUE;

		// 북동남서 순.
		int[] dr = { -1, 0, 1, 0 };
		int[] dc = { 0, 1, 0, -1 };

		// 초기 차 위치. (1,0) -> (0,0)으로 들어가고 있는 중.
		// 교차로 하나는 무조건 지남 = ic_Count는 1부터
		Car car = new Car(1, 0, 0, 1, 0);

		Queue<Car> q = new LinkedList<>();
		q.offer(car);

		while (!q.isEmpty()) {
			Car now = q.poll();
			total = Math.max(now.ic_count, total);

			int r = now.r;
			int c = now.c;
			int dir = now.dir;
			int Time = now.time;

			// 이동할 교차로 위치. 처음엔 (0,0)이 됨.
			int nr = r + dr[dir];
			int nc = c + dc[dir];

			if (nr < 0 || nc < 0 || nr >= N || nc >= N)
				continue;

			if (Time == 3)
				break;
//			System.out.println(r + "," + c + " - 현재신호 : " + map[r][c][Time % 4]);
//			System.out.println(Arrays.toString(signal[map[r][c][Time % 4]].dr));
//			System.out.println(Arrays.toString(signal[map[r][c][Time % 4]].dc));

			for (int i = 0; i < signal[map[nr][nc][Time % 4]].dr.length; i++) {
				int pr = r + signal[map[nr][nc][Time % 4]].dr[i];
				int pc = c + signal[map[nr][nc][Time % 4]].dc[i];

				if (pr < 0 || pc < 0 || pr >= N || pc >= N)
					continue;

				// 갈 수 있다면?
				dir = change_dir(dir, r, c, pr, pc);
				System.out.println("\t" + pr + "," + pc + " 로 이동 가능");
				q.offer(new Car(nr, nc, dir, now.ic_count + 1, Time + 1));
			}
			System.out.println("--------------------");
		}
		System.out.println(total);
	}

	public static int change_dir(int dir, int r, int c, int pr, int pc) {
		int result = 0;
		// 동서라면
		if (dir % 2 == 1) {
			if (r < pr) {
				result = 2;
			} else if (r > pr) {
				result = 0;
			} else {
				result = c < pc ? 1 : 3;
			}
		}
		// 북남이라면
		else {
			if (c < pc) {
				result = 1;
			} else if (c > pc) {
				result = 3;
			} else {
				result = r > pr ? 0 : 2;
			}
		}
		return result;
	}

}