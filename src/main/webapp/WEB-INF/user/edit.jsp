<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
<h2>Formularz: Dodaj uzytkownika</h2>
<form:form method="post" modelAttribute="user">
    <form:hidden path="id"/>
    <form:errors class="bg-danger text-danger" path="firstName"/><br>
    Imie <form:input path="firstName"/><br>
    <form:errors class="bg-danger text-danger" path="lastName"/><br>
    Nazwisko <form:input path="lastName"/><br>
    <form:errors class="bg-danger text-danger" path="email"/><br>
    Email <form:input path="email"/>
    <input type="submit" value="Wyslij">
</form:form>
</body>
</html>
