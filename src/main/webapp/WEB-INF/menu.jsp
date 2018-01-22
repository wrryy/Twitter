<style>
    form {
        width: 400px;
        height: 100px;
        float: left;
        margin-top: 5px;
        margin-left: 5px;
    }

    .div2 {
        width: initial;
        float: right;
    }

    .afloatright {
        float: right;
        margin-top: 5px;
        margin-left: 5px;
        margin-right: 10px;
    }
</style>
<div>
    <form:form action="/tweet/add" class="d-inline" modelAttribute="tweet" method="post">
        <form:errors class="bg-danger text-danger" path="user.id"/>
        <form:hidden path="user.id"/>
        <form:errors class="bg-danger text-danger" path="tweetText"/>
        <form:textarea path="tweetText" cols="40" rows="1"/>
        <input type="submit" value="Tweet it">
    </form:form>
    <c:if test="${user==null}">
        <a class="afloatright" href="/register"> Register</a>
        <a class="afloatright" href="/login">Login</a>
    </c:if>
    <c:if test="${user!=null}">
        <a class="afloatright" href="/user/settings">Hello ${user}</a>
    </c:if>
    <form class="div2" action="/search/tag">
        <input type="text" required>
        <input type="submit" value="Search tags">
    </form>
</div>
