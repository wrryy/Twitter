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
    <%@ include file="../menu.jsp" %>
    <p>
    <h5 class="small text-info">User: ${tweets.user.username}<br>${tweets.createdd} </h5>
    <h3>${tweets.tweetText}</h3>
        <form:form action="/comment/add/${tweets.id}" method="post" modelAttribute="comment">
            <form:errors path="text"/>
            <form:input path="text"/>
            <input type="submit" value="Add comment">
        </form:form>
    <hr>
    </p>
    <c:forEach items="${comments}" var="comm">
        <div class="message">
        <h6 class="small text-info">User: ${comm.user.username}<br>${comm.createdd} </h6>
        ${comm.text}
        </div>
    </c:forEach>
</body>
</html>
