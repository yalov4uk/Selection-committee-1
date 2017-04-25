<%@ page import="by.training.nc.dev3.localisation.Bundle" %>
<%@ page import="java.util.ResourceBundle" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    ResourceBundle resourceBundle = Bundle.getInstance();
    String SELECTION_COMMITTEE = resourceBundle.getString("SELECTION_COMMITTEE");
%>

<title><%=SELECTION_COMMITTEE%>
</title>

<jsp:include page="includes/header.jsp"/>
<jsp:include page="includes/footer.jsp"/>