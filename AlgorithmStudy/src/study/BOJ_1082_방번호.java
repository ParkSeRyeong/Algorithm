package study;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1082_방번호 {
	static String[] dp = new String[51];
	static int N;
	static int[] num = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
	static int[] money;

	private static class number implements Comparable<number> {
		int num;
		int cost;

		public number(int num, int cost) {
			super();
			this.num = num;
			this.cost = cost;
		}

		@Override
		public int compareTo(number o) {
			if (this.cost == o.cost) {
				return this.num - o.num;
			}
			return this.cost - o.cost;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Map<Integer, Integer> m = new HashMap<>();

		N = Integer.parseInt(br.readLine());
		number[] arr = new number[N];
		int[] result = new int[51];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = new number(i, Integer.parseInt(st.nextToken()));
			m.put(i, arr[i].cost);
		}
		int my = Integer.parseInt(br.readLine());

		Arrays.sort(arr);
//		for(int i=0;i<arr.length;i++) {
//			System.out.println(arr[i].num+" "+arr[i].cost);
//		}

		int cnt = 0;
		if (arr[0].num == 0) {
			if (N == 1 || arr[1].cost > my) {
				System.out.println(0);
				System.exit(0);
			}
			result[cnt++] = arr[1].num;
			my -= arr[1].cost;
		}

		while (my - arr[0].cost >= 0) {
			result[cnt++] = arr[0].num;
			my -= arr[0].cost;
		}
		for (int i = 0; i < cnt; i++) {
			for (int j = N - 1; j >= 0; j--) {
				if (i == 0 && j == 0)
					continue; // 맨 앞자리에 0이 들어가면 xxx
				int tmp = my + m.get(result[i]) - m.get(j);
				if (tmp >= 0) { // 가격 범위 안 넘어서 현재 숫자로 바꿀 수 있으면 바꿈(최대한 큰 수이므로)
					my = tmp; // 허용 가능한 비용 갱신
					result[i] = j;
					break;
				}
			}
		}
		for (int i = 0; i < cnt; i++)
			bw.write(String.valueOf(result[i]));
		bw.flush();
		bw.close();
		br.close();
	}
}
