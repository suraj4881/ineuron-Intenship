package in.bookstore.users;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.bookstore.dao.UserDaoImpl;
import in.bookstore.db.DBconnect;
import in.bookstore.entity.User;


@WebServlet("/update_profile")
public class Update_Profile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id=Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("fname");
		String email=request.getParameter("email");
		String phno=request.getParameter("phno");
		String password=request.getParameter("password");
		
		User us=new User();
		us.setId(id);
		us.setName(name);
		us.setEmail(email);
		us.setPhno(phno);
		
		UserDaoImpl udao= new UserDaoImpl(DBconnect.getConn());
		boolean f=udao.checkPassword(id, password);
		HttpSession session=request.getSession();
		if(f) {
			
			boolean f2=udao.updateProfile(us);
			if(f2) {
				session.setAttribute("successMsg","User Update Successfully....");
				   response.sendRedirect("edit_profile.jsp");
			}else {
				session.setAttribute("failedMsg", "User Update failed..");
				   response.sendRedirect("edit_profile.jsp");
			}
		}
		else {
			session.setAttribute("failedMsg","Your Password Incorrect..");
			   response.sendRedirect("edit_profile.jsp");
		}
	
}
}