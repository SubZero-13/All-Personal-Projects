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

import com.nagarro.initializer.entities.Author;
import com.nagarro.initializer.service.AuthorService;

@RestController
public class AuthorController {

	@Autowired
	private AuthorService authorService;

	@PostMapping("/author")
	public Author addAuthor(@RequestBody Author author) {
		/* author.setId(1); */

		authorService.save(author);

		return author;
	}

	@GetMapping("/author")
	public List<Author> findAllAuthor() {
		return (List<Author>) authorService.findAll();
	}

	@GetMapping("/author/{id}")
	public Author getAuthor(@PathVariable int id) {

		Author author = authorService.findById(id).orElse(null);

		if (author == null) {
			throw new RuntimeException("Author id not found - " + id);
		}

		return author;
	}

	@PutMapping("/updateAuthor/{id}")
	public Author updateAuthor(@RequestBody Author author, @PathVariable int id) {

		author.setId(id);
		authorService.save(author);

		return author;
	}

	@DeleteMapping("/deleteAuthor/{id}")
	public void deleteAuthor(@PathVariable int id) {
		authorService.deleteById(id);
	}

}
