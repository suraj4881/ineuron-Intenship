<%@page import="in.bookstore.entity.User"%>
<%@page import="in.bookstore.entity.BookDetails"%>
<%@page import="java.util.List"%>
<%@page import="in.bookstore.db.DBconnect"%>
<%@page import="in.bookstore.dao.BookDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All New Books</title>
<%@include file="allcomponents/allcss.jsp"%>
<style type="text/css">
.card-ho:hover {
	background-color: #beccc2;
}
/* toast */
#toast {
	min-width: 300px;
	position: fixed;
	bottom: 30px;
	left: 50%;
	margin-left: -125px;
	background: #333;
	padding: 10px;
	color: white;
	text-align: center;
	z-index: 1;
	font-size: 18px;
	visibility: hidden;
	box-shadow: 0px 0px 100px #000;
}

#toast.display {
	visibility: visible;
	animation: fadeIn 0.5, fadeOut 0.5s 2.5s;
}

@
keyframes fadeIn {from { bottom:0;
	opacity: 0;
}

to {
	bottom: 30px;
	opacity: 1;
}

}
@
keyframes fadeOut {form { bottom:30px;
	opacity: 1;
}

to {
	bottom: 0;
	opacity: 0;
}
}

/* toast */
</style>
</head>
<body>

	<%
	User u = (User) session.getAttribute("userobj");
%>
	<c:if test="${not empty addCart }">

		<div id="toast">${addCart}</div>

		<script type="text/javascript">
		showToast();
		function showToast(content)
		{
		    $('#toast').addClass("display");
		    $('#toast').html(content);
		    setTimeout(()=>{
		        $("#toast").removeClass("display");
		    },2000)
		}	
</script>
		<c:remove var="addCart" scope="session" />

	</c:if>

	<%@include file="allcomponents/navbar.jsp"%>

	<div class="container-fluid">
		<div class="row p-3">
			<%
				BookDaoImpl bdao = new BookDaoImpl(DBconnect.getConn());
				List<BookDetails> list1 = bdao.getAllNewBook();

				for (BookDetails bds : list1) {
				%>
			<div class="col-md-3">
				<div class="card card-ho mt-2">
					<div class="card-body text-center">
						<img alt="" src="books/<%=bds.getBook_Photo() %>"
							style="width: 100px; height: 150px" class="img-thumblin">
						<p><%=bds.getBook_Name() %></p>
						<p><%=bds.getBook_Author() %></p>
						<p>
							Categories:<%=bds.getBook_Category() %></p>
						<div class="row">

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

							<a href="view_details_book.jsp?bid=<%=bds.getBook_Id()%>" class="btn btn-success btn-sm ml-1">View Details</a>
							<a href="" class="btn btn-danger btn-sm ml-1 ">
							<i class="fa-solid fa-indian-rupee-sign"></i><%=bds.getBook_Price()%></a>
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