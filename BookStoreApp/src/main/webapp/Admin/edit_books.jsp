<%@page import="in.bookstore.entity.BookDetails"%>
<%@page import="in.bookstore.db.DBconnect"%>
<%@page import="in.bookstore.dao.BookDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Book Store:Add_books</title>
<%@include file="allcss.jsp"%>
</head>
<body style="background-color: #f0f2f2;">
	<%@include file="navbar.jsp"%>

	<div class="container">
		<div class="row p-5">
			<div class="col-md-4 offset-md-4">
				<div class="card ">
					<div class="card-body ">
						<h4 class="text-center">Edit Books</h4>

						
						<% 
				          int id=Integer.parseInt(request.getParameter("id"));
				          BookDaoImpl dao =new  BookDaoImpl(DBconnect.getConn());
				          BookDetails b=dao.getBookById(id);
				         %>

						<form action="../edit_books" method="post">
						
						<input type="hidden" name="id" value="<%=b.getBook_Id()%>">
						
							<div class="form-group">
								<label for="exampleInputtext">Book Name*</label> <input
									type="text" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" name="bname"
									value="<%=b.getBook_Name()%>">

							</div>
							<div class="form-group">
								<label for="exampleInputtext">Author Name*</label> <input
									type="text" class="form-control" id="exampleInputPassword1"
									name="author" value="<%=b.getBook_Author() %>">
							</div>
							<div class="form-group">
								<label for="exampleInputtext">Price*</label> <input
									type="number" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" name="price"
									value="<%=b.getBook_Price() %>">

							</div>

							<div class="form-group">
								<label for="exampleFormControlSelect1">Book Status</label> <select
									class="form-control" id="exampleFormControlSelect1"
									name="bstatus">
									<%if("Active".equals(b.getBook_Status())){
										%>
									<option value="Active">Active</option>
									<option value="Inactive">Inactive</option>
									<% }else{%>
									<option value="Inactive">Inactive</option>
									<option value="Active">Active</option>
									<% }%>

								</select>
							</div>


							<button type="submit" class="btn btn-primary ">Update</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div style="margin-top: 40px;">
		<%@include file="footer.jsp"%>
	</div>
</body>
</html>