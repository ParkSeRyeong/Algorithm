package ssafy_0129;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BufferedReaderEx {
	public static void main(String[] args) throws IOException {
//		InputStreamReader isr=new InputStreamReader(System.in);
//		BufferedReader br=new BufferedReader(isr);
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		String name;
		int age;
		float tall;
		double weight;
		char gender;
		
		System.out.print("이름:"); name=br.readLine();
		System.out.print("나이:"); age=Integer.parseInt(br.readLine());    //"25" --> 25
		System.out.print("신장:"); tall=Float.parseFloat(br.readLine());
		System.out.print("체중:"); weight=Double.parseDouble(br.readLine());
		System.out.print("성별:"); gender=br.readLine().charAt(0);
		
		System.out.println("나의 이름은 "+name+"입니다");
		System.out.println("나의 나이는 "+age+"입니다");
		System.out.println("나의 신장은 "+tall+"입니다");
		System.out.println("나의 체중은 "+weight+"입니다");
		System.out.println("나의 성별은 "+gender+"입니다");
		
	}
}












