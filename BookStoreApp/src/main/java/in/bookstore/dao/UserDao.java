package in.bookstore.dao;

import in.bookstore.entity.User;

public interface UserDao {

	public boolean userRegister(User us);
	public User login(String email,String password);
	public boolean checkPassword(int id,String ps);
	public boolean updateProfile(User us);
	public boolean checkUser(String email,String phno);
}
