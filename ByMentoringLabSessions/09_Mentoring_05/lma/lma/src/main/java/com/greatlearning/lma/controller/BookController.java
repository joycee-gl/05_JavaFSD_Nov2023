package com.greatlearning.lma.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatlearning.lma.entity.Book;
import com.greatlearning.lma.service.BookService;

@Controller
@RequestMapping("/books")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@RequestMapping("/list")
	public String listBooks(Model theModel) {
		
		//get books from the DB
		List<Book> theBooks = bookService.findAll();
		
		//add the books to the spring model
		theModel.addAttribute("books", theBooks);
		
		return "books/list-books";
	}

	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		//create model attribute to bind the form data
		Book theBook = new Book();
		
		theModel.addAttribute("book", theBook);
		
		return "books/book-form";
	}
	
	@PostMapping("/save")
	public String saveBook(
		@ModelAttribute("book") Book theBook ) {
		
		//save the book
		bookService.save(theBook);
		
		return "redirect:/books/list";		
	}
	
	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("bookId") int bookId , 
			Model theModel) {
		
		//get the particular book from the service
		Book theBook = bookService.findById(bookId);
		
		//set this book as a model attribute to pre-populate the form 
		theModel.addAttribute("book", theBook);
		
		//send over to the form
		return "books/book-form";
		
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam("bookId") int bookId) {
		
		//delete the book from DB
		bookService.deleteById(bookId);
		
		//redirect to /books/list
		return "redirect:/books/list";
	}
	
}
