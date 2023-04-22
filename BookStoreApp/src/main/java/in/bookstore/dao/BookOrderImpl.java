package in.bookstore.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.bookstore.entity.Book_Order;

public class BookOrderImpl implements book_Order {

	private Connection conn;

	public BookOrderImpl(Connection conn) {
		super();
		this.conn = conn;
	}

	
	@Override
	public boolean saveOrder(List<Book_Order> blist) {
		boolean flag=false;
		try 
		{
			String sqlInsertQuery="insert into book_order(order_Id,username,email,address,phno,book_name,author,price,payment) value(?,?,?,?,?,?,?,?,?) ";
			conn.setAutoCommit(false);
			PreparedStatement ps = conn.prepareStatement(sqlInsertQuery);
		    for(Book_Order bo :blist){
		    	
		    	ps.setString(1, bo.getOrderid());
		    	ps.setString(2, bo.getUsername());
		    	ps.setString(3, bo.getEmail());
		    	ps.setString(4, bo.getFulladd());
		    	ps.setString(5, bo.getPhno());
		    	ps.setString(6, bo.getBookname());
		    	ps.setString(7, bo.getAuthor());
		    	ps.setString(8, bo.getPrice());
		    	ps.setString(9, bo.getPaymentType());
		    	ps.addBatch();
		    }
		     int[] count=ps.executeBatch();
		     conn.commit();
		     flag=true;
		     conn.setAutoCommit(true);
		     
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return flag;
	}


	@Override
	public List<Book_Order> getBook(String email) {
		
		List<Book_Order> list=new ArrayList<Book_Order>();
		Book_Order o=null;
		try 
		{
			String sqlSelectQuery="select * from book_order where email=? ";
			PreparedStatement ps = conn.prepareStatement(sqlSelectQuery);
			ps.setString(1, email);
		    ResultSet rs=ps.executeQuery();
		    while(rs.next()) {
		    	o=new Book_Order();
		    	o.setId(rs.getInt(1));
		    	o.setOrderid(rs.getString(2));
		    	o.setUsername(rs.getString(3));
		    	o.setEmail(rs.getString(4));
		    	o.setFulladd(rs.getString(5));
		    	o.setPhno(rs.getString(6));
		    	o.setBookname(rs.getString(7));
		    	o.setAuthor(rs.getString(8));
		    	o.setPrice(rs.getString(9));
		    	o.setPaymentType(rs.getString(10));
		    	list.add(o);
		    	
		    }
		     
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}


	@Override
	public List<Book_Order> getBookAll() {
		List<Book_Order> list=new ArrayList<Book_Order>();
		Book_Order o=null;
		try 
		{
			String sqlSelectQuery="select * from book_order";
			PreparedStatement ps = conn.prepareStatement(sqlSelectQuery);
			
		    ResultSet rs=ps.executeQuery();
		    while(rs.next()) {
		    	o=new Book_Order();
		    	o.setId(rs.getInt(1));
		    	o.setOrderid(rs.getString(2));
		    	o.setUsername(rs.getString(3));
		    	o.setEmail(rs.getString(4));
		    	o.setFulladd(rs.getString(5));
		    	o.setPhno(rs.getString(6));
		    	o.setBookname(rs.getString(7));
		    	o.setAuthor(rs.getString(8));
		    	o.setPrice(rs.getString(9));
		    	o.setPaymentType(rs.getString(10));
		    	list.add(o);
		    	
		    }
		     
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
}
