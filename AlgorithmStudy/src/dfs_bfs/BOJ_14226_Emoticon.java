package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Emoji {
	int screen;
	int clip;
	int cnt;

	public Emoji(int screen_num, int clipboard, int cnt) {
		this.screen = screen_num;
		this.clip = clipboard;
		this.cnt = cnt;
	}
}

public class BOJ_14226_Emoticon {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int MAX = 1001;

		boolean[][] visit = new boolean[1001][1001];

		Queue<Emoji> q = new LinkedList<>();
		q.offer(new Emoji(1, 0, 0));
		visit[1][0] = true;

		while (!q.isEmpty()) {
			Emoji now = q.poll();
			if (now.screen == N) {
				System.out.println(now.cnt);
				break;
			}

			// 1. 복사하기
			if (now.screen > 0 && now.screen < MAX && !visit[now.screen][now.screen]) {
				visit[now.screen][now.screen] = true;
				q.offer(new Emoji(now.screen, now.screen, now.cnt + 1));
			}

			// 2. 붙여넣기
			if (now.clip > 0 && now.screen + now.clip < MAX && !visit[now.screen + now.clip][now.clip]) {
				visit[now.screen][now.clip] = true;
				q.offer(new Emoji(now.screen + now.clip, now.clip, now.cnt + 1));
			}

			// 3. 삭제하기
			if (now.screen > 0 && !visit[now.screen - 1][now.cnt]) {
				visit[now.screen - 1][now.cnt] = true;
				q.offer(new Emoji(now.screen - 1, now.clip, now.cnt + 1));
			}
		}
	}
}
