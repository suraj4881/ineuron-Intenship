package in.bookstore.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import in.bookstore.entity.Cart;

public class CartDaoImpl implements CartDao {

	
	private Connection conn;
	
	
	public CartDaoImpl(Connection conn) {
		super();
		this.conn = conn;
	}


	@Override
	public boolean addCart(Cart c) {
		
		boolean flag=false;
		String sqlInsertQuery="insert into cart(bid,uid,book_Name,author_name,price,total_price) value(?,?,?,?,?,?)";
		try {
			PreparedStatement ps=conn.prepareStatement(sqlInsertQuery);
			ps.setInt(1,c.getBid());
			ps.setInt(2, c.getUid());
			ps.setString(3, c.getBook_Name());
			ps.setString(4, c.getAuthor_Name());
			ps.setDouble(5, c.getPrice());
			ps.setDouble(6, c.getTotal_price());
			int i=ps.executeUpdate();
			if(i==1) {
				flag=true;
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return flag;
	}


	@Override
	public List<Cart> getByUser(int userid) {
		
		
		List<Cart> list=new ArrayList<Cart>();
		Cart c=null;
		Double totalprice=(double) 0;
		try {
			String sqlSelectQuery="select * from cart where uid=?";
			PreparedStatement ps=conn.prepareStatement(sqlSelectQuery);
			ps.setInt(1,userid);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				c=new Cart();
				c.setCid(rs.getInt(1));
				c.setBid(rs.getInt(2));
				c.setUid(rs.getInt(3));
				c.setBook_Name(rs.getString(4));
				c.setAuthor_Name(rs.getString(5));
				c.setPrice(rs.getDouble(6));
				
				totalprice=totalprice+rs.getDouble(7);
				c.setTotal_price(totalprice);
				
				list.add(c);
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return list;
	}


	@Override
	public boolean deleteBook(int bid,int uid,int cid) {
		boolean flag=false;
		
		
		try {
			
			String sqlSelectQuery="delete from cart where bid=? and uid=? and cid=?";
			PreparedStatement ps=conn.prepareStatement(sqlSelectQuery);
			ps.setInt(1, bid);
			ps.setInt(2, uid);
			ps.setInt(3, cid);
			int i=ps.executeUpdate();
			if(i==1) {
				flag=true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return flag;
	}

}
