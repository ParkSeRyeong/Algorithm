package study;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_7682_틱택토 {

	public static boolean isContinous(char[][] arr, int o_cnt, int x_cnt, char c) {
		for (int i = 0; i < 3; i++) {
			if (arr[i][0] == c && arr[i][1] == c && arr[i][2] == c) {
				return true;
			}
		}
		for (int i = 0; i < 3; i++) {
			if (arr[0][i] == c && arr[1][i] == c && arr[2][i] == c) {
				return true;
			}
		}
		if(arr[0][0] == c && arr[1][1] == c && arr[2][2] == c) {
			return true;
		}
		if(arr[0][2] == c && arr[1][1] == c && arr[2][0] == c) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/study/틱택토_test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(); // bw로 바꿔보기
		while (true) {
			String tmp = br.readLine();
			if (tmp.equals("end"))
				break;

			char[][] arr = new char[3][3];
			int o_cnt = 0;
			int x_cnt = 0;

			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					arr[i][j] = tmp.charAt((3 * i) + j);
					if (arr[i][j] == 'O')
						o_cnt++;
					else if (arr[i][j] == 'X')
						x_cnt++;
				}
			}

			for (char[] i : arr) {
				for (char j : i) {
					System.out.print(j + " ");
				}
				System.out.println();
			}
			// o가 더 많거나 / x와 o의 갯수 차이가 1보다 크면 / 빈 공간이 5개 이상이면
			if (o_cnt > x_cnt || x_cnt - o_cnt > 1 || 9 - x_cnt - o_cnt > 4) {
				sb.append("invalid").append("\n");
				continue;
			}
			//boolean flag = isContinous(arr, o_cnt, x_cnt);
//			if (flag)
//				sb.append("valid\n");
//			else
//				sb.append("invalid\n");
		}
		System.out.println(sb);
	}
}
