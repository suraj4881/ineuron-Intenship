package in.bookstore.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.bookstore.db.DBconnect;
import in.bookstore.dao.BookDaoImpl;

@WebServlet("/delete")
public class BooksDeletes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id=Integer.parseInt(request.getParameter("id"));
		
		BookDaoImpl dao=new BookDaoImpl(DBconnect.getConn());
		boolean f=dao.deleteBooks(id);
		
        HttpSession session = request.getSession();
		
		if(f) {
			
			session.setAttribute("successMsg", "Book Delete Successfully...");
			response.sendRedirect("Admin/all_books.jsp");
		} 
		
		else {
			session.setAttribute("failedMsg", "Book Delete Failed...");
			response.sendRedirect("Admin/all_books.jsp");

		}
		
		
	}

	

}
