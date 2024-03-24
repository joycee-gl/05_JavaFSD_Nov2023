package com.greatlearning.lma.service;

import java.util.List;

import com.greatlearning.lma.entity.Book;

public interface BookService {
	
	public List<Book> findAll();
	
	public void save(Book theBook);

	public Book findById(int bookId);
	
	public void deleteById(int bookId);
	
}
