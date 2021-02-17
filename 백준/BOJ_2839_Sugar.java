package ssafy_algo_0216;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_2839_Sugar {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		int bag = 0;
		while (N % 5 != 0 && N > 2) {
			bag++;
			N -= 3;
		}

		bag += N / 5;
		N %= 5;

		if (N != 0)
			bag = -1;
		bw.write(String.valueOf(bag));
		bw.flush();
		bw.close();
		br.close();
	}
}
