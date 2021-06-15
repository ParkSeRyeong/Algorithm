package imple_simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class BOJ_12904_A와B {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String S = br.readLine();
		int N = Integer.parseInt(br.readLine());

		sb.append(S);

		Random random = new Random();
		for (int i = 0; i < N; i++) {
			int r = random.nextInt(10);
			if (r % 2 == 0) {
				//System.out.print(sb);
				sb.reverse();
				sb.insert(0, "B");
				//System.out.println(" -> " + sb.toString());
			} else {
				//System.out.print(sb);
				sb.insert(0, "A");
				//System.out.println(" -> " + sb.toString());
			}
		}
		System.out.println(sb);
		br.close();
	}
}
