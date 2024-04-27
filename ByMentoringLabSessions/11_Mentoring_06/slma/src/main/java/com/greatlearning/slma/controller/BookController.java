package com.greatlearning.slma.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.greatlearning.slma.entity.Book;
import com.greatlearning.slma.service.BookService;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;    

import org.springframework.web.servlet.ModelAndView;
import java.security.Principal;    

@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;
    
    @RequestMapping("/list")
    public String listBooks(Model theModel) {
        
        List<Book> theBooks = bookService.findAll();

        theModel.addAttribute("books", theBooks);                

        return "list-books";
    }
    
    @RequestMapping("/displayBookForm")
    public String addBook_Step1(Model theModel) {

        Book book = new Book();

        theModel.addAttribute("book", book);

        return "book-form";
    }    
    
    @PostMapping("/save")
    public String saveBook(@RequestParam("id") int id, @RequestParam("name") String name,
        @RequestParam("category") String category, @RequestParam("author") String author) {

      bookService.saveOrUpdate(id, name, category, author);
      
      // use a redirect to 'books-listing'
      return "redirect:/books/list";
    }  
    
    @RequestMapping("/displayBookForm_Update")
    public String updateBook_Step1(
        @RequestParam("bookId") int bookId,
            Model theModel) {

        Book book = bookService.findById(bookId);

        // set Book as a model attribute to pre-populate the form
        theModel.addAttribute("book", book);

        // send over to our form
        return "book-form";   
    }  
    
    @RequestMapping("/delete")
    public String delete(@RequestParam("bookId") int bookId) {

        // delete the Book
        bookService.deleteById(bookId);

        // redirect to 'books-listing'
        return "redirect:/books/list";
    }  
    
    @RequestMapping("/search")
    public String search(@RequestParam("name") String name, @RequestParam("author") String author, Model theModel) {

      // Check the name and the author names
      // If both of them are empty, then just give list of all Books
      if (name.trim().isEmpty() && author.trim().isEmpty()) {
        return "redirect:/books/list";
      } else {

        // Else, search by 'book name' and 'author'
        List<Book> books = bookService.searchBy(name, author);

        // Add it to the UI Model
        theModel.addAttribute("books", books);

        // Returns the 'books-listing' page
        return "list-books";
      }
    }            
    
    @RequestMapping(value = "/403")
    public ModelAndView handleAccessDeniedError(Principal user) {

      ModelAndView model = new ModelAndView();

      if (user != null) {
        model.addObject("msg", "Hi " + user.getName() + ", you do not have permission to access this page!");
      } else {
        model.addObject("msg", "You do not have permission to access this page!");
      }

      model.setViewName("authorization-error-403");
      return model;
    }    
}  