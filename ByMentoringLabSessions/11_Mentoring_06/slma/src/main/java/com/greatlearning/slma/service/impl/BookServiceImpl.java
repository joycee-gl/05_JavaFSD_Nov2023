package com.greatlearning.slma.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.slma.entity.Book;
import com.greatlearning.slma.repository.BookRepository;
import com.greatlearning.slma.service.BookService;

@Service
public class BookServiceImpl implements BookService {

  @Autowired
  BookRepository bookRepository;

  @Override
  public List<Book> findAll() {
    List<Book> books = bookRepository.findAll();
    return books;
  }
  
  @Override
  public void save(Book book) {
      bookRepository.save(book);                    
  }  
  
  @Override
  public Book findById(int bookId) {
      return bookRepository.findById(bookId).get();
  }  
  
  @Override
  public void saveOrUpdate(int id, String name, String category, String author) {

    System.out.println("Book ID ->" + id);

    Book bookObj = null;
    if (id == 0) {

      bookObj = new Book(name, category, author);
      System.out.println("Add Book Scenario");
    } else {

      System.out.println("Update Book Scenario");

      bookObj = this.findById(id);
      bookObj.setName(name);
      bookObj.setCategory(category);
      bookObj.setAuthor(author);
    }

    // Save/Update the book
    this.save(bookObj);
  }          
  
  @Override
  public void deleteById(int id) {
      bookRepository.deleteById(id);    
  }  
  
  @Override
  public List<Book> searchBy(String name, String author) {
    List<Book> books 
      = bookRepository.findByNameContainsAndAuthorContainsAllIgnoreCase(
        name, author);
    return books;
  }  

}  