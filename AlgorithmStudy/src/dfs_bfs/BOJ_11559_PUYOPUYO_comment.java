package dfs_bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class BOJ_11559_PUYOPUYO_comment {
	static char[][] map;
	static boolean[][] visit;
	static ArrayList<Point> list = new ArrayList<>();
	static int height = 0;
	static int idx = 1;
	static int remove_cnt = 0;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void print() {
		for (int i = 0; i < height; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
		System.out.println("--------------");
	}

	public static void visit_print() {
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < 6; j++) {
				if (visit[i][j])
					System.out.print(1 + " ");
				else
					System.out.print(0 + " ");
			}
			System.out.println();
		}
		System.out.println("-----------------");
	}

	/**
	 * 리스트에 저장된 뿌요 좌표 다 지워버려욤
	 * */
	public static void remove() {
		Iterator<Point> iter = list.iterator();
		while (iter.hasNext()) {
			Point p = iter.next();
			map[p.r][p.c] = '.';
		}
	}

	public static void falling() {
		/**
		 * 나는 열 기준으로 오른쪽으로 옮겨가면서 비교할 것.
		 * 그니까 한 턴에 세로로 길게 쭉 보겠다는 것!
		 * */
		for (int i = 0; i < 6; i++) {
			
			/* 열은 밑에서부터 판단. */
			int j = height - 1;
			int cnt=0;
			
			/* 빈 공간(.)이 나올 때까지 쭉쭉 위로 올라가기.*/
			while (map[j][i] != '.'&& j > 0) {
				j--;
			}
			/* 그럼 여기 위치에서 j는 빈 공간(.)이 있는 위치겠지?*/
			/**
			 * 그럼 다시 이제 뿌요가 나올 때까지 올라가기.
			 * 이 때 cnt 변수에 현재 빈공간에서 몇 칸위에 뿌요가 있는지 저장. 
			 */
			while (map[j][i] == '.'&&j>0) {
				j--;
				cnt++;
			}
			/**
			 * 그럼 j위치에 뿌요가 있고, cnt만큼 밑으로 내려가면 빈공간이 시작된 위치겠지!
			 * 그럼 j위치부터 쭉 아래로 cnt만큼 끌어내려준다.
			 * */
			if(cnt!=0 && j>=0) {
				for(;j>=0;j--) {
					map[j+cnt][i]=map[j][i];
					map[j][i]='.';
				}
			}
		}
	}

	public static int puyo() {
		visit = new boolean[height][6];
		int bomb = 0;
		for (int i = height - 1; i >= 0; i--) {
			for (int j = 0; j < 6; j++) {
				
				/*방문도 안 했고 빈 공간도 아니라면*/
				if (!visit[i][j] && map[i][j] != '.') {
					/**
					 * idx : dfs를 통해 갱신된 연결된 같은 색 뿌요의 개수
					 * list : 나중에 idx가 4이상이면 지워야하니까,
					 * 			이 list에 있는 값만 지우기 위해 해당 좌표 list에 넣기.
					 * 
					 *  dfs마다 새로 판단해야하니까 초기화.
					 * */
					idx = 0;
					list.clear();
					
					/* dfs를 통해 연결된 뿌요 개수 세고 + 뿌요 위치 저장하고 */
					dfs(i, j, map[i][j], 1);
					
					/* 4개 이상이면 지웁시당 */
					if (idx >= 4) {
						remove();
						bomb++;
					}
				}
			}
		}
		
		/* 다 터뜨렸나..? 그럼 이제 뿌요 밑으로 떨어뜨리자. */
		falling();
		
		/* 이 bomb가 0이면 아무것도 안 터졌다는 뜻이니까, main의 while문 탈출하기 위해 넣음.*/
		return bomb;
	}

	public static void dfs(int r, int c, char color, int cnt) {
		visit[r][c] = true;
		list.add(new Point(r, c));
		idx++;
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];

			if (nr < 0 || nc < 0 || nr >= map.length || nc >= map[0].length || visit[nr][nc] || map[nr][nc] != color) {
				continue;
			}
			dfs(nr, nc, color, cnt + 1);
		}
	}

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src\\dfs_bfs\\puyopuyo.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		boolean flag = false;
		int start = 0;
		/**
		 * 입력부.
		 * 실제로 뿌요가 쌓여있는 공간만 map으로 넣기 위해
		 * flag를 사용해 뿌요가 시작되는 순간 그 크기만큼만 map을 만들었다.
		 * */
		for (int i = 0; i < 12; i++) {
			String tmp = br.readLine();
			if (!flag) {
				if (tmp.contains("R") || tmp.contains("G") || tmp.contains("B") || tmp.contains("P")
						|| tmp.contains("Y")) {
					flag = true;
					height = 12 - start;
					map = new char[height][6];
				} else
					start++;
			}
			if (flag) {
				for (int j = 0; j < 6; j++) {
					map[i - start][j] = tmp.charAt(j);
				}
			}
		}
		
		/**
		 * 뿌요를 처음 발견했을 때 flag를 true로 설정하는데,
		 * 아직 false라는 건 뿌요가 아예 없다는 뜻이므로
		 * 그냥 0 출력하고 끝내버린다.
		 * */
		if(!flag) {
			System.out.println(0);
			return;
		}
		
		/**
		 * puyo를 통해 터뜨릴 수 있는 건 다 터뜨리고,
		 * 그 때마다 연쇄 횟수를 1 증가시킨다.
		 * */
		int bomb = 0;
		while (true) {
			bomb = puyo();
			if (bomb == 0)
				break;
			remove_cnt++;
		}
		System.out.println(remove_cnt);
	}
}
