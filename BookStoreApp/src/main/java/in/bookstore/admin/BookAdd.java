package in.bookstore.admin;

import java.io.IOException;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import in.bookstore.entity.*;
import in.bookstore.dao.*;
import in.bookstore.db.DBconnect;

@WebServlet("/add_books")
@MultipartConfig
public class BookAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String book_Name = request.getParameter("bname");
		String book_Author = request.getParameter("author");
		String book_Price = request.getParameter("price");
		String book_Category = request.getParameter("category");
		String book_Status = request.getParameter("bstatus");
		Part part = request.getPart("bimg");
		String fileName = part.getSubmittedFileName();

		BookDetails bd = new BookDetails(book_Name, book_Author, book_Price, book_Category, book_Status, fileName,"Admin");

		BookDaoImpl bdao = new BookDaoImpl(DBconnect.getConn());

		boolean f = bdao.addBooks(bd);
		HttpSession session = request.getSession();

		if (f) {

			String path = getServletContext().getRealPath("") + "books";

			File f1 = new File(path);

			part.write(path + File.separator + fileName);

			session.setAttribute("successMsg", "Book Add Successfully...");
			response.sendRedirect("Admin/add_books.jsp");
		} 
		
		else {
			session.setAttribute("failedMsg", "Book Add Failed...");
			response.sendRedirect("Admin/add_books.jsp");

		}

	}

}
