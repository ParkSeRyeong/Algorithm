package dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem04_Floor {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[1001];

		arr[1] = 1;
		arr[2] = 3;

		for (int i = 3; i <= N; i++) {
			arr[i] = arr[i - 1] + 2 * arr[i - 2];
		}
		System.out.println(arr[N] / 796796);
	}
}