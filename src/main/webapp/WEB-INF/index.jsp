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
<c:forEach items="${tweets}" var="tweet">
    <h3>${tweet.title}</h3>
    <div> <h5 class="small text-info">User: ${tweet.user.username}<br>${tweet.createdd}  <a href="/tweet/info">Details</a> </h5>
        <p>${tweet.tweetText}</p>
    </div>
    <hr>
</c:forEach>
</body>
</html>
