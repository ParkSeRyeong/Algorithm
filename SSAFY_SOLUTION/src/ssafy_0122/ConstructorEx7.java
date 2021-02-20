/*package ssafy_0122;

public class ConstructorEx7 {
	public static void main(String[] args) {
		// 자바의정석, 김자바, 150을 setter로 대입, toString으로 출력
		Book b1 = new Book();
		b1.setTitle("자바의 정석");
		b1.setAuthor("김자바");
		b1.setPage(150);
		// [출력] 자바의정석의 저자는 김자바이고 150페이지로 구성됨
		System.out.println(b1); // or b1.toString
								// toString은 생략됐을 뿐, 기본적으로 자동호출된다!!

		// 내가 Book 클래스에서 오버라이딩한 toString을 주석처리하면,
		// toString이 자동으로 호출되어서, 객체의 주소값을 보여준다.
		// ssafy_0122.Book@2a139a55 이렇게!

		// 생성자에 JSP무조건따라하기, 송JP, 200대입후 getter이용해서 출력
		Book b2 = new Book("JSP 무조건 따라하기", "송JP", 200);
		System.out.println("책이름 : " + b2.getTitle());
		System.out.println("책저자 : " + b2.getAuthor());
		System.out.println("페이지 : " + b2.getPage());
		// [출력]
		// 책이름 : JSP무조건따라하기
		// 책저자 : 송JP
		// 페이지 : 200페이지

	}
}*/