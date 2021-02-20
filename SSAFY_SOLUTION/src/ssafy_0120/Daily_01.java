package ssafy_0120;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Daily_01 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);

		int ti = Integer.parseInt(br.readLine());
		int arrSize = Integer.parseInt(br.readLine());
		char[][] arr = new char[arrSize][arrSize];
		int[][] building = new int[arrSize][arrSize];

		// 1. 입력받기
		for (int i = 0; i < arrSize; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int j = 0;
			while (st.hasMoreElements()) {
				arr[i][j] = st.nextToken().charAt(0);
				j++;
			}
		}

		// 2. 찾기
		for (int i = 0; i < arrSize; i++) {
			for (int j = 0; j < arrSize; j++) {
				
				if(i-1>=0) {
					if(((j-1>=0)&&arr[i-1][j-1]=='G')||((j+1<arrSize)&&arr[i-1][j+1]=='G')||arr[i-1][j]=='G') {
						building[i][j]=2;
						continue;
					}
				}
				if(i+1<arrSize) {
					if(((j-1>=0)&&arr[i-1][j-1]=='G')||((j+1<arrSize)&&arr[i-1][j+1]=='G')||arr[i-1][j]=='G') {
						building[i][j]=2;
						continue;
					}
				}
				if(arr[i][j-1]=='G'||arr[i][j+1]=='G')
				
				
				
				
				
				
				// 위쪽에 G
				if(arr[i][j]!='G') {
					if (i - 1 >= 0 && arr[i - 1][j] == 'G') {
						building[i][j] = 2;
						continue;
					}
					// 아래쪽에 G
					if (i + 1 < arrSize && arr[i + 1][j] == 'G') {
						building[i][j] = 2;
						continue;
					}
					// 왼쪽에 G
					if (j - 1 >= 0 && arr[i][j - 1] == 'G') {
						building[i][j] = 2;
						continue;
					}
					// 오른쪽에 G
					if (j + 1 < arrSize && arr[i][j + 1] == 'G') {
						building[i][j] = 2;
						continue;
					}
					// 대각선
					if (i - 1 >= 0 && j - 1 >= 0 && arr[i - 1][j - 1] == 'G') {
						building[i][j] = 2;
						continue;
					}
					if (i - 1 >= 0 && j + 1 < arrSize && arr[i - 1][j + 1] == 'G') {
						building[i][j] = 2;
						continue;
					}
					if (i + 1 < arrSize && j - 1 >= 0 && arr[i + 1][j - 1] == 'G') {
						building[i][j] = 2;
						continue;
					}
					if (i + 1 < arrSize && j + 1 < arrSize && arr[i + 1][j + 1] == 'G') {
						building[i][j] = 2;
						continue;
					}
					int cnt=0;
					for(int k=0;k<arrSize;k++) {
						if(arr[i][k]=='B' && k!=j) {
							cnt++;
						}
						if(arr[k][j]=='B'&&k!=i) {
							cnt++;
						}
					}
					cnt++;
					building[i][j]=cnt;
					cnt=0;
				}
				
				}
				
			
		}
		System.out.println(Arrays.toString(building[0]));
		System.out.println(Arrays.toString(building[1]));
		System.out.println(Arrays.toString(building[2]));
		System.out.println(Arrays.toString(building[3]));
		System.out.println(Arrays.toString(building[4]));
		System.out.println(Arrays.toString(building[5]));
	}
}
