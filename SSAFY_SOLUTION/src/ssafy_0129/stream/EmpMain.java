package ssafy_0129.stream;

import java.util.ArrayList;
import java.util.List;

public class EmpMain {
	public static void main(String[] args) {
		List<Emp> list=new ArrayList<>();
		list.add(new Emp("홍길동", 25, 75.5));
		list.add(new Emp("이순신", 23, 100.5));
		list.add(new Emp("강호동", 24, 85.5));
		
		// 람다를 이용해서 출력하시오
		list.stream().forEach(System.out::println);
	}
}
/*
[출력결과]
홍길동 25 75.5
이순신 23 100.5
강호동 24 85.5
*/

