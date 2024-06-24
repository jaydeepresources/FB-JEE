package com;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.Product;
import com.dao.ProductDAOImpl;
 
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		if (session == null || ((String) session.getAttribute("user")) == null) {
			response.sendRedirect("http://localhost:8080/Product/login.html");
			return;
		}
		
		ProductDAOImpl impl = new ProductDAOImpl();
		
		List<Product> products = impl.searchProducts(request.getParameter("productName"));
		
		// send this data to jsp for display
		HttpSession session1 = request.getSession(false);
		session1.setAttribute("products", products);
		
		// go to search_results.jsp
		request.getRequestDispatcher("search_results.jsp").forward(request, response);
		
	}

}
