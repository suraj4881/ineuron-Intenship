<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Book Store:Register</title>
<%@include file="allcomponents/allcss.jsp"%>
</head>
<body style="background-color:#91c4a0;">
<%@include file="allcomponents/navbar.jsp"%>

<div class="container p-2">
<div class="row">
<div class="col-md-4 offset-md-4">
<div class="card">
<div class="card-body">
<h5 class="text-center">Registration Page</h5>
<c:if test="${not empty successMsg }">
<p class="text-center text-success">${successMsg }</p>
<c:remove var="successMsg"/>
</c:if>
<c:if test="${not empty failedMsg }">
<p class="text-center text-danger">${failedMsg }</p>
<c:remove var="failedMsg"/>
</c:if>
<form action="register" method="post">
<div class="form-group">
    <label for="exampleInputName">Enter Your Name</label>
    <input type="text" class="form-control" id="exampleInputName" aria-describedby="emailHelp" placeholder="Enter Your Name" required="required"
    name="fname">
    
  </div>
  <div class="form-group">
    <label for="exampleInputEmail1">Email address</label>
    <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter Your email" required="required" name="email">
    
  </div>
  <div class="form-group">
    <label for="exampleInputNumber">Phone No</label>
    <input type="number" class="form-control" id="exampleInputNumber" aria-describedby="emailHelp" placeholder="Enter Mobile Number" required="required" name="phno">
    
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">Password</label>
    <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password" required="required"name="password">
  </div>
  <div class="form-check">
    <input type="checkbox" class="form-check-input" id="exampleCheck1" name="check">
    <label class="form-check-label" for="exampleCheck1" required="required">Agree term & condition</label>
  </div>
  <button type="submit" class="btn btn-primary">Submit</button>
</form>

</div>
</div>
</div>
</div>
</div>

<%@include file="allcomponents/footer.jsp"%>

</body>
</html>