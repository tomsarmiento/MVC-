<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>Books</title>
	</head>
	<body>
		<h1><c:out value="${book.title}"/></h1>
		<p>Id: <c:out value="${book.id}"/></p>
		<p>Description: <c:out value="${book.description}"/></p>
		<p>Language: <c:out value="${book.language}"/></p>
		<p>Number of pages: <c:out value="${book.numberOfPages}"/></p>
		<a href="/books/${book.id}/edit">Edit Book</a>
		<form action="/books/${book.id}" method="post">
    		<input type="hidden" name="_method" value="delete">
    		<input type="submit" value="Delete">
		</form>
	</body>
</html>