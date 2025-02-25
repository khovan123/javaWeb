<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Set Properties JSP Page</title>
    </head>
    <body>
        <jsp:useBean id="user" class="entity.User" scope="application"></jsp:useBean>
        <jsp:setProperty property="firstName" name="user" value="NewPerson"></jsp:setProperty>
        <jsp:setProperty property="lastName" name="user" value="Nguyen"></jsp:setProperty>
    </body>
</html>