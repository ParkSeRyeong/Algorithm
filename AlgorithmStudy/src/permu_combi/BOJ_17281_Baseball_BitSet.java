package permu_combi;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.BitSet;

public class BOJ_17281_Baseball_BitSet {
	static int[][] score;
	static int Max = Integer.MIN_VALUE;

	private static void permutation(int toSelect, int[] selected, BitSet visited) {
		if (toSelect == 9) {
			calculateScore(selected);
			return;
		}
		if (toSelect == 3) {
			visited.set(0);
			selected[toSelect] = 0;
			permutation(toSelect + 1, selected, visited);
		} else {
			for (int i = 1; i < 9; i++) {
				if (!visited.get(i)) {
					visited.set(i);
					selected[toSelect] = i;
					permutation(toSelect + 1, selected, visited);
					visited.clear(i);
				}
			}
		}
	}

	private static void calculateScore(int[] selected) {
		int index, rs, whole_cnt;
		index = rs = whole_cnt = 0;
		for (int i = 0; i < score.length; i++) {
			long sum = 1;
			int out = 0;
			while (out != 3) {
				if (score[i][selected[index]] == 0) {
					out++;
					whole_cnt = Long.bitCount(sum);
					sum &= 15;
					whole_cnt -= Long.bitCount(sum);
					rs += whole_cnt;
				} else {
					sum = sum << score[i][selected[index]];
					sum |= (1 << score[i][selected[index]]);
				}
				index = (index + 1) % 9;
				if (out == 3)
					break;

			}
		}
		Max = Math.max(Max, rs);
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

		permutation(0, new int[9], new BitSet(9));
		bw.write(String.valueOf(Max));
		br.close();
		bw.flush();
		bw.close();
	}
}
