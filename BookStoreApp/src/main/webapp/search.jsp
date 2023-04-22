<%@page import="in.bookstore.entity.User"%>
<%@page import="java.util.List"%>
<%@page import="in.bookstore.db.DBconnect"%>
<%@page import="in.bookstore.dao.BookDaoImpl"%>
<%@page import="in.bookstore.entity.BookDetails"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Books</title>
<%@include file="allcomponents/allcss.jsp"%>
<style type="text/css">
.card-ho:hover {
	background-color: #beccc2;
}
</style>
</head>
<body>

<%
	User u = (User) session.getAttribute("userobj");
%>


	<%@include file="allcomponents/navbar.jsp"%>

	<div class="container-fluid">
		<div class="row p-3">
			<%
			    String ch=request.getParameter("ch");
				BookDaoImpl bdi = new BookDaoImpl(DBconnect.getConn());
				List<BookDetails> list =bdi.getBookBySearch(ch);
				for (BookDetails bd : list) {
				%>

			<div class="col-md-3">
				<div class="card card-ho mt-2">
					<div class="card-body text-center">
						<img alt="" src="books/<%=bd.getBook_Photo() %>"
							style="width: 100px; height: 150px" class="img-thumblin">
						<p><%=bd.getBook_Name() %></p>
						<p><%=bd.getBook_Author() %></p>
						<p>
							Categories:<%=bd.getBook_Category()%></p>
						<div class="row">
							
							<%
							if (u == null) {
							%>

							<a href="login.jsp" class="btn btn-danger btn-sm ml-1"><i
								class="fa-solid fa-cart-plus"></i> Add Cart</a>

							<%
							} else {
							%>
							<a href="cart?bid=<%=bd.getBook_Id()%>&&uid=<%=u.getId()%>"
								class="btn btn-danger btn-sm ml-1"><i
								class="fa-solid fa-cart-plus"></i> Add Cart</a>
							<%
							}
							%>
							
							 <a href="view_details_book.jsp?bid=<%=bd.getBook_Id()%>"class="btn btn-success btn-sm ml-1">View Details</a> 
							 <a href=""	class="btn btn-danger btn-sm ml-1"><i class="fa-solid fa-indian-rupee-sign"></i><%=bd.getBook_Price()%></a>
						</div>
					</div>
				</div>
			</div>
			<%
				}
				%>

		</div>
	</div>







	<%@include file="allcomponents/footer.jsp"%>
</body>
</html>