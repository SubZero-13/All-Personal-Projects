package com.nagarro.initializer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.initializer.dao.AuthorService;
import com.nagarro.initializer.dao.BookService;
import com.nagarro.initializer.entities.Author;
import com.nagarro.initializer.entities.Book;

@RestController
public class BookController {

	@Autowired
	private BookService bookService;
	@Autowired
	private AuthorService authorService;

	@PostMapping("/book")
	public Book addBook(@RequestBody Book book) {

		// also just in case they pass an id in JSON ... set id to 0
		// this is to force a save of new item ... instead of update
		/* book.setId(1); */
		bookService.save(book);

		return book;
	}

	@PostMapping("/book/{id}")
	public Book addBookByAuthorId(@RequestBody Book book, @PathVariable int id) {

		// also just in case they pass an id in JSON ... set id to 0
		// this is to force a save of new item ... instead of update

		/* book.setId(1); */

		Author auth = authorService.findById(id).orElse(null);

		if (auth != null) {
			book.setAuthor(auth);
		}

		bookService.save(book);

		return book;
	}

	@GetMapping("/book")
	public List<Book> findAll() {
		return (List<Book>) bookService.findAll();
	}

	@GetMapping("/book/{id}")
	public Book getBook(@PathVariable int id) {

		Book book = bookService.findById(id).orElse(null);

		return book;
	}

	@PutMapping("/updateBook")
	public Book updateBook(@RequestBody Book book) {
		bookService.save(book);
		return book;
	}

	// used if no change is made to author
	@PutMapping("/updateBook/{bookId}")
	public Book updateBook(@RequestBody Book book, @PathVariable int bookId) {

		book.setId(bookId);
		bookService.save(book);

		return book;
	}

	@PutMapping("/book/{bookId}/{authorId}")
	public Book updateBookWithAuthor(@RequestBody Book book, @PathVariable int bookId, @PathVariable int authorId) {

		// also just in case they pass an id in JSON ... set id to 0
		// this is to force a save of new item ... instead of update

		book.setId(bookId);

		Author auth = authorService.findById(authorId).orElse(null);

		if (auth != null) {
			book.setAuthor(auth);
		}

		bookService.save(book);

		return bookService.findById(bookId).orElse(new Book());
	}

	@DeleteMapping("/deleteBook/{id}")
	public void deleteBook(@PathVariable int id) {
		bookService.deleteById(id);
	}

}
