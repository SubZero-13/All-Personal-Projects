package com.nagarro.initializer.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.initializer.entities.Book;
import com.nagarro.initializer.services.BookService;
import com.nagarro.initializer.services.UserService;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;

	@Autowired
	private BookService bookService;

	@RequestMapping("/")
	public String home() {
		return "login.jsp";
	}

	@RequestMapping("/login")
	public ModelAndView login(HttpServletRequest req) {

		int id = Integer.parseInt(req.getParameter("userid"));
		String password = req.getParameter("password");

		ModelAndView mv = new ModelAndView();

		if (userService.checkUser(id, password)) {
			mv.addObject("userid", id);
			List<Book> list = bookService.getAllBooks();
			mv.addObject("books", list);
			mv.setViewName("book-list.jsp");
		} else {
			mv.setViewName("login.jsp");
		}
		return mv;
	}

}
