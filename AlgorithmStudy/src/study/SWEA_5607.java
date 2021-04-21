package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_5607 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		long[] arr = new long[1000001];
		int p = 1234567891;
		arr[0] = 1;

		for (int i = 1; i <= 1000000; i++) {
			arr[i] = i * arr[i - 1] % p;
		}

		for (int t = 1; t <= tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			long denominator = (arr[r] * arr[n - r]) % p;

			long index = p - 2;
			long fermatNum = 1;
			while (index > 0) {
				if (index % 2 == 1) {
					fermatNum *= denominator;
					fermatNum %= p;
				}
				denominator = (denominator * denominator) % p;
				index /= 2;
			}
			long result = ((arr[n] % p) * (fermatNum % p)) % p;

			sb.append("#").append(t).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
		br.close();
	}
}
