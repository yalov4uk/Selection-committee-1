<%@ page import="by.training.nc.dev3.localisation.Bundle" %>
<%@ page import="java.util.ResourceBundle" %><%--
  Created by IntelliJ IDEA.
  User: Valera Yalov4uk
  Date: 4/18/2017
  Time: 8:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
    ResourceBundle resourceBundle = Bundle.getInstance();
    String REGISTER_TO_FACULTY = resourceBundle.getString("REGISTER_TO_FACULTY");
    String SIGN_UP = resourceBundle.getString("SIGN_UP");
    String VALUE_REQ = resourceBundle.getString("VALUE_REQ");
    String FACULTIES = resourceBundle.getString("FACULTIES");
    String SELECTION_COMMITTEE = resourceBundle.getString("SELECTION_COMMITTEE");
    String HELLO = resourceBundle.getString("HELLO");
    String LOGOUT = resourceBundle.getString("LOGOUT");
    String CHANGE_LANGUAGE = resourceBundle.getString("CHANGE_LANGUAGE");
    String HOME = resourceBundle.getString("HOME");
    String ABOUT = resourceBundle.getString("ABOUT");
    String SOME_FUNCTIONS = resourceBundle.getString("SOME_FUNCTIONS");
    String ROLES = resourceBundle.getString("ROLES");
    String STATEMENTS = resourceBundle.getString("STATEMENTS");
    String SUBJECTS = resourceBundle.getString("SUBJECTS");
    String USERS = resourceBundle.getString("USERS");
    String REG_USERS = resourceBundle.getString("REG_USERS");
    String CALCULATE_AND_SHOW_ENTRANTS = resourceBundle.getString("CALCULATE_AND_SHOW_ENTRANTS");
    String SOMETHING_ELSE = resourceBundle.getString("SOMETHING_ELSE");
    String CONTACT = resourceBundle.getString("CONTACT");
    String LOG_IN = resourceBundle.getString("LOG_IN");
%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title><%=REGISTER_TO_FACULTY%>
    </title>
    <script type="text/javascript" src="/js/validator.js"></script>
    <link rel="stylesheet" href="/css/index.css">
    <style>
        .tab {
            padding-top: 5%;
            text-align: center;
        }
    </style>
</head>
<body>

<ul class="login_signup">
    <c:choose>
        <c:when test="${user == null}">
            <li><a href="/signup.jsp"><%=SIGN_UP%>
            </a></li>
            <li><a href="/login.jsp"><%=LOG_IN%>
            </a></li>
        </c:when>
        <c:when test="${user != null}">
            <%=HELLO%> ${user.name}!
            <a href="/controller?command=logout"><%=LOGOUT%>
            </a>
        </c:when>
    </c:choose>
    <a href="/controller?command=changeLanguage"><c:out value="<%=CHANGE_LANGUAGE%>"/></a>
</ul>

<header>
    <h2 class="selection_comittee"><%=SELECTION_COMMITTEE%>
    </h2>
</header>

<nav>
    <ul class="Navigation">
        <li><a href="/"><%=HOME%>
        </a></li>
        <li><a href="#"><%=ABOUT%>
        </a></li>
        <li><a href="#"><%=SOME_FUNCTIONS%>
        </a>
            <c:if test="${user != null}">
                <ul>
                    <li><a href="/controller?command=showFaculties"><%=FACULTIES%>
                    </a></li>
                    <c:if test="${user.roleId == 2}">
                        <li><a href="/controller?command=showRoles"><%=ROLES%>
                        </a></li>
                        <li><a href="/controller?command=showStatements"><%=STATEMENTS%>
                        </a></li>
                        <li><a href="/controller?command=showSubjects"><%=SUBJECTS%>
                        </a></li>
                        <li><a href="/controller?command=showUsers"><%=USERS%>
                        </a></li>
                        <li><a href="/controller?command=showRegisteredUsers"><%=REG_USERS%>
                        </a></li>
                        <li><a href="/controller?command=calculateEntrants"><%=CALCULATE_AND_SHOW_ENTRANTS%>
                        </a></li>
                    </c:if>
                </ul>
            </c:if>
        </li>
        <li><a href="#"><%=SOMETHING_ELSE%>
        </a></li>
        <li><a href="#"><%=CONTACT%>
        </a></li>
    </ul>
</nav>

<div class="tab">
    <h2><%=REGISTER_TO_FACULTY%>
    </h2>
    <form id="reg_form" action="/controller" method="post" onsubmit="return registerToFaculty();">
        <input type="hidden" id="VALUE_REQ" value="<%=VALUE_REQ%>"/>
        <input type="hidden" name="command" value="registerToFacultyPost"/>
        <table>
            <c:forEach var="subjectName" items="${subjectNames}">
                <tr>
                    <td>
                        <c:out value="${subjectName.name}"/>
                        <input class="value" type="text" name="value" placeholder="0<x<100"/>
                        <input type="hidden" name="subjectNameId" value="${subjectName.id}"/>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <input type="submit" id="submit" value="<%=SIGN_UP%>">
    </form>
</div>
</body>
</html>
