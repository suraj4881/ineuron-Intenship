package in.bookstore.users;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.bookstore.entity.User;
import in.bookstore.dao.UserDaoImpl;
import in.bookstore.db.DBconnect;

@WebServlet("/register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		String name = request.getParameter("fname");
		String email = request.getParameter("email");
		String phno = request.getParameter("phno");
		String password = request.getParameter("password");
		String check = request.getParameter("check");

		User us = new User();
		us.setName(name);
		us.setEmail(email);
		us.setPhno(phno);
		us.setPassword(password);

		HttpSession session = request.getSession();

		if (check != null) {
			UserDaoImpl ud = new UserDaoImpl(DBconnect.getConn());
			boolean f1 = ud.checkUser(email, phno);
			if (f1) {

				boolean f = ud.userRegister(us);

				if (f) {
					// System.out.println("user registration sucessfull..");
					session.setAttribute("successMsg", "user registration sucessfull..");
					response.sendRedirect("register.jsp");
				} else {
					// System.out.println("user registration failed..");
					session.setAttribute("failedMsg", "user registration failed..");
					response.sendRedirect("register.jsp");
				}

			} else {

				session.setAttribute("failedMsg", "user Already Exist Try New Email Or Phone Number....");
				response.sendRedirect("register.jsp");
			}
		} else {
			// System.out.println("please check Agree & term condition");
			session.setAttribute("failedMsg", "please check Agree & term condition");
			response.sendRedirect("register.jsp");
		}

	}

}
