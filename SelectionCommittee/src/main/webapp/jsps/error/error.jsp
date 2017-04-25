<%@ page import="by.training.nc.dev3.localisation.Bundle" %>
<%@ page import="java.util.ResourceBundle" %><%--
  Created by IntelliJ IDEA.
  User: Valera Yalov4uk
  Date: 4/18/2017
  Time: 9:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
    ResourceBundle resourceBundle = Bundle.getInstance();
    String ERROR = resourceBundle.getString("ERROR");
    String SOME_WRONG = resourceBundle.getString("SOME_WRONG");
%>
<title><%=ERROR%>
</title>

<jsp:include page="../includes/header.jsp"/>

<div style="text-align: center; margin-top: 9%">
    <c:out value="<%=SOME_WRONG%>"/>.
    <c:out value="${errorMessage}"/>
</div>

<jsp:include page="../includes/footer.jsp"/>
