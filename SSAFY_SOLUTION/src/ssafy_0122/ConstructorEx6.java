package ssafy_0122;

import java.util.Scanner;

/*  
클래스명 : ConstructorEx6
x:int
y:int

+ConstructorEx6()             -- 입력받기(Scanner 이용)
							-- 가로/세로를 입력받기
+calc():int                   -- x * y 를 리턴
+display():void              -- 출력하기
*/
public class ConstructorEx6 {
	Scanner sc = new Scanner(System.in);
	public int x;
	public int y;

	public ConstructorEx6() {
		System.out.print("가로 입력 : ");
		this.x = sc.nextInt();
		System.out.println("세로 입력 : ");
		this.y = sc.nextInt();
	}

	public int calc() {
		return x * y;
	}

	public void display() {
		System.out.println("사각형의 넓이 : " + calc());
	}

	public static void main(String[] args) {

//		ConstructorEx6 ob = new ConstructorEx6();
//		ob.display();
	}
}
/*
 * [문제] 사각형의 넓이
 * 
 * 가로를 입력 : 5 세로를 입력 : 4
 * 
 * 사각형의 넓이 : 20
 */