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
<title>Book Store:All_books</title>
<%@include file="allcss.jsp"%>
</head>
<body>

	<%@include file="navbar.jsp"%>
	
	<c:if test="${empty userobj }">
	<c:redirect url="../login.jsp" ></c:redirect>
	</c:if>

	<h3 class="text-center">Hello Admin</h3>
	<c:if test="${not empty successMsg }">
		<h5 class="text-center text-success">${successMsg}</h5>
		<c:remove var="successMsg" scope="session" />
	</c:if>

	<c:if test="${not empty failedMsg }">
		<h5 class="text-center text-danger">${failedMsg}</h5>
		<c:remove var="failedMsg" scope="session" />
	</c:if>


	<table class="table table-striped ">
		<thead class="bg-primary text-white">
			<tr>
				<th scope="col">Id</th>
				<th scope="col">Image</th>
				<th scope="col">Book Name</th>
				<th scope="col">Author</th>
				<th scope="col">Price</th>
				<th scope="col">Categories</th>
				<th scope="col">Status</th>
				<th scope="col">Action</th>
			</tr>
		</thead>
		<tbody>
			<%
			BookDaoImpl dao = new BookDaoImpl(DBconnect.getConn());
			List<BookDetails> list = dao.getAllBooks();

			for (BookDetails bds : list) {
			%>
			<tr>
				<td><%=bds.getBook_Id()%></td>
				<td><img src="../books/<%=bds.getBook_Photo()%>"
					style="width: 50px; height: 50px;"></td>
				<td><%=bds.getBook_Name()%></td>
				<td><%=bds.getBook_Author()%></td>
				<td><%=bds.getBook_Price()%></td>
				<td><%=bds.getBook_Category()%></td>
				<td><%=bds.getBook_Status()%></td>


				<td><a href="edit_books.jsp?id=<%=bds.getBook_Id()%>"
					class="btn btn-sm btn-primary"><i class="fa-solid fa-user-pen"></i>Edit</a> <a
					href="../delete?id=<%=bds.getBook_Id()%>"
					class="btn btn-sm btn-danger"><i class="fa-solid fa-trash"></i>Delete</a></td>
			</tr>


			<%
			}
			%>

		</tbody>
	</table>
	<div style="margin-top: 130px;">
		<%@include file="footer.jsp"%>
	</div>
</body>
</html>