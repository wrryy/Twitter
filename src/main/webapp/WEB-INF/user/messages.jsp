<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>${user}' profile</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
<%@ include file="../menu.jsp" %>
<form:form action="/send" modelAttribute="message">
    Addressee: <form:select path="addressee.id" items="${users}" itemLabel="username" itemValue="id"/>
    Message: <form:input path="text"/>
</form:form>

<c:forEach items="${messages}" var="mess">
    <p>
    <h5 class="small text-info">${mess.sender}${mess.createdd}</h5>
    <h3>${mess.text}</h3>
    </p>
    <hr>
</c:forEach>
</body>
</html>
