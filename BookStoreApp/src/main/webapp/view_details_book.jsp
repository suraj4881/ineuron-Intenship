<%@page import="in.bookstore.entity.BookDetails"%>
<%@page import="in.bookstore.db.DBconnect"%>
<%@page import="in.bookstore.dao.BookDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%@include file="allcomponents/allcss.jsp"%>
</head>
<body style="background-color: #f0f1f2">
	<%@include file="allcomponents/navbar.jsp"%>
	<%
	int bid = Integer.parseInt(request.getParameter("bid"));
	BookDaoImpl bdao = new BookDaoImpl(DBconnect.getConn());
	BookDetails b = bdao.getBookById(bid);
	%>
	<div class="container p-3">
		<div class="row">
			<div class="col-md-6 text-center p-5 border bg-white">
				<img alt="" src="books/<%=b.getBook_Photo()%>"
					style="width: 100px; height: 150px"><br>
				<h4 class="mt-3">
					Book Name: <span class="text-success"><%=b.getBook_Name()%></span>
				</h4>
				<h4>
					Author Name: <span class="text-success"><%=b.getBook_Author()%></span>
				</h4>
				<h4>
					Category: <span class="text-success"><%=b.getBook_Category()%></span>
				</h4>
			</div>

			<div class="col-md-6 text-center p-5 border bg-white">
				<h2><%=b.getBook_Name()%></h2>

				<%
				if ("Old".equals(b.getBook_Category())) {
				%>
                
				<h5 class="text-primary">Contact to Seller</h5>
				<h5 class="text-primary">
					<i class="fa-solid fa-envelope"></i>Email:<%=b.getBook_Email()%></h5>


				<%
				}else
				{%>
				
				<h5 class="text-primary">Contact to Seller</h5>
				<h5 class="text-primary">
					<i class="fa-solid fa-envelope"></i>Email:<%=b.getBook_Email()%></h5>
				
               <%} %>


				<div class="row ">
					<div class="col-md-4 text-danger text-center p-2 mt-2">
						<i class="fa-solid fa-money-check fa-2x"></i>
						<p>Cash On Delivery</p>
					</div>
					<div class="col-md-4 text-danger text-center p-2 mt-2">
						<i class="fa-solid fa-arrow-rotate-left fa-2x"></i>
						<p>Return Available</p>
					</div>
					<div class="col-md-4 text-danger text-center p-2 mt-2">
						<i class="fa-regular fa-truck fa-2x"></i>
						<p>Free Shipping</p>
					</div>

				</div>
				<div class="text-center p-3">
					<a href="" class="btn btn-primary"><i
						class="fa-solid fa-cart-plus"></i>Add Cart</a> <a href=""
						class="btn btn-danger"><i
						class="fa-solid fa-indian-rupee-sign"></i>200</a>

				</div>
			</div>
		</div>
	</div>
</body>
</html>