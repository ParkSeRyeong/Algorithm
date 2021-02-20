package live02_0119;

import java.util.Scanner;

/*
다음은 4x4 의 2차원 배열을 나타낸다. X 로 표시된 항목의 좌우 숫자의 합을
구하는 코드를 작성하시오.
[입력]
2 3 1 4
1 X 3 2
3 4 X X
X 4 1 5
[출력]
12
*/

public class T15 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[][] grid = new char[4][4];
		boolean[][] used = new boolean[4][4];
		int sum = 0;

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				grid[i][j] = sc.next().charAt(0);
			}
		}
		// ---------------------------------------------------------------------------------

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				// x를 만난다면
				if (grid[i][j] == 'X') {
					// 위 아래------------------------------------------------------------------------
					if (i - 1 >= 0 && grid[i - 1][j] != 'X' && used[i - 1][j] == false) {
						sum += grid[i - 1][j] - '0';
						used[i - 1][j] = true;
						System.out.println(i - 1 + ", " + j);
					}

					if (i + 1 < grid.length && grid[i + 1][j] != 'X' && used[i + 1][j] == false) {
						sum += (int) grid[i + 1][j] - '0';
						used[i + 1][j] = true;
						System.out.println(i + 1 + ", " + j);
					}

					// 좌 우------------------------------------------------------------------------
					if (j - 1 >= 0 && grid[i][j - 1] != 'X' && used[i][j - 1] == false) {
						sum += grid[i][j - 1] - '0';
						used[i][j - 1] = true;
						System.out.println(i + ", " + (j - 1));
					}

					if (j + 1 < grid[i].length && grid[i][j + 1] != 'X' && used[i][j + 1] == false) {
						sum += (int) grid[i][j + 1] - '0';
						used[i][j + 1] = true;
						System.out.println(i + ", " + (j + 1));
					}

				}

			}
		}
		System.out.println(sum);

		sc.close();
	}
}
