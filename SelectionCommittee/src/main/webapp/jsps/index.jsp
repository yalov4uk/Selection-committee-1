<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Selection committee</title>
    <link rel="stylesheet" href="/css/index.css">
</head>

<body>
<ul class="login_signup">
    <c:choose>
        <c:when test="${user == null}">
            <li><a href="/signup.jsp">Sign up</a></li>
            <li><a href="/login.jsp">Log in</a></li>
        </c:when>
        <c:when test="${user != null}">
            Hello ${user.name}!
            <a href="/controller?command=logout">Log out</a>
        </c:when>
    </c:choose>
</ul>

<header>
    <h2 class="selection_comittee">Selection comittee</h2>
</header>

<nav>
    <ul class="Navigation">
        <li><a href="/">Home</a></li>
        <li><a href="#">About</a></li>
        <li><a href="#">Some functions</a>
            <c:if test="${user != null}">
                <ul>
                    <li><a href="/controller?command=showFaculties">Show faculties</a></li>
                    <c:if test="${user.roleId == 2}">
                        <li><a href="/controller?command=showRoles">Show roles</a></li>
                        <li><a href="/controller?command=showStatements">Show statements</a></li>
                        <li><a href="/controller?command=showSubjects">Show subjects</a></li>
                        <li><a href="/controller?command=showUsers">Show users</a></li>
                        <li><a href="/controller?command=showRegisteredUsers">Show registered to faculty users</a></li>
                        <li><a href="/controller?command=calculateEntrants">Calculate and show pass entrants</a></li>
                    </c:if>
                </ul>
            </c:if>
        </li>
        <li><a href="#">Something else</a></li>
        <li><a href="#">Contact</a></li>
    </ul>
</nav>
</body>