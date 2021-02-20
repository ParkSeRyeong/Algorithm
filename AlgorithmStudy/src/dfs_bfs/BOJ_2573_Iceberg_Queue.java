package dfs_bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pos {
	int r;
	int c;
	int ice;

	public Pos() {
	}

	public Pos(int r, int c) {
		this.r = r;
		this.c = c;
	}

	public Pos(int r, int c, int ice) {
		super();
		this.r = r;
		this.c = c;
		this.ice = ice;
	}

	@Override
	public String toString() {
		return r + " " + c + " " + " : " + ice;
	}

}

public class BOJ_2573_Iceberg_Queue {
	static int[][] map;
	static int row, col;
	static int year = 0;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static Queue<Pos> queue = new LinkedList<>();
	static ArrayList<Pos> list = new ArrayList<>();

	/** 한 번에 녹게 하기 위한 메서드. */
	public static void makeZero() {
		Iterator<Pos> iter = queue.iterator();
		while (iter.hasNext()) {
			Pos tmp = iter.next();
			map[tmp.r][tmp.c] = tmp.ice;

			if (tmp.ice == 0) {
				iter.remove();
			}
		}

	}

	/** 인접한 노드를 쭉 따라가다가, 더 이상 없을 때 그 떄까지의 cnt가 빙산 개수랑 같으면 true */
	public static boolean isCombined() {

		// 큐 사이즈 = 현재 남아있는 빙산 개수
		int icebergCnt = queue.size();

		// 방문 정보 배열
		boolean[][] visit = new boolean[row][col];

		// 빙산 위치가 있는 큐 queue랑 별개로, 남아있는 빙산들로 BFS를 진행할 큐 생성
		Queue<Pos> remain = new LinkedList<>();

		// 1. 일단 시작위치 하나 넣어주고 시작
		remain.offer(queue.peek());
		visit[queue.peek().r][queue.peek().c] = true;

		int cnt = 1;

		// 2. 빙산 큐가 빌 때까지 반복
		while (!remain.isEmpty()) {
			Pos tmp = remain.poll();
			for (int i = 0; i < 4; i++) {
				int nr = tmp.r + dr[i];
				int nc = tmp.c + dc[i];

				// 3. 범위 안 + 방문도 안 했고 + 맵도 바다가 아닌 빙산이면
				if (nr >= 0 && nc >= 0 && nr < row && nc < col && !visit[nr][nc] && map[nr][nc] != 0) {

					// 4. 방문 완료!
					visit[nr][nc] = true;

					// 5. 이따 얘 가지고 또 인접 위치 방문해야하니까 다시 큐에 꾸깃 넣는다
					remain.offer(new Pos(nr, nc));

					// 6. 방문한 빙산개수 세려고 cnt를 ++해줌.
					cnt++;
				}
			}
		}
		// 7. 빙산 개수 = 방문개수? ㅇㅋ이어짐 : 앗 분리됨
		return icebergCnt == cnt ? true : false;
	}

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src\\dfs_bfs\\iceberg_test.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 입력
		// row, col
		// map 정보
		StringTokenizer st = new StringTokenizer(br.readLine());
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());

		map = new int[row][col];

		for (int i = 0; i < row; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < col; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

				// 정수가 들어오면 q에 위치정보 저장 : 나중에 탐색할 필요 없게
				if (map[i][j] != 0) {
					queue.offer(new Pos(i, j, map[i][j]));
				}
			}
		}
		while (true) {

			// 1. 큐가 비었다! = 중간에 break 안 걸리고 빙산이 다 녹을 때까지 반복했다 -> 0 출력
			if (queue.isEmpty()) {
				year = 0;
				break;
			}

			// 2. 분리돼버렸다! -> 브레이크!
			if (!isCombined()) {
				break;
			}

			// 3. 큐를 한 바퀴 돌 때마다 1년씩 ++
			year++;
			int size = queue.size();

			// 4. 큐 안에 있는 빙산들의 ice, 높이 정보를 일단 업데이트.
			for (int k = 0; k < size; k++) {
				int zeros = 0;

				// 한 개씩 뽑아서 인접위치에 바다 있는지 확인, 바다인 칸 개수 세서 zeros++
				Pos tmp = queue.poll();
				for (int i = 0; i < 4; i++) {
					int nr = tmp.r + dr[i];
					int nc = tmp.c + dc[i];

					if (nr < 0 || nc < 0 || nr > row - 1 || nc > col - 1 || map[nr][nc] != 0)
						continue;
					zeros++;
				}

				// 6. 높이인 ice를 업데이트만 하고 큐에서 없애지 않는다!! 맵도 0으로 미리 바꾸지 않는다!!
				tmp.ice -= zeros > tmp.ice ? tmp.ice : zeros;

				// 7. 그대로 다시 큐에 넣어줌
				queue.offer(tmp);
			}

			// 8. 한 바퀴 다 돌았다! -> 이제 빙산 일괄적으로 높이 조정. 큐에서 ice가 0인 빙산들을 맵에서도 0으로 바꿔준다.
			makeZero();
		}

		bw.write(String.valueOf(year));
		bw.flush();
		bw.close();
		br.close();
	}
}
