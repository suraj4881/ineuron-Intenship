<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	isELIgnored="false"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Book Store:Add_books</title>
<%@include file="allcss.jsp"%>
</head>
<body style="background-color: #f0f2f2;">
	<%@include file="navbar.jsp"%>
	
	<c:if test="${empty userobj }">
	<c:redirect url="../login.jsp" ></c:redirect>
	</c:if>

	<div class="container">
		<div class="row p-5">
			<div class="col-md-4 offset-md-4">
				<div class="card ">
					<div class="card-body ">
						<h4 class="text-center">Add Books</h4>
						
						<c:if test="${not empty successMsg }">
						<p class="text-center text-success">${successMsg}</p>
						<c:remove var="successMsg" scope="session"/>
						</c:if>
						
						<c:if test="${not empty failedMsg }">
						<p class="text-center text-danger">${failedMsg}</p>
						<c:remove var="failedMsg" scope="session"/>
						</c:if>
						
						<form action="../add_books" method="post" enctype="multipart/form-data">
							<div class="form-group">
								<label for="exampleInputtext">Book Name*</label> <input
									type="text" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" name="bname">

							</div>
							<div class="form-group">
								<label for="exampleInputtext">Author Name*</label> <input
									type="text" class="form-control" id="exampleInputPassword1"
									name="author">
							</div>
							<div class="form-group">
								<label for="exampleInputtext">Price*</label> <input
									type="number" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" name="price">

							</div>

							<div class="form-group">
								<label for="exampleFormControlSelect1">Book Categories</label> <select
									class="form-control" id="exampleFormControlSelect1"
									name="category">
									<option selected>--select--</option>
									<option value="New">New Book</option>

								</select>
							</div>
							<div class="form-group">
								<label for="exampleFormControlSelect1">Book Status</label> <select
									class="form-control" id="exampleFormControlSelect1"
									name="bstatus">
									<option selected>--select--</option>
									<option value="Active">Active</option>
									<option value="Inactive">Inactive</option>
								</select>
							</div>
							<div class="form-group">
								<label for="exampleFormControlFile1">Upload Photo</label> <input
									type="file" class="form-control-file"
									id="exampleFormControlFile1" name="bimg">
							</div>

							<button type="submit" class="btn btn-primary">Add</button>
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