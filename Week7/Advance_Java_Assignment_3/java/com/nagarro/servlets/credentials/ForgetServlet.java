package com.nagarro.servlets.credentials;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nagarro.dao.ForgetPassDao;

@WebServlet("/Forget")
public class ForgetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname = request.getParameter("uname");
		String pass = request.getParameter("pass");

		ForgetPassDao dao = new ForgetPassDao();

		if (dao.forgetPass(uname, pass)) {
			response.sendRedirect("login.jsp");
		}

		else
			response.sendRedirect("ForgetPassword.jsp");
	}

}
