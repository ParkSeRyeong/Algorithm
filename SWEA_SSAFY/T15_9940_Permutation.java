package swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class T15_9940_Permutation {
	static int N = 3;
	static int[] arr = { 2, 3, 4, 5, 6 };
	static int total = 0;
	static StringBuilder sb = new StringBuilder();

	public static void Permutation(int toSelect, int[] selected, boolean[] visited) {

		if (toSelect == N) {
			System.out.println(Arrays.toString(selected));
			total++;
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			if (!visited[i]) {
				selected[toSelect] = arr[i];
				visited[i] = true;
				Permutation(toSelect + 1, selected, visited);
				visited[i] = false;
			}
		}
	}

	public static void Combination(int toSelect, int[] selected, int start) {

		if (toSelect == N) {
			System.out.println(Arrays.toString(selected));
			total++;
			return;
		}
		for (int i = start; i < arr.length; i++) {
			selected[toSelect] = arr[i];
			Combination(toSelect + 1, selected, i + 1);
		}
	}

	public static void Subset(int cnt, boolean[] selected) {
		if (cnt == N) {
			for (int i = 0; i < arr.length; i++) {
				if (selected[i]) {
					sb.append(i + " ");
				}
			}
			total++;
			System.out.println(sb.toString());
			sb.setLength(0);
			return;
		}
		selected[cnt] = true;
		Subset(cnt + 1, selected);
		selected[cnt] = false;
		Subset(cnt + 1, selected);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src/swea/9940_test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t < tc + 1; t++) {
			sb.append("#");
			sb.append(t);
			sb.append(" ");

			boolean flag = true;
			int N = Integer.parseInt(br.readLine());
			int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			boolean[] visited = new boolean[N + 1];
			for (int i : arr) {
				if (visited[i]) {
					flag = false;
					break;
				}
				visited[i] = true;
			}
			sb.append(flag == true ? "Yes\n" : "No\n");
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb.toString());
	}
}
