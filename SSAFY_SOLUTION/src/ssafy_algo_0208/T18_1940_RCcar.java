package ssafy_algo_0208;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class T18_1940_RCcar {
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src/ssafy_algo_0208/rc_test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 0 유지 / 1 가속 / 2 감속
		// 가속도값이 추가로 주어짐
		int tc = Integer.parseInt(br.readLine());

		for (int t = 0; t < tc; t++) {
			sb.append("#").append(t + 1).append(" ");

			int speed = 0;
			int dist = 0;
			// 커맨드 수 N
			int N = Integer.parseInt(br.readLine());
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int command = Integer.parseInt(st.nextToken());
				int a = 0;
				switch (command) {
				case 0:
					break;
				case 1:
					a = Integer.parseInt(st.nextToken());
					speed += a;
					break;
				case 2:
					a = Integer.parseInt(st.nextToken());
					if (speed - a < 0) {
						speed = 0;
						break;
					}
					speed -= a;
					break;
				}
				dist += speed;
			}
			sb.append(dist).append("\n");
		}
		System.out.println(sb);
	}
}
