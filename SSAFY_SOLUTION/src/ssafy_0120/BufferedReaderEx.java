package ssafy_0120;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BufferedReaderEx {
	public static void main(String[] args) throws NumberFormatException, IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);

		String name;
		int age;
		float tall;
		double weight;
		char gender;

		// 1. 문자열을 받고 싶어요!
		System.out.println("이름 : ");
		name = br.readLine();
		System.out.println("나이 : ");
		age = Integer.parseInt(br.readLine());
		System.out.println("키 : ");
		tall = Float.parseFloat(br.readLine());
		System.out.println("체중 : ");
		weight = Double.parseDouble(br.readLine());
		System.out.println("성별 : ");
		gender = br.readLine().charAt(0);

		System.out.printf("%-10s\t%d\t%.2f\t%.1f\t%-10s", name, age, tall, weight, gender);
	}
}
