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
<h2>Dodaj Tweeta</h2>
<form:form modelAttribute="tweet" method="post">
    <form:hidden path="id"/>
    <form:errors class="bg-danger text-danger" path="user"/><br>
    User <form:select items="${users}" path="user.id" itemLabel="fullName" itemValue="id"></form:select>
    Content<br><form:errors class="bg-danger text-danger" path="tweetText"/><br>
    <form:textarea path="tweetText" cols="20" rows="5"/><br>
    <input type="submit" value="Wyslij">
</form:form>
</body>
</html>
