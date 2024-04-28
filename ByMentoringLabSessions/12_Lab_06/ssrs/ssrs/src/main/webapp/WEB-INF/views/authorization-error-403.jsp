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