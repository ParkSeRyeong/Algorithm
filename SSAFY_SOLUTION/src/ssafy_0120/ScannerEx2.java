package ssafy_0120;

import java.util.Scanner;

public class ScannerEx2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		sc.nextLine();
		
		int[] sum = new int[count];

		for (int i = 0; i < count; i++) {
			String[] input = sc.nextLine().split(" ");
			for (int j = 0; j < input.length; j++) {
				sum[i] += Integer.parseInt(input[j]);
			}
		}
		for(int i=0;i<count;i++) {
			System.out.println("#"+(i+1)+" "+sum[i]);
		}
		sc.close();
	}

}
