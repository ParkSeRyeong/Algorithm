package live02_0119;

public class T13 {
	public static void main(String[] args) {
		/*
		 * 다음은 5x5의 2차원 배열을 나타낸다 각 항목의 숫자 중 3의 배수의 수와 합을 구하는 코드를 작성하시오.
		 * [출력] 6 78
		 */
		int[][] grid = { { 2, 3, 1, 4, 7 }, { 8, 13, 3, 33, 1 }, { 7, 4, 5, 80, 12 }, { 17, 9, 11, 5, 4 },
				{ 4, 5, 91, 27, 7 } };

		int count = 0;
		int sum = 0;
		
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[i].length;j++) {
				if(grid[i][j]%3==0) {
					count++;
					sum+=grid[i][j];
				}
			}
		}
		
		System.out.println(count);
		System.out.println(sum);
	}
}
