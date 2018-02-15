<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<header>
    <ul class="menu">
        <li class="menu__item"><a class="menu__button" href="/">Главная</a></li>
        <li class="menu__item"><a class="menu__button" href="/addBook">Добавить книгу</a></li>
        <li class="menu__item"><a class="menu__button" href="/search">Поиск</a></li>


        <li class="menu__item"><a class="menu__button" href="#" >Список авторов</a>
            <ul class="submenu">
                <c:forEach  items="${authors}" var="author">
                    <li class="submenu__item"><a class="menu__button" href="books/${author.authorId}">${author.name} ${author.surname}</a></li>
                </c:forEach>
            </ul>
        </li>
        <li class="menu__item"><a class="menu__button" href="#" >Работа с REST </a>
            <ul class="submenu">
                <li class="submenu__item"><a class="menu__button" href="">GET</a></li>
                <li class="submenu__item"><a class="menu__button" href="">POST</a></li>
            </ul>
        </li>
        <li class="menu__item"><a class="menu__button" href="#" >Работа с SOAP</a>
            <ul class="submenu">
                <li class="submenu__item"><a class="menu__button" href="">GET</a></li>
                <li class="submenu__item"><a class="menu__button" href="">POST</a></li>
            </ul>
        </li>
    </ul>
</header>
