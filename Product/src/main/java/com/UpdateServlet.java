package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.Product;
import com.dao.ProductDAOImpl;

@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		if (session == null || ((String) session.getAttribute("user")) == null) {
			response.sendRedirect("http://localhost:8080/Product/login.html");
			return;
		}
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		int productId = Integer.parseInt(request.getParameter("productId"));
		String productName = request.getParameter("productName");
		float productPrice = Float.parseFloat(request.getParameter("productPrice"));

		ProductDAOImpl impl = new ProductDAOImpl();

		int res = impl.updateProduct(new Product(productId, productName, productPrice));

		if (res == 1) {
			out.println("<h5>Product updated successfully.</h5>");
		}

		else {
			out.println("<h5>Product couldn't be updated.</h5>");
		}

	}

}
