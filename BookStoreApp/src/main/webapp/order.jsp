<%@page import="in.bookstore.entity.Book_Order"%>
<%@page import="java.util.List"%>
<%@page import="in.bookstore.db.DBconnect"%>
<%@page import="in.bookstore.dao.BookOrderImpl"%>
<%@page import="in.bookstore.entity.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Book Order</title>
<%@include file="allcomponents/allcss.jsp"%>
</head>
<body style="background-color: #f0f1f2;">
	<%@include file="allcomponents/navbar.jsp"%>

	<c:if test="${empty userobj }">

		<c:redirect url="login.jsp" />

	</c:if>

	<div class="container p-1">
		<h4 class="text-center text-primary">Your Order</h4>
		<table class="table table-striped mt-3">
			<thead class="bg-primary text-white">
				<tr>
					<th scope="col">Order_Id</th>
					<th scope="col">Name</th>
					<th scope="col">Book_Name</th>
					<th scope="col">Author</th>
					<th scope="col">Price</th>
					<th scope="col">Payment</th>
				</tr>
			</thead>
			<tbody>
				<%
			User u=(User)session.getAttribute("userobj");
			BookOrderImpl bdo=new BookOrderImpl(DBconnect.getConn());
			List<Book_Order>list=bdo.getBook(u.getEmail());
			
			for(Book_Order b:list){%>

				<tr>
					<th scope="row"><%=b.getOrderid() %></th>
					<td><%=b.getUsername() %></td>
					<td><%=b.getBookname() %></td>
					<td><%=b.getAuthor() %></td>
					<td><%=b.getPrice() %></td>
					<td><%=b.getPaymentType() %></td>
				</tr>

				<% }%>


			</tbody>
		</table>

	</div>

	<%@include file="allcomponents/footer.jsp"%>
</body>
</html>