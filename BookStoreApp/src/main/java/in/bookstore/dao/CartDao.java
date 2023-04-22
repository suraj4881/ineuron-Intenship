package in.bookstore.dao;


import java.util.List;

import in.bookstore.entity.Cart;

public interface CartDao {

	public boolean addCart(Cart c);
	public List<Cart> getByUser(int userid);
	public boolean deleteBook(int bid,int uid,int cid);
	
}
