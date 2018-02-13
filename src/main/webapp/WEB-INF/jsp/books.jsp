<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <jsp:include page="templates/head.jsp"/>

</head>
<body>
<jsp:include page="templates/header.jsp"/>

<div id="container">
    <div class="mainTitle">
        ${author.surname} ${author.name}
    </div>

    <div class="row">
        <div class="cols col-2">
            <jsp:include page="templates/sidebar.jsp"/>
        </div>
        <div class="cols col-10">
            <c:forEach items="${books}" var="book">
               <%-- <img src="../../resources/img/images.jpg" width="100%" height="30%">--%>

                <span class="title"> ${book.bookname}</span><br>

            </c:forEach>
        </div>
    </div>

</div>

<jsp:include page="templates/footer.jsp"/>
</body>
</html>
