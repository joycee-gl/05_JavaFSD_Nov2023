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