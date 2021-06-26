package bst;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_10816_숫자카드2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		HashMap<Integer, Integer> map = new HashMap<>();

		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		while (st.hasMoreTokens()) {
			int now = Integer.parseInt(st.nextToken());
			if (map.get(now) == null) {
				map.put(now, 1);
			} else {
				map.put(now, map.get(now) + 1);
			}
		}

		int M = Integer.parseInt(br.readLine());
		int[] find = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		for (int i : find) {
			if (map.get(i) == null)
				bw.write("0 ");
			else {
				bw.write(String.valueOf(map.get(i)));
				bw.write(" ");
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
