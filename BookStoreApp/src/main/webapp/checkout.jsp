<%@page import="java.util.List"%>
<%@page import="in.bookstore.entity.Cart"%>
<%@page import="in.bookstore.entity.User"%>
<%@page import="in.bookstore.db.DBconnect"%>
<%@page import="in.bookstore.dao.CartDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cart Details</title>
<%@include file="allcomponents/allcss.jsp"%>
</head>
<body style="background-color: #f0f1f2;">
	<%@include file="allcomponents/navbar.jsp"%>

	<c:if test="${empty userobj }">
		<c:redirect url="login.jsp"></c:redirect>
	</c:if>

	<c:if test="${not empty successMsg }">
		<div class="alert alert-success" role="alert">${successMsg }</div>
		<c:remove var="successMsg" scope="session" />
	</c:if>


	<c:if test="${not empty failedMsg }">
		<div class="alert alert-danger text-center" role="alert">${failedMsg }</div>
		<c:remove var="failedMsg" scope="session" />
	</c:if>



	<div class="container">
		<div class="row p-2">
			<div class="col-md-6">
				<div class="card bg-white">
					<div class="card-body">
						<h3 class="text-center text-success">Your Select Item</h3>
						<table class="table table-striped">
							<thead>
								<tr>
									<th scope="col">Book Name</th>
									<th scope="col">Author</th>
									<th scope="col">Price</th>
									<th scope="col">Action</th>
								</tr>
							</thead>
							<tbody>
								<%
							User u=(User)session.getAttribute("userobj");
							CartDaoImpl cdi=new CartDaoImpl(DBconnect.getConn());
						    List<Cart> lis=cdi.getByUser(u.getId());
						    Double totalprice=0.00;
						    for(Cart c:lis){
						        totalprice=c.getTotal_price();%>
								<tr>
									<th scope="row"><%=c.getBook_Name()%></th>
									<td><%=c.getAuthor_Name() %></td>
									<td><%=c.getPrice() %></td>
									<td><a
										href="remove?bid=<%=c.getBid() %>&&uid=<%=c.getUid() %>&&cid=<%=c.getCid() %>"
										class="btn btn-sm btn-danger">Remove</a></td>
								</tr>



								<%}
							%>
								<tr>

									<td>Total Price</td>
									<td></td>
									<td></td>
									<td><%=totalprice %></td>
								</tr>

							</tbody>
						</table>


					</div>
				</div>
			</div>

			<div class="col-md-6">
				<div class="card bg-white">
					<div class="card-body">
						<h4 class="text-center text-success">Your Details For Order</h4>
						<form action="order" method="post">
						<input type="hidden" value="${userobj.id }" name="id">
							<div class="form-row">
								<div class="form-group col-md-6">
									<label for="inputtext">Name</label> <input type="text"
										class="form-control" id="inputtext" value="${userobj.name }" name="username" required>
								</div>
								<div class="form-group col-md-6">
									<label for="inputEmail4">Email</label> <input type="email"
										class="form-control" id="inputEmail4"
										value="${userobj.email }" name="email" required>
								</div>
							</div>
							<div class="form-group">
								<label for="inputAddress">Phone No</label> <input type="number"
									class="form-control" id="inputnumber" value="${userobj.phno}" name="phno" required>
							</div>
							<div class="form-group">
								<label for="inputAddress2">Address</label> <input type="text"
									class="form-control" id="inputAddress2"
									placeholder="Apartment, studio, or floor" name="address" required>
							</div>
							<div class="form-row">
								<div class="form-group col-md-6">
									<label for="inputCity">City</label> <input type="text"
										class="form-control" id="inputCity" name="city" required>
								</div>
							</div>
							<div class="form-row">
								<div class="form-group col-md-6">
									<label for="inputLandmark">Landmark</label> <input type="text"
										class="form-control" id="inputLandmark" name="landmark" required>
								</div>
								<div class="form-group col-md-4">
									<label for="inputState">State</label> <input type="text"
										class="form-control" id="inputState" name="state" required>

								</div>
								<div class="form-group col-md-2">
									<label for="inputZip">Zip</label> <input type="text"
										class="form-control" id="inputZip" name="zip" required>
								</div>
							</div>
							<div class="form-row">
								<div class="form-group col-md-6">
									<label for="inputPayment">Payment</label> <select
										id="inputPayment" class="form-control" name="payment" >
										<option value="noselect">..Select..</option>
										<option value="cod">Cash On Delivery</option>
									</select>
								</div>
							</div>
							<div class="text-center">
								<button class="btn btn-warning ">Order Now</button>
								<a href="index.jsp"><button class="btn btn-success">Continue
										Shopping..</button></a>

							</div>
						</form>

					</div>
				</div>
			</div>

		</div>
	</div>
	<%@include file="allcomponents/footer.jsp"%>
</body>
</html>