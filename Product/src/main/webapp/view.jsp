<%@ page import="com.dao.Product"%>
<%@ page import="java.util.List"%>
<%@ page import="com.dao.ProductDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Products</title>
</head>
<body>

	<%
		if(session == null || session.getAttribute("user") == null)
			response.sendRedirect("http://localhost:8080/Product/login.html");
	%>

	<h2>Products</h2>

	<%
		ProductDAOImpl impl = new ProductDAOImpl();
		List<Product> products = impl.getProducts();
	%>

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


</body>
</html>
