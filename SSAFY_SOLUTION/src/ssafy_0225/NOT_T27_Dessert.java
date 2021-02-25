package ssafy_0225;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Stack;

class Pos {
	int r;
	int c;
	int dir;

	public Pos() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Pos(int r, int c, int dir) {
		super();
		this.r = r;
		this.c = c;
		this.dir = dir;
	}

}

public class NOT_T27_Dessert {

	static int N;
	static int[][] arr;
	static boolean[][] visited;
	static int[] dr = { -1, -1, 1, 1 };
	static int[] dc = { -1, 1, -1, 1 };
	static boolean[] dirCheck;
	static Stack<Pos> stack = new Stack<>();
	static StringBuilder sb = new StringBuilder();

	static int index = 0;

	public static void tour() {
		Pos cur = stack.pop();
		int r = cur.r;
		int c = cur.c;

		int nr = r + dr[index];
		int nc = c + dc[index];

		// 1. 범위 아웃
		if (nr < 0 || nc < 0 || nr > N - 1 || nc > N - 1) {
			index = (index + 1) % 4;
			return;
		} else if (visited[nr][nc]) {
			index = (index + 1) % 4;
			return;
		} else if (sb.toString().contains(String.valueOf(arr[nr][nc]))) {
			index = (index + 1) % 4;
			return;
		}
		stack.push(new Pos(nr, nc, (cur.dir + 1) % 4));
		visited[nr][nc] = true;
		dirCheck[index] = true;
		index = (index + 1) % 4;
		sb.append(arr[nr][nc]);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int testCase = Integer.parseInt(br.readLine());

		for (int i = 0; i < testCase; i++) {
			stack.clear();
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			visited = new boolean[N][N];
			dirCheck = new boolean[4];
			for (int j = 0; j < N; j++) {
				arr[j] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			}

		}

		bw.flush();
		bw.close();
		br.close();
	}
}
