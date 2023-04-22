package in.bookstore.dao;

import java.util.List;

import in.bookstore.entity.Book_Order;

public interface book_Order {

	
	public boolean saveOrder(List<Book_Order> blist);
	
	public List<Book_Order> getBook(String email);
	public List<Book_Order> getBookAll();
}
