package fail;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class POS {
	int r;
	int c;

	public POS(int r, int c) {
		super();
		this.r = r;
		this.c = c;
	}
}

public class NOT_BOJ_17136_ColorPaper {
	static int[][] arr = new int[10][10];
	static int[][] info = new int[10][10];
	static int[] paper = new int[6];
	static Queue<POS> q = new LinkedList<>();

	public static void func() {
		while(!q.isEmpty()) {
			POS now = q.poll();
			

			int i = 0;
			int cnt = 0;
			int min = Integer.MAX_VALUE;
			while (true) {
				if (info[now.r + i][now.c] == 1) {
					break;
				}
				cnt++;
				min = Math.min(min, info[now.r][now.c + i]);
			}
			// 갯수를 다 세면?
			// cnt엔 세로로 이어진 개수, min에는 그 이어진 수들 중 젤 작은 값.
			// 5
			// 4
			// 3
			// 5 
			// 1 -> cnt = 4, min = 3. 그럼 3*3이 들어갈 수 있음!
			min = Math.min(min, cnt);
			paper[min]++;
			for (int k = 0; k < cnt; k++) {
				info[now.r + k][now.c] -= min;
			}
		}
		
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for (int i = 0; i < 10; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int one_cnt = 0;
			for (int j = 0; j < 10; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());

				// 1. 값이 1이라면 -> one_cnt 하나씩 증가
				if (arr[i][j] == 1) {
					one_cnt++;
				}
				// 2. 값이 맨 앞이라면 -> 0 넣기
				else if (j == 0) {
					info[i][j] = 0;
				}
				// 3. 값이 맨 앞이 아니고 0이라면 -> 이 전까지 1의 개수를 직전 위치에 넣는다.
				// 즉, info 배열에 있는 숫자는 이 칸 포함 N칸까지
				else {
					info[i][j - 1] = one_cnt;
					q.offer(new POS(i, j - 1));
					one_cnt = 0;
				}

			}
		}

		for (int[] i : info) {
			for (int j : i) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
	}
}
