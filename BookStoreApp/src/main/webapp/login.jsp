<%@ page language="java" contentType="text/html;"
    isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Book Store:Login</title>
<%@include file="allcomponents/allcss.jsp"%>
</head>
<body style="background-color:#91c4a0;">
<%@include file="allcomponents/navbar.jsp"%>
<div class="container p-2">
<div class="row mt-2">
<div class="col-md-4 offset-md-4">
<div class="card">
<div class="card-body">
<h5 class="text-center">Login Page</h5>

<c:if test="${not empty failedMsg }">
<p class="text-center text-danger">${failedMsg}</p>
<c:remove var="failedMsg" scope="session"/>
</c:if>

<c:if test="${not empty successMsg }">
<p class="text-center text-success">${successMsg}</p>
<c:remove var="successMsg" scope="session"/>
</c:if>



<form action="login" method="post">

  <div class="form-group">
    <label for="exampleInputEmail1">Email address</label>
    <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter Your email" required="required" name="email">
    
  </div>
  
  <div class="form-group">
    <label for="exampleInputPassword1">Password</label>
    <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password" required="required" name="password">
  </div>
  <div class="form-check">
    <input type="checkbox" class="form-check-input" id="exampleCheck1" name="check">
    <label class="form-check-label" for="exampleCheck1" required="required">Check me out</label>
  </div>
  <div class="text-center">
  <button type="submit" class="btn btn-primary">Login</button><br/>
  <a href="register.jsp">Create Account</a>
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