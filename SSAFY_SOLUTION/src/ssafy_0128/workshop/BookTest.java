package ssafy_0128.workshop;

public class BookTest {
	public static void main(String[] args){
		BookManagerImpl mgr = new BookManagerImpl();

		mgr.add(new Book("21424", "Java Pro", "김하나", "jaen.kr", 15000, "Java 기본 문법", 10));
		mgr.add(new Book("21425", "Java Pro2", "김하나", "jaen.kr", 25000, "Java 응용", 15));
		mgr.add(new Book("35355", "분석설계", "소나무", "jaen.kr", 30000, "SW 모델링", 7));
		mgr.add(new Magazine("45678", "월간 알고리즘", "홍길동", "jaen.kr", 10000, "1월 알고리즘", 20, 2021, 1));
		
		//mgr.remove("35355");
		
//		
//		System.out.println("******************** 도서 전체 목록 ********************");
//		for(Book b:mgr.getList()) {
//			System.out.println(b.toString());
//		}
//		
//		System.out.println("******************** 일반 도서 목록 ********************");
//		for(Book b:mgr.getBooks()) {
//			System.out.println(b.toString());
//		}
//		
//		System.out.println("******************** 잡지 도서 목록 ********************");
//		for(Book b:mgr.getMagazines()) {
//			System.out.println(b.toString());
//		}
//		
//		System.out.println("******************** 도서 제목 포함 검색 ********************");
//		for(Book b:mgr.searchByTitle("Java")) {
//			System.out.println(b.toString());
//		}
		
		try {
			mgr.sell("21424", 15);
		} catch (ISBNNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (QuantityException e) {
			System.out.println(e.getMessage());
		}
		//mgr.buy("21424", 5);
	}
}
