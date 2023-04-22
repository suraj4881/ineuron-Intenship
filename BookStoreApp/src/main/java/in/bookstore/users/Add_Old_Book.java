package in.bookstore.users;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import in.bookstore.dao.BookDaoImpl;
import in.bookstore.db.DBconnect;
import in.bookstore.entity.BookDetails;

@WebServlet("/add_old_book")
@MultipartConfig
public class Add_Old_Book extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String book_Name = request.getParameter("bname");
		String book_Author = request.getParameter("author");
		String book_Price = request.getParameter("price");
		String book_Category ="Old";
		String book_Status = "Active";
		Part part = request.getPart("bimg");
		String fileName = part.getSubmittedFileName();
		
		String useremail=request.getParameter("user");

		BookDetails bd = new BookDetails(book_Name, book_Author, book_Price, book_Category, book_Status, fileName,useremail);

		BookDaoImpl bdao = new BookDaoImpl(DBconnect.getConn());

		boolean f = bdao.addBooks(bd);
		HttpSession session = request.getSession();

		if (f) {

			String path = getServletContext().getRealPath("") + "books";

			File f1 = new File(path);

			part.write(path + File.separator + fileName);

			session.setAttribute("successMsg", "Book Add Successfully...");
			response.sendRedirect("sell_book.jsp");
		} 
		
		else {
			session.setAttribute("failedMsg", "Book Add Failed...");
			response.sendRedirect("sell_book.jsp");

		}

		
	}

}
