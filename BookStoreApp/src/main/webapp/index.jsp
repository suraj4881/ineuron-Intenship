<%@page import="in.bookstore.entity.User"%>
<%@page import="java.util.List"%>
<%@page import="in.bookstore.dao.BookDaoImpl"%>
<%@page import="in.bookstore.entity.BookDetails"%>
<%@page import="java.sql.Connection"%>
<%@page import="in.bookstore.db.DBconnect"%>
<%@ page language="java" contentType="text/html;" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Book Store</title>
<%@include file="allcomponents/allcss.jsp"%>
<style type="text/css">
.back-img {
	background: url("img/book.jpg");
	height: 70vh;
	background-size
	=
	cover;
	background-repeat
	=
	no-repeat;
}

.card-ho:hover {
	background-color: #beccc2;
}
</style>
</head>

<body style="background-color: #beccc2;">
	<%
	User u = (User) session.getAttribute("userobj");
	%>
	<%@include file="allcomponents/navbar.jsp"%>
	<div class="container-fluid back-img">
		<h2 class="text-center text-warning">BOOKS STORE FOR SELL AND BUY</h2>
	</div>

	<!-- Start Recent Book -->


	<div class="container">
		<h3 class="text-center">Recent Books</h3>
		<div class="row">

			<%
			BookDaoImpl bdi = new BookDaoImpl(DBconnect.getConn());
			List<BookDetails> list = bdi.getRecentBook();
			for (BookDetails bd : list) {
			%>

			<div class="col-md-3">
				<div class="card card-ho">
					<div class="card-body text-center">
						<img alt="" src="books/<%=bd.getBook_Photo()%>"
							style="width: 159px; height: 200px" class="img-thumblin">
						<p><%=bd.getBook_Name()%></p>
						<p><%=bd.getBook_Author()%></p>
						<p>
							Categories:<%=bd.getBook_Category()%></p>
						<div class="row ml-0.5">

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
							<a href="view_details_book.jsp?bid=<%=bd.getBook_Id()%>"
								class="btn btn-success btn-sm ml-1">View Details</a> <a href=""
								class="btn btn-danger btn-sm ml-(-1)"><i
								class="fa-solid fa-indian-rupee-sign"></i><%=bd.getBook_Price()%></a>
						</div>
					</div>
				</div>
			</div>
			<%
			}
			%>

		</div>
		<div class="text-center m-1">
			<a href="all_recent_book.jsp"
				class="btn btn-danger btn-sm text-white">View All</a>
		</div>
	</div>
	<!-- End Recent Book -->

	<hr>

	<!-- Start New Book -->

	<div class="container">
		<h3 class="text-center">New Books</h3>
		<div class="row">


			<%
			BookDaoImpl bdao = new BookDaoImpl(DBconnect.getConn());
			List<BookDetails> list1 = bdao.getNewBook();

			for (BookDetails bds : list1) {
			%>
			<div class="col-md-3">
				<div class="card card-ho">
					<div class="card-body text-center">
						<img alt="" src="books/<%=bds.getBook_Photo()%>"
							style="width: 159px; height: 200px" class="img-thumblin">
						<p><%=bds.getBook_Name()%></p>
						<p><%=bds.getBook_Author()%></p>
						<p>
							Categories:<%=bds.getBook_Category()%></p>
						<div class="row ml-0.5">
							<%
							if (u == null) {
							%>

							<a href="login.jsp" class="btn btn-danger btn-sm ml-1"><i
								class="fa-solid fa-cart-plus"></i> Add Cart</a>

							<%
							} else {
							%>
							<a href="cart?bid=<%=bds.getBook_Id()%>&&uid=<%=u.getId()%>"
								class="btn btn-danger btn-sm ml-1"><i
								class="fa-solid fa-cart-plus"></i> Add Cart</a>
							<%
							}
							%>
							<a href="view_details_book.jsp?bid=<%=bds.getBook_Id()%>"
								class="btn btn-success btn-sm ml-1">View Details</a> <a href=""
								class="btn btn-danger btn-sm ml-(-1)"><i
								class="fa-solid fa-indian-rupee-sign"></i><%=bds.getBook_Price()%></a>
						</div>
					</div>
				</div>
			</div>
			<%
			}
			%>
		</div>
		<div class="text-center m-1">
			<a href="all_new_book.jsp" class="btn btn-danger btn-sm text-white">View
				All</a>
		</div>
	</div>
	<!-- End New Book -->


	<hr>

	<!-- Start Old Book -->
	<div class="container">
		<h3 class="text-center">Old Books</h3>
		<div class="row">
			<%
			BookDaoImpl bde = new BookDaoImpl(DBconnect.getConn());
			List<BookDetails> list2 = bde.getOldBook();
			for (BookDetails bd : list2) {
			%>

			<div class="col-md-3">
				<div class="card card-ho">
					<div class="card-body text-center">
						<img alt="" src="books/<%=bd.getBook_Photo()%>"
							style="width: 159px; height: 200px" class="img-thumblin">
						<p><%=bd.getBook_Name()%></p>
						<p><%=bd.getBook_Author()%></p>
						<p>
							Categories:<%=bd.getBook_Category()%></p>
						<div class="row ml-0.5">
							<%
							if (u == null) {
							%>

							<a href="login.jsp" class="btn btn-danger btn-sm ml-1"><i
								class="fa-solid fa-cart-plus"></i> Add Cart</a>

							<%
							} else {
							%>
							<a href="oldcart?bid=<%=bd.getBook_Id()%>&&uid=<%=u.getId()%>"
								class="btn btn-danger btn-sm ml-1"><i
								class="fa-solid fa-cart-plus"></i> Add Cart</a>
							<%
							}
							%>

							<a href="view_details_book.jsp?bid=<%=bd.getBook_Id()%>"
								class="btn btn-success btn-sm ml-1">View Details</a> <a href=""
								class="btn btn-danger btn-sm ml-(-1)"><i
								class="fa-solid fa-indian-rupee-sign"></i><%=bd.getBook_Price()%></a>
						</div>
					</div>
				</div>
			</div>
			<%
			}
			%>
		</div>
		<div class="text-center m-1">
			<a href="all_old_book.jsp" class="btn btn-danger btn-sm text-white">View
				All</a>
		</div>
	</div>
	<!-- End Old Book -->



	<%@include file="allcomponents/footer.jsp"%>

</body>
</html>