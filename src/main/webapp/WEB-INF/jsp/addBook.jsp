<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <jsp:include page="templates/head.jsp"/>

    <script src="<c:url value="/resources/script/book/addBook.js" />"></script>

</head>
<body>
<jsp:include page="templates/header.jsp"/>

<div id="container">
    <div class="mainTitle">
        Добавление книги
    </div>

    <div class="row">
        <div class="cols col-2">
            <jsp:include page="templates/sidebar.jsp"/>
        </div>
        <div class="cols col-10">
            <form id="addBook-form">
                <div>
                    <label>author</label>
                    <select id="authorId">
                        <c:forEach items="${authors}" var="author">
                            <option value="${author.authorId}">${author.surname} ${author.name}</option>
                        </c:forEach>
                    </select>
                </div>
                <div>
                    <label>book</label>
                    <input type="text" id="book">
                </div>
                <div>
                    <button id="bth-add">Add</button>
                </div>
            </form>
            <p id="result_text"></p>
        </div>
    </div>
</div>

<jsp:include page="templates/footer.jsp"/>

</body>
</html>
