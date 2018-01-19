<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
<a href="/tweet/add">Dodaj tweet</a>
<br>
<c:forEach items="${tweets}" var="tweet">
    <h3>${tweet.title}</h3>
   <div> <h5 class="small text-info">User: ${tweet.user.fullName}<br>${tweet.createdd}  </h5>
    <p>${tweet.tweetText}</p>
   </div>
    <hr>
</c:forEach>
</body>
</html>
