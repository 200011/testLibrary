<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <title>Title</title>
    <link href="<c:url value="/resources/css/myStyle.css" />" rel="stylesheet">
</head>
<body>
<div id="myContainer">
    <c:forEach  items="${authors}" var="author">
        <a href="books/${author.authorId}">${author.surname} ${author.name}</a><br>
    </c:forEach>
    <a href="addBook">Добавить книгу</a><br>
</div>
</body>
</html>
