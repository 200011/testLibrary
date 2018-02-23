<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<header>
    <ul class="menu">
        <li class="menu__item"><a class="menu__button" href="/index.html">Главная</a></li>
        <li class="menu__item"><a class="menu__button" href="/addBook.html">Добавить книгу</a></li>
        <li class="menu__item"><a class="menu__button" href="/search.html">Поиск</a></li>


        <li class="menu__item"><a class="menu__button" href="#" >Список авторов</a>
            <ul class="submenu">
                <c:forEach  items="${authors}" var="author">
                    <li class="submenu__item"><a class="menu__button" href="/books/${author.authorId}.html">${author.name} ${author.surname}</a></li>
                </c:forEach>
            </ul>
        </li>
        <li class="menu__item"><a class="menu__button" href="#" >Работа с REST </a>
            <ul class="submenu">
                <li class="submenu__item"><a class="menu__button" href="rest/getAllBooks.html">GET all books</a></li>
                <li class="submenu__item"><a class="menu__button" href="rest/addBook.html">POST</a></li>
            </ul>
        </li>
        <li class="menu__item"><a class="menu__button" href="/soap/book.wsdl" >Работа с SOAP</a></li>
    </ul>
</header>
