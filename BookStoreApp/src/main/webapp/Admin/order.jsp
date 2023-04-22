<%@page import="in.bookstore.entity.Book_Order"%>
<%@page import="java.util.List"%>
<%@page import="in.bookstore.db.DBconnect"%>
<%@page import="in.bookstore.dao.BookOrderImpl"%>
<%@page import="in.bookstore.entity.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Book Store:All_Orders</title>
<%@include file="allcss.jsp"%>
</head>
<body>

	<%@include file="navbar.jsp"%>
	
	<c:if test="${empty userobj }">
	<c:redirect url="../login.jsp" ></c:redirect>
	</c:if>

	<h3 class="text-center">Hello Admin</h3>

	<table class="table table-striped ">
		<thead class="bg-primary text-white">
			<tr>
				<th scope="col">Order_Id</th>
				<th scope="col">Name</th>
				<th scope="col">Email</th>
				<th scope="col">Address</th>
				<th scope="col">Ph No</th>
				<th scope="col">Book Name</th>
				<th scope="col">Author</th>
				<th scope="col">Price</th>
				<th scope="col">Payment Type</th>
			</tr>
		</thead>
		<tbody>
			<%
			
			BookOrderImpl bdo=new BookOrderImpl(DBconnect.getConn());
			List<Book_Order>list=bdo.getBookAll();
			
			for(Book_Order b:list){%>

				<tr>
					<th scope="row"><%=b.getOrderid() %></th>
					<td><%=b.getUsername() %></td>
					<td><%=b.getEmail() %></td>
					<td><%=b.getFulladd() %></td>
					<td><%=b.getPhno() %></td>
					<td><%=b.getBookname() %></td>
					<td><%=b.getAuthor() %></td>
					<td><%=b.getPrice() %></td>
					<td><%=b.getPaymentType() %></td>
				</tr>

				<% }%>

		
		</tbody>
	</table>
	<div style="margin-top: 130px;">
		<%@include file="footer.jsp"%>
	</div>
</body>
</html>