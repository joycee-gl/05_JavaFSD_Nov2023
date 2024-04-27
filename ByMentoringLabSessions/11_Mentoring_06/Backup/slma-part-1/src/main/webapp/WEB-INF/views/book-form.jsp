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