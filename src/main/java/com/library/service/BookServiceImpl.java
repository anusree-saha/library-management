package com.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.model.Book;
import com.library.repository.BookRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;

	public Book findByName(String name) {
		log.info("Find book by name");
		return bookRepository.findByName(name);
	}

	public List<Book> findAll() {
		log.info("Find all books");
		return bookRepository.findAll();
	}

	public Book save(Book book) {
		log.info("Save book");
		return bookRepository.save(book);
	}

	public void delete(Book book) {
		log.info("Delete book");
		bookRepository.delete(book);
	}

}
