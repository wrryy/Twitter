<style>
    body {
        background: #99d6ff;
    }
    form {
        width: 400px;
        height: 100px;
        float: left;
        margin-top: 5px;
        margin-left: 5px;
    }
    hr{
        width: 30%;
        text-align:left;
        margin-left:0;
    }
    p{
        clear: both;
    }
    .div2 {
        width: initial;
        float: right;
    }
    .tweet{
        width: 30%;
        word-break: keep-all;
    }
    .afloatright {
        float: right;
        margin-top: 7px;
        margin-left: 5px;
        margin-right: 10px;
    }
    .container {
        display: table;
        height: 70%;
        width: 100%;
    }
    .usr {

        display: table-cell;
        text-align: center;
        vertical-align: middle;
        width: 50%;
        padding: 1rem;
    }
    .message{
        border: 1px solid antiquewhite;
        width: max-content;
    }
</style>
<div>
    <form:form action="/tweet/add" modelAttribute="tweet" method="post">
        <form:errors class="bg-danger text-danger" path="user.id"/>
        <form:hidden path="user.id"/>
        <form:errors class="bg-danger text-danger" path="tweetText"/>
        <form:input size="35px" path="tweetText" cols="40" rows="1"/>
        <input type="submit" value="Tweet it">
    </form:form>
    <c:if test="${user==null}">
        <a class="afloatright" href="/register"> Register</a>
        <a class="afloatright" href="/login">Login</a>
    </c:if>
    <c:if test="${user!=null}">
        <a class="afloatright" href="/logout">Logout</a>
        <a class="afloatright" href="/user/${user}">Hello ${user}</a>
    </c:if>
    <form class="div2" action="/search/tag">
        <input type="text" required>
        <input type="submit" value="Search tags">
    </form>
</div>
