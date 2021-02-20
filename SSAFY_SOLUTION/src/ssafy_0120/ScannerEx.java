package ssafy_0120;

import java.util.Scanner;

/*
 * [입력]
 * 1. Scanner
 * 		- 스캐너 자체에서 예외처리 다 됨.
 * 2. BufferedReader
 * 		- 예외처리 안 됨.
*/

public class ScannerEx {
	@SuppressWarnings("unused")
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String name;
		int age;
		float tall;
		double weight;
		char gender;

		//1. 문자열을 받고 싶어요!
		System.out.println("이름 : "); name=sc.next();
		System.out.println("나이 : "); age=sc.nextInt();
		System.out.println("키 : "); tall=sc.nextFloat();
		System.out.println("체중 : "); weight=sc.nextDouble();
		System.out.println("성별 : "); gender=sc.next().charAt(0);
		
		System.out.printf("%-10s\t%d\t%.2f\t%.1f\t%-10s", name, age, tall, weight, gender);
		
		
		sc.close();
	}
}
