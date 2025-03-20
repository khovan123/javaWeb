<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>JSTL Demo
        <hr>
        <c:set var="name" value="Mr Z"></c:set>      
        <c:out value="${name}"></c:out>
        </h1>
    </body>
</html>
