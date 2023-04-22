package in.bookstore.users;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.bookstore.dao.CartDaoImpl;
import in.bookstore.db.DBconnect;

@WebServlet("/remove")
public class Remove extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int bid=Integer.parseInt(request.getParameter("bid"));
		int uid=Integer.parseInt(request.getParameter("uid"));
		int cid=Integer.parseInt(request.getParameter("cid"));
		CartDaoImpl cdi=new CartDaoImpl(DBconnect.getConn());
		boolean f=cdi.deleteBook(bid,uid,cid);
		HttpSession session=request.getSession();
		
		if(f) {
			
			session.setAttribute("successMsg", "Remove Cart Successfully..");
			response.sendRedirect("checkout.jsp");
		}else {
			
			session.setAttribute("FailedMsg", "Remove Cart Failed..");
			response.sendRedirect("checkout.jsp");
			
		}
		
		
	}

}
