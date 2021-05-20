package com.library.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.library.model.Book;

public interface BookRepository extends CrudRepository<Book, Long>{
	
	Book findByName(String name);
	
	List<Book> findAll();
	
//	Book save(Book book);
	
	void delete(Book book);

}
