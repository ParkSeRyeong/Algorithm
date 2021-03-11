package backtracking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

import javax.sound.midi.Synthesizer;

public class BOJ_16928_Snake_and_Ladder2 {

	public static void print(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (i % 10 == 0) {
				System.out.println(arr[i]);
			} else {
				System.out.print(arr[i] + " ");
			}
		}
	}

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/backtracking/ladder_test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int ladder = Integer.parseInt(st.nextToken());
		int snake = Integer.parseInt(st.nextToken());
		int[] map = new int[101];
		int[] visited = new int[101];
		int tmp = 0;

		for (int i = 0; i < ladder; i++) {
			st = new StringTokenizer(br.readLine());
			tmp = Integer.parseInt(st.nextToken());
			map[tmp] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < snake; i++) {
			st = new StringTokenizer(br.readLine());
			tmp = Integer.parseInt(st.nextToken());
			map[tmp] = Integer.parseInt(st.nextToken());
		}

		Queue<Integer> q = new LinkedList<Integer>();

		visited[1] = 0;
		q.offer(1);
		while (!q.isEmpty()) {
			int now = q.poll();
			if (now == 100) {
				System.out.println(visited[100]);
				return;
			}

			for (int k = 1; k <= 6; k++) {
				int movingPoint = now + k;
				if (movingPoint > 100)
					break;

				// 이미 방문한 곳
				if (visited[movingPoint] != 0) {
					continue;
				}

				if (map[movingPoint] == 0) {
					visited[movingPoint] = visited[now] + 1;
					q.add(movingPoint);
				}
				
				else {
					movingPoint = map[movingPoint];
					if (visited[movingPoint] == 0) {
						visited[movingPoint] = visited[now] + 1;
						q.add(movingPoint);
					}
				}
			}

		}
		// bw.write(String.valueOf(map[100]));
		bw.flush();
		bw.close();
		br.close();
		// print(map);
	}
}
