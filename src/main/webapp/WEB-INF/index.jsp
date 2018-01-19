<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<html>
<body>
<h2>Hello World!</h2>

<a href="/user/all">Wszyscy uzytkownicy</a><br>
<a href="/user/add">Dodaj uzytkownika</a><br>
<a href="/tweet/add">Dodaj tweet</a><br><br>

<a href="/user/1/tweets">Wszystkie tweety usera</a><br>

<a href="/user/clear">USUN UZYTKOWNIKOW I ICH TWEETY</a><br><br>

<form method="get" action="/user/search-tweets">
    Szukaj Tweeta po stringu<br> <input type="text" name="start">
    <input type="submit" value="Szukaj">
</form>
</body>
</html>
