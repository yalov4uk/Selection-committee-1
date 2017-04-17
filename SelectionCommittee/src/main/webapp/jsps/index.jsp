<%@ page import="by.training.nc.dev3.entities.User" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Selection committee</title>
    <link rel="stylesheet" href="/css/index.css">
</head>

<body>
    <c:out value="${user.name}">no name</c:out>
    <ul class="login_signup">
        <li><a href="/jsps/signup.jsp">Sign up</a></li>
        <li><a href="/jsps/login.jsp">Log in</a></li>
    </ul>

    <header>
        <h2 class="selection_comittee">Selection comittee</h2>
    </header>

    <nav>
        <ul class="Navigation">
            <li><a href="#">Home</a></li>
            <li><a href="#">About</a></li>
            <li><a href="#">Some functions</a>
                <ul>
                    <li><a href="#">A</a></li>
                    <li><a href="#">B</a></li>
                    <li><a href="#">C</a></li>
                    <li><a href="#">D</a></li>
                    <li><a href="#">E</a></li>
                </ul>
            </li>
            <li><a href="#">Something else</a></li>
            <li><a href="#">Contact</a></li>
        </ul>
    </nav>
</body>