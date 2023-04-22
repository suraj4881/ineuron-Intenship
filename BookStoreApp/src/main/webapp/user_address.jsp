<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Address</title>
<%@include file="allcomponents/allcss.jsp"%>
</head>
<body style="background-color: #f0f1f2;">
	<%@include file="allcomponents/navbar.jsp"%>
	<div class="container">
		<div class="row p-3">
			<div class="col-md-4 offset-md-4 ">
				<div class="card">
					<div class="card-body">
                     <h4 class="text-center text-primary">Edit Address</h4>
						<form action="">

							<div class="form-group">
								<label for="inputAddress2">Address</label> <input type="text"
									class="form-control" id="inputAddress2"
									placeholder="Apartment, studio, or floor">
							</div>
							<div class="form-group">
								<label for="inputLandmark">Landmark</label> <input type="text"
									class="form-control" id="inputLandmark">
							</div>

							<div class="form-row">

								<div class="form-group col-md-4">
									<label for="inputCity">City</label> <input type="text"
										class="form-control" id="inputCity">
								</div>
								<div class="form-group col-md-4">
									<label for="inputState">State</label> <input type="text"
										class="form-control" id="inputState">
								</div>
								<div class="form-group col-md-4">
									<label for="inputZip">Zip</label> <input type="text"
										class="form-control" id="inputZip">
								</div>
							</div>

							<div class="text-center">
								<a href="index.jsp"><button class="btn btn-warning">Add Address</button></a>
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