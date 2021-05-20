package com.library.service;

import java.util.List;

import com.library.model.Book;

public interface BookService {
	Book findByName(String name);

	List<Book> findAll();

	Book save(Book book);

	void delete(Book book);
}
