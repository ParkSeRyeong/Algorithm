package permu_combi;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1182_SubStringSum {
	static int cnt = 0;

	public static void powerset(int toSelect, boolean[] visited, int[] arr, int S, int sum) {
		if (toSelect == arr.length) {
			if (sum == S)
				cnt++;
			return;
		}
//		visited[toSelect] = true;
//		powerset(toSelect + 1, visited, arr, S, sum + arr[toSelect]);
//		visited[toSelect] = false;
//		powerset(toSelect + 1, visited, arr, S, sum);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		powerset(0, new boolean[N], arr, S, 0);
		cnt = S != 0 ? cnt : cnt - 1;
		bw.write(String.valueOf(cnt));
		br.close();
		bw.flush();
		bw.close();
	}
}
