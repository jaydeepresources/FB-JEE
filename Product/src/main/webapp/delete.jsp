<%@page import="java.util.List"%>
<%@page import="com.dao.ProductDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete Product</title>
</head>
<body>

<%
	if(session == null || session.getAttribute("user") == null)
		response.sendRedirect("http://localhost:8080/Product/login.html");
%>

<% 
	ProductDAOImpl impl = new ProductDAOImpl(); 
	List<Integer> productIds = impl.getProductIds();	
%>

	<form action="DeleteServlet" method="get">
		<label>Select Product Id</label>
		<select name="productId">
			<% for(Integer productId: productIds){ %>
				<option value=<%= productId %>><%= productId %></option>
			<% } %>
		</select>
		<input type="submit" value="Delete" />
	</form>
</body>
</html>