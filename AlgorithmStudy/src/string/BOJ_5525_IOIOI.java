package string;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_5525_IOIOI {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int strLen = Integer.parseInt(br.readLine());
		String str = br.readLine();

		int num = 0;
		int answer = 0;

		for (int i = 0; i < strLen - 2; i++) {
			if (str.charAt(i) == 'I' && str.charAt(i + 1) == 'O' && str.charAt(i + 2) == 'I') {
				num++;
				i++;
				if (num == N) {
					answer++;
					num--;
				}
			} else
				num = 0;
		}
		bw.write(String.valueOf(answer));
		bw.flush();
		bw.close();
		br.close();
	}
}
