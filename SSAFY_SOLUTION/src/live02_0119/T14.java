package live02_0119;

import java.util.Scanner;

public class T14 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		/*
		 * 다음은 4x4의 2차원 배열을 나타낸다 Scanner를 이용해서 사용자의 입력으로 아래의 배열을 구성하고 출력하는 코드를 작성하시오
		 * 사용자의 입력은 다음과 같이 제공된다:
		 * [입력]
		 * 2 3 1 4
		 * 1 x 3 2
		 * 3 4 x x
		 * x 4 1 5
		 * [출력]
		 * 2314
		 * 1x32
		 * 34xx
		 * x415
		 */
				char[][] grid = new char[4][4];
				for(int i=0;i<grid.length;i++) {
					for(int j=0;j<grid[i].length;j++) {
						grid[i][j]=sc.next().charAt(0);
					}
				}
				
				for(int i=0;i<grid.length;i++) {
					for(int j=0;j<grid[i].length;j++) {
						System.out.print(grid[i][j]+" ");
					}
					System.out.println();
				}
				sc.close();
			
	}
}
