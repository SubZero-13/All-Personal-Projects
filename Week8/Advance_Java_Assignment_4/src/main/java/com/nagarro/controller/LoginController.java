package com.nagarro.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.dao.LoginDao;

@Controller
public class LoginController {

	@RequestMapping("/Login")
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) {

		String username = request.getParameter("uname");
		String password = request.getParameter("pass");

		LoginDao logindao = new LoginDao();
		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession();

		if (logindao.checkLogin(username, password)) {
			session.setAttribute("username", username);
			mv.setViewName("home.jsp");
		} else {
			session.setAttribute("errorMessage", "Username Or Password is Invalid!!!");
			mv.setViewName("login.jsp");
		}

		return mv;
	}

}
