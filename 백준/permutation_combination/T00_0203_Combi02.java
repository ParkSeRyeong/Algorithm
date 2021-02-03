package permutation_combination;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class T00_0203_Combi02 {
	static int[] num;
	static int N, M;
	static StringBuilder sb= new StringBuilder();

	public static void Combination(int toSelect, int[] selected, int start) {
		if (toSelect == M) {
			for(int i:selected) {
				sb.append(i+" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = start; i < num.length; i++) {
			selected[toSelect] = num[i];
			Combination(toSelect + 1, selected, i + 1);
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String tmp = br.readLine();

		N = Integer.parseInt(tmp.split(" ")[0]);
		M = Integer.parseInt(tmp.split(" ")[1]);

		num = new int[N];
		// 1. 중복 없이 M개 고른 수열 (=조합)
		// 2. 고른 수열은 오름차순 -> 안주어졌으니까 따로 sort안 해도 될듯?

		for (int i = 0; i < N; i++) {
			num[i] = i + 1;
		}
		Combination(0, new int[M], 0);
		sb.setLength(sb.length()-1);
		System.out.println(sb.toString());
	}
}
