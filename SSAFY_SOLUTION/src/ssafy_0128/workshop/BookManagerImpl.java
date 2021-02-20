package ssafy_0128.workshop;

import java.util.ArrayList;
import java.util.Iterator;

public class BookManagerImpl implements IBookManager {
	private static BookManagerImpl instance;
	public static ArrayList<Book> books = new ArrayList<>();

	/** 싱글톤 패턴 적용 */
	public static BookManagerImpl getInstance() {
		if (instance == null) {
			instance = new BookManagerImpl();
		}
		return instance;
	}

	public ArrayList<Book> tmp = new ArrayList<>();

	/** 책 추가 */
	public void add(Book book) {
		books.add(book);
	}

	/** 책 리스트 불러오기 */
	public ArrayList<Book> getList() {
		tmp.clear();
		if (books == null) {
			return null;
		}
		tmp.addAll(books);
		return tmp;
	}

	/** 책 제거 */
	public void remove(String isbn) {
		tmp.clear();

		Iterator<Book> iter = books.iterator();
		while (iter.hasNext()) {
			Book b = iter.next();
			if (b.getIsbn().equals(isbn)) {
				iter.remove();
				return;
			}
		}
		System.out.println("제거할 대상의 상품이 존재하지 않습니다.");
	}

	@Override
	public Book searchByIsbn(String isbn) {
		Iterator<Book> iter = books.iterator();
		while (iter.hasNext()) {
			Book b = iter.next();
			if (b.getIsbn().equals(isbn)) {
				return b;
			}
		}
		return null;
	}

	@Override
	public ArrayList<Book> searchByTitle(String title) {
		tmp.clear();
		Iterator<Book> iter = books.iterator();
		while (iter.hasNext()) {
			Book b = iter.next();
			if (b.getTitle().equals(title)) {
				tmp.add(b);
			}
		}
		return tmp;
	}

	@Override
	/** 여기 상속 문제 해결하기. instanceof 때문에 제대로 안 될 듯 */
	public ArrayList<Book> getBooks() {
		tmp.clear();
		Iterator<Book> iter = books.iterator();
		while (iter.hasNext()) {
			Book b = iter.next();
			if (b instanceof Book) {
				tmp.add(b);
			}
		}
		return tmp;
	}

	@Override
	public ArrayList<Magazine> getMagazines() {
		ArrayList<Magazine> temp = new ArrayList<>();
		Iterator<Book> iter = books.iterator();
		while (iter.hasNext()) {
			Magazine b = (Magazine) iter.next();
			// 이렇게 하면 무조건 Magazine형 아냐..? 테스트하기
			if (b instanceof Magazine) {
				temp.add(b);
			}
		}
		return temp;
	}

	@Override
	public int getTotalPrice() {
		int sum = 0;
		for (Book b : books) {
			sum += b.getPrice();
		}
		return sum;
	}

	@Override
	public double getPriceAvg() {
		return getTotalPrice() / books.size();
	}

	@Override
	public void sell(String isbn, int quantity) throws ISBNNotFoundException, QuantityException {
		Book b = searchByIsbn(isbn);
		if (b == null) {
			throw new ISBNNotFoundException(isbn);
		}
		int res = b.getQuantity() - quantity;
		if (res < 0) {
			throw new QuantityException(b.getQuantity());
		}

		System.out.println("판매 완료! " + b.getTitle() + " 재고 : " + b.getQuantity() + " -> " + res);
		b.setQuantity(res);

	}

	@Override
	public void buy(String isbn, int quantity) throws QuantityException {
		Book b = searchByIsbn(isbn);

		int res = b.getQuantity() - quantity;
		if (res < 0) {
			throw new QuantityException(b.getQuantity());
		}
		System.out.println("구매 완료! " + b.getTitle() + " " + quantity + "개 구매");
		b.setQuantity(res);
	}

}
