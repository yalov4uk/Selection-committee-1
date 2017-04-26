<%@include file="../includes/init.jsp" %>

<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title><fmt:message key="SIGN_UP"/>
    </title>
    <link rel="stylesheet" href="/css/signup.css">
    <link rel="stylesheet" href="/css/login_and_signup.css">
    <script type="text/javascript" src="/js/validator.js"></script>
</head>

<body>

<form id="signup" action="/controller" method="post" onsubmit="return signup();">
    <fmt:message key="LEN" var="LEN"/>
    <input type="hidden" id="LEN" value="${LEN}"/>
    <fmt:message key="PASSWORD_MATCH" var="PASSWORD_MATCH"/>
    <input type="hidden" id="PASSWORD_MATCH" value="${PASSWORD_MATCH}"/>
    <input type="hidden" name="command" value="register"/>
    <h1><fmt:message key="SIGN_UP"/></h1>
    <fiedset id="inputs">
        <fmt:message key="LOGIN" var="LOGIN"/>
        <input id="username" name="username" type="text" placeholder="${LOGIN}" autofocus required>
        <fmt:message key="NAME" var="NAME"/>
        <input id="name" name="name" type="text" placeholder="${NAME}" required>
        <fmt:message key="PASSWORD" var="PASSWORD"/>
        <input id="password" name="password" type="password" placeholder="${PASSWORD}" required>
        <fmt:message key="REPEAT_PASSWORD" var="REPEAT_PASSWORD"/>
        <input id="passwordverify" type="password" placeholder="${REPEAT_PASSWORD}" required>
    </fiedset>
    <fieldset id="actions">
        <fmt:message key="SIGN_UP" var="SIGN_UP"/>
        <input type="submit" id="submit" value="${SIGN_UP}">
        <a href="/jsps/login_signup/login.jsp"><fmt:message key="YOU_SIGNUP_SO_LOGIN"/></a>
    </fieldset>
</form>
</body>

</html>