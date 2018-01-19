<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title></title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
<h2>Lista userow</h2>
<a href="/user/add">Dodaj uzytkownika</a>
<table class="table-bordered">
    <tr>
        <td>Imie</td>
        <td>Nazwisko</td>
        <td>Email</td>
        <td colspan="4">Akcja</td>
    </tr>

    <c:forEach items="${users}" var="user">
        <tr>
            <td>${user.firstName}</td>
            <td>${user.lastName}</td>
            <td>${user.email}</td>
            <td><a href="/user/${user.id}/tweets">Pokaz Tweety </a> </td>
            <td><a href="/tweet/deletetweets?id=${user.id}">Usun Tweety </a> </td>
            <td><a href="/user/edit?id=${user.id}"> Edytuj </a> </td>
            <td><a href="/user/delete?id=${user.id}"> Usun </a> </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
