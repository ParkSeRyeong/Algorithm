package ssafy_algo_0201;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class T04_0201_Water_Strider {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("테스트 케이스 입력 : ");
		int tc = Integer.parseInt(br.readLine());

		int[] dir_r = { 1, 0 };
		int[] dir_c = { 0, 1 };
		int[] cnt = new int[tc];

		// 1. tc만큼 반복
		for (int k = 0; k < tc; k++) {

			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int bugs = Integer.parseInt(st.nextToken());

			int[][] map = new int[N][N];
			int[][] visit = new int[N][N];

			// 2. 소금쟁이 수만큼 입력 받고
			for (int i = 0; i < bugs; i++) {
				String[] str = br.readLine().split(" ");

				// 3. 각각 소금쟁이 위치와 방향을 저장
				int r = Integer.parseInt(str[0]);
				int c = Integer.parseInt(str[1]);
				int dir = Integer.parseInt(str[2]) - 1;

				// 4. 시작 전 소금쟁이의 위치를 맵에 저장. 우린 1~N번 소금쟁이로 할 거니까 i+1로.
				map[r][r] = i + 1;

				// System.out.println("\n------" + (i + 1) + "번 소금쟁이 이동------");
				for (int jump = 3; jump > 0; jump--) {

					// 5. nr, nc : row/col 방향으로 이동할 위치를 저장
					int nr = r + dir_r[dir] * jump;
					int nc = c + dir_c[dir] * jump;

					// 6. 범위를 벗어나면 다음 소금쟁이로
					if (nr >= N || nr < 0 || nc >= N || nc < 0) {
						// System.out.println("범위 아웃");
						break;
					}

					// 7. 확인용
					// System.out.println("\t" + r + "," + c + " -> " + nr + "," + nc + "로 이동");

					// 8. 소금쟁이 이동
					r = nr;
					c = nc;

					// 9. 이미 뛰었던 자리인지 판단 후, 뛰었던 자리라면 소금쟁이 번호 저장
					if (visit[r][c] != 0) {
						cnt[k]=i+1;
					}

					// 10. 해당 소금쟁이가 방문했음을 표시
					visit[r][c] = i + 1;
				}
			}
		}
		for(int i=0;i<tc;i++) {
			System.out.println("#"+(i+1)+" "+cnt[i]);
		}

	}
}
