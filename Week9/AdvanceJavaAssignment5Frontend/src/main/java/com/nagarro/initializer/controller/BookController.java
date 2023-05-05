package com.nagarro.initializer.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.nagarro.initializer.entities.Author;
import com.nagarro.initializer.entities.Book;
import com.nagarro.initializer.services.BookService;

@Controller
@RequestMapping("/book")
public class BookController {

	@Autowired
	private BookService bookService;

	private RestTemplate restTemplate;
	private String url = "http://localhost:8085/";

	public BookController(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	/*
	 * @RequestMapping("") public String book(Model model) { List<Book> list =
	 * bookService.getAllBooks(); model.addAttribute("books", list); return
	 * "book-list.jsp"; }
	 */

	@PostMapping("/register")
	public String registerBook(@ModelAttribute("book") Book book, HttpServletRequest req, Model model) {

		System.out.println(book);

		ResponseEntity<Author> response = restTemplate.getForEntity(url + "author/" + book.getAuthor().getId(),
				Author.class);

		System.out.println(book.getId());

		int bookId = Integer.parseInt(req.getParameter("id"));
		book.setId(bookId);
		book.setAuthor(response.getBody());
		book.setDate("" + java.time.LocalDate.now());

		System.out.println(">> " + book);

		if (bookId == 0)
			restTemplate.postForEntity(url + "book", book, Book.class);
		else
			restTemplate.postForEntity(url + "updateBook", book, Book.class);
		String path = req.getContextPath();

		return path + "/book";

	}

	@RequestMapping("/showFormForUpdate/{id}")
	public String showForUpdate(HttpServletRequest req, @PathVariable int id, Model model) {

		ResponseEntity<Book> bookResponse = restTemplate.getForEntity(url + "book/" + id, Book.class);

		Book book = bookResponse.getBody();

		ResponseEntity<Author[]> response = restTemplate.getForEntity(url + "author", Author[].class);

		Author[] author = response.getBody();

		HashMap<Integer, String> hm = new HashMap<Integer, String>();

		for (Author auth : author)
			hm.put(auth.getId(), auth.getName());

		model.addAttribute("authorMap", hm);

		model.addAttribute("book", book);

		model.addAttribute("id", id);

		String path = req.getContextPath();

		return path + "/book-form.jsp";
	}

	@PostMapping("/formForNewBook")
	public String bookForm(HttpServletRequest req, Model model) {

		ResponseEntity<Author[]> response = restTemplate.getForEntity(url + "author", Author[].class);

		Author[] author = response.getBody();

		HashMap<Integer, String> hm = new HashMap<Integer, String>();

		for (Author auth : author)
			hm.put(auth.getId(), auth.getName());

		model.addAttribute("authorMap", hm);
		model.addAttribute("book", new Book());
		model.addAttribute("id", 0);

		String path = req.getContextPath();

		return path + "/EditBook.jsp";

	}

	@RequestMapping("/delete/{id}")
	public String deleteBook(HttpServletRequest req, Model model, @PathVariable int id) {

		List<Book> list = bookService.deleteBook(id);

		model.addAttribute("books", list);

		String path = req.getContextPath();

		return path + "/book-list.jsp";
	}

}
