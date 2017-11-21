<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <c:forEach  items="${authors}" var="author">
        <a href="books/${author.authorId}">${author.surname} ${author.name}</a><br>
    </c:forEach>
</body>
</html>
