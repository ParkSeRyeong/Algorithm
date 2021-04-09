package imple_simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Snake {
	int r, c;

	public Snake(int r, int c) {
		this.r = r;
		this.c = c;
	}

}

public class BOJ_3190_뱀2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N + 1][N + 1];
		int K = Integer.parseInt(br.readLine());
		for (int i = 0; i < K; ++i) {
			st = new StringTokenizer(br.readLine());
			map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 2;
		}
		int L = Integer.parseInt(br.readLine());
		HashMap<Integer, Character> dir = new HashMap<>();
		for (int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			char c = st.nextToken().charAt(0);
			dir.put(x, c);
		}

		int sec = 0;
		int r = 1;
		int c = 1;
		int[] dr = { -1, 0, 1, 0 };
		int[] dc = { 0, 1, 0, -1 };
		int flag = 1; // 처음에 오른쪽방향

		Deque<Snake> q = new LinkedList<>();
		q.offerFirst(new Snake(r, c));

		while (!q.isEmpty()) {
			sec++;
			r = q.peek().r;
			c = q.peek().c;
			int nr = r + dr[flag];
			int nc = c + dc[flag]; 
			if (nr < 1 || nc < 1 || nr > N || nc > N || map[nr][nc] == 1) {
				System.out.println(sec);
				return;
			}
			if (dir.get(sec) != null) {
				switch (dir.get(sec)) {
				case 'L': flag = flag == 0 ? 3 : flag - 1;
					break;
				case 'D': flag = flag == 3 ? 0 : flag + 1;
					break;
				}
			}
			q.offerFirst(new Snake(nr, nc));
			if (map[nr][nc] != 2)	map[q.peekLast().r][q.pollLast().c] = 0;
			
			map[nr][nc] = 1;
		}
	}
}
