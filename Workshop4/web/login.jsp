<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form style="display: grid; grid-template-columns: auto 1fr;width: fit-content;gap: 5px;" action="auth" method="post">
            Username: <input type="text" id="userName" name="userName"/>
            Password: <input type="password" id="passowrd" name="password"/>
            <label style="grid-column: 2/3;">
                <input type="checkbox" id="remember" name="remember" value="remember"/> Remember me
            </label>
            <button type="submit" style="grid-column: 2/3;width: fit-content;">Login</button>
        </form>
    </body>
</html>
