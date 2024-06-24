package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.ProductDAOImpl;

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
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
		
		ProductDAOImpl impl = new ProductDAOImpl();
		int res = impl.deleteProduct(Integer.parseInt(request.getParameter("productId")));
		
		if(res > 0)
			out.println("<h4>Product deleted.</h4>");
		else
			out.println("<h4>Product couldn't be deleted.</h4>");

	}

}
