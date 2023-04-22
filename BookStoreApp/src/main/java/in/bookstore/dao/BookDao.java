package in.bookstore.dao;

import java.util.List;

import in.bookstore.entity.BookDetails;

public interface BookDao {

	public boolean addBooks(BookDetails bd);
	public List<BookDetails> getAllBooks();
	public BookDetails getBookById(int id);
	public boolean updateEditBooks(BookDetails bd);
	public boolean deleteBooks(int id);
	public List<BookDetails> getNewBook();
	public List<BookDetails> getRecentBook();
	public List<BookDetails> getOldBook();
	public List<BookDetails> getAllRecentBook();
	public List<BookDetails> getAllNewBook();
	public List<BookDetails> getAllOldBook();
	public List<BookDetails> getBookByOld(String email,String cate);
	public boolean OldBookDelete(String email,String cate,int id);
	public List<BookDetails> getBookBySearch(String ch);
}
