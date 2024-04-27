package com.greatlearning.slma.service;

import java.util.List;
import com.greatlearning.slma.entity.Book;

public interface BookService {

  public List<Book> findAll();
  
  public void save(Book book);  
  
  public Book findById(int id);
  
  public void saveOrUpdate(int id, String name, String category, String author);
  
  public void deleteById(int id);
  
  public List<Book> searchBy(String name, String author);

}  