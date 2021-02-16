package linkedlist;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Problem04_AntSoldiers {
	static int[] arr;
	static int N;
	static int Max = 0;

	public static void permutation(int cnt, boolean[] select, int sum) {
		if (cnt >= N) {
			for (int i = 0; i < N; i++) {
				if (select[i]) {
					System.out.print(arr[i] + " ");
				}
			}
			System.out.println();
			Max = Math.max(sum, Max);
			return;
		}
		sum += arr[cnt];
		select[cnt] = true;
		permutation(cnt + 2, select, sum);
		sum -= arr[cnt];
		select[cnt] = false;
		permutation(cnt + 1, select, sum);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src/linkedlist/ant_test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		ArrayList<int[]> list = new ArrayList<>();

		N = Integer.parseInt(br.readLine());
		arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		permutation(0, new boolean[N], 0);

		bw.write(String.valueOf(Max));
		br.close();
		bw.flush();
		bw.close();
	}
}
