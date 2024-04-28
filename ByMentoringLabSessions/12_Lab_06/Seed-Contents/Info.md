
# Create Starter Project

- N/A

# Lombok Configuration


- Java Path
  - Example-1
    ```
    set PATH=C:\Softwares\Java\jdk-17\bin;%PATH%;
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
  server.servlet.context-path=/ssrs
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
  package com.greatlearning.ssrs.controller;

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
    <h1>Spring Boot - Welcome to Secure Student Registration System</h1>

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
  http://localhost:9999/ssrs/welcome
  ```

# Listing Students

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
  spring.datasource.url=jdbc:mysql://localhost:3306/ssrs

  spring.datasource.username=root
  spring.datasource.password=mypassword_11 / password11
  spring.jpa.hibernate.ddl-auto=update

  spring.jpa.show-sql=true  
  ```

- Student
  ```
  package com.greatlearning.ssrs.entity;

  import jakarta.persistence.*;
  import lombok.Getter;
  import lombok.Setter;

  @Entity
  @Table(name = "student")
  @Getter
  @Setter
  public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "course")
    private String course;

    @Column(name = "country")
    private String country;

    public Student() {

    }

    public Student(String firstName, String lastName, String course, String country) {

      this.firstName = firstName;
      this.lastName = lastName;
      this.course = course;
      this.country = country;
    }
  }  
  ```

- StudentRepository
  ```
  package com.greatlearning.ssrs.repository;

  import org.springframework.data.jpa.repository.JpaRepository;

  import com.greatlearning.ssrs.entity.Student;

  public interface StudentRepository 
    extends JpaRepository<Student, Integer> {

  }          
  ```

- StudentService
  ```
  package com.greatlearning.ssrs.service;

  import java.util.List;

  import com.greatlearning.ssrs.entity.Student;

  public interface StudentService {

    public List<Student> findAll();
  }  
  ```

- StudentServiceImpl
  ```
  package com.greatlearning.ssrs.service.impl;

  import java.util.List;

  import org.springframework.beans.factory.annotation.Autowired;
  import org.springframework.stereotype.Service;

  import com.greatlearning.ssrs.entity.Student;
  import com.greatlearning.ssrs.repository.StudentRepository;
  import com.greatlearning.ssrs.service.StudentService;

  @Service
  public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public List<Student> findAll() {

      List<Student> students = studentRepository.findAll();
      return students;
    }

  }  
  ```

- StudentController
  ```
  package com.greatlearning.ssrs.controller;

  import java.util.List;

  import org.springframework.beans.factory.annotation.Autowired;
  import org.springframework.stereotype.Controller;
  import org.springframework.ui.Model;
  import org.springframework.web.bind.annotation.RequestMapping;

  import com.greatlearning.ssrs.entity.Student;
  import com.greatlearning.ssrs.service.StudentService;

  @Controller
  @RequestMapping("/students")
  public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("/list")
    public String listStudents(Model theModel) {

      List<Student> students = studentService.findAll();

      theModel.addAttribute("students", students);

      return "list-students";
    }
  }  
  ```

- list-students.jsp
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

  <title>Students Listing</title>
  </head>

  <body>

    <div class="container">

      <h3>Students Listing</h3>
      <hr>

      <table class="table table-bordered table-striped">
        <thead class="thead-dark">
          <tr>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Course</th>
            <th>Country</th>
            <th>Action</th>
          </tr>
        </thead>

        <tbody>
          <c:forEach items="${students}" var="studentObj">
            <tr>
              <td><c:out value="${studentObj.firstName}" /></td>
              <td><c:out value="${studentObj.lastName}" /></td>
              <td><c:out value="${studentObj.course}" /></td>
              <td><c:out value="${studentObj.country}" /></td>
            </tr>
          </c:forEach>

        </tbody>
      </table>

    </div>

  </body>

  </html>          
  ```

- URL
  ```
  http://localhost:9999/ssrs/students/list
  ```

- Database Script
  - Snippet-1
    ```
    -- Disable safe updates
    SET SQL_SAFE_UPDATES = 0;

    -- Delete any existing rows
    delete from student;

    -- Revert to the previous value
    SET SQL_SAFE_UPDATES = 1;    
    ```
  - Snippet-2
    ```
    INSERT INTO student (id, first_name, last_name, course, country) VALUES (1, 'Suresh', 'Reddy', 'B.Tech', 'India');
    INSERT INTO student (id, first_name, last_name, course, country) VALUES (2, 'Murali', 'Mohan', 'B.Arch', 'Canada');
    INSERT INTO student (id, first_name, last_name, course, country) VALUES (3, 'Daniel', 'Denson', 'B.Tech', 'New Zealand');
    INSERT INTO student (id, first_name, last_name, course, country) VALUES (4, 'Tanya', 'Gupta', 'B.Com', 'USA');    
    ```

# Listing Students at Application's Root Context

- WelcomeController
  ```
  @RequestMapping("/")
  public String defaultApplicationHomePage() {
      
      return "redirect:/students/list";
  }  
  ```

- URL
  ```
  http://localhost:9999/ssrs
  ```

# Add Students

- StudentService
  ```
  public void save(Student student);
  ```

- StudentServiceImpl
  ```
  @Override
  public void save(Student student) {
      studentRepository.save(student);                    
  }  
  ```

- StudentController
  - Snippet-1
    ```
    @RequestMapping("/displayStudentForm")
    public String addStudent_Step1(Model theModel) {

        Student student = new Student();

        theModel.addAttribute("student", student);

        return "student-form";
    }    
    ```
  - Snippet-2
    ```
    @PostMapping("/save")
    public String saveStudent(@RequestParam("id") int id, @RequestParam("firstName") String firstName,
        @RequestParam("lastName") String lastName, @RequestParam("course") String course,
        @RequestParam("country") String country) {

      System.out.println("Student ID ->" + id);

      Student studentObj = null;
      if (id == 0) {

        studentObj = new Student(firstName, lastName, course, country);
        System.out.println("Add Student Scenario");
      } else {

        System.out.println("Update Student Scenario");
      }

      // Save/Update the student
      studentService.save(studentObj);

      // use a redirect to 'students-listing'
      return "redirect:/students/list";
    }                  
    ```
  - Snippet-3
    ```
    import org.springframework.web.bind.annotation.RequestParam;
    import org.springframework.web.bind.annotation.PostMapping;    
    ```

- list-students.jsp
  ```
  <form action="" class="form-inline">

    <c:url var="addUrl" value="/students/displayStudentForm" />

    <!-- Add a button -->
    <a href="${addUrl}" class="btn btn-primary btn-sm mb-3"> Add Student
    </a>

  </form>  
  ```

- student-form.jsp
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

  <title>Save Student</title>
  </head>

  <body>

    <div class="container">

      <h3>New Student Creation</h3>
      <hr>

      <p class="h4 mb-4">Student Details</p>

      <c:url var="saveUrl" value="/students/save" />

      <form action="${saveUrl}" method="POST">

        <!-- Add hidden form field to handle update -->
        <input type="hidden" name="id" value="${student.id}" />

        <div class="form-inline">
          <input type="text" name="firstName" value="${student.firstName}"
            class="form-control mb-4 col-4" placeholder="First Name" />
        </div>

        <div class="form-inline">
          <input type="text" name="lastName" value="${student.lastName}"
            class="form-control mb-4 col-4" placeholder="Last Name" />
        </div>

        <div class="form-inline">
          <input type="text" name="course" value="${student.course}"
            class="form-control mb-4 col-4" placeholder="Course" />
        </div>

        <div class="form-inline">
          <input type="text" name="country" value="${student.country}"
            class="form-control mb-4 col-4" placeholder="Country" />

        </div>

        <button type="submit" class="btn btn-info col-2">Save</button>

      </form>

      <hr>
      <c:url var="listUrl" value="/students/list" />

      <a href="${listUrl}">Back to students List</a>

    </div>
  </body>

  </html>  
  ```

# Edit Students

- StudentService
  ```
  public Student findById(int id);
  ```

- StudentServiceImpl
  ```
  @Override
  public Student findById(int studentId) {
      return studentRepository.findById(studentId).get();
  }  
  ```

- StudentController
  - Snippet-1
    ```
    @RequestMapping("/displayStudentForm_Update")
    public String updateStudent_Step1(
        @RequestParam("studentId") int studentId,
            Model theModel) {

        Student student = studentService.findById(studentId);

        // set 'student' as a model attribute to pre-populate the form
        theModel.addAttribute("student", student);

        // send over to our form
        return "student-form";   
    }  
    ```
  - Snippet-2
    ```
    studentObj = studentService.findById(id);
    studentObj.setFirstName(firstName);
    studentObj.setLastName(lastName);
    studentObj.setCourse(course);
    studentObj.setCountry(country);    
    ```

- list-students.jsp
  ```
  <td>
    <!-- Add "update" button/link --> 
    <c:url var="updateUrl"
      value="/students/displayStudentForm_Update?studentId=${studentObj.id}" /> 
    <a href="${updateUrl}" class="btn btn-info btn-sm"> 
      Update 
    </a>
  </td>  
  ```

# Refactoring

- StudentService
  ```
  public void saveOrUpdate(int id, String firstName, String lastName, String course, String country);
  ```

- StudentServiceImpl
  ```
  @Override
  public void saveOrUpdate(int id, String firstName, String lastName, String course, String country) {

    System.out.println("Student ID ->" + id);

    Student studentObj = null;
    if (id == 0) {

      studentObj = new Student(firstName, lastName, course, country);
      System.out.println("Add Student Scenario");
    } else {

      System.out.println("Update Student Scenario");

      studentObj = this.findById(id);
      studentObj.setFirstName(firstName);
      studentObj.setLastName(lastName);
      studentObj.setCourse(course);
      studentObj.setCountry(country);
    }

    // Save/Update the student
    this.save(studentObj);
  }          
  ```

- StudentController
  ```
  @PostMapping("/save")
  public String saveStudent(@RequestParam("id") int id, @RequestParam("firstName") String firstName,
      @RequestParam("lastName") String lastName, @RequestParam("course") String course,
      @RequestParam("country") String country) {

    studentService.saveOrUpdate(id, firstName, lastName, course, country);

    // use a redirect to 'students-listing'
    return "redirect:/students/list";
  }  
  ```

# Delete Students

- StudentService
  ```
  public void deleteById(int id);
  ```

- StudentServiceImpl
  ```
  @Override
  public void deleteById(int id) {
      studentRepository.deleteById(id);    
  }  
  ```

- StudentController
  ```
  @RequestMapping("/delete")
  public String delete(@RequestParam("studentId") int studentId) {

      // delete the student
      studentService.deleteById(studentId);

      // redirect to 'students-listing'
      return "redirect:/students/list";
  }  
  ```

- list-students.jsp
  ```
  <!-- Add "delete" button/link -->							
  <c:url var="deleteUrl" value="/students/delete?studentId=${studentObj.id}" />				
  <a href="${deleteUrl}" class="btn btn-danger btn-sm"
    onclick="if (!(confirm('Are you sure you want to delete this student?'))) return false">
    Delete 
  </a>  
  ```

# Security Features

## Default Spring Security Capabilities

- pom.xml
  ```
  <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
  </dependency>      
  ```

## Authentication Support

### Default Authentication Support

- N/A

### Customize Authentication Credentials

- application.properties
  ```
  spring.security.user.name=student_admin_user
  spring.security.user.password=student_admin_password  
  ```

### Database-based Authentication Support

- User
  ```
  package com.greatlearning.ssrs.security.entity;

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
  package com.greatlearning.ssrs.security.repository;

  import org.springframework.data.jpa.repository.JpaRepository;
  import org.springframework.data.jpa.repository.Query;

  import com.greatlearning.ssrs.security.entity.User;

  public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.username = ?1")
    public User getUserByUsername(String username);

  }        
  ```

- SsrsUserDetails
  ```
  package com.greatlearning.ssrs.security.entity;

  import java.util.ArrayList;
  import java.util.Collection;
  import java.util.List;

  import org.springframework.security.core.GrantedAuthority;
  import org.springframework.security.core.authority.SimpleGrantedAuthority;
  import org.springframework.security.core.userdetails.UserDetails;

  public class SsrsUserDetails implements UserDetails {

    private User user;

    public SsrsUserDetails(User user) {
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

- SsrsUserDetailsServiceImpl
  ```
  package com.greatlearning.ssrs.security.service.impl;

  import org.springframework.beans.factory.annotation.Autowired;
  import org.springframework.security.core.userdetails.UserDetails;
  import org.springframework.security.core.userdetails.UserDetailsService;
  import org.springframework.security.core.userdetails.UsernameNotFoundException;

  import com.greatlearning.ssrs.security.entity.SsrsUserDetails;
  import com.greatlearning.ssrs.security.entity.User;
  import com.greatlearning.ssrs.security.repository.UserRepository;

  public class SsrsUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

      User user = userRepository.getUserByUsername(username);

      if (user == null) {
        throw new UsernameNotFoundException("Could not find user");
      }

      return new SsrsUserDetails(user);
    }
  }  
  ```

- SsrsSecurityConfiguration
  ```
  package com.greatlearning.ssrs.security.web;

  import org.springframework.context.annotation.Bean;
  import org.springframework.context.annotation.Configuration;
  import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
  import org.springframework.security.core.userdetails.UserDetailsService;
  import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
  import org.springframework.security.crypto.password.PasswordEncoder;

  import com.greatlearning.ssrs.security.service.impl.SsrsUserDetailsServiceImpl;

  @Configuration
  public class SsrsSecurityConfiguration {

    @Bean
    public UserDetailsService userDetailsService() {
      return new SsrsUserDetailsServiceImpl();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
      return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider ssrsDaoAuthenticationProvider() {

      DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();

      authProvider.setUserDetailsService(userDetailsService());
      authProvider.setPasswordEncoder(passwordEncoder());

      return authProvider;
    }
  }  
  ```

- Database Script
  - Snippet-1
    ```
    -- Disable safe updates
    SET SQL_SAFE_UPDATES = 0;

    -- Delete any existing rows
    delete from users;

    -- Revert to the previous value
    SET SQL_SAFE_UPDATES = 1;            
    ```

- Password Definition
  - Plain text Password
    ```
    mypassword
    ```
  - Encrypted Password
    ```
    $2a$12$SnQXQrEzEAD8pj/3KGVhneF0R1BsRug5a.ON9Up0Qfucdoci7Uvbe
    ```

- Data Population Script
  ```
  -- This corresponds to the plain text password value - 'mypassword'
  set @SSRS_PASSWORD = '$2a$12$SnQXQrEzEAD8pj/3KGVhneF0R1BsRug5a.ON9Up0Qfucdoci7Uvbe';

  insert into users (user_id, username, password) values (1, 'varun', @SSRS_PASSWORD);

  insert into users (user_id, username, password) values (2, 'sanjay', @SSRS_PASSWORD);  
  ```

### Logout Support

- list-students.jsp
  ```
  <!-- Add Logout button -->
  <c:url var="logoutUrl" value="/logout" />
  <a href="${logoutUrl}" class="btn btn-primary btn-sm mb-3 mx-auto">
    Logout 
  </a>  
  ```

## Authorization Support

- Role
  ```
  package com.greatlearning.ssrs.security.entity;

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

- SsrsUserDetails
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

- SsrsSecurityConfiguration
  - Snippet-1
    ```
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
      http.authorizeRequests()
        .requestMatchers("/","/students/list", "/students/displayStudentForm", "/students/save").hasAnyAuthority("NORMAL_USER","ADMIN_USER")
        .requestMatchers("/students/displayStudentForm_Update","/students/delete").hasAuthority("ADMIN_USER")
        .anyRequest().authenticated()
        .and()
        .formLogin().loginProcessingUrl("/login").successForwardUrl("/students/list").permitAll()
        .and()
        .logout().logoutSuccessUrl("/login").permitAll()
        .and()
        .exceptionHandling().accessDeniedPage("/students/403")
        .and()
        .cors().and().csrf().disable();
      
      http.authenticationProvider(ssrsDaoAuthenticationProvider());
      return http.build();
    }    
    ```
  - Snippet-2
    ```
    import org.springframework.security.web.SecurityFilterChain;
    import org.springframework.security.config.annotation.web.builders.HttpSecurity;    
    ```

- StudentController
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

    <c:url var="listUrl" value="/students/list" />

    <a href="${listUrl}">Back to listing students...</a>

  </body>
  </html>  
  ```

- Database Script
  - Snippet-1
    ```
    -- Disable safe updates
    SET SQL_SAFE_UPDATES = 0;

    -- Delete any existing rows
    delete from users_roles;
    delete from roles;

    -- Revert to the previous value
    SET SQL_SAFE_UPDATES = 1;                      
    ```
  - Snippet-2
    ```
    insert into roles (role_id, name) values (1, 'NORMAL_USER');
    insert into roles (role_id, name) values (2, 'ADMIN_USER');    
    ```
  - Snippet-3
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
