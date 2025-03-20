<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSTL Demo</title>
    </head>
    <body>
        <h3>JSTL Demo</h3>
        <hr>
        <c:set var="name" value="Mr AB"></c:set>
        <c:out value="${name}"></c:out>
        <br>
        <c:set var="goldCustomer" value="true"></c:set>
        
        <c:if test="${goldCustomer}">
            Special Discount
        </c:if>

    </body>
</html>
