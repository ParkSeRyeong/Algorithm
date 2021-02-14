package implementation;

import java.io.IOException;
import java.util.Scanner;

public class Problem_02_Knight {
	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();

		int r = input.charAt(1) - 48;
		int c = input.charAt(0) - 96;

		// 상 하 좌 우
		int[] dir_r = { -1, 1, 0, 0 };
		int[] dir_c = { 0, 0, -1, 1 };

		int cnt = 0;
		int nr, nc = 0;

		for (int i = 0; i < 4; i++) {
			
			// 상하좌우로 두 칸 이동 후
			nr = r + (dir_r[i] * 2);
			nc = c + (dir_c[i] * 2);

			// 다시 좌우상하로 한 칸 이동
			for (int j = 0; j < 2; j++) {
				int tmp_r = nr;
				int tmp_c = nc;
				
				// 상하로 이동할 땐 -> 좌우로 1칸씩 움직여야 하니까 -> 배열상 r과 c를 반대로 더해주면 -> 좌 우 한칸씩 움직이는거랑 같음
				if (i < 2) {
					nr = nr + dir_c[j];
					nc = nc + dir_r[j];
				}
				// 좌우로 이동할 땐 -> 상하로 1칸씩 움직여야 하니까 -> 원래대로 r과 c를 더해주면 -> 상 하 한칸씩 움직이는 거랑 같음
				else {
					nr = nr + dir_r[j];
					nc = nc + dir_c[j];
				}

				if (nr < 1 || nr > 8 || nc < 1 || nc > 8) {
					System.out.println("\t\t이동 불가!");
					continue;
				}
				System.out.println("이동 후 좌표 " + nr + "," + nc);
				
				// 반복문이라 좌로 움직였으면 -> 원래 위치에서 우로 움직여야 하니까 -> 원래 위치를 기억해놨다가 -> 다시 대입하기
				nr = tmp_r;
				nc = tmp_c;
				cnt++;
			}

		}
		System.out.println(cnt);
		sc.close();
	}
}
