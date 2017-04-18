<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Sign up</title>
    <link rel="stylesheet" href="/css/signup.css">
    <link rel="stylesheet" href="/css/login_and_signup.css">
    <script type="text/javascript" src="/js/validator.js"></script>
</head>

<body>
    <form id="signup" action="/controller" method="post" onsubmit="return signup();">
        <input type="hidden" name="command" value="register" />
        <h1>Sign up</h1>
        <fieldset id="inputs">
            <input id="username" name="username" type="text" placeholder="login" autofocus required>
            <input id="name" name="name" type="text" placeholder="name" required>
            <input id="password" name="password" type="password" placeholder="password" required>
            <input id="passwordverify" type="password" placeholder="repeat password" required>
        </fieldset>
        <fieldset id="actions">
            <input type="submit" id="submit" value="Sign up">
            <a href="/jsps/login.jsp">You already sign up? Log in</a>
        </fieldset>
    </form>
</body>

</html>