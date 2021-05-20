package com.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.library.model.Book;
import com.library.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {

	@Autowired
	private BookService bookService;

	@GetMapping(value = "/byName/{bookName}")
	public Book getBookByName(@PathVariable("bookName") String bookName) {
		return bookService.findByName(bookName);
	}

	@GetMapping(value = "/")
	public List<Book> getAllBooks() {
		return bookService.findAll();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping(value = "/save")
	public ResponseEntity<?> save(@RequestBody Book book) {
		bookService.save(book);
		return new ResponseEntity("Book added successfully", HttpStatus.OK);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@DeleteMapping(value = "/delete/{bookName}")
	public ResponseEntity<?> delete(@PathVariable String bookName) {
		bookService.delete(bookService.findByName(bookName));
		return new ResponseEntity("Book deleted successfully", HttpStatus.OK);
	}

}
