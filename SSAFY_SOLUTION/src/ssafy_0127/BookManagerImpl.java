package ssafy_0127;

import java.util.Arrays;

public class BookManagerImpl implements IBookManager{
	private static BookManagerImpl instance;
	public static Book[] books = new Book [10];
	public int size = 0;

	/** 싱글톤 패턴 적용*/
	public static BookManagerImpl getInstance() {
		if (instance == null) {
			instance = new BookManagerImpl();
		}
		return instance;
	}

	/** 책 추가*/
	public void add(Book book) {
		books[size] = book;
		size++;
	}

	/**책 제거*/
	public void remove(String isbn) {
		for (int i = 0; i < size; i++) {
			if (books[i].getIsbn().equals(isbn)) {
				Book[] tmp = Arrays.copyOfRange(books, i + 1, size);
				System.arraycopy(tmp, 0, books, i, tmp.length);
				books[size] = null;
				size--;
				return;
			}
		}
	}

	/** 책 리스트 불러오기*/
	public Book[] getList() {

		return Arrays.copyOfRange(books, 0, size);
	}

	/** ISBN으로 검색*/
	public Book searchByIsbn(String isbn) {
		for (int i=0;i<size;i++) {
			if (books[i].isbn.equals(isbn)) {
				return books[i];
			}
		}
		return null;
	}

	/** 도서제목을 포함검색하여 도서리스트를 반환*/
	public Book[] searchByTitle(String title) {
		Book[] tmp = new Book[size];
		int findCnt = 0;
		
		for (int i = 0; i < size; i++) {
			if (books[i].getTitle().contains(title)) {
				tmp[findCnt] = books[i];
				findCnt++;
			}
		}
		if (findCnt == 0) {
			return null;
		}
		return Arrays.copyOfRange(tmp, 0, findCnt);
	}

	// 5. 잡지가 아닌 일반도서 리스트를 반환
	public Book[] getBooks() {
		Book[] tmp = new Book[size];
		int tmpCnt = 0;
		for (int i = 0; i < size; i++) {
			if (books[i] instanceof Magazine) {
				continue;
			}
			tmp[tmpCnt] = books[i];
			tmpCnt++;
		}
		return Arrays.copyOfRange(tmp, 0, tmpCnt);
	}

	// 6. 잡지 리스트를 반환
	public Magazine[] getMagazines() {
		Magazine[] tmp = new Magazine[size];
		int tmpCnt = 0;
		for (int i = 0; i < size; i++) {
			if (books[i] instanceof Magazine) {
				tmp[tmpCnt] = (Magazine) books[i];
				tmpCnt++;
				continue;
			}
		}
		return Arrays.copyOfRange(tmp, 0, tmpCnt);
	}

	// 7. 도서 리스트의 가격의 총합을 반환
	public int getTotalPrice() {
		int sum = 0;
		for (Book b : books) {
			sum += b.getPrice();
		}
		return sum;
	}

	public double getPriceAvg() {
		int Avg = 0;
		return (double) getTotalPrice() / size;
	}

}
