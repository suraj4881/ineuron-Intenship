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

@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserDaoImpl ud=new UserDaoImpl(DBconnect.getConn());
		
		HttpSession session=request.getSession();
		
		
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String check=request.getParameter("check");
		
		
    if(check!=null) 
       {
		   if("admin@gmail.com".equals(email)&& "admin".equals(password))
		  {
			User us=new User();
			us.setName("Admin");
			session.setAttribute("userobj", us);
			response.sendRedirect("Admin/home.jsp");
			
		   }
		  else 
		   {
			User us=ud.login(email, password);
			
			if(us!=null) 
			 {
				session.setAttribute("userobj", us);
				response.sendRedirect("index.jsp");
			 }
			else 
			 {
				session.setAttribute("failedMsg", "Email & Password Invalid");
				response.sendRedirect("login.jsp");
			 }
		    }
	
	}
    else {
		//System.out.println("please check Agree & term condition");
		 session.setAttribute("failedMsg", "please check Agree & term condition");
		 response.sendRedirect("login.jsp");
	}
}
}
