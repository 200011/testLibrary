<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="<c:url value="/resources/css/myStyle.css" />" rel="stylesheet">
    <script src="<c:url value="/resources/script/jquery/jquery-3.2.1.min.js" />"></script>
</head>
<body>
authors
<div id="feedback"></div>
<form id="addBook-form">
    <div>
        <label>author</label>
        <input list="authors" name="author" id="authorId">
        <datalist id="authors">
            <c:forEach  items="${authors}" var="author">
                <option value="${author.surname} ${author.name}">
            </c:forEach>
        </datalist>
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

<script>
    jQuery(document).ready(function($) {

        $("#addBook-form").submit(function(event) {

            // Disble the search button
            enableSearchButton(false);

            // Prevent the form from submitting via the browser.
            event.preventDefault();

            searchViaAjax();

        });

    });

    function searchViaAjax() {

        var search = {}
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
            },
            error : function(e) {
                console.log("ERROR: ", e);
                display(e);
            },
            done : function(e) {
                console.log("DONE");
                enableSearchButton(true);
            }
        });

    }

    function enableSearchButton(flag) {
        $("#bth-add").prop("disabled", flag);
    }

    function display(data) {
        var json = "<h4>Ajax Response</h4><pre>"
            + JSON.stringify(data, null, 4) + "</pre>";
        $('#feedback').html(json);
    }
</script>
</body>
</html>
