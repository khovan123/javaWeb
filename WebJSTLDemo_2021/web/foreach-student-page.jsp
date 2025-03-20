<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="model.Student"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello Students!</h1>
        <%
            List<Student> data = new ArrayList<>();
            data.add(new Student("A", "Ly", true));
            data.add(new Student("C", "Nguyen", true));
            data.add(new Student("B", "Van", true));
            data.add(new Student("D", "Hoang", false));
            pageContext.setAttribute("myStudents", data);

        %>
        <table border="1">
            <thead>
                <tr>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Gold Customer</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="tempStudent" items="${myStudents}">
                    <tr>
                        <td>${tempStudent.firstName}</td>
                        <td>${tempStudent.lastName}</td>
                        <td>${tempStudent.goldCustomer}</td>
                    </tr>                   
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
