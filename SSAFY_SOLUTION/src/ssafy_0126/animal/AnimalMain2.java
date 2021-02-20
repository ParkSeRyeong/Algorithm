package ssafy_0126.animal;

import java.util.Scanner;

//동적바인딩(Dynamic Binding): 실행시점 (run time)에 호출 메서드를 결정한다.
//코딩량을 상당부분 줄일수 있다.
public class AnimalMain2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		Animal ani = null;	// 부모클래스로 만든 참조변수
		
		while (true) {
			System.out.println("1. Dog 2. Cat 3. Duck 4. Fish 5. Exit\nSelect : ");
			n = sc.nextInt();

			switch (n) {
			case 1:
				ani = new Dog();
				break;
			case 2:
				ani = new Cat();
				break;
			case 3:
				ani = new Duck();
				break;
			case 4:
				ani = new Fish();
				break;
			default:
				System.out.println("작업을 종료합니다");
				sc.close();
				System.exit(0);
			}
			ani.speak();	// 실행을 해서 입력을 받기 전까지 어떤 객체인지 모른다..!
			ani.walk();		// 이것이 바로 동적 바인딩
		}
	}
}
