package ssafy_algo_0209;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2563_Origami {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[100][100];
		int count = 0;

		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			for (int j = 0; j < 10; j++) {
				for (int k = 0; k < 10; k++) {
					// 이미 색칠된 구간이면 무시
					if (arr[r + j][c + k] == 1) {
						continue;
					}
					arr[r + j][c + k] = 1;
					count++;
				}
			}

		}
		System.out.println(count);
	}
}
