<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="templates/head.jsp"/>
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
<script>
    jQuery(document).ready(function($) {

        $("#addBook-form").submit(function(event) {
            event.preventDefault();

            addViaAjax();
        });

    });

    function addViaAjax() {

        var search = {};
        search["authorId"] = $("#authorId").val();
        search["book"] = $("#book").val();

        $.ajax({
            type : "POST",
            contentType : "application/json",
            url : "./addBook",
            data : JSON.stringify(search),
            dataType : 'json',
            timeout : 100000,
            success : function(data) {
                console.log("SUCCESS: ", data);
                display(data);
            }
        });
    }
    function display(data) {
        $('#result_text').html(data.msg);
    }
</script>
</body>
</html>
