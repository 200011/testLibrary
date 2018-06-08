<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<head>
    <jsp:include page="templates/head.jsp"/>

    <script src="<c:url value="/resources/script/book/searchBook.js" />"></script>
</head>
<body>
<jsp:include page="templates/header.jsp"/>
<div id="container">
    <div class="mainTitle">
        Поиск
    </div>
    <div class="row">
        <div class="cols col-2">
            <jsp:include page="templates/sidebar.jsp"/>
        </div>
        <div class="cols col-10">
            <form id="searchForm">
                <div>
                    <label>Name author</label>
                    <input type="text" id="authorName">
                    <label>Surname author</label>
                    <input type="text" id="authorSurname">
                </div>
                <div>
                    <label>Name book</label>
                    <input type="text" id="book">
                </div>
                <div>
                    <button id="searchButton">Search</button>
                </div>
            </form>

            <p id="searchResult"></p>
        </div>
    </div>
</div>

<jsp:include page="templates/footer.jsp"/>

</body>
</html>
