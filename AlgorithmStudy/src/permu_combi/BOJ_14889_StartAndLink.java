package permu_combi;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class BOJ_14889_StartAndLink {
	static int min = Integer.MAX_VALUE;

	public static void combi(int toSelect, int[] selected, int cnt, int[][] ability) {
		if (toSelect == ability.length) {
			if (cnt != ability.length / 2)
				return;
			int[] team = new int[3];
			for (int i = 0; i < ability.length; i++) {
				for (int j = 0; j < ability[i].length; j++) {
					if (j != i && selected[j] == selected[i]) {
						team[selected[j]] += ability[i][j];
					}
				}
			}
			min = Math.min(min, Math.abs(team[1] - team[2]));
			return;
		}

		selected[toSelect] = 1;
		combi(toSelect + 1, selected, cnt + 1, ability);
		selected[toSelect] = 2;
		combi(toSelect + 1, selected, cnt, ability);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		int[][] ability = new int[N][N];
		for (int i = 0; i < N; i++) {
			ability[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}
		combi(0, new int[N], 0, ability);
		
		bw.write(String.valueOf(min));
		br.close();
		bw.flush();
		bw.close();
	}
}
