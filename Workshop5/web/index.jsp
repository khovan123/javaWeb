<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee List</title>
        <style>
            ul {
                list-style: none;
                display: flex;
                flex-direction: column;
                gap: 18px;
                width: fit-content;
            }

            li {
                padding: 0 12px;
                padding-bottom: 6px;
                border-bottom: 2px solid activeborder;
            }
        </style>
    </head>
    <body>
        <c:if test="${employees == null}">
            <form action="send" method="get">
                <button type="submit">Get data</button>
            </form>
        </c:if>
        <c:if test="${employees != null}">
            <ul>
                <c:forEach var="employee" items="${employees}">
                    <li>${employee.getName().getFirstName()} ${employee.getName().getLastName()}: ${employee.getAddress().getCity()}, ${employee.getAddress().getStreet()}, ${employee.getAddress().getZIP()}</li>
                    </c:forEach>
            </ul>
        </c:if>
    </body>
</html>
