<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="templates/head.jsp"/>
<body>
<jsp:include page="templates/header.jsp"/>

<div id="container">
    <div class="row">
        <div class="cols col-2">
            <jsp:include page="templates/sidebar.jsp"/>
        </div>
        <div class="cols col-10">content</div>
    </div>
</div>

<jsp:include page="templates/footer.jsp"/>
</body>
</html>
