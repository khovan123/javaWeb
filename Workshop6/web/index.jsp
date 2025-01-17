<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>DemoStupidPage</title>
        <style>
            ul{
                list-style: none;
                display: flex;
                gap: 12px;
            }
            th.id {
                width: 100px;
            }
            th.name{
                width: 200px;
            }
            
            tr:nth-child(even){
                background-color: gray;
            }
            tr:nth-child(odd){
                background-color: white;
            }
        </style>
    </head>
    <body>          
        <c:if test="${records == null}">
            <script>
                window.location.href = "${"DemoStupidPage/search?page=1"}"
            </script>
        </c:if>
        <c:if test="${records != null}">
            <table border="1">
                <tr>
                    <th class="id">
                        ID
                    </th>
                    <th class="name">
                        Name
                    </th>
                </tr>
                <c:forEach var="record" items="${records}">
                    <tr>
                        <td>${record.getId()}</td>
                        <td>${record.getName()}</td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>

        <c:import url="tagPage.jsp">
            <c:param name="maxIndex" value="${maxIndex}"/>
            <c:param name="active" value="${active}"/>
        </c:import>
    </body>
</html>
