<%@include file="../includes/init.jsp" %>

<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title><fmt:message key="LOG_IN"/></title>
    <link rel="stylesheet" href="/css/login.css">
    <link rel="stylesheet" href="/css/login_and_signup.css">
    <script type="text/javascript" src="/js/validator.js"></script>
</head>

<body>

<form id="login" action="/controller" onsubmit="return login();">
    <fmt:message key="LEN" var="LEN"/>
    <input type="hidden" id="LEN" value="${LEN}"/>
    <input type="hidden" name="command" value="login"/>
    <h1><fmt:message key="LOG_IN"/></h1>
    <fieldset id="inputs">
        <fmt:message key="LOGIN" var="LOGIN"/>
        <input id="username" name="username" type="text" placeholder="${LOGIN}" autofocus required>
        <fmt:message key="PASSWORD" var="PASSWORD"/>
        <input id="password" name="password" type="password" placeholder="${PASSWORD}" required>
    </fieldset>
    <fieldset id="actions">
        <fmt:message key="LOG_IN" var="LOG_IN"/>
        <input type="submit" id="submit" value="${LOG_IN}">
        <a href="/jsps/login_signup/signup.jsp"><fmt:message key="SIGN_UP"/></a>
    </fieldset>
</form>
</body>

</html>