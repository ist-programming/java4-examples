<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Example Client Side</title>
    <link rel="stylesheet" href="<c:url value="/assets/css/bootstrap.min.css"/>">
    <link rel="stylesheet" href="<c:url value="/assets/css/main.css"/>">
    <script src="<c:url value="/assets/js/simple.js"/>"></script>
    <script>
        contextName = "${pageContext.request.contextPath}";
    </script>
</head>
<body>
<div class="book-card template-block">
    <div class="book-header">
        <h3 class="book-name"><a href="#"></a></h3>
        <div class="book-delete-icon"><a href="" class="text-danger">X</a></div>
        <div class="clearfix"></div>
    </div>
    <div class="book-description">${book.description}</div>
</div>

<div class="container">
    <a href="" class="update-button .btn .btn-success">Update Book List</a>
    <div class="books-list">
    </div>
</div>
</body>
</html>
