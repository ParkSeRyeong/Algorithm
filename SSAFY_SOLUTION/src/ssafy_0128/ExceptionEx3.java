package ssafy_0128;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 클래스명 : ExceptionEx3
 * 
 *  str:String
 *  
 *  +ExceptionEx3()            --> input() 호출
 *  +input():void              --> BufferedReader로 입력받기
 *  +output():void              --> 출력하기
 *  
 *  [출력화면]
 *  문자열을 입력하시오 : abcd
 *  결과 : abcd
 *  
 *  Checked Exception : 강제로 예외처리 수행
*/
public class ExceptionEx3 {
	String str;

	public ExceptionEx3() //throws IOException 
	{
		input();
	}

	public void input() //throws IOException 
	{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("문자열을 입력하시오 : ");
		try {
			str = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void output() 
	{
		System.out.println("결과 : " + str);
	}

	public static void main(String[] args) //throws IOException 
	{
		new ExceptionEx3().output();
	}
}
