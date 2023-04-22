package in.bookstore.users;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.bookstore.dao.BookDaoImpl;
import in.bookstore.dao.CartDaoImpl;
import in.bookstore.db.DBconnect;
import in.bookstore.entity.BookDetails;
import in.bookstore.entity.Cart;


@WebServlet("/oldcart")
public class OldCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int bid=Integer.parseInt(request.getParameter("bid"));
		int uid=Integer.parseInt(request.getParameter("uid"));
		
		BookDaoImpl dao=new BookDaoImpl(DBconnect.getConn());
		BookDetails bd=dao.getBookById(bid);
		
		Cart c=new Cart();
		c.setBid(bid);
		c.setUid(uid);
		c.setBook_Name(bd.getBook_Name());
		c.setAuthor_Name(bd.getBook_Author());
		c.setPrice(Double.parseDouble(bd.getBook_Price()));
		c.setTotal_price(Double.parseDouble(bd.getBook_Price()));
		
		CartDaoImpl dao1=new CartDaoImpl(DBconnect.getConn());
		boolean f=dao1.addCart(c);
	    HttpSession session=request.getSession();
	    
	    
		if(f) {
			
			
			session.setAttribute("addCart", "Book Added to Cart Successfull...");
			response.sendRedirect("all_old_book.jsp");
			
		}else {
			
			session.setAttribute("failed", "Book Added to Cart Failed...");
			response.sendRedirect("all_old_book.jsp");
		}
		
	}

}
