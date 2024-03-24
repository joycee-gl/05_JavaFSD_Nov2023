
# Introduction

- Base URL
    - http://localhost:8080/


# Welcome Page

- application.propeties

    ```
    spring.application.name=lma
    server.servlet.context-path=/lma
    ```

- URL
    - http://localhost:8080/lma/welcome


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
    spring.datasource.url=jdbc:mysql://localhost:3306/lma

    spring.datasource.username=root
    spring.datasource.password=password11
    spring.jpa.hibernate.ddl-auto=update

    spring.jpa.show-sql=true                        
    ```

- list-books.html

    ```
    <!DOCTYPE HTML>
    <html lang="en" xmlns:th="http://www.thymeleaf.org">

        <head>
            <!-- Required meta tags -->
            <meta charset="utf-8">
            <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        
            <!-- Bootstrap CSS -->
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
                integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
        
            <title>Book Directory</title>
        </head>

        <body>
        
            <div class="container">
        
                <h3>Book Directory</h3>
                <hr>
        
                <table class="table table-bordered table-striped">
                    <thead class="thead-dark">
                        <tr>
                            <th>Title</th>
                            <th>Author</th>
                            <th>Category</th>
                            <th>Action</th>
                        </tr>
                    </thead>
        
                    <tbody>
                        <tr th:each="tempBook : ${books}">
        
                            <td th:text="${tempBook.title}" />
                            <td th:text="${tempBook.author}" />
                            <td th:text="${tempBook.category}" />
        
                            <td>
                            </td>
        
        
                        </tr>
                    </tbody>
                </table>
        
            </div>
        
        </body>

    </html>                
    ```

- URL
    - http://localhost:8080/lma/books/list

- Books Sample Data

    ```
    INSERT INTO book (id, author, title, category) VALUES (1, 'Mary Shelley', 'Frankenstein', 'General');
    INSERT INTO book (id, author, title, category) VALUES (2, 'Emily Brontë', 'Wuthering Heights', 'General');
    INSERT INTO book (id, author, title, category) VALUES (3, 'Fyodor Dostoevsky', 'Crime and Punishment', 'General');
    INSERT INTO book (id, author, title, category) VALUES (4, 'Henrik Ibsen', 'Peer Gynt', 'General');
    INSERT INTO book (id, author, title, category) VALUES (5, 'Leo Tolstoy', 'War and Peace', 'General');
    INSERT INTO book (id, author, title, category) VALUES (6, 'Leo Tolstoy', 'Anna Karenina', 'General');
    INSERT INTO book (id, author, title, category) VALUES (7, 'Henrik Ibsen', 'A Doll''s House', 'General');
    INSERT INTO book (id, author, title, category) VALUES (8, 'Fyodor Dostoevsky', 'The Brothers Karamazov', 'General');
    INSERT INTO book (id, author, title, category) VALUES (9, 'Thomas Mann', 'Buddenbrooks', 'General');
    INSERT INTO book (id, author, title, category) VALUES (10, 'Rabindranath Tagore', 'Gitanjali', 'General');
    insert into book (id, title, author, category) values (11, 'Harry Potter - Series', 'JK Rowling', 'Fantasy');
    insert into book (id, title, author, category) values (12, 'Java Programmming', 'Martin Fowler', 'Programming');
    ```

# Add Book

- list-books.html

    ```
    <!-- Add a button -->
    <a th:href="@{/books/showFormForAdd}"
        class="btn btn-primary btn-sm mb-3">
        Add Book
    </a>                        
    ```

- book-form.html

    ```
    <!DOCTYPE HTML>
    <html lang="en" xmlns:th="http://www.thymeleaf.org">

    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
            integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">

        <title>Save book</title>
    </head>

    <body>

        <div class="container">

            <h3>Book Directory</h3>
            <hr>

            <p class="h4 mb-4">Save Book</p>

            <form action="#" th:action="@{/books/save}" th:object="${book}" method="POST">

                <!-- Add hidden form field to handle update -->
                <input type="hidden" th:field="*{id}" />

                <input type="text" th:field="*{title}" class="form-control mb-4 col-4" placeholder="Title">

                <input type="text" th:field="*{author}" class="form-control mb-4 col-4" placeholder="Author">

                <input type="text" th:field="*{category}" class="form-control mb-4 col-4" placeholder="Category">

                <button type="submit" class="btn btn-info col-2">Save</button>

            </form>

            <hr>
            <a th:href="@{/books/list}">Back to Books List</a>

        </div>
    </body>

    </html>                    
    ```

## New Book to add

- Title
    - Love, Medicine and Miracles
- Author 
    - Bernie S. Siegel
- Category
    - Health & Healing
    
# Editing Books

- list-books.html

    ```
    <div class="row">
        <div class="col-small">
            <!-- Add "update" button/link -->
            <form action="#" th:action="@{/books/showFormForUpdate}" method="POST">

                <input type="hidden" name="bookId" th:value="${tempBook.id}" />
                <button type="submit" class="btn btn-info btn-sm ml-3 mr-1">Update</button>

            </form>
        </div>
    </div>                        
    ```

# Delete Books

- list-books.html
    ```
    <div class="col-small">
        <!-- Add "delete" button/link -->
        <form action="#" th:action="@{/books/delete}" method="POST">

            <input type="hidden" name="bookId" th:value="${tempBook.id}" />
            <button type="submit" class="btn btn-danger btn-sm"
                onclick="if (!(confirm('Are you sure you want to delete this book?'))) return false">
                Delete
            </button>

        </form>
    </div>                        
    ```