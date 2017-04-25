<%@ page import="by.training.nc.dev3.localisation.Bundle" %>
<%@ page import="java.util.ResourceBundle" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    ResourceBundle resourceBundle = Bundle.getInstance();
    String LOGIN = resourceBundle.getString("LOGIN");
    String LOG_IN = resourceBundle.getString("LOG_IN");
    String LEN = resourceBundle.getString("LEN");
    String PASSWORD = resourceBundle.getString("PASSWORD");
    String SIGN_UP = resourceBundle.getString("SIGN_UP");
%>

<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title><%=LOG_IN%></title>
    <link rel="stylesheet" href="/css/login.css">
    <link rel="stylesheet" href="/css/login_and_signup.css">
    <script type="text/javascript" src="/js/validator.js"></script>
</head>

<body>

    <form id="login" action="/controller" onsubmit="return login();">
        <input type="hidden" id="LEN" value="<%=LEN%>" />
        <input type="hidden" name="command" value="login" />
        <h1><%=LOG_IN%></h1>
        <fieldset id="inputs">
            <input id="username" name="username" type="text" placeholder="<%=LOGIN%>" autofocus  required>
            <input id="password" name="password" type="password" placeholder="<%=PASSWORD%>" required>
        </fieldset>
        <fieldset id="actions">
            <input type="submit" id="submit" value="<%=LOG_IN%>">
            <a href="/jsps/login_signup/signup.jsp"><%=SIGN_UP%></a>
        </fieldset>
    </form>
</body>

</html>