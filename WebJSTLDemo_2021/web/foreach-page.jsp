<%-- 
    Document   : foreach-page
    Created on : 21/06/2021, 7:55:23 AM
    Author     : Ly Quynh Tran
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>For Each</h1>
        <hr>
        <%
            // assume servlet send a list name cities
            String[] cities = {"Da Nang", "Ho Chi MInh", "Ha Noi"};
            pageContext.setAttribute("myCities", cities);

        %>
        <c:forEach var="tempCity" items="${myCities}">
            ${tempCity} <br>
        </c:forEach>

    </body>
</html>
