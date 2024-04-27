package com.greatlearning.slma.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greatlearning.slma.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer>{
	
	java.util.List<Book> findByNameContainsAndAuthorContainsAllIgnoreCase(String name,String author);  

}
