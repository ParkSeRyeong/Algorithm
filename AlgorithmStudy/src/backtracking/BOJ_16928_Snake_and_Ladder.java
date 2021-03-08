package backtracking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_16928_Snake_and_Ladder {
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/backtracking/ladder_test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int ladder = Integer.parseInt(st.nextToken());
		int snake = Integer.parseInt(st.nextToken());
		int[] map = new int[101];
		int tmp = 0;

		for (int i = 0; i < ladder; i++) {
			st = new StringTokenizer(br.readLine());
			tmp = Integer.parseInt(st.nextToken());
			map[tmp] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < snake; i++) {
			st = new StringTokenizer(br.readLine());
			tmp = Integer.parseInt(st.nextToken());
			map[tmp] = -Integer.parseInt(st.nextToken());
		}

		int cur = 2;
		int index = 0;
		while (true) {
			if (cur == 99) {
				break;
			}
			index++;
			for (int i = 0; i < 6; i++) {
				if (map[cur] < 0) {
					System.out.println("뱀이당!");
					// 현재 뱀 타고 간 위치 값이 지금 인덱스+1 값보다 크면
					if (map[-map[cur]] > index + 1) {
						System.out.println("현재 뱀 위치 " + cur + ", 뱀 도착 위치 " + (-map[cur]));
						System.out.println("\t" + (index + 1) + "값으로 변경");
						map[-map[cur]] = index + 1;
					}
				} else if (map[cur] > 0) {
					// 사다리 있거나 사다리타고와서 이미 값이 갱신된 상태?
				}
				map[cur] = index;
				cur++;
			}
		}

		System.out.println(Arrays.toString(map));
	}
}
