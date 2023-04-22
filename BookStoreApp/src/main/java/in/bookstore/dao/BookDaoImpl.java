package in.bookstore.dao;

import java.sql.Connection;

import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import in.bookstore.entity.BookDetails;

public class BookDaoImpl implements BookDao {

	private Connection conn;
	

	public BookDaoImpl(Connection conn) {
		super();
		this.conn = conn;
	}

	@Override
	public boolean addBooks(BookDetails bd) {
		
		boolean flag=false; 
		String sqlInsertQuery = "insert into book_details(book_name,book_author,book_price,book_category,book_status,book_photo,book_email) value(?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps =conn.prepareStatement(sqlInsertQuery);
			ps.setString(1,bd.getBook_Name());
			ps.setString(2,bd.getBook_Author() );
			ps.setString(3,bd.getBook_Price() );
			ps.setString(4,bd.getBook_Category() );
			ps.setString(5,bd.getBook_Status() );
			ps.setString(6,bd.getBook_Photo() );
			ps.setString(7,bd.getBook_Email() );
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
	public List<BookDetails> getAllBooks() {
		
		List<BookDetails> list= new ArrayList<BookDetails>();
		
		
		
		String sqlSelectQuery="select * from book_details";
		
		
		try {
			PreparedStatement ps = conn.prepareStatement(sqlSelectQuery);
			
			
			ResultSet rs =ps.executeQuery();
			while(rs.next()) 
			{
				BookDetails	bds =new BookDetails("Book_Id","Book_Name","Book_Author","Book_Price","Book_Category","Book_Status","Book_Photo");
				bds.setBook_Id(rs.getInt(1));
				bds.setBook_Name(rs.getString(2));
				bds.setBook_Author(rs.getString(3));
				bds.setBook_Price(rs.getString(4));
				bds.setBook_Category(rs.getString(5));
				bds.setBook_Status(rs.getString(6));
				bds.setBook_Photo(rs.getString(7));
				bds.setBook_Email(rs.getString(8));
				list.add(bds);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return list;
	}

	@Override
	public BookDetails getBookById(int id) {
		

		BookDetails bd=null;
		
		try 
		{
			String sqlSelectQuery="select * from book_details where book_id=?";
			PreparedStatement ps = conn.prepareStatement(sqlSelectQuery);
	         ps.setInt(1, id);
		    ResultSet rs =ps.executeQuery();
		while(rs.next()) 
		{
			bd =new BookDetails("Book_Id","Book_Name","Book_Author","Book_Price","Book_Category","Book_Status","Book_Photo");
			bd.setBook_Id(rs.getInt(1));
			bd.setBook_Name(rs.getString(2));
			bd.setBook_Author(rs.getString(3));
			bd.setBook_Price(rs.getString(4));
			bd.setBook_Category(rs.getString(5));
			bd.setBook_Status(rs.getString(6));
			bd.setBook_Photo(rs.getString(7));
			bd.setBook_Email(rs.getString(8));
			
			
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return bd ;
	}

	@Override
	public boolean updateEditBooks(BookDetails bd) {
		
		boolean flag=false;
		
		try {
			
			String sqlSelectQuery="update book_details set book_name=?,book_author=?,book_price=?,book_status=? where book_id=?";
			PreparedStatement ps = conn.prepareStatement(sqlSelectQuery);
			ps.setString(1,bd.getBook_Name());
			ps.setString(2,bd.getBook_Author() );
			ps.setString(3,bd.getBook_Price() );
			ps.setString(4,bd.getBook_Status() );
			ps.setInt(5, bd.getBook_Id());
			
			int i=ps.executeUpdate();
			if(i==1) {
				flag=true;
			}
		
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		return flag;
	}

	@Override
	public boolean deleteBooks(int id) {
		
		boolean flag=false;
		
try {
			
			String sqlSelectQuery="delete from book_details where book_id=?";
			PreparedStatement ps = conn.prepareStatement(sqlSelectQuery);
			
			ps.setInt(1,id);
			
			int i=ps.executeUpdate();
			
			if(i==1) {
				flag=true;
			}
		
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return flag;
	}

	@Override
	public List<BookDetails> getNewBook() {
		
		List<BookDetails> list=new ArrayList<BookDetails>();
		BookDetails bds=null;
		

		
		try {
			String sqlSelectQuery="select * from book_details where book_category=? and book_status=? order by book_Id DESC";
			PreparedStatement ps = conn.prepareStatement(sqlSelectQuery);
			ps.setString(1, "new");
			ps.setString(2, "Active");
			
			ResultSet rs=ps.executeQuery();
			int i=1;
			while(rs.next() && i<=4){
				bds =new BookDetails("Book_Id","Book_Name","Book_Author","Book_Price","Book_Category","Book_Status","Book_Photo");
				bds.setBook_Id(rs.getInt(1));
				bds.setBook_Name(rs.getString(2));
				bds.setBook_Author(rs.getString(3));
				bds.setBook_Price(rs.getString(4));
				bds.setBook_Category(rs.getString(5));
				bds.setBook_Status(rs.getString(6));
				bds.setBook_Photo(rs.getString(7));
				bds.setBook_Email(rs.getString(8));
				list.add(bds);
				i++;
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return list;
	}

	@Override
	public List<BookDetails> getRecentBook() {
		
		List<BookDetails> list=new ArrayList<BookDetails>();
		BookDetails bd=null;
		

		
		try {
			String sqlSelectQuery="select * from book_details where book_status=? order by book_Id DESC";
			PreparedStatement ps = conn.prepareStatement(sqlSelectQuery);
			
			ps.setString(1, "Active");
			
			ResultSet rs=ps.executeQuery();
			int i=1;
			while(rs.next() && i<=4){
				bd =new BookDetails("Book_Id","Book_Name","Book_Author","Book_Price","Book_Category","Book_Status","Book_Photo");
				bd.setBook_Id(rs.getInt(1));
				bd.setBook_Name(rs.getString(2));
				bd.setBook_Author(rs.getString(3));
				bd.setBook_Price(rs.getString(4));
				bd.setBook_Category(rs.getString(5));
				bd.setBook_Status(rs.getString(6));
				bd.setBook_Photo(rs.getString(7));
				bd.setBook_Email(rs.getString(8));
				list.add(bd);
				i++;
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public List<BookDetails> getOldBook() {

		List<BookDetails> list=new ArrayList<BookDetails>();
		BookDetails bd=null;
		

		
		try {
			String sqlSelectQuery="select * from book_details where book_category=? and book_status=? order by book_Id DESC";
			PreparedStatement ps = conn.prepareStatement(sqlSelectQuery);
			ps.setString(1, "Old");
			ps.setString(2, "Active");
			
			ResultSet rs=ps.executeQuery();
			int i=1;
			while(rs.next() && i<=4){
				bd =new BookDetails("Book_Id","Book_Name","Book_Author","Book_Price","Book_Category","Book_Status","Book_Photo");
				bd.setBook_Id(rs.getInt(1));
				bd.setBook_Name(rs.getString(2));
				bd.setBook_Author(rs.getString(3));
				bd.setBook_Price(rs.getString(4));
				bd.setBook_Category(rs.getString(5));
				bd.setBook_Status(rs.getString(6));
				bd.setBook_Photo(rs.getString(7));
				bd.setBook_Email(rs.getString(8));
				list.add(bd);
				i++;
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public List<BookDetails> getAllRecentBook() {

		List<BookDetails> list=new ArrayList<BookDetails>();
		BookDetails bds=null;
		

		
		try {
			String sqlSelectQuery="select * from book_details where book_status=? order by book_Id DESC";
			PreparedStatement ps = conn.prepareStatement(sqlSelectQuery);
			ps.setString(1, "Active");
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()){
				bds =new BookDetails("Book_Id","Book_Name","Book_Author","Book_Price","Book_Category","Book_Status","Book_Photo");
				bds.setBook_Id(rs.getInt(1));
				bds.setBook_Name(rs.getString(2));
				bds.setBook_Author(rs.getString(3));
				bds.setBook_Price(rs.getString(4));
				bds.setBook_Category(rs.getString(5));
				bds.setBook_Status(rs.getString(6));
				bds.setBook_Photo(rs.getString(7));
				bds.setBook_Email(rs.getString(8));
				list.add(bds);
				
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return list;
	}


	@Override
	public List<BookDetails> getAllNewBook() {

		List<BookDetails> list=new ArrayList<BookDetails>();
		BookDetails bds=null;
		

		
		try {
			String sqlSelectQuery="select * from book_details where book_category=? and book_status=? order by book_Id DESC";
			PreparedStatement ps = conn.prepareStatement(sqlSelectQuery);
			ps.setString(1, "new");
			ps.setString(2, "Active");
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()){
				bds =new BookDetails("Book_Id","Book_Name","Book_Author","Book_Price","Book_Category","Book_Status","Book_Photo");
				bds.setBook_Id(rs.getInt(1));
				bds.setBook_Name(rs.getString(2));
				bds.setBook_Author(rs.getString(3));
				bds.setBook_Price(rs.getString(4));
				bds.setBook_Category(rs.getString(5));
				bds.setBook_Status(rs.getString(6));
				bds.setBook_Photo(rs.getString(7));
				bds.setBook_Email(rs.getString(8));
				list.add(bds);
				
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return list;
	}


	@Override
	public List<BookDetails> getAllOldBook() {
		

		List<BookDetails> list=new ArrayList<BookDetails>();
		BookDetails bds=null;
		

		
		try {
			String sqlSelectQuery="select * from book_details where book_category=? and book_status=? order by book_Id DESC";
			PreparedStatement ps = conn.prepareStatement(sqlSelectQuery);
			ps.setString(1, "Old");
			ps.setString(2, "Active");
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()){
				bds =new BookDetails("Book_Id","Book_Name","Book_Author","Book_Price","Book_Category","Book_Status","Book_Photo");
				bds.setBook_Id(rs.getInt(1));
				bds.setBook_Name(rs.getString(2));
				bds.setBook_Author(rs.getString(3));
				bds.setBook_Price(rs.getString(4));
				bds.setBook_Category(rs.getString(5));
				bds.setBook_Status(rs.getString(6));
				bds.setBook_Photo(rs.getString(7));
				bds.setBook_Email(rs.getString(8));
				list.add(bds);
				
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return list;
	}

	@Override
	public List<BookDetails> getBookByOld(String email, String cate) {
		
		List<BookDetails> list=new ArrayList<BookDetails>();
		BookDetails bds=null;
		
		
		try {
			String sqlSelectQuery="select * from book_details where book_category=? and book_email=?  ";
			PreparedStatement ps = conn.prepareStatement(sqlSelectQuery);
			ps.setString(1, cate);
			ps.setString(2, email);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				bds=new BookDetails("Book_Id","Book_Name","Book_Author","Book_Price","Book_Category","Book_Status","Book_Photo");
				bds =new BookDetails("Book_Id","Book_Name","Book_Author","Book_Price","Book_Category","Book_Status","Book_Photo");
				bds.setBook_Id(rs.getInt(1));
				bds.setBook_Name(rs.getString(2));
				bds.setBook_Author(rs.getString(3));
				bds.setBook_Price(rs.getString(4));
				bds.setBook_Category(rs.getString(5));
				bds.setBook_Status(rs.getString(6));
				bds.setBook_Photo(rs.getString(7));
				bds.setBook_Email(rs.getString(8));
				list.add(bds);
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public boolean OldBookDelete(String email, String cate,int id) {
		
		boolean flag=false;
		
		
		try {
			String sqlSelectQuery="delete from book_details where book_category=? and book_email=? and book_id=?  ";
		    PreparedStatement ps = conn.prepareStatement(sqlSelectQuery);
		    ps.setString(1, cate);
			ps.setString(2, email);
			ps.setInt(3, id);
			
			
            int i=ps.executeUpdate();
			
			if(i==1) 
			{
				
				flag=true;
			}
			
		    
		    
		    
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return flag;
	}

	@Override
	public List<BookDetails> getBookBySearch(String ch) {
		List<BookDetails> list=new ArrayList<BookDetails>();
		BookDetails bds=null;
		
		
		try {
			String sqlSelectQuery="select * from book_details where book_name like ? or book_author like ? or book_category like ? and book_status=? ";
			PreparedStatement ps = conn.prepareStatement(sqlSelectQuery);
			ps.setString(1, "%"+ch+"%");
			ps.setString(2, "%"+ch+"%");
			ps.setString(3, "%"+ch+"%");
			ps.setString(4, "Active");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				bds=new BookDetails("Book_Id","Book_Name","Book_Author","Book_Price","Book_Category","Book_Status","Book_Photo");
				bds =new BookDetails("Book_Id","Book_Name","Book_Author","Book_Price","Book_Category","Book_Status","Book_Photo");
				bds.setBook_Id(rs.getInt(1));
				bds.setBook_Name(rs.getString(2));
				bds.setBook_Author(rs.getString(3));
				bds.setBook_Price(rs.getString(4));
				bds.setBook_Category(rs.getString(5));
				bds.setBook_Status(rs.getString(6));
				bds.setBook_Photo(rs.getString(7));
				bds.setBook_Email(rs.getString(8));
				list.add(bds);
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	
	
}