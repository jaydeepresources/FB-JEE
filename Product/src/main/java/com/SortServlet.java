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
 
@WebServlet("/SortServlet")
public class SortServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ProductDAOImpl impl = new ProductDAOImpl();
		
		List<Product> sortedProducts = impl.sortProduct(request.getParameter("criteria"));
		
		HttpSession session = request.getSession(false);
		session.setAttribute("sortedProducts", sortedProducts);
		
		request.getRequestDispatcher("sort_view.jsp").forward(request, response);
		
	}

}
