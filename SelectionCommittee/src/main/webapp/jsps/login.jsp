<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Log in</title>
    <link rel="stylesheet" href="/css/login.css">
    <link rel="stylesheet" href="/css/login_and_signup.css">
    <script type="text/javascript" src="/js/validator.js"></script>
</head>

<body>
    <form id="login" action="controller" onsubmit="return login();">
        <input type="hidden" name="command" value="login" />
        <h1>Log in</h1>
        <fieldset id="inputs">
            <input id="username" name="username" type="text" placeholder="login" autofocus  required>
            <input id="password" name="password" type="password" placeholder="password" required>
        </fieldset>
        <fieldset id="actions">
            <input type="submit" id="submit" value="Log in">
            <a href="">Forget password?</a><a href="/jsps/signup.jsp">Sign up</a>
        </fieldset>
    </form>
</body>

</html>