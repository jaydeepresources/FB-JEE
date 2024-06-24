<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search Product</title>
</head>
<body>

	<%
		if(session == null || session.getAttribute("user") == null)
			response.sendRedirect("http://localhost:8080/Product/login.html");
	%>

	<h2>Search Products</h2>

	<form action="SearchServlet" method="get">
		<label>Product Name</label> 
		<input type="text" name="productName" placeholder="enter product name"> 
		<input type="submit" value="search">
	</form>

</body>
</html>