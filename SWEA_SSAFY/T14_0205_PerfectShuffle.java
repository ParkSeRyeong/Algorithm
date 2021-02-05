package ssafy_algo_0205;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class T14_0205_PerfectShuffle {
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(
				new FileInputStream("C:\\SSAFY\\javawork\\AlgorithmClass\\src\\ssafy_algo_0205\\sample_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t < T + 1; t++) {
			sb.append("#");
			sb.append(t);
			sb.append(" ");

			int N = Integer.parseInt(br.readLine());
			String[] arr = br.readLine().split(" ");

			String[] left = null;
			String[] right = null;
			if (N % 2 == 1) {
				left = Arrays.copyOfRange(arr, 0, N / 2 + 1);
				right = Arrays.copyOfRange(arr, N / 2 + 1, arr.length);
			} else {
				left = Arrays.copyOfRange(arr, 0, N / 2);
				right = Arrays.copyOfRange(arr, N / 2, arr.length);
			}

			String[] result = new String[arr.length];
			for (int i = 0; i < arr.length; i++) {
				if (i % 2 == 0) {
					result[i] = left[i/2];
				} else {
					result[i] = right[i/2];
				}
			}
			for(String s:result) {
				sb.append(s);
				sb.append(" ");
			}
			sb.append("\n");
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb.toString());
	}
}
