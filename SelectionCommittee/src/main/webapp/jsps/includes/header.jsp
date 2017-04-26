<%@include file="../includes/init.jsp" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link rel="stylesheet" href="/css/index.css">
</head>
<body>
<ul class="login_signup">
    <c:choose>
        <c:when test="${user == null}">
            <li><a href="/jsps/login_signup/signup.jsp"><fmt:message key="SIGN_UP"/>
            </a></li>
            <li><a href="/jsps/login_signup/login.jsp"><fmt:message key="LOG_IN"/>
            </a></li>
        </c:when>
        <c:when test="${user != null}">
            <fmt:message key="HELLO"/> ${user.name}!
            <a href="/controller?command=logout"><fmt:message key="LOGOUT"/>
            </a>
        </c:when>
    </c:choose>
    <form id="langForm" action="/controller" style="display: inline">
        <input type="hidden" name="command" value="changeLanguage"/>
        <select id="language" name="language" onchange="submitLanguage()">
            <option value="en US" ${language == 'en_US' ? 'selected' : ''}><fmt:message key="ENGLISH"/></option>
            <option value="ru RU" ${language == 'ru_RU' ? 'selected' : ''}><fmt:message key="RUSSIAN"/></option>
        </select>
    </form>
</ul>

<header>
    <h2 class="selection_comittee"><fmt:message key="SELECTION_COMMITTEE"/>
    </h2>
</header>

<nav>
    <ul class="Navigation">
        <li><a href="/"><fmt:message key="HOME"/>
        </a></li>
        <li><a href="#"><fmt:message key="ABOUT"/>
        </a></li>
        <li><a href="#"><fmt:message key="SOME_FUNCTIONS"/>
        </a>
            <c:if test="${user != null}">
                <ul>
                    <li><a href="/controller?command=showFaculties"><fmt:message key="FACULTIES"/>
                    </a></li>
                    <c:if test="${user.roleId == 2}">
                        <li><a href="/controller?command=showRoles"><fmt:message key="ROLES"/>
                        </a></li>
                        <li><a href="/controller?command=showStatements"><fmt:message key="STATEMENTS"/>
                        </a></li>
                        <li><a href="/controller?command=showSubjects"><fmt:message key="SUBJECTS"/>
                        </a></li>
                        <li><a href="/controller?command=showUsers"><fmt:message key="USERS"/>
                        </a></li>
                        <li><a href="/controller?command=showRegisteredUsers"><fmt:message key="REG_USERS"/>
                        </a></li>
                        <li><a href="/controller?command=calculateEntrants"><fmt:message
                                key="CALCULATE_AND_SHOW_ENTRANTS"/>
                        </a></li>
                    </c:if>
                </ul>
            </c:if>
        </li>
        <li><a href="#"><fmt:message key="SOMETHING_ELSE"/>
        </a></li>
        <li><a href="#"><fmt:message key="CONTACT"/>
        </a></li>
    </ul>
</nav>

<script>function submitLanguage() {
    document.getElementById("langForm").submit();
}</script>
