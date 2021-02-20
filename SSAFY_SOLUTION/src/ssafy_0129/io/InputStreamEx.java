package ssafy_0129.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputStreamEx {
	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(isr);
		
		System.out.print("Input String : ");
		String str=br.readLine();		// 속도 향상!	
		System.out.println(str);
		
		isr.close();
		br.close();
		
	//--------------------------------------------------------------------------
/*		InputStreamReader isr = new InputStreamReader(System.in);
		System.out.print("Input String : ");
		
		char ch = '\0';
		while (ch != '\n') {
			ch = (char) isr.read();		// 캐릭터스트림(InputStreamREader), 한글 처리 o
			System.out.print(ch);		// 한글자씩 이라서 반복문으로 해결해야함.
		}*/
		
	//--------------------------------------------------------------------------
		/*
		 * System.out.print("Input String : "); char ch='\0'; while(ch!='\n') {
		 * ch=(char)System.in.read(); System.out.print(ch); }
		 */
	}
}
