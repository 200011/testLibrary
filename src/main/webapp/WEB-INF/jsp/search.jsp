<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: atapstov
  Date: 1/17/2018
  Time: 9:30 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>FIND</title>
    <link href="<c:url value="/resources/css/myStyle.css" />" rel="stylesheet">
    <script src="<c:url value="/resources/script/jquery/jquery-3.2.1.min.js" />"></script>
</head>
<body>
Search
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

<script>
    jQuery(document).ready(function($) {

        $("#searchForm").submit(function(event) {
            event.preventDefault();

            searchViaAjax();
        });

    });

    function searchViaAjax() {

        var search = {};
        search["authorName"] = $("#authorName").val();
        search["authorSurname"] = $("#authorSurname").val();
        search["book"] = $("#book").val();

        $.ajax({
            type : "POST",
            contentType : "application/json",
            url : "./search",
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
        $('#searchResult').html(data.msg);
    }

</script>

</body>
</html>
