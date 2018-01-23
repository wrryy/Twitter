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
   <p>User tweets</p>
<c:forEach items="${tweets}" var="twt">
    <p> <h5 class="small text-info">${twt.createdd} <a href="/tweet/${twt.id}">Details</a></h5>
    <h3>${twt.tweetText}</h3></p>
    <hr>
</c:forEach>
</body>
</html>
