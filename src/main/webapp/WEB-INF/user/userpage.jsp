<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<html>
<head>
        <title>${usr}' profile</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
<%@ include file="../menu.jsp" %>

<form:form modelAttribute="message" method="post">
    User <form:select items="${users}" path="user.id" itemLabel="fullName" itemValue="id"></form:select>
    Content<br><form:errors class="bg-danger text-danger" path="tweetText"/><br>
    <form:textarea path="tweetText" cols="20" rows="5"/><br>
    <input type="submit" value="Wyslij">
</form:form>
   <p>User tweets</p>
<c:forEach items="${tweets}" var="twt">
    <p> <h5 class="small text-info">${twt.createdd} <a href="/tweet/${twt.id}">Details</a></h5>
    <h3>${twt.tweetText}</h3></p>
    <hr>
</c:forEach>
</body>
</html>
