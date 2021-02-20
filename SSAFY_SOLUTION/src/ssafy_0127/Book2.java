package ssafy_0127;

public class Book2 {
	private String title;
	private String author;
	private int page;

	public Book2() {
		super();
	}

	public Book2(String title, String author, int page) {
		super();
		this.title = title;
		this.author = author;
		this.page = page;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	@Override
	public String toString() {
		return "책 이름 : "+title + "\t책 저자 : " + author + "\t페이지 : " + page;
	}

}
