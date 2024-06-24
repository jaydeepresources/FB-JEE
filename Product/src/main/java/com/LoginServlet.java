package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.Login;
import com.dao.LoginDAOImpl;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		String username = request.getParameter("username");
		String userPassword = request.getParameter("userPassword");
		Login login = new Login(0, username, userPassword);

		HttpSession session = request.getSession();
		session.setAttribute("user", username);
		
		LoginDAOImpl impl = new LoginDAOImpl();

		if (impl.signIn(login)) {
			out.println("<h2>Login successfull.</h2>");
			RequestDispatcher rd1 = request.getRequestDispatcher("index.html");
			rd1.forward(request, response);
		} else {
			out.println("<h2>Login not successfull.</h2>");
			RequestDispatcher rd1 = request.getRequestDispatcher("login.html");
			rd1.include(request, response);
		}
	}

}
