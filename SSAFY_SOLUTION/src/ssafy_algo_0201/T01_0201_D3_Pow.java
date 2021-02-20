package ssafy_algo_0201;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class T01_0201_D3_Pow {
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("C:\\SSAFY\\javawork\\세령_연습용프로젝트\\src\\collection01\\input.txt"));
		Scanner sc = new Scanner(System.in);

		int[] result = new int[10];
		

		for (int i = 0; i < 10; i++) {
			int tc=sc.nextInt();
			int n = sc.nextInt();
			int m = sc.nextInt();
			
			result[i] = (int) Math.pow(n, m);
			System.out.println("#" + tc + " " + result[i]);
		}
	}
}
