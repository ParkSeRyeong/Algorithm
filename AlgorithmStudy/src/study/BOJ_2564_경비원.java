package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_2564_경비원 {
	private static class Loc {
		int r, c, dir;

		public Loc(int r, int c, int dir) {
			super();
			this.r = r;
			this.c = c;
			this.dir = dir;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int col = Integer.parseInt(st.nextToken());
		int row = Integer.parseInt(st.nextToken());

		int n = Integer.parseInt(br.readLine());
		ArrayList<Loc> list = new ArrayList<>();
		for (int i = 0; i < n + 1; i++) {
			st = new StringTokenizer(br.readLine());
			int dir = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());

			// 북남서동
			switch (dir) {
			case 1:
				list.add(new Loc(0, dist, 1));
				break;
			case 2:
				list.add(new Loc(row, dist, 2));
				break;
			case 3:
				list.add(new Loc(dist, 0, 3));
				break;
			case 4:
				list.add(new Loc(dist, col, 4));
				break;
			}
		}
		int r = list.get(n).r;
		int c = list.get(n).c;
		int ndir = list.get(n).dir;
		int total = 0;
		list.remove(n);

		for (Loc l : list) {
			if (l.dir != ndir && (l.dir - 1) / 2 == (ndir - 1) / 2) {
				if ((l.dir - 1) / 2 == 0)
					total += row + Math.min(c + l.c, (col - c) + (col - l.c));
				else
					total += col + Math.min(r + l.r, (row - r) + (row - l.r));
			} else {
				total += Math.abs(r - l.r) + Math.abs(c - l.c);
			}
		}
		System.out.println(total);
	}
}
