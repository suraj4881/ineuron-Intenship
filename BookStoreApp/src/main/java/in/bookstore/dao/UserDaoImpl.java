package in.bookstore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import in.bookstore.entity.User;

public class UserDaoImpl implements UserDao {
	
	private Connection conn;

	public UserDaoImpl(Connection conn) {
		super();
		this.conn = conn;
	}

	@Override
	public boolean userRegister(User us) {
		boolean flag=false;
		
		String sqlInsertQuery="insert into user(name,email,phno,password) value(?,?,?,?) ";
		try {
			PreparedStatement ps =conn.prepareStatement(sqlInsertQuery);
			ps.setString(1, us.getName());
			ps.setString(2, us.getEmail());
			ps.setString(3, us.getPhno());
			ps.setString(4, us.getPassword());
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
	public User login(String email, String password) {
		
		User us=null;
		
		String sqlSelectQuery="select * from user where email=? and password=? ";
		try {
			
			PreparedStatement ps =conn.prepareStatement(sqlSelectQuery);
			ps.setString(1, email);
			ps.setString(2, password);
			
			ResultSet rs =ps.executeQuery();
			while(rs.next()) {
				us=new User();
				us.setId(rs.getInt(1));
				us.setName(rs.getString(2));
				us.setEmail(rs.getString(3));
				us.setPassword(rs.getString(4));
				us.setPhno(rs.getString(5));
				us.setAddress(rs.getString(6));
				us.setLandmark(rs.getString(7));
				us.setCity(rs.getString(8));
				us.setState(rs.getString(9));
				us.setPincode(rs.getString(10));
				
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return us;
	}

	@Override
	public boolean checkPassword(int id,String ps) {
		boolean flag=false;
		try {
		String sqlSelectQuery="select * from user where id=? and password=? ";
		PreparedStatement ps1 =conn.prepareStatement(sqlSelectQuery);
		ps1.setInt(1,id);
		ps1.setString(2, ps);
		ResultSet rs =ps1.executeQuery();
		while(rs.next()) {
			flag=true;
		}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return flag;
	}

	@Override
	public boolean updateProfile(User us) {
		
        boolean flag=false;
		
		
		try {
			String sqlInsertQuery="update user set name=?,email=?,phno=? where id=? ";
			PreparedStatement ps =conn.prepareStatement(sqlInsertQuery);
			ps.setString(1, us.getName());
			ps.setString(2, us.getEmail());
			ps.setString(3, us.getPhno());
			ps.setInt(4,us.getId());
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
	public boolean checkUser(String email, String phno) {
		boolean flag=true;
		
		try {
			String sqlSelectQuery="select * from user where email=? or phno=? ";
			PreparedStatement ps =conn.prepareStatement(sqlSelectQuery);
			ps.setString(1, email);
			ps.setString(2, phno);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				flag=false;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return flag;
	}



}
