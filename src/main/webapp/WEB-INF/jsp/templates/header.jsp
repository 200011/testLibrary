<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<header>
    <ul class="menu">
        <li><a href="/">Главная</a></li>
        <li><a href="/addBook">Добавить книгу</a></li>
        <li><a href="/search">Поиск</a></li>


        <li><a href="#" >Список авторов</a>
            <ul class="submenu">
                <c:forEach  items="${authors}" var="author">
                    <li><a href="books/${author.authorId}">${author.name} ${author.surname}</a></li>
                </c:forEach>
            </ul>
        </li>
        <li><a href="#" >Работа с REST </a>
            <ul class="submenu">
                <li><a href="">GET</a></li>
                <li><a href="">POST</a></li>
            </ul>
        </li>
        <li><a href="#" >Работа с SOAP</a>
            <ul class="submenu">
                <li><a href="">GET</a></li>
                <li><a href="">POST</a></li>
            </ul>
        </li>
    </ul>
</header>
