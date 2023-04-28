package com.nagarro.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.dao.RegisterDao;

@Controller
public class RegisterController {

	@RequestMapping("/Register")
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) {

		String uname = request.getParameter("uname");
		String pass = request.getParameter("pass");
		RegisterDao register = new RegisterDao();
		ModelAndView mv = new ModelAndView();
		if (register.registerUser(uname, pass)) {
			mv.setViewName("login.jsp");
		} else {
			mv.setViewName("register.jsp");
		}
		return mv;
	}

}
