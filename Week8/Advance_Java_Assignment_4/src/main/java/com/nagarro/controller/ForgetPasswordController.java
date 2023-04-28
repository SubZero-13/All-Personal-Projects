package com.nagarro.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.dao.ForgetPassDao;

@Controller
public class ForgetPasswordController {

	@RequestMapping("/Forget")
	public ModelAndView forget(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String uname = request.getParameter("uname");
		String pass = request.getParameter("pass");

		ForgetPassDao dao = new ForgetPassDao();
		ModelAndView mv = new ModelAndView();

		if (dao.forgetPass(uname, pass)) {
			mv.setViewName("login.jsp");
		} else
			mv.setViewName("forgetPassword.jsp");

		return mv;
	}
}
