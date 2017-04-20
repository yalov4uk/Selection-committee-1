<%@ page import="by.training.nc.dev3.localisation.Bundle" %>
<%@ page import="java.util.ResourceBundle" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    ResourceBundle resourceBundle = Bundle.getInstance();
    String SELECTION_COMMITTEE = resourceBundle.getString("SELECTION_COMMITTEE");
    String HELLO = resourceBundle.getString("HELLO");
    String LOGOUT = resourceBundle.getString("LOGOUT");
    String CHANGE_LANGUAGE = resourceBundle.getString("CHANGE_LANGUAGE");
    String HOME = resourceBundle.getString("HOME");
    String ABOUT = resourceBundle.getString("ABOUT");
    String SOME_FUNCTIONS = resourceBundle.getString("SOME_FUNCTIONS");
    String FACULTIES = resourceBundle.getString("FACULTIES");
    String ROLES = resourceBundle.getString("ROLES");
    String STATEMENTS = resourceBundle.getString("STATEMENTS");
    String SUBJECTS = resourceBundle.getString("SUBJECTS");
    String USERS = resourceBundle.getString("USERS");
    String REG_USERS = resourceBundle.getString("REG_USERS");
    String CALCULATE_AND_SHOW_ENTRANTS = resourceBundle.getString("CALCULATE_AND_SHOW_ENTRANTS");
    String SOMETHING_ELSE = resourceBundle.getString("SOMETHING_ELSE");
    String CONTACT = resourceBundle.getString("CONTACT");
    String LOG_IN = resourceBundle.getString("LOG_IN");
    String SIGN_UP = resourceBundle.getString("SIGN_UP");
%>

<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title><%=SELECTION_COMMITTEE%></title>
    <link rel="stylesheet" href="/css/index.css">
</head>

<body>
<ul class="login_signup">
    <c:choose>
        <c:when test="${user == null}">
            <li><a href="/signup.jsp"><%=SIGN_UP%></a></li>
            <li><a href="/login.jsp"><%=LOG_IN%></a></li>
        </c:when>
        <c:when test="${user != null}">
            <%=HELLO%> ${user.name}!
            <a href="/controller?command=logout"><%=LOGOUT%></a>
        </c:when>
    </c:choose>
    <a href="/controller?command=changeLanguage"><c:out value="<%=CHANGE_LANGUAGE%>"/></a>
</ul>

<header>
    <h2 class="selection_comittee"><%=SELECTION_COMMITTEE%></h2>
</header>

<nav>
    <ul class="Navigation">
        <li><a href="/"><%=HOME%></a></li>
        <li><a href="#"><%=ABOUT%></a></li>
        <li><a href="#"><%=SOME_FUNCTIONS%></a>
            <c:if test="${user != null}">
                <ul>
                    <li><a href="/controller?command=showFaculties"><%=FACULTIES%></a></li>
                    <c:if test="${user.roleId == 2}">
                        <li><a href="/controller?command=showRoles"><%=ROLES%></a></li>
                        <li><a href="/controller?command=showStatements"><%=STATEMENTS%></a></li>
                        <li><a href="/controller?command=showSubjects"><%=SUBJECTS%></a></li>
                        <li><a href="/controller?command=showUsers"><%=USERS%></a></li>
                        <li><a href="/controller?command=showRegisteredUsers"><%=REG_USERS%></a></li>
                        <li><a href="/controller?command=calculateEntrants"><%=CALCULATE_AND_SHOW_ENTRANTS%></a></li>
                    </c:if>
                </ul>
            </c:if>
        </li>
        <li><a href="#"><%=SOMETHING_ELSE%></a></li>
        <li><a href="#"><%=CONTACT%></a></li>
    </ul>
</nav>
</body>