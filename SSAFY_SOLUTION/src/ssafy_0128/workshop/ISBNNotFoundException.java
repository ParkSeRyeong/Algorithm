package ssafy_0128.workshop;

public class ISBNNotFoundException extends Exception{

	private static final long serialVersionUID = 1L;
	private String isbn;
	
	public ISBNNotFoundException(String isbn) {
		super(isbn+ "은 존재하지 않는 ISBN입니다.");
		this.isbn=isbn;
	}	
	
}
