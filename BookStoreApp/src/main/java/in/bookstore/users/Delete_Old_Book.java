package in.bookstore.users;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.bookstore.dao.BookDaoImpl;
import in.bookstore.db.DBconnect;


@WebServlet("/delete_old_book")
public class Delete_Old_Book extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email=request.getParameter("email");
		int id=Integer.parseInt(request.getParameter("id"));
		BookDaoImpl bdao=new BookDaoImpl(DBconnect.getConn());
		boolean f=bdao.OldBookDelete(email, "Old",id);
        HttpSession session=request.getSession();
		
		if(f) {
			
			session.setAttribute("successMsg", "Old Book Delete Successfully..");
			response.sendRedirect("old_book.jsp");
		}
		
		
		else {
			
			session.setAttribute("FailedMsg", "Old Book Delete Failed..");
			response.sendRedirect("old_book.jsp");
			
		}
		
		
	}

}
