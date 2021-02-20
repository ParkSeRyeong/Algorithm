package ssafy_0122;

import java.util.Scanner;

/*
[문제] 생성자에서 두수를 입력받아 큰수와 작은수를 출력하시오
show()메서드에서 maxValue(), minValue()를 호출할것

클래스명 : Max
-a:int
-b:int
+Max()           <--입력받기
+maxValue():int  <--큰값 리턴(삼항연산자 이용)
+minValue():int  <--작은값 리턴
+show():void     <--출력

[출력]
Input a: 5
Input b: 3

큰수 : 5
작은수: 3
 */
class Max {
	Scanner sc = new Scanner(System.in);
	private int a;
	private int b;

	public Max() {
		System.out.print("Input a : ");
		this.a = sc.nextInt();
		System.out.print("Input b : ");
		this.b = sc.nextInt();
	}

	public int maxValue() {
		return a > b ? a : b;
	}

	public int minValue() {
		return a < b ? a : b;
	}

	public void show() {
		System.out.println("큰 수 : " + maxValue());
		System.out.println("작은 수 : " + minValue());
	}

}

public class ConstructorEx8 {
	public static void main(String[] args) {
		new Max().show();
	}
}
