package in.bookstore.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.bookstore.dao.BookDaoImpl;
import in.bookstore.db.DBconnect;
import in.bookstore.entity.BookDetails;

@WebServlet("/edit_books")
public class Edit_Books extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int book_id=Integer.parseInt(request.getParameter("id"));
		String book_Name = request.getParameter("bname");
		String book_Author = request.getParameter("author");
		String book_Price = request.getParameter("price");
		String book_Category = request.getParameter("category");
		String book_Status = request.getParameter("bstatus");
		
		
		BookDetails bds= new BookDetails(book_Name, book_Author, book_Price, null,book_Status, null, null);
		bds.setBook_Id(book_id);
		bds.setBook_Name(book_Name);
		bds.setBook_Author(book_Author);
		bds.setBook_Price(book_Price);
		bds.setBook_Status(book_Status);
		
		BookDaoImpl bdao = new BookDaoImpl(DBconnect.getConn());
		boolean f=bdao.updateEditBooks(bds);
		HttpSession session = request.getSession();
		
		if(f) {
			
			session.setAttribute("successMsg", "Book Update Successfully...");
			response.sendRedirect("Admin/all_books.jsp");
		} 
		
		else {
			session.setAttribute("failedMsg", "Book Update Failed...");
			response.sendRedirect("Admin/all_books.jsp");

		}

     
}
}