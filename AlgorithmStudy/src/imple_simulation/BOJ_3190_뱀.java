package imple_simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;


public class BOJ_3190_뱀 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

	// ------------------- 입력부 ----------------------
		// 1. 보드 크기 N
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N + 1][N + 1];
		// 2. 사과 개수 apple
		int K = Integer.parseInt(br.readLine());
		// 3. 사과 위치. 사과는 2로 할 거양.
		for (int i = 0; i < K; ++i) {
			st = new StringTokenizer(br.readLine());
			map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 2;
		}
		// 4. 뱀 방향 변환 횟수 L
		int L = Integer.parseInt(br.readLine());
		HashMap<Integer, Character> dir = new HashMap<>();
		for (int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			char c = st.nextToken().charAt(0);
			dir.put(x, c);
		}

	// ------------------- 실행부 ----------------------
		int sec = 0;
		int r = 1;
		int c = 1;
		int[] dr = { -1, 0, 1, 0 };
		int[] dc = { 0, 1, 0, -1 };
		int flag = 1; // 처음에 오른쪽방향

		Deque<Snake> q = new LinkedList<>();
		q.offerFirst(new Snake(r, c));

		while (!q.isEmpty()) {
			
			// 1. 일단 꾸물럭이라도 하면 1초 증가다. 시작 위치에서 못 움직여도 1초여야됨.
			sec++;
			r = q.peek().r;
			c = q.peek().c;
			
			// 2. 현재 방향으로 한 칸 이동
			int nr = r + dr[flag];
			int nc = c + dc[flag];

			// 3. 벽이랑 부딪히거나 내 몸이면 끝내버린다.
			if (nr < 1 || nc < 1 || nr > N || nc > N || map[nr][nc] == 1) {
				System.out.println(sec);
				return;
			}
			
			// 4. 현재 sec 끝. 방향 정보 바꿀 거 있으면 바꾸기.
			if (dir.get(sec) != null) {
				if(dir.get(sec)=='L') flag = (flag + 3) % 4;
				else flag = (flag + 1) % 4;
			}

			// 5. 머리 위치를 새 이동 위치로 옮겨준 후 큐에 넣고, 사과가 없다면 꼬리 위치는 없앤다.
			q.offerFirst(new Snake(nr, nc));
			if (map[nr][nc] != 2) {
				map[q.peekLast().r][q.pollLast().c] = 0;
			}
			map[nr][nc] = 1;
		}
	}
}