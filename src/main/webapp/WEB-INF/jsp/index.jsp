<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="templates/head.jsp"/>
<body>
<jsp:include page="templates/header.jsp"/>
<div id="myContainer">
    <%--<c:forEach  items="${authors}" var="author">
        <a href="books/${author.authorId}">${author.surname} ${author.name}</a><br>
    </c:forEach>--%>
    <a href="addBook">Добавить книгу</a><br>
</div>

<jsp:include page="templates/footer.jsp"/>
</body>
</html>
