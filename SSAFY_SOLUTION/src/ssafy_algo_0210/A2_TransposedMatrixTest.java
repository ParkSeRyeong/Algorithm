package ssafy_algo_0210;

import java.util.Arrays;

public class A2_TransposedMatrixTest {
	private static int[][] arr = {
			{1,2,3},
			{4,5,6},
			{7,8,9}
	};
	
	public static void transpose() {
		final int N= arr.length;
		for(int i=0; i<N; ++i) {
			for(int j=i+1; j<N; ++j) {
				swap(i,j);
			}
		}
	}
	
	private static void swap(int i, int j) {
		int temp = arr[i][j];
		arr[i][j] = arr[j][i];
		arr[j][i] = temp;
	}
	
	public static void print() {
		for(int[] subArr: arr) {
			System.out.println(Arrays.toString(subArr));
		}
	}
	
	public static void main(String[] args) {
		print();
		System.out.println("===========");
		transpose();
		print();
		System.out.println("===========");
		transpose();
		print();
	}
}











