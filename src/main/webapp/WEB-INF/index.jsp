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
<%@ include file="menu.jsp" %>
<c:forEach items="${tweets}" var="twt">
    <p> <h5 class="small text-info">User: ${twt.user.username}<br>${twt.createdd} <a
        href="/tweet/${twt.id}">Details</a></h5>
    <h3 class="tweet"> ${twt.tweetText}</h3>
    <hr>
    </p>
</c:forEach>
</body>
</html>
