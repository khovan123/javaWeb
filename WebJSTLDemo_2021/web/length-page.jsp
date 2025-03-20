<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h3>JSTL Function
            <hr>
            <c:set var="data" value="Mr A"></c:set>
            Length of the string <b>${data}</b>: ${fn:length(data)}
            <br><br>
            Uppercase <b>${data}</b>: ${fn:toUpperCase(data)}
            <br><br>
            Does the string <b>${data}</b> start with <b>Mr</b>?:  ${fn:startsWith(data,"Mr")}
            <br><br>
             <hr>
            Split demo <br>
            <c:set var="cities" value="DaNang, HaNoi, SaiGon"></c:set>
            <c:set var="citiesArray" value="${fn:split(cities,',')}"></c:set>
            <c:forEach var="tempCity" items="${citiesArray}">
                ${tempCity}<br>
            </c:forEach>
                <hr>
            Join demo <br>
            <c:set var="citiesStar" value="${fn:join(citiesArray,'*')}"></c:set>
            <c:forEach var="tempCity" items="${citiesArray}">
                ${tempCity}<br>
            </c:forEach>
        </h3>
    </body>
</html>
