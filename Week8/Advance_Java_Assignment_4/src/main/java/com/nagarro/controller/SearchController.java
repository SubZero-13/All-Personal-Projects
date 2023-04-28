package com.nagarro.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.dao.SearchDao;
import com.nagarro.entities.Tshirt;
import com.nagarro.exceptions.ItemNotPresentException;

@Controller
public class SearchController {

	@RequestMapping("/Search")
	public ModelAndView search(HttpServletRequest request, HttpServletResponse response) {
		String color = request.getParameter("colour");
		String size = request.getParameter("size");
		String gender = request.getParameter("gender");
		String preference = request.getParameter("outputPreference");
		ModelAndView mv = new ModelAndView();

		SearchDao searchdao = new SearchDao();
		HttpSession session = request.getSession();

		List<Tshirt> tshirts = searchdao.searchTshirt(color, gender, size, preference);
		if (tshirts.size() == 0) {
			session.removeAttribute("tshirts");
			mv.setViewName("home.jsp");
			return mv;
		} else {
			session.removeAttribute("tshirts");
			session.setAttribute("tshirts", tshirts);
			mv.setViewName("home.jsp");
			return mv;
		}

	}

}
