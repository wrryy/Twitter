<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Login into Twitter</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
<form action="login" method="post">
    <div>
        Login: <input type="text" name="username"/>
    </div>
    <div>
        Password: <input type="password" name="password"/>
    </div>
    <div>
        <input type="submit" value="Log in"/>
    </div>
    <div>
        <a href="register">Register new account</a>
    </div>
</form>
</body>
</html>
