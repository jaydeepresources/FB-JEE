<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sort Products</title>
</head>
<body>

<h2>Sort Products</h2>

	<form action="SortServlet" method="get">
		<label>Sort Criteria</label> 
		<select name="criteria">
			<option value="product_id">Id</option>
			<option value="product_name">Name</option>
			<option value="product_price">Price</option>
		</select>
		<input type="submit" value="Sort">
	</form>

</body>
</html>