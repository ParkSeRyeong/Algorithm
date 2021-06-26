package bst;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_3079_입국심사 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 이 두개를 long으로 안해서.................오지게틀림
		// 이거 줄이기
		long N = Long.parseLong(st.nextToken());
		long M = Long.parseLong(st.nextToken());

		int[] time = new int[(int)N];

		for (int i = 0; i < N; i++) {
			time[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(time);

		long low = 0; // 최소 시간
		long high = time[(int) (N - 1)] * M; // 최대 시간 = 젤 오래 걸리는 심사대 * 상근이 친구수
		long result = high;

		while (low <= high) {
			long mid = (low + high) / 2;
			long sum = 0;

			for (long i : time) {
				sum += mid / i;
			}

			if (sum >= M) {
				result = Math.min(result, mid);
				high = mid - 1;
			} else {
				low = mid + 1;
			}

		}
		bw.write(String.valueOf(result));
		bw.flush();
		bw.close();
		br.close();
	}

}
