package recursive;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_2579_Step {
	static int[] steps;
	static int Step;

	public static void func(int start, int sum, boolean[] visit) {

		for (int i = start; i >= 0; i--) {
			visit[i] = true;
			if (i + 1 >= Step || !visit[i + 1]) {
				func(i - 1, sum + steps[i], visit);
			}
			func(i - 2, sum + steps[i], visit);
			visit[i] = false;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Step = Integer.parseInt(br.readLine());

		steps = new int[Step];
		for (int i = 0; i < Step; i++) {
			steps[i] = Integer.parseInt(br.readLine());
		}

		int now = Step - 1;

	}
}
