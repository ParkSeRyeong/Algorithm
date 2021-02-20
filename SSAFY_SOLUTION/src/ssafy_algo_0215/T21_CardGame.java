package ssafy_algo_0215;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class T21_CardGame {
	static ArrayList<Integer> ky;
	static ArrayList<Integer> iy;
	static int total_win = 0;
	static int total_lose = 0;

	public static void permutation(int toSelect, int[] selected, boolean[] visited) {
		if (toSelect == 9) {
			int ksum = 0;
			int isum = 0;
			for (int i = 0; i < 9; i++) {
				int kcard = ky.get(i);
				int icard = selected[i];
				isum += icard > kcard ? icard + kcard : 0;
				ksum += kcard > icard ? kcard + icard : 0;
			}
			if (isum > ksum)
				total_lose++;
			else if (isum < ksum)
				total_win++;
			return;
		}

		for (int i = 0; i < 9; i++) {
			if (!visited[i]) {
				visited[i] = true;
				selected[toSelect] = iy.get(i);
				permutation(toSelect + 1, selected, visited);
				visited[i] = false;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int tc = Integer.parseInt(br.readLine());
		Integer[] arr = new Integer[19];

		for (int t = 0; t < tc; t++) {
			sb.append(t + 1).append(" ");
			ky = new ArrayList<>();
			iy = new ArrayList<>();
			total_win = 0;
			total_lose = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			while (st.hasMoreElements()) {
				ky.add(Integer.parseInt(st.nextToken()));
			}
			for (int i = 1; i < 19; i++) {
				if (ky.contains(i)) {
					continue;
				}
				iy.add(i);
			}
			permutation(0, new int[9], new boolean[9]);
			sb.append(total_win).append(" ").append(total_lose).append("\n");
		}
		bw.write(String.valueOf(sb));

		br.close();
		bw.flush();
		bw.close();
	}
}