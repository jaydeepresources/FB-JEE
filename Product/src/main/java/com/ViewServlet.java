package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.Product;
import com.dao.ProductDAOImpl;

@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		if (session == null || ((String) session.getAttribute("user")) == null) {
			response.sendRedirect("http://localhost:8080/Product/login.html");
			return;
		}
		
		ProductDAOImpl impl = new ProductDAOImpl();

		List<Product> products = impl.getProducts();

		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		out.println("<h2>Products</h2>");

		out.println("<table>" + "<tr>" + "<th>Id</th>" + "<th>Name</th>" + "<th>Price</th>" + "</tr>");

		for (Product product : products) {
			out.println("<tr>" + "<td>" + product.getProductId() + "</td>" + "<td>" + product.getProductName() + "</td>"
					+ "<td>" + product.getProductPrice() + "</td>");
		}

		out.println("</table>");

	}

}