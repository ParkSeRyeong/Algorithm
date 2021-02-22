package string;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

public class BOJ_11478_AnotherSubString {
	static int len;
	static char[] arr;
	static int cnt = 0;
	static HashMap<String, Integer> map = new HashMap<>();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String str = br.readLine();
		int N = str.length();
		arr = new char[N];
		for (int i = 0; i < N; i++) {
			arr[i] = str.charAt(i);
		}

		for (int i = 0; i < N; i++) {
			for (int j = 1; j <= N - i; j++) {
				map.put(str.substring(i, i + j), 0);
			}
		}

		bw.write(String.valueOf(map.size()));
		bw.flush();
		bw.close();
		br.close();
	}
}
