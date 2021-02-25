package permutation_combination;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_14888_Calculate {
	static int[] num;
	static int[] oper;
	static int Max = Integer.MIN_VALUE;
	static int Min = Integer.MAX_VALUE;

	public static int calculate(int[] operator) {
		int index = 1;
		int result = num[0];
		for (int i : operator) {
			switch (i) {
			case -1:
				result += num[index];
				break;
			case -2:
				result -= num[index];
				break;
			case -3:
				result *= num[index];
				break;
			case -4:
				if (result < 0) {
					result = (-result) / num[index];
					result = -result;
				} else {
					result /= num[index];
				}
				break;
			}
			index++;
		}
		return result;
	}

	public static void permutation(int toSelect, int[] selected, boolean[] visited) {
		if (toSelect == oper.length) {
			int result = 0;
			result = calculate(selected);
			Max = Math.max(Max, result);
			Min = Math.min(Min, result);
			return;
		}

		for (int i = 0; i < oper.length; i++) {
			if (!visited[i]) {
				selected[toSelect] = oper[i];
				visited[i] = true;
				permutation(toSelect + 1, selected, visited);
				visited[i] = false;
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		num = new int[N];
		num = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		oper = new int[N - 1];
		String[] tmp = br.readLine().split(" ");
		int index = 0;
		int operatorIdx = -1;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < Integer.parseInt(tmp[i]); j++) {
				oper[index] = operatorIdx;
				index++;
			}
			operatorIdx--;
		}
		permutation(0, new int[oper.length], new boolean[oper.length]);
		bw.write(String.valueOf(Max)+"\n");
		bw.write(String.valueOf(Min));
		bw.flush();
		bw.close();
		br.close();
	}
}
