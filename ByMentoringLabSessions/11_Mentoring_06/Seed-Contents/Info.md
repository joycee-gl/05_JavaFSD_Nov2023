
# Create Starter Project

- URL
  ```
  http://localhost:8080
  ```


# Lombok Configuration


- Java Path
  - Example-1
    ```
    set PATH=C:\Softwares\Oracle\Java17\JDK-17\bin;%PATH%;
    ```

- Lombok Path
  - Example-1
    ```
    SET LOMBOK_LIBRARY_JAR_PATH=C:\Users\queen\.m2\repository\org\projectlombok\lombok\1.18.32\lombok-1.18.32.jar
    ```

- Lombok Installation
  ```
  java -jar %LOMBOK_LIBRARY_JAR_PATH%
  ```

# Welcome Page

- application.properties
  ```
  server.servlet.context-path=/slma
  server.port=9999

  spring.mvc.view.prefix=/WEB-INF/views/
  spring.mvc.view.suffix=.jsp  
  ```

- pom.xml
  ```
  <dependency>
      <groupId>org.apache.tomcat.embed</groupId>
      <artifactId>tomcat-embed-jasper</artifactId>
  </dependency>

  <dependency>
      <groupId>jakarta.servlet.jsp.jstl</groupId>
      <artifactId>jakarta.servlet.jsp.jstl-api</artifactId>
  </dependency>
      
  <dependency>
      <groupId>jakarta.servlet.jsp</groupId>
      <artifactId>jakarta.servlet.jsp-api</artifactId>
      <version>3.1.1</version>
      <scope>provided</scope>
  </dependency>
      
  <dependency>
      <groupId>org.glassfish.web</groupId>
      <artifactId>jakarta.servlet.jsp.jstl</artifactId>
  </dependency>  
  ```


- WelcomeController
  ```
  package com.greatlearning.slma.controller;

  import org.springframework.stereotype.Controller;
  import org.springframework.web.bind.annotation.RequestMapping;

  @Controller
  public class WelcomeController {

    @RequestMapping("/welcome")
    public String displayWelcomePage() {
      return "welcome";
    }
  }  
  ```

- welcome.jsp
  ```
  <%@ page import="java.util.Date"%>

  <html>

  <body>
    <h1>Spring Boot - Welcome to Secure Library Management System</h1>

    <%
        Date date = new Date();
    %>

    <h3>
      Current Date and Time is
      <%=date%>
    </h3>
  </body>

  </html>  
  ```

- URL
  ```
  http://localhost:9999/slma/welcome
  ```


# Listing Books

- pom.xml
  ```
  <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-data-jpa</artifactId>
  </dependency>

  <dependency>
      <groupId>com.mysql</groupId>
      <artifactId>mysql-connector-j</artifactId>
  </dependency>  
  ```

- application.properties
  ```
  spring.datasource.url=jdbc:mysql://localhost:3306/slma

  spring.datasource.username=root
  spring.datasource.password=mypassword_11 / password11
  spring.jpa.hibernate.ddl-auto=update

  spring.jpa.show-sql=true  
  ```

- Book
  ```
  package com.greatlearning.slma.entity;

  import jakarta.persistence.Column;
  import jakarta.persistence.Entity;
  import jakarta.persistence.GeneratedValue;
  import jakarta.persistence.GenerationType;
  import jakarta.persistence.Id;
  import jakarta.persistence.Table;
  import lombok.Getter;
  import lombok.Setter;

  @Entity
  @Table(name = "book")
  @Getter
  @Setter
  public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "AUTHOR")
    private String author;

    @Column(name = "CATEGORY")
    private String category;

    public Book() {
    }

    public Book(String name, String category, String author) {
      this.name = name;
      this.category = category;
      this.author = author;
    }
  }          
  ```


- BookRepository
  ```
  package com.greatlearning.slma.repository;

  import org.springframework.data.jpa.repository.JpaRepository;
  import com.greatlearning.slma.entity.Book;

  public interface BookRepository extends JpaRepository<Book, Integer> {

  }  
  ```

- BookService
  ```
  package com.greatlearning.slma.service;

  import java.util.List;
  import com.greatlearning.slma.entity.Book;

  public interface BookService {

    public List<Book> findAll();

  }  
  ```

- BookServiceImpl
  ```
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

  }  
  ```


- BookController
  ```
  package com.greatlearning.slma.controller;

  import java.util.List;

  import org.springframework.beans.factory.annotation.Autowired;
  import org.springframework.stereotype.Controller;
  import org.springframework.ui.Model;
  import org.springframework.web.bind.annotation.RequestMapping;

  import com.greatlearning.slma.entity.Book;
  import com.greatlearning.slma.service.BookService;

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
  }  
  ```

- list-books.jsp
  ```
  <%@ page contentType="text/html;charset=UTF-8" language="java"%>
  <%@ taglib prefix="c" uri="jakarta.tags.core"%>

  <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
  <html>

  <head>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport"
    content="width=device-width, initial-scale=1, shrink-to-fit=no">

  <!-- Bootstrap CSS -->
  <link rel="stylesheet"
    href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
    integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
    crossorigin="anonymous">

  <title>Books Directory</title>
  </head>

  <body>

    <div class="container">

      <h3>Books Directory</h3>
      <hr>

      <table class="table table-bordered table-striped">
        <thead class="thead-dark">
          <tr>
            <th>Name</th>
            <th>Category</th>
            <th>Author</th>
            <th>Action</th>
          </tr>
        </thead>

        <tbody>
          <c:forEach items="${books}" var="bookObj">
            <tr>
              <td><c:out value="${bookObj.name}" /></td>
              <td><c:out value="${bookObj.category}" /></td>
              <td><c:out value="${bookObj.author}" /></td>
            </tr>
          </c:forEach>

        </tbody>
      </table>

    </div>

  </body>

  </html>  
  ```

- URL
  - http://localhost:9999/slma/books/list

- Database Cleanup
  ```
  -- Disable safe updates
  SET SQL_SAFE_UPDATES = 0;

  -- Delete any existing rows
  delete from book;

  -- Revert to the previous value
  SET SQL_SAFE_UPDATES = 1;  
  ```

- Sample Data
  ```
  INSERT INTO book (id, author, name, category) VALUES (1, 'Mary Shelley', 'Frankenstein', 'General');
  INSERT INTO book (id, author, name, category) VALUES (2, 'Emily Brontë', 'Wuthering Heights', 'General');
  INSERT INTO book (id, author, name, category) VALUES (3, 'Fyodor Dostoevsky', 'Crime and Punishment', 'General');
  INSERT INTO book (id, author, name, category) VALUES (4, 'Henrik Ibsen', 'Peer Gynt', 'General');
  INSERT INTO book (id, author, name, category) VALUES (5, 'Leo Tolstoy', 'War and Peace', 'General');
  INSERT INTO book (id, author, name, category) VALUES (6, 'Leo Tolstoy', 'Anna Karenina', 'General');
  INSERT INTO book (id, author, name, category) VALUES (7, 'Henrik Ibsen', 'A Doll''s House', 'General');
  INSERT INTO book (id, author, name, category) VALUES (8, 'Fyodor Dostoevsky', 'The Brothers Karamazov', 'General');
  INSERT INTO book (id, author, name, category) VALUES (9, 'Thomas Mann', 'Buddenbrooks', 'General');
  INSERT INTO book (id, author, name, category) VALUES (10, 'Rabindranath Tagore', 'Gitanjali', 'General');
  insert into book (id, name, author, category) values (11, 'Harry Potter - Series', 'JK Rowling', 'Fantasy');
  insert into book (id, name, author, category) values (12, 'Java Programmming', 'Martin Fowler', 'Programming');  
  ```

- WelcomeController
  ```
  @RequestMapping("/")
  public String defaultApplicationHomePage() {
      
      return "redirect:/books/list";    	
  }  
  ```

# Add Book

- BookService
  ```
  public void save(Book book);  
  ```

- BookServiceImpl
  ```
  @Override
  public void save(Book book) {
      bookRepository.save(book);                    
  }  
  ```

- BookController
  - Snippet-1
    ```
    @RequestMapping("/displayBookForm")
    public String addBook_Step1(Model theModel) {

        Book book = new Book();

        theModel.addAttribute("book", book);

        return "book-form";
    }    
    ```
  - Snippet-2
    ```
    @PostMapping("/save")
    public String saveBook(@RequestParam("id") int id, @RequestParam("name") String name,
        @RequestParam("category") String category, @RequestParam("author") String author) {

      System.out.println("Book ID ->" + id);

      Book bookObj = null;
      if (id == 0) {

        bookObj = new Book(name, category, author);
        System.out.println("Add Book Scenario");
      } else {

        System.out.println("Update Book Scenario");
      }

      // Save/Update the book
      bookService.save(bookObj);

      // use a redirect to 'books-listing'
      return "redirect:/books/list";
    }    
    ```
  - Snippet-3
    ```
    import org.springframework.web.bind.annotation.RequestParam;
    import org.springframework.web.bind.annotation.PostMapping;    
    ```

- list-books.jsp
  ```
  <!-- Add Button Support -->
  <c:url var="addUrl" value="/books/displayBookForm" />
  <a href="${addUrl}" class="btn btn-primary btn-sm mb-3"> Add Book
  </a>  
  ```

- book-form.jsp
  ```
  <%@ page contentType="text/html;charset=UTF-8" language="java"%>

  <%@ taglib prefix="c" uri="jakarta.tags.core"%>

  <!DOCTYPE html>
  <html>

  <head>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport"
    content="width=device-width, initial-scale=1, shrink-to-fit=no">

  <!-- Bootstrap CSS -->
  <link rel="stylesheet"
    href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
    integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
    crossorigin="anonymous">

  <title>Save Book</title>
  </head>

  <body>

    <div class="container">

      <h3>New Book Creation</h3>
      <hr>

      <p class="h4 mb-4">Book Details</p>

      <c:url var="saveUrl" value="/books/save" />

      <form action="${saveUrl}" method="POST">

        <!-- Add hidden form field to handle update -->
        <input type="hidden" name="id" value="${book.id}" />

        <div class="form-inline">
          <input type="text" name="name" value="${book.name}"
            class="form-control mb-4 col-4" placeholder="Name" />
        </div>

        <div class="form-inline">

          <input type="text" name="category" value="${book.category}"
            class="form-control mb-4 col-4" placeholder="Category" />
        </div>

        <div class="form-inline">

          <input type="text" name="author" value="${book.author}"
            class="form-control mb-4 col-4" placeholder="Author" />

        </div>

        <button type="submit" class="btn btn-info col-2">Save</button>

      </form>

      <hr>
      <c:url var="listUrl" value="/books/list" />

      <a href="${listUrl}">Back to Books List</a>

    </div>
  </body>

  </html>          
  ```

# Editing Books

- BookService
  ```
  public Book findById(int id);
  ```

- BookServiceImpl
  ```
  @Override
  public Book findById(int bookId) {
      return bookRepository.findById(bookId).get();
  }  
  ```

- BookController
  - Snippet-1
    ```
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
    ```
  - Snippet-2
    ```
    bookObj=bookService.findById(id);
    bookObj.setName(name);
    bookObj.setCategory(category);
    bookObj.setAuthor(author);    
    ```

- list-books.jsp
  ```
  <td>
    <!-- Add "update" button/link --> 
    <c:url var="updateUrl"
      value="/books/displayBookForm_Update?bookId=${bookObj.id}" /> 
    <a href="${updateUrl}" class="btn btn-info btn-sm"> 
      Update 
    </a>
  </td>  
  ```

# Refactoring 

- BookService
  ```
  public void saveOrUpdate(int id, String name, String category, String author);
  ```

- BookServiceImpl
  ```
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
  ```

- BookController
  ```
  @PostMapping("/save")
  public String saveBook(@RequestParam("id") int id, @RequestParam("name") String name,
      @RequestParam("category") String category, @RequestParam("author") String author) {

    bookService.saveOrUpdate(id, name, category, author);
    
    // use a redirect to 'books-listing'
    return "redirect:/books/list";
  }  
  ```


# Delete Books

- BookService
  ```
  public void deleteById(int id);
  ```

- BookServiceImpl
  ```
  @Override
  public void deleteById(int id) {
      bookRepository.deleteById(id);    
  }  
  ```

- BookController
  ```
  @RequestMapping("/delete")
  public String delete(@RequestParam("bookId") int bookId) {

      // delete the Book
      bookService.deleteById(bookId);

      // redirect to 'books-listing'
      return "redirect:/books/list";
  }  
  ```

- list-books.jsp
  ```
  <!-- Add "delete" button/link -->							
  <c:url var="deleteUrl" value="/books/delete?bookId=${bookObj.id}" />				
  <a href="${deleteUrl}" class="btn btn-danger btn-sm"
    onclick="if (!(confirm('Are you sure you want to delete this book?'))) return false">
    Delete 
  </a>  
  ```

# Searching Books

- BookRepository
  ```
  java.util.List<Book> findByNameContainsAndAuthorContainsAllIgnoreCase(String name,String author);  
  ```

- BookService
  ```
  public List<Book> searchBy(String name, String author);
  ```

- BookServiceImpl
  ```
  @Override
  public List<Book> searchBy(String name, String author) {
    List<Book> books 
      = bookRepository.findByNameContainsAndAuthorContainsAllIgnoreCase(
        name, author);
    return books;
  }  
  ```

- BookController
  ```
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
  ```

- list-books.jsp
  ```
  <c:url var="searchUrl" value="/books/search" />
  <form action="${searchUrl}" class="form-inline">

    <input type="search" name="name" placeholder="Name"
      class="form-control-sm mr-2 mb-3" /> 
    
    <input type="search" name="author" placeholder="Author" 
      class="form-control-sm mr-2 mb-3" />

    <button type="submit" class="btn btn-success btn-sm mb-3">
      Search
    </button>
  </form>  
  ```


# Security Features

## Default Spring Security

- pom.xml
  ```
  <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
  </dependency>      
  ```

## Adding Authentication Support

- N/A

### Customize Authentication Credentials

- application.properties
  ```
  spring.security.user.name=book_admin_user
  spring.security.user.password=book_admin_password  
  ```

### Database-based Authentication Support

- User
  ```
  package com.greatlearning.slma.security.entity;

  import jakarta.persistence.Column;
  import jakarta.persistence.Entity;
  import jakarta.persistence.GeneratedValue;
  import jakarta.persistence.GenerationType;
  import jakarta.persistence.Id;
  import jakarta.persistence.Table;
  import lombok.Data;

  @Entity
  @Table(name = "users")
  @Data
  public class User {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

  }        
  ```

- UserRepository

  ```
  package com.greatlearning.slma.security.repository;

  import org.springframework.data.jpa.repository.JpaRepository;
  import org.springframework.data.jpa.repository.Query;

  import com.greatlearning.slma.security.entity.User;

  public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.username = ?1")
    public User getUserByUsername(String username);

  }        
  ```

- SlmaUserDetails

  ```
  package com.greatlearning.slma.security.entity;

  import java.util.ArrayList;
  import java.util.Collection;
  import java.util.List;

  import org.springframework.security.core.GrantedAuthority;
  import org.springframework.security.core.authority.SimpleGrantedAuthority;
  import org.springframework.security.core.userdetails.UserDetails;

  public class SlmaUserDetails implements UserDetails {

    private User user;

    public SlmaUserDetails(User user) {
      this.user = user;
    }

    @Override
    public String getPassword() {
      return user.getPassword();
    }

    @Override
    public String getUsername() {
      return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
      return true;
    }

    @Override
    public boolean isAccountNonLocked() {
      return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
      return true;
    }

    @Override
    public boolean isEnabled() {
      return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

      List<SimpleGrantedAuthority> authorities = new ArrayList<>();

      return authorities;
    }

  }        
  ```

- SlmaUserDetailsServiceImpl
  ```
  package com.greatlearning.slma.security.service.impl;

  import org.springframework.beans.factory.annotation.Autowired;
  import org.springframework.security.core.userdetails.UserDetails;
  import org.springframework.security.core.userdetails.UserDetailsService;
  import org.springframework.security.core.userdetails.UsernameNotFoundException;

  import com.greatlearning.slma.security.entity.SlmaUserDetails;
  import com.greatlearning.slma.security.entity.User;
  import com.greatlearning.slma.security.repository.UserRepository;

  public class SlmaUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

      User user = userRepository.getUserByUsername(username);

      if (user == null) {
        throw new UsernameNotFoundException("Could not find user");
      }

      return new SlmaUserDetails(user);
    }
  }  
  ```

- SlmaSecurityConfiguration

  ```
  package com.greatlearning.slma.security.web;

  import org.springframework.context.annotation.Bean;
  import org.springframework.context.annotation.Configuration;
  import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
  import org.springframework.security.core.userdetails.UserDetailsService;
  import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
  import org.springframework.security.crypto.password.PasswordEncoder;

  import com.greatlearning.slma.security.service.impl.SlmaUserDetailsServiceImpl;

  @Configuration
  public class SlmaSecurityConfiguration {

    @Bean
    public UserDetailsService userDetailsService() {
      return new SlmaUserDetailsServiceImpl();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
      return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider slmaDaoAuthenticationProvider() {

      DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();

      authProvider.setUserDetailsService(userDetailsService());
      authProvider.setPasswordEncoder(passwordEncoder());

      return authProvider;
    }
  }  
  ```

- Database Cleanup Script
  ```
  -- Disable safe updates
  SET SQL_SAFE_UPDATES = 0;

  -- Delete any existing rows
  delete from users;

  -- Revert to the previous value
  SET SQL_SAFE_UPDATES = 1;          
  ```

- Password
  - Plain password
    ```
    mypassword
    ```
  - Encrypted Password
    ```
    $2a$12$SnQXQrEzEAD8pj/3KGVhneF0R1BsRug5a.ON9Up0Qfucdoci7Uvbe
    ```

- Database Script
  ```
  -- This corresponds to the plain text password value - 'mypassword'
  set @SLMA_PASSWORD = '$2a$12$SnQXQrEzEAD8pj/3KGVhneF0R1BsRug5a.ON9Up0Qfucdoci7Uvbe';

  insert into users (user_id, username, password) values (1, 'varun', @SLMA_PASSWORD);

  insert into users (user_id, username, password) values (2, 'sanjay', @SLMA_PASSWORD);  
  ```

### Logout Support

- list-books.jsp
  ```
  <!-- Add Logout button -->
  <c:url var="logoutUrl" value="/logout" />
  <a href="${logoutUrl}" class="btn btn-primary btn-sm mb-3 mx-auto">
    Logout 
  </a>  
  ```

## Adding Authorization Support

- Role
  ```
  package com.greatlearning.slma.security.entity;

  import jakarta.persistence.Column;
  import jakarta.persistence.Entity;
  import jakarta.persistence.GeneratedValue;
  import jakarta.persistence.GenerationType;
  import jakarta.persistence.Id;
  import jakarta.persistence.Table;
  import lombok.Data;

  @Entity
  @Table(name = "roles")
  @Data
  public class Role {

    @Id
    @Column(name = "role_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;
  }         
  ```

- User
  - Snippet-1
    ```
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles = new ArrayList<>();    
    ```
  - Snippet-2
    ```
    import jakarta.persistence.ManyToMany;
    import jakarta.persistence.CascadeType;
    import jakarta.persistence.FetchType;
    import jakarta.persistence.JoinTable;
    import jakarta.persistence.JoinColumn;

    import java.util.ArrayList;
    import java.util.List;    
    ```

- SlmaUserDetails
  ```
  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    List<Role> roles = user.getRoles();
    List<SimpleGrantedAuthority> authorities = new ArrayList<>();

    for (Role role : roles) {
      authorities.add(new SimpleGrantedAuthority(role.getName()));
    }

    return authorities;
  }  
  ```

- SlmaSecurityConfiguration
  - Snippet-1
    ```
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
      http.authorizeRequests()
        .requestMatchers("/","/books/list", "/books/search", "/books/displayBookForm", "/books/save").hasAnyAuthority("NORMAL_USER","ADMIN_USER")
        .requestMatchers("/books/displayBookForm_Update","/books/delete").hasAuthority("ADMIN_USER")
        .anyRequest().authenticated()
        .and()
        .formLogin().loginProcessingUrl("/login").successForwardUrl("/books/list").permitAll()
        .and()
        .exceptionHandling().accessDeniedPage("/books/403")
        .and()
        .cors().and().csrf().disable();
      
      http.authenticationProvider(slmaDaoAuthenticationProvider());
      return http.build();
    }   
    ```
  - Snippet-2
    ```
    import org.springframework.security.web.SecurityFilterChain;
    import org.springframework.security.config.annotation.web.builders.HttpSecurity;    
    ```

- BookController
  - Snippet-1
    ```
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
    ```
  - Snippet-2
    ```
    import org.springframework.web.servlet.ModelAndView;
    import java.security.Principal;    
    ```

- authorization-error-403.jsp
  ```
  <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix="c" uri="jakarta.tags.core"%>

  <!DOCTYPE html>

  <html>
  <body>
    <h1>HTTP Status 403 - Access is denied</h1>
    <h2>${msg}</h2>

    <hr>

    <c:url var="listUrl" value="/books/list" />

    <a href="${listUrl}">Back to listing books...</a>

  </body>
  </html>  
  ```

- Database Cleanup Script
  ```
  -- Disable safe updates
  SET SQL_SAFE_UPDATES = 0;

  -- Delete any existing rows
  delete from users_roles;
  delete from roles;

  -- Revert to the previous value
  SET SQL_SAFE_UPDATES = 1;                    
  ```

- Sample Data
  - Script-1
    ```
    insert into roles (role_id, name) values (1, 'NORMAL_USER');
    insert into roles (role_id, name) values (2, 'ADMIN_USER');    
    ```
  - Script-2
    ```
    insert into users_roles (user_id, role_id) values (
    (select user_id from users where username = 'varun'),
    (select role_id from roles where name = 'ADMIN_USER')
    );


    insert into users_roles (user_id, role_id) values (
    (select user_id from users where username = 'sanjay'),
    (select role_id from roles where name = 'NORMAL_USER')
    );    
    ```