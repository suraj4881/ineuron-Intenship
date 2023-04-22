package in.bookstore.users;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.bookstore.dao.CartDaoImpl;
import in.bookstore.db.DBconnect;
import in.bookstore.entity.Book_Order;
import in.bookstore.entity.Cart;
import in.bookstore.dao.BookOrderImpl;

@WebServlet("/order")
public class Order extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		HttpSession session=request.getSession();
		
		int id=Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("username");
		String email=request.getParameter("email");
		String phno=request.getParameter("phno");
		String address=request.getParameter("address");
		String landmark=request.getParameter("landmark");
		String city=request.getParameter("city");
		String state=request.getParameter("state");
		String zip=request.getParameter("zip");
		String paymentType=request.getParameter("payment");
		
		String fulladd=address+","+landmark+","+city+","+state+","+zip;
		
		CartDaoImpl cdo=new CartDaoImpl(DBconnect.getConn());
		
		List<Cart> list=cdo.getByUser(id);
		if(list.isEmpty()) 
		{
		   session.setAttribute("failedMsg", "Add Item!..");
		   response.sendRedirect("checkout.jsp");
			
		}
		else 
		{
			BookOrderImpl bdao=new BookOrderImpl(DBconnect.getConn());
			
			Book_Order bo=null;
			
			ArrayList<Book_Order> o=new ArrayList<Book_Order>();
			
			Random r=new Random();
			
			for(Cart c:list) {
				bo=new Book_Order();
				bo.setOrderid("BOOK-ORD-00"+r.nextInt(1000));
				bo.setUsername(name);
				bo.setEmail(email);
				bo.setPhno(phno);
				bo.setFulladd(fulladd);
				bo.setBookname(c.getBook_Name());
				bo.setAuthor(c.getAuthor_Name());
				bo.setPrice(c.getPrice()+"");
				bo.setPaymentType(paymentType);
				o.add(bo);
				
			}
			
			
			if("noselect".equals(paymentType)) {
				
				session.setAttribute("failedMsg", "Please Choose Payment Method..");
				response.sendRedirect("checkout.jsp");
			}
			else {
				boolean f=bdao.saveOrder(o);
				if(f) {
					
					response.sendRedirect("order_success.jsp");
				}
				else {
					session.setAttribute("failedMsg", "Your Order Failed..");
					response.sendRedirect("order_success.jsp");
				}
			}
		}
		
	}

}
