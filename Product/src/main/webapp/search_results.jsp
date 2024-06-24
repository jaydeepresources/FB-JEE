<%@page import="com.dao.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search Results</title>
</head>
<body>

<%
	if(session == null || session.getAttribute("user") == null)
		response.sendRedirect("http://localhost:8080/Product/login.html");
%>

<h2>Products</h2>
	<%
		if(session == null || session.getAttribute("user") == null)
			response.sendRedirect("http://localhost:8080/Product/login.html");
	%>
<% List<Product> products = (List<Product>)session.getAttribute("products"); %>
<% if(products.size() == 0){ %>
	<h4>No Products Found</h4>
<% } 
	else { %>
<table>
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Price</th>
		</tr>

		<%
		for (Product product : products) {
		%>

		<tr>
			<td><%=product.getProductId()%></td>
			<td><%=product.getProductName()%></td>
			<td><%=product.getProductPrice()%></td>
		</tr>

		<%
		}
		%>


	</table>
	
<% } %>

</body>
</html>

