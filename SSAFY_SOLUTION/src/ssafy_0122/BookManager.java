package ssafy_0122;

import java.util.ArrayList;
import java.util.Arrays;

public class BookManager {
	private static BookManager manager;
	public static Book[] books = new Book[15];
	public int index = 0;

	public static BookManager getInstance() {
		if (manager == null) {
			manager = new BookManager();
		}
		return manager;
	}

	public void add(Book book) {
		books[index] = book;
		index++;
	}

	public void remove(String isbn) {
		for (int i = 0; i < index; i++) {
			if (books[i].getIsbn().equals(isbn)) {
				Book[] tmp = Arrays.copyOfRange(books, i + 1, index);
				System.arraycopy(tmp, 0, books, i, tmp.length);
				books[index] = null;
				index--;
				return;
			}
		}
	}

	public Book[] getList() {

		return Arrays.copyOfRange(books, 0, index);
	}

	// isbn으로 검색
	public String searchByIsbn(String isbn) {
		for (Book e : books) {
			if (e.isbn.equals(isbn)) {
				return e.title;
			}
		}
		return "해당하는 책이 없습니다.";
	}

	// 4. 도서제목을 포함검색하여 도서리스트를 반환
	public Book[] searchByTitle(String title) {
		Book[] tmp = new Book[index];
		int findCnt = 0;
		
		for (int i = 0; i < index; i++) {
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
		Book[] tmp = new Book[index];
		int tmpCnt = 0;
		for (int i = 0; i < index; i++) {
			if (books[i] instanceof Magazine) {
				continue;
			}
			tmp[tmpCnt] = books[i];
			tmpCnt++;
		}
		return Arrays.copyOfRange(tmp, 0, tmpCnt);
	}

	// 6. 잡지 리스트를 반환
	public Book[] getMagazines() {
		Book[] tmp = new Book[index];
		int tmpCnt = 0;
		for (int i = 0; i < index; i++) {
			if (books[i] instanceof Magazine) {
				tmp[tmpCnt] = books[i];
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
		return (double) getTotalPrice() / index;
	}

}
