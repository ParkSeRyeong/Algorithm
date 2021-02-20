package ssafy_0122;

public class BookTest {
	public static void main(String[] args) {
		BookManager mgr = new BookManager();

		mgr.add(new Book("21424", "Java Pro", "김하나", "jaen.kr", 15000, "Java 기본 문법"));
		mgr.add(new Book("21425", "Java Pro2", "김하나", "jaen.kr", 25000, "Java 응용"));
		mgr.add(new Book("35355", "분석설계", "소나무", "jaen.kr", 30000, "SW 모델링"));
		mgr.add(new Magazine("45678", "월간 알고리즘", "홍길동", "jaen.kr", 10000, "1월 알고리즘", 2021, 1));
		
		//mgr.remove("35355");
		
		
		System.out.println("******************** 도서 전체 목록 ********************");
		for(Book b:mgr.getList()) {
			System.out.println(b.toString());
		}
		
		System.out.println("******************** 일반 도서 목록 ********************");
		for(Book b:mgr.getBooks()) {
			System.out.println(b.toString());
		}
		
		System.out.println("******************** 잡지 도서 목록 ********************");
		for(Book b:mgr.getMagazines()) {
			System.out.println(b.toString());
		}
		
		System.out.println("******************** 도서 제목 포함 검색 ********************");
		for(Book b:mgr.searchByTitle("Java")) {
			System.out.println(b.toString());
		}
	}
}
