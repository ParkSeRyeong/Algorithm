package ssafy_algo_0210;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1535_Hi {
	static int N;
	static int[] Lost;
	static int[] Happy;
	static int Max;
//	static int hp = 100;
//	static int feel = 0;

	public static void powerset(int cnt, boolean[] select, int health, int feel) {
		if (health <= 0) {
			return;
		}
		if (cnt == N) {
			Max = Math.max(Max, feel);
			return;
		}
		select[cnt] = true;
		powerset(cnt + 1, select, health - Lost[cnt], feel + Happy[cnt]);
		select[cnt] = false;
		powerset(cnt + 1, select, health, feel);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src/ssafy_algo_0210/hi_test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		Lost = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		Happy = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		powerset(0, new boolean[N], 100, 0);
		System.out.println(Max);
	}
}
