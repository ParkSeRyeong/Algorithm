package ssafy_0127.test;

import java.util.ArrayList;
import java.util.Scanner;

public class UserMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String id;
		String pw;

		System.out.print("ID를 입력하시오:");
		id = sc.next();
		System.out.print("PW를 입력하시오:");
		pw = sc.next();

		UserProc up = new UserProc();
		User entity = up.getLoginUser(id, pw);

		BookProc bp = new BookProc();
		ArrayList<Book> list = bp.getList();

		if (entity == null) {
			System.out.println("\nID 또는 PW가 틀리거나 존재하지 않는 ID입니다");

		} else {
			System.out.println("\n" + entity.getName() + "님이 입장하셨습니다");
			System.out.println("현재 포인트는 " + entity.getPoint() + "점입니다.\n");

			for (Book b : list) {
				System.out.println(b);
			}
		}

	}
}
/*
 * [문제1] ID를 입력하시오 : pororo PW를 입력하시오 : 1111
 * 
 * ID 또는 PW가 틀리거나 존재하지 않는 ID입니다 <---틀린경우
 * 
 * 
 * ID를 입력하시오 : pororo PW를 입력하시오 : 1234
 * 
 * 뽀로로님이 입장하셨습니다 <--id / pw맞는경우 현재포인터는 89.97점 입니다
 * ----------------------------------------------- [문제2] ID를 입력하시오 : pororo PW를
 * 입력하시오 : 1234
 * 
 * 뽀로로님이 입장하셨습니다 현재포인터는 89.97점 입니다
 * 
 * 
 * [[BOOk의 정보보기]] 책이름:JAVA 책저자:kim 페이지: 100 책이름:C++ 책저자:lee 페이지: 250 책이름:JSP
 * 책저자:park 페이지: 150
 */