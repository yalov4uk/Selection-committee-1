<%@ page import="by.training.nc.dev3.localisation.Bundle" %>
<%@ page import="java.util.ResourceBundle" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    ResourceBundle resourceBundle = Bundle.getInstance();
    String LOGIN = resourceBundle.getString("LOGIN");
    String LEN = resourceBundle.getString("LEN");
    String NAME = resourceBundle.getString("NAME");
    String PASSWORD = resourceBundle.getString("PASSWORD");
    String REPEAT_PASSWORD = resourceBundle.getString("REPEAT_PASSWORD");
    String SIGN_UP = resourceBundle.getString("SIGN_UP");
    String YOU_SIGNUP_SO_LOGIN = resourceBundle.getString("YOU_SIGNUP_SO_LOGIN");
    String PASSWORD_MATCH = resourceBundle.getString("PASSWORD_MATCH");
%>

<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title><%=SIGN_UP%>
    </title>
    <link rel="stylesheet" href="/css/signup.css">
    <link rel="stylesheet" href="/css/login_and_signup.css">
    <script type="text/javascript" src="/js/validator.js"></script>
</head>

<body>

<form id="signup" action="/controller" method="post" onsubmit="return signup();">
    <input type="hidden" id="LEN" value="<%=LEN%>"/>
    <input type="hidden" id="PASSWORD_MATCH" value="<%=PASSWORD_MATCH%>"/>
    <input type="hidden" name="command" value="register"/>
    <h1><%=SIGN_UP%></h1>
    <fiedset id="inputs">
        <input id="username" name="username" type="text" placeholder="<%=LOGIN%>" autofocus required>
        <input id="name" name="name" type="text" placeholder="<%=NAME%>" required>
        <input id="password" name="password" type="password" placeholder="<%=PASSWORD%>" required>
        <input id="passwordverify" type="password" placeholder="<%=REPEAT_PASSWORD%>" required>
    </fiedset>
    <fieldset id="actions">
        <input type="submit" id="submit" value="<%=SIGN_UP%>">
        <a href="/jsps/login_signup/login.jsp"><%=YOU_SIGNUP_SO_LOGIN%></a>
    </fieldset>
</form>
</body>

</html>