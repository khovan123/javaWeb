<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Login</title>
    </head>
    <body>
        <h2>Login to Chat</h2>
        <% if (request.getParameter("error") != null) { %>
        <p style="color:red">Invalid credentials!</p>
        <% } %>
        <form action="login" method="post">
            User ID: <input type="number" name="userId" required><br>
            Password: <input type="password" name="password" required><br>
            <input type="submit" value="Login">
        </form>
    </body>
</html>