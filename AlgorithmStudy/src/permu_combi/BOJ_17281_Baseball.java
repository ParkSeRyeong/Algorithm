package permu_combi;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class BOJ_17281_Baseball {
	static int[][] score;

	private static void permutation(int toSelect, int[] selected, boolean[] visited) {
		if (toSelect == 9) {
			calculateScore(selected);
			return;
		}
		if (toSelect == 3) {
			visited[0] = true;
			selected[toSelect] = 0;
			permutation(toSelect + 1, selected, visited);
		} else {
			for (int i = 1; i < 9; i++) {
				if (!visited[i]) {
					visited[i] = true;
					selected[toSelect] = i;
					permutation(toSelect + 1, selected, visited);
					visited[i] = false;
				}
			}
		}

	}

	private static void calculateScore(int[] selected) {
		int sum = 0;
		int index = 0;
		for (int i = 0; i < score.length; i++) {
			int out = 0;
			while (out != 3) {
				// 현재 타순의 점수가 0이면 아웃 증가
				if (score[i][selected[index]] == 0) {
					out++;
				} else {
					
				}
				index++;
			}
			System.out.println((i + 1) + "이닝까지 점수 : " + sum);
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src/permu_combi/baseball_test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int inning = Integer.parseInt(br.readLine());
		score = new int[inning][9];
		for (int i = 0; i < inning; i++) {
			score[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}

		//permutation(0, new int[9], new boolean[9]);
		int sum=1;
		System.out.println(sum);
		sum=1<<1;
		System.out.println(sum);
		sum=sum<<1;
		System.out.println(sum);
		br.close();
		bw.flush();
		bw.close();
	}
}
