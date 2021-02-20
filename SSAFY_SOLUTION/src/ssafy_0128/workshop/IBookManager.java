package ssafy_0128.workshop;

import java.util.ArrayList;

public interface IBookManager {
	public void add(Book book);
	public void remove(String isbn);
	public ArrayList<Book> getList();
	public Book searchByIsbn(String isbn);
	public ArrayList<Book> searchByTitle(String title);
	public ArrayList<Book> getBooks();
	public ArrayList<Magazine> getMagazines();
	public int getTotalPrice();
	public double getPriceAvg();
	public void sell(String isbn, int quantity) throws ISBNNotFoundException, QuantityException;
	public void buy(String isbn, int quantity) throws QuantityException;
}
