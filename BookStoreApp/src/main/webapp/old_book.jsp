<%@page import="in.bookstore.entity.BookDetails"%>
<%@page import="java.util.List"%>
<%@page import="in.bookstore.entity.User"%>
<%@page import="in.bookstore.db.DBconnect"%>
<%@page import="in.bookstore.dao.BookDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User:Old Book</title>
<%@include file="allcomponents/allcss.jsp"%>
</head>
<body style="background-color: #f0f1f2;">
<%@include file="allcomponents/navbar.jsp"%>

<c:if test="${not empty successMsg }">
<h4 class="text-center text-success">${successMsg }</h4>
<c:remove var="successMsg"/>
</c:if>
<c:if test="${not empty failedMsg }">
<h4 class="text-center text-danger">${failedMsg }</h4>
<c:remove var="failedMsg"/>
</c:if>

<div class="container p-5">
<table class="table table-striped ">
  <thead class="bg-primary text-white">
    <tr>
      <th scope="col">Book_Name</th>
      <th scope="col">Author</th>
      <th scope="col">Price</th>
      <th scope="col">Category</th>
      <th scope="col">Action</th>
    </tr>
  </thead>
  <tbody>
  <%
  User u=(User)session.getAttribute("userobj");
  String email=u.getEmail();
  BookDaoImpl bdao=new BookDaoImpl(DBconnect.getConn());
  List<BookDetails> list=bdao.getBookByOld(email, "Old");
  
  for(BookDetails b:list){%>
	
	<tr>
      
      <td><%=b.getBook_Name() %></td>
      <td><%=b.getBook_Author() %></td>
      <td><%=b.getBook_Price() %></td>
      <td><%=b.getBook_Category() %></td>
      <td><a href="delete_old_book?email=<%=email%>&&id=<%=b.getBook_Id() %>" class="btn btn-sm btn-danger">Delete</a></td>
    </tr>
	
	  
  <% 
  }
  %>
  </tbody>
</table>
</div>
<%@include file="allcomponents/footer.jsp"%>
</body>
</html>