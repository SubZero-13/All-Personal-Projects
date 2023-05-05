package com.nagarro.initializer.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.nagarro.initializer.entities.Book;

@Service
public class BookService {

	private RestTemplate restTemplate;
	private String url = "http://localhost:8085/";

	public BookService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public List<Book> getAllBooks() {
		ResponseEntity<Book[]> response = restTemplate.getForEntity(url + "book", Book[].class);

		Book[] books = response.getBody();

		List<Book> list = new ArrayList<Book>();

		for (Book book : books)
			list.add(book);
		return list;
	}

	public List<Book> deleteBook(int bookid) {
		restTemplate.delete(url + "deleteBook/" + bookid);

		// Use HTTP GET method to get the updated list of books
		ResponseEntity<Book[]> bookResponse = restTemplate.getForEntity(url + "book", Book[].class);
		Book[] books = bookResponse.getBody();

		List<Book> list = new ArrayList<Book>();
		for (Book book : books) {
			list.add(book);
		}
		return list;
	}
}
